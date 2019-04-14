package pdumaresq_B31_A02;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HomeworkTask extends Task implements Serializable {
	String taskType;
	String taskNumber;
	String teacherName;
	String courseNumber;
	String description;
	
	public HomeworkTask() {
		super();
	}
	
	public HomeworkTask(String dD, int p, String tT, String tN, String t, String cN) {
		super(dD, p);
		taskType = tT;
		taskNumber = tN;
		teacherName = t;
		courseNumber = cN;
		description = "";
	}
	
	public HomeworkTask(String dD, int p, String tT, String tN, String t, String cN, String d) {
		super(dD, p);
		taskType = tT;
		taskNumber = tN;
		teacherName = t;
		courseNumber = cN;
		description = d;
	}
	
	public void setTaskType(String tT) {
		taskType = tT;
	}
	
	public void setTaskNumber(String tN) {
		taskNumber = tN;
	}
	
	public void setTeacherName(String t) {
		teacherName = t;
	}
	
	public void setCourseNumber(String cN) {
		courseNumber = cN;
	}
	
	public void setDescription(String d) {
		description = d;
	}
	
	public String getTaskType() {
		return taskType;
	}
	
	public String getTaskNumber() {
		return taskNumber;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	/*
	 * The instructions say to implement the method, but 
	 * it's the same implementation as in the task class
	 * so I'm just returning super. 
	 */
	public long compareTo(HomeworkTask hT) {
		return super.compareTo(hT);
	}
	
	/*
	 * Overridden Object class equals method
	 */
	public boolean equals(HomeworkTask hTask) {
		boolean equal = true;
		equal = equal && courseNumber.equals(hTask.getCourseNumber());
		equal = equal && teacherName.equals(hTask.getTeacherName());
		equal = equal && taskType.equals(hTask.getTaskType());
		equal = equal && taskNumber.equals(hTask.getTaskNumber());
		return equal;
	}
	
	/*
	 * Overridden Task class toString method
	 */
	public String toString() {
		String taskInfo = 	"<html><body>" +
							taskType + " " + taskNumber + 
							"<br />" + super.toString() + 
							"<br />Course number: " + courseNumber + 
							"<br />Teacher: " + teacherName +
							"</body></html>";
		try {
			if (!description.equals(null) || !description.equals("")) {
				taskInfo += "<html><body><br />Description: " + description + "</body></html>";
			}
		}
		catch (NullPointerException e) {
			taskInfo += "<html><body><br />Description: " + description + "</body></html>";
		}
				
		return taskInfo;
	}
}