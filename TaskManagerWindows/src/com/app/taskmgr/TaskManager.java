package com.app.taskmgr;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class TaskManager{
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private boolean active;
	private StatusEnum status;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public int getTaskId() {
		return taskId;
	}
	public TaskManager(int taskId, String taskName, String description, LocalDate taskDate, boolean active,
			StatusEnum status) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.active = true;
		this.status = status;
	}
	
	public TaskManager(int taskId) {
		this.taskId = taskId;
	}
	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description
				+ ", taskDate=" + taskDate + ", active=" + active + ", status=" + status + "]";
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(taskId);
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskManager other = (TaskManager) obj;
		return taskId == other.taskId;
	}

	
	
	
	
}
