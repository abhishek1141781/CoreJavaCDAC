package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.taskmgr.StatusEnum;
import com.app.taskmgr.TaskManager;

import utils.PopulateTaskManager;
import utils.ValidationRules;

public class TaskManagerTester {
	public static void main(String[] args) {
		try {Scanner sc = new Scanner(System.in);
		List<TaskManager> taskAL = PopulateTaskManager.populateTaskManager();
		boolean exit=false; 
		
			while(!exit) {
				System.out.println("0. Display all Tasks\n"
								 + "1. Add New Task\n"
								 + "2. Delete a Task\n"
								 + "3. Update task status\n"
								 + "4. Display all pending tasks\n"
								 + "5. Display all pending tasks for today\n"
								 + "6. Display all tasks sorted by taskDate\n");
				
				System.out.println("Choose a number: \n");
				try {
					
				switch (sc.nextInt()) {
				case 0:
					System.out.println("List of all tasks: ");
					for(TaskManager t: taskAL) {
						System.out.println(t);
					}
					break;
				
				case 1:
					System.out.println("Add New Task: \n"
									 + "taskID taskName  description  taskDate(yyyy-mm-dd)");
					int taskId = sc.nextInt();
					ValidationRules.checkForDupTaskId(taskId,taskAL);
					String taskName = sc.next();
					String desc = sc.nextLine();
					LocalDate taskDate = LocalDate.parse(sc.next());
					ValidationRules.checkDateSinceToday(taskDate);
					
					taskAL.add(new TaskManager(taskId, taskName, desc, taskDate, true, StatusEnum.valueOf("PENDING")));
					
					break;
				case 2:
					System.out.println("Delete a task: Enter taskID");
					int taskId1 = sc.nextInt();
//					ValidationRules.checkIfTaskExists(taskId1,taskAL);
					taskAL.remove(new TaskManager(taskId1));
					
					for(TaskManager t: taskAL) {
						System.out.println(t);
					}
					break;
				case 3://Update task status
					System.out.println("Update task status: PENDING, IN_PROGRESS, COMPLETED");
					System.out.println("Enter task Id");
					int taskId2 = sc.nextInt();
					TaskManager tmRef = new TaskManager(taskId2);
					TaskManager tsk= ValidationRules.objectGetterFromList(taskAL,tmRef);
					System.out.println("Enter task status:");
					String stat= sc.next().toUpperCase();
					tsk.setStatus(StatusEnum.valueOf(stat));
					
					if(stat==stat.toUpperCase()) {
						tmRef.setActive(false);
					}
					
					for(TaskManager t: taskAL) {
						System.out.println(t);
					}
					
					
					break;

				case 4:
					System.out.println("Display all pending tasks:");
					for(TaskManager t: taskAL) {
						if(t.getStatus().name().contains("PENDING")){
							System.out.println(t);
						}
					}
					break;

				case 5://Display all pending tasks for today
					System.out.println("Display all pending tasks for today");
					for(TaskManager t: taskAL) {
						if(t.getStatus().name().contains("PENDING") && t.getTaskDate().isEqual(LocalDate.now())) {
							System.out.println(t);
						}
					}
					break;

				case 6://Display all tasks sorted by taskDate
					System.out.println("Display all tasks sorted by taskDate: ");
					List<TaskManager> list = new ArrayList<>(taskAL);
					Collections.sort(list, new Comparator<TaskManager>() {

						@Override
						public int compare(TaskManager o1, TaskManager o2) {
							return o1.getTaskDate().compareTo(o2.getTaskDate());
						}
					});
					
					for(TaskManager t: list) {
						System.out.println(t);
						
					}
					break;
				default:
					break;
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}