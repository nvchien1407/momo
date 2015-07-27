package com.momo.controller;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.momo.domain.TaskDo;
import com.momo.service.interfaces.TaskService;

@RestController
public class TaskManagerController {

	private TaskService taskService = null;

	@Autowired
	public TaskManagerController(TaskService taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<TaskDo> getAllTasks() {
		return taskService.getTaskList();
	}

	@RequestMapping(value="/tasks/archive/{taskIds}",method = RequestMethod.POST,headers="Accept=application/json")
	public List<TaskDo> archiveAllTasks(@PathVariable int[] taskIds) { 
		taskService.archiveTask(taskIds);
		return taskService.getTaskList();
	}

	@RequestMapping(value = "/tasks/{taskId}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<TaskDo> changeTaskStatus(@PathVariable int taskId,@PathVariable String taskStatus) throws ParseException {
		taskService.changeTaskStatus(taskId, taskStatus);
		return taskService.getTaskList();

	}

	@RequestMapping(value = "/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<TaskDo> addTask(@PathVariable String taskName,
			@PathVariable String taskDesc, @PathVariable String taskPriority,
			@PathVariable String taskStatus) throws ParseException {
		TaskDo task = new TaskDo();
		task.setTaskName(taskName);
		task.setTaskDesc(taskDesc);
		task.setTaskPriority(taskPriority);
		task.setTaskStatus(taskStatus);
		taskService.addTask(task);
		return taskService.getTaskList();

	}
}
