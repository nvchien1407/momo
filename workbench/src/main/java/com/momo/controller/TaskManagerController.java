package com.momo.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.momo.util.WBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.momo.domain.TaskDo;
import com.momo.service.interfaces.TaskService;

@RestController
public class TaskManagerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private TaskService taskService = null;

    @Autowired
    public TaskManagerController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<TaskDo> getAllTasks() {
        LOGGER.info("Get list of task");
        return taskService.getTaskList();
    }

    @RequestMapping(value = "/tasks/archive/{taskIds}", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<TaskDo> archiveAllTasks(@PathVariable int[] taskIds) {
        LOGGER.info("Archive tasks", taskIds);
        taskService.archiveTask(taskIds);
        return taskService.getTaskList();
    }

    @RequestMapping(value = "/tasks/{taskId}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<TaskDo> changeTaskStatus(@PathVariable int taskId, @PathVariable String taskStatus) throws ParseException {
        LOGGER.info("Change tasks status", taskStatus);
        taskService.changeTaskStatus(taskId, taskStatus);
        return taskService.getTaskList();

    }

    @RequestMapping(value = "/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}/{startTime}/{endTime}",
            method = RequestMethod.POST, headers = "Accept=application/json")
    public List<TaskDo> addTask(@PathVariable String taskName,
                                @PathVariable String taskDesc, @PathVariable String taskPriority,
                                @PathVariable String taskStatus, @PathVariable String startTime, @PathVariable String endTime

    ) throws ParseException {
        TaskDo task = new TaskDo();
        task.setTaskName(taskName);
        task.setTaskDesc(taskDesc);
        task.setTaskPriority(taskPriority);
        task.setTaskStatus(taskStatus);
        task.setStartTime(startTime);
        task.setEndTime(endTime);
        taskService.addTask(task);
        LOGGER.info("Add task", task);
        return taskService.getTaskList();

    }
}
