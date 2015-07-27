package com.momo.service.interfaces;

import java.util.List;

import com.momo.domain.TaskDo;

public interface TaskService extends CommonService{
	public List<TaskDo> getTaskList();
	public void addTask(TaskDo task);
	public void changeTaskStatus(int taskId, String taskStatus);
	public void archiveTask(int[] taskIds);
}
