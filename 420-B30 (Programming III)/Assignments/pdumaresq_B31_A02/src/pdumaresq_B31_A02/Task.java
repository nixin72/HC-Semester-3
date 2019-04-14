package pdumaresq_B31_A02;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public abstract class Task implements Serializable {
	Calendar dueDate = new GregorianCalendar();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	int priority;
	
	protected Task() {
		
	}
	
	protected Task(String d, int p) {
		dueDate = formatDate(d);
		priority = p;
	}
	
	protected void setDueDate(String d) {
		dueDate = formatDate(d);
	}
	
	protected void setPriority(int p) {
		priority = p;
	}
	
	protected Calendar getDueDate() {
		return dueDate;
	}
	
	protected int getPriority() {
		return priority;
	}
	
	protected long compareTo(Task e) {
		long p = e.getDueDate().getTimeInMillis();
		long d = this.getDueDate().getTimeInMillis();
		int compare = 0;
		
		//same date
		if (p == d) {
			compare = 0;
		} 
		//this task comes before the one passed in
		else if (p > d) {
			compare = -1;
		} 
		//this task comes after the one passed in
		else if (p < d) {
			compare = 1;
		}
		
		return compare;
	}
	
	private Calendar formatDate(String dD) {
		dueDate.setLenient(false);
		Date due = null;
		try {
			due = sdf.parse(dD);
			dueDate.setTime(due);
		} catch (ParseException e) {
			System.out.println("Task.java > formatDate() > Parse");
		}
		catch (NullPointerException e) {
			System.out.println("Task.java > formatDate() > NullPointer");
		}
		return dueDate;
	}
		
	public String toString() {
		return "Priority: " + priority +
				"<br />Due date: " + sdf.format(getDueDate().getTime());
	}
}