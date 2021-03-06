package com.momo.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class TaskDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int taskId;
	@Column(name = "task_name")
	private String taskName;
	@Column(name = "task_description")
	private String taskDesc;
	@Column(name = "task_priority")
	private String taskPriority;
	@Column(name = "task_status")
	private String taskStatus;
	@Column(name = "task_start_time")
	private String startTime;
	@Column(name = "task_end_time")
	private String endTime;
	@Column(name = "task_archived")
	private boolean taskArchived;

	public TaskDo() {
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + taskId + ", task_name=" + getTaskName()
				+ ", task_description=" + getTaskDesc() + ", task_priority="
				+ getTaskPriority() + ",task_start_time="
				+ getStartTime() + ",task_end_time=" + getEndTime()+ "]";
	}


	/**
	 * @return the taskDesc
	 */
	public String getTaskDesc() {
		return taskDesc;
	}

	/**
	 * @param taskDesc
	 *            the taskDesc to set
	 */
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	/**
	 * @return the taskPriority
	 */
	public String getTaskPriority() {
		return taskPriority;
	}

	/**
	 * @param taskPriority
	 *            the taskPriority to set
	 */
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	/**
	 * @return the taskStatus
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * @param taskStatus
	 *            the taskStatus to set
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isTaskArchived() {
		return taskArchived;
	}

	public void setTaskArchived(boolean taskArchived) {
		this.taskArchived = taskArchived;
	}
}
