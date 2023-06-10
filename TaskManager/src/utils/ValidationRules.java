package utils;

import java.time.LocalDate;
import java.util.List;
import com.app.taskmgr.TaskManager;
import custom_exception.InvalidInputException;

public class ValidationRules {
	
	public static TaskManager objectGetterFromList(List<TaskManager> list,TaskManager task) {
		int index = list.indexOf(task);
		TaskManager taskRef = list.get(index);
		return taskRef;
	}
	
	public static void checkDateSinceToday(LocalDate date) throws InvalidInputException{
		if(date.isBefore(LocalDate.now())) {
			throw new InvalidInputException("Can't add a new task in the past dates");
		}
	}
	
	public static void checkIfTaskExists(int taskId,List<TaskManager> list) throws InvalidInputException{
		if(!list.contains(new TaskManager(taskId)))
			throw new InvalidInputException("Entered taskId doesn't exist");
	}
	
	public static void checkForDupTaskId(int taskId,List<TaskManager> list) throws InvalidInputException {
		if(list.contains(new TaskManager(taskId))) {
			throw new InvalidInputException("Entered taskId doesn't exist");
		}
	}
}
