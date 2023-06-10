package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.app.taskmgr.StatusEnum;
import com.app.taskmgr.TaskManager;

public class PopulateTaskManager {
	public static List<TaskManager> populateTaskManager(){
		List<TaskManager> taskList = new ArrayList<>();
		
		taskList.add(new TaskManager(001, "Work", "1st work in morning",LocalDate.of(2023,01,01), true, StatusEnum.valueOf("PENDING")));
		taskList.add(new TaskManager(002, "Play", "2st work in night",LocalDate.of(2023,02,01), true, StatusEnum.valueOf("PENDING")));
		taskList.add(new TaskManager(003, "Work", "1st work in morning",LocalDate.of(2023,11,21), false, StatusEnum.valueOf("COMPLETED")));
		taskList.add(new TaskManager(004, "Work", "1st work in morning",LocalDate.of(2023,11,21), true, StatusEnum.valueOf("IN_PROGRESS")));
		taskList.add(new TaskManager(005, "Work", "1st work in morning",LocalDate.of(2023,05,14), true, StatusEnum.valueOf("PENDING")));
		
		return taskList;		
	}
}
