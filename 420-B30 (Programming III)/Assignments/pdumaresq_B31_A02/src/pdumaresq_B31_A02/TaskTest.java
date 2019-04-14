package pdumaresq_B31_A02;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

public class TaskTest {
	
	@Test
	public void testCompareTo() {
		LinkedList<Task> e = createSomeTasks();
		//compare homework task to homework task
		assertEquals("Test compareTo(): Task 1 comes before task 2", -1, e.get(0).compareTo(e.get(1)));
		assertEquals("Test compareTo(): Task 1 has the same date as task 2", 0, e.get(1).compareTo(e.get(2)));
		assertEquals("Test compareTo(): Task 1 comes after task 2", 1, e.get(1).compareTo(e.get(0)));
		
		//compare personal task to personal task
		assertEquals("Test compareTo(): Task 1 before before task 2", -1, e.get(10).compareTo(e.get(11)));
		assertEquals("Test compareTo(): Task 1 has the same date as task 2", 0, e.get(8).compareTo(e.get(9)));
		assertEquals("Test compareTo(): Task 1 comes after task 2", 1, e.get(11).compareTo(e.get(10)));
		
		//compare personal task to homework task
		assertEquals("Test compareTo(): Task 1 before before task 2", -1, e.get(5).compareTo(e.get(10)));
		assertEquals("Test compareTo(): Task 1 has the same date as task 2", 0, e.get(5).compareTo(e.get(7)));
		assertEquals("Test compareTo(): Task 1 before after task 2", 1, e.get(10).compareTo(e.get(5)));
		
		//compare a task to itself
		assertEquals("Test compareTo(): Task 1 has the same date as task 2", 0, e.get(0).compareTo(e.get(0)));
	}
	
	@Test
	public void testEquals() {
		HomeworkTask h1 = new HomeworkTask("26/10/2016", 1, "Test", "02", "420-C30", "Allan");
		HomeworkTask h2 = new HomeworkTask("26/10/2016", 1, "Test", "02", "420-C30", "Allan");
		HomeworkTask h3 = new HomeworkTask("01/11/2016", 2, "Lab", "11", "420-B31", "Sandra");
		HomeworkTask h4 = new HomeworkTask("01/11/2016", 2, "Lab", "11", "420-B30", "Sandra");
		HomeworkTask h5 = new HomeworkTask("01/11/2016", 2, "Lab", "11", "420-B31", "Zandra");
		HomeworkTask h6 = new HomeworkTask("01/11/2016", 2, "Test", "11", "420-B31", "Sandra");
		
		assertEquals("Test equals(): h1 is equal to h2", true, h1.equals(h2));
		assertEquals("Test equals(): h1 is not equal to h3", false, h1.equals(h3));
		assertEquals("Test equals(): h3 has a different course numbe than h4", false, h3.equals(h4));
		assertEquals("Test equals(): h3 has a different teacher than h5", false, h3.equals(h5));
		assertEquals("Test equals(): h3 has a different task type than h6", false, h3.equals(h6));
		
		PersonalTask p1 = new PersonalTask("23/11/2016", 1, "Appointment", "Dentist");
		PersonalTask p2 = new PersonalTask("23/11/2017", 1, "Appointment", "Dentist");
		PersonalTask p3 = new PersonalTask("23/11/2016", 1, "Bill Payment", "Dentist");
		PersonalTask p4 = new PersonalTask("23/11/2016", 1, "Appointment", "Orthodontist");
		PersonalTask p5 = new PersonalTask("23/11/2016", 1, "Bill Payment", "Orthodontist");
				
		assertEquals("Test equals(): p1 is equal to p2", true, p1.equals(p2));
		assertEquals("Test equals(): p1 has a different task type than t3", false, p1.equals(p3));
		assertEquals("Test equals(): p1 has a different task name than t4", false, p1.equals(p4));
		assertEquals("Test equals(): p1 is different than t5", false, p1.equals(p5));
		
	}
	
	/*
	 * Just a method to use for some test cases that will provide a LinkedList to 
	 * test with instead of manually creating one each time. 
	 */
	public LinkedList<Task> createSomeTasks() {
		LinkedList<Task> e = new LinkedList<Task>();
/*00*/	e.add(new HomeworkTask("02/10/2016", 2, "Other", "01", "N/A", "N/A", "CSEC job Application"));
/*01*/	e.add(new HomeworkTask("26/10/2016", 1, "Assignment", "02", "420-C30", "Allan"));
/*02*/	e.add(new HomeworkTask("26/10/2016", 1, "Test", "02", "420-C30", "Allan"));
/*03*/	e.add(new HomeworkTask("01/11/2016", 2, "Lab", "11", "420-B31", "Sandra", "Upcoming programming lab"));
/*04*/	e.add(new HomeworkTask("01/04/2017", 3, "Assignment", "99", "420-D20", "Richard", "Final HVK System due this month!"));
/*05*/	e.add(new HomeworkTask("05/12/2016", 4, "Test", "99", "420-C30", "Allan", "Final Exam!"));
		
/*06*/	e.add(new PersonalTask("04/08/2017", 2, "Other", "Birthday!"));
/*07*/	e.add(new PersonalTask("05/12/2016", 1, "Appointment", "", "123 someones road"));
/*08*/	e.add(new PersonalTask("23/11/2016", 1, "Appointment", "Dentist"));
/*09*/	e.add(new PersonalTask("23/11/2016", 2, "Bill Payment", "Pay phone bill!", "literally anywhere"));
/*10*/	e.add(new PersonalTask("12/12/2016", 1, "Errand", "Christmas shopping!"));
/*11*/	e.add(new PersonalTask("31/12/2020", 4, "Appointment", "The last possible date", "Ottawa"));
		
		return e;
	}

}
