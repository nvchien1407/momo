package com.momo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.momo.dao.TaskDao;
import com.momo.domain.TaskDo;
import com.momo.service.interfaces.CommonService;
import com.momo.service.interfaces.Service;
import com.momo.service.interfaces.TaskService;
import com.momo.service.util.ServiceConstants;

@Qualifier("taskService")
public class TaskServiceImpl implements TaskService, Service{
	
	@Qualifier("taskDao")
	private TaskDao taskDao;
	
	@Autowired
	public TaskServiceImpl(TaskDao taskDao){
		this.taskDao=taskDao;
	}
	
	public TaskServiceImpl() {
	}

	public List<TaskDo> getTaskList() {
		return taskDao.getAllTasks();
	}
	
	public void addTask(TaskDo task) {
		taskDao.addTask(task);
		
	}
	
	public void changeTaskStatus(int taskId, String taskStatus) {
		taskDao.changeStatus(taskId, taskStatus);
		
	}

	public void archiveTask(int[] taskIds) {
		taskDao.archive(taskIds);
		
	}
	
	
	/**
	 * @return the taskDao
	 */
	public TaskDao getTaskDao() {
		return taskDao;
	}

	/**
	 * @param taskDao the taskDao to set
	 */
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	public String getName() {
		return ServiceConstants.TASK_SERVICE;
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
