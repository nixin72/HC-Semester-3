package pdumaresq_B31_A02;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PersonalTask extends Task implements Serializable {
	String taskType;
	String taskName;
	String location;
	
	public PersonalTask() {
		super();
	}
	
	public PersonalTask(String dD, int p, String tT, String tN) {
		super(dD, p);
		taskType = tT;
		taskName = tN;
	}
	
	public PersonalTask(String dD, int p, String tT, String tN, String l) {
		super(dD, p);
		taskType = tT;
		taskName = tN;
		location = l;
	}
	
	public void setTaskType(String tT) {
		taskType = tT;
	}
	
	public void setTaskName(String tN) {
		taskName = tN;
	}
	
	public void setLocation(String l) {
		location = l;
	}
	
	public String getTaskType() {
		return taskType;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getLocation() {
		return location;
	}
	
	/*
	 * The instructions say to implement the method, but 
	 * it's the same implementation as in the task class
	 * so I'm just returning super. 
	 */
	public long compareTo(PersonalTask pT) {
		return super.compareTo(pT);
	}
	
	/*
	 * Takes the taskType and taskName and compares them to
	 * the name and type of the Task passed in. If they're 
	 * equal, then the method will return true.
	 */
	public boolean equals(PersonalTask pT) {
		boolean equal = true;
		equal = equal && taskType.equals(pT.getTaskType());
		equal = equal && taskName.equals(pT.getTaskName());
		return equal;
	}
	
	/*
	 * Returns all the data for the task formated nicely. 
	 * If the task contains a location, it will return it 
	 * as well, otherwise it'll just return the data that 
	 * was required by the user.
	 */
	public String toString() {
		String taskInfo = "<html><body>" + 
						taskName +
						"<br />Type: " + taskType + 
						"<br />\n" + super.toString() + 
						"</body></html>";
		try {
			if (!location.equals(null) || !location.equals("")) {
				taskInfo += "<html><body><br />Location: " + location + "</body></html>";
			}
		}
		catch (NullPointerException e) {
			taskInfo += "<html><body><br />Location: " + location + "</body></html>";
		}
		
		return taskInfo;
	}
}