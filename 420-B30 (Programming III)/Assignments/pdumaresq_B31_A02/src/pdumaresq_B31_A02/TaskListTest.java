package pdumaresq_B31_A02;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

//import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TaskListTest {
	
	@Test
	public void testAddTask() {
		TaskList test = new TaskList();
		LinkedList<Task> e = test.tasks;
		
		Task h1 = new HomeworkTask("02/10/2016", 2, "Other", "01", "N/A", "N/A", "CSEC job Application");
		Task h2 = new HomeworkTask("26/10/2016", 1, "Assignment", "02", "420-C30", "Allan");
		Task h3 = new HomeworkTask("26/10/2016", 1, "Test", "02", "420-C30", "Allan");
		
		Task p1 = new PersonalTask("04/08/2017", 2, "Other", "Birthday!");
		Task p2 = new PersonalTask("05/03/2017", 1, "Appointment", "", "123 someones road");
		Task p3 = new PersonalTask("23/11/2016", 2, "Bill Payment", "Pay phone bill!", "literally anywhere");
		
		//add a bunch of homework tasks
		assertEquals("Test addTask: add a homework task", true, test.addTask(h1));
		assertEquals("Test addTask: add another homework task", true, test.addTask(h2));
		assertEquals("Test addTask: a bunch of homework tasks", true, test.addTask(h3));
		//Makes sure everything is good up to this point
		assertEquals("Test addTask: make sure the first element is correct", true, e.get(0).equals(h1));
		assertEquals("Test addTask: make sure the second element is correct", true, e.get(1).equals(h2));
		assertEquals("Test addTask: the whole list is correct up to date", true, e.get(2).equals(h3));
		
		//add a bunch of personal tasks
		assertEquals("Test addTask: add a personal task", true, test.addTask(p1));
		assertEquals("Test addTask: add another personal task", true, test.addTask(p2));
		assertEquals("Test addTask: a bunch of personal taska", true, test.addTask(p3));
		//Make sure everything is good up to this point again
		assertEquals("Test addTask: make sure the first element is correct", true, e.get(3).equals(p1));
		assertEquals("Test addTask: make sure the second element is correct", true, e.get(4).equals(p2));
		assertEquals("Test addTask: the whole list is correct up to date", true, e.get(5).equals(p3));		
	}
	
	@Test 
	public void testFindNextDueTask() {
		TaskList test = new TaskList();
		LinkedList<Task> e = createSomeTasks();
		
		assertEquals("Test findNextDueTask: an empty list", new LinkedList<Task>(), test.findNextDueTask());
		
		test.tasks = e;
		LinkedList<Task> correct = new LinkedList<Task>();
		correct.add(e.get(0));
		assertEquals("Test findNextDueTask: A full list containing personal and homework tasks"
				, correct, test.findNextDueTask());
	}
	
	
	@Test
	public void TestGetHighPriorityTasksByDueDate() {
		class TestHighPriority {
			public void testHighPriority_EmptyList() {
				LinkedList<Task> e = new LinkedList<Task>();
						
				TaskList test = new TaskList();
				test.tasks = e;
				
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_EmptyList"
						, new LinkedList<Task>(), test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_oneItemNotOfHighPriority() {
				LinkedList<Task> e = new LinkedList<Task>();
						
				TaskList test = new TaskList();
				test.tasks = e;
				
				e.add(createSomeTasks().get(0));
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_oneItemNotOfHighPriority"
						, e, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_oneTaskOfHighPriority() {
				LinkedList<Task> fullList = createSomeTasks();
				TaskList test = new TaskList();
				test.addTask(fullList.get(1));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(1));
				
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_oneTaskOgHighPriority"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_oneHomeworkItem() {
				LinkedList<Task> fullList = createSomeTasks();
				
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
						
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(0));
				
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_oneHomeworkItem"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_onePersonalItem() {
				LinkedList<Task> fullList = createSomeTasks();
				
				TaskList test = new TaskList();
				test.addTask(fullList.get(6));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(6));
				
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_onePersonalItem"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_multipleHomeworkItems() {
				LinkedList<Task> fullList = createSomeTasks();
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				test.addTask(fullList.get(3));
				test.addTask(fullList.get(4));
				test.addTask(fullList.get(5));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(1));
				correct.add(fullList.get(2));
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_multipleHomeworkItems"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_multiplePersonalItems() {
				LinkedList<Task> fullList = createSomeTasks();
				TaskList test = new TaskList();
				test.addTask(fullList.get(6));
				test.addTask(fullList.get(7));
				test.addTask(fullList.get(8));
				test.addTask(fullList.get(9));
				test.addTask(fullList.get(10));
				test.addTask(fullList.get(11));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(8));
				correct.add(fullList.get(7));
				correct.add(fullList.get(10));
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_multiplePersonalItems"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_multipleWithSamePriority() {
				LinkedList<Task> fullList = createSomeTasks();
				TaskList test = new TaskList();
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(7));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(1));
				correct.add(fullList.get(7));
				
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_multipleWithSamePriority"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_multipleWithSameDate() {
				LinkedList<Task> fullList = createSomeTasks();
				TaskList test = new TaskList();
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(1));
				correct.add(fullList.get(2));
				
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_multipleWithSameDate"
						, correct, test.getHighPriorityTasksByDueDate());
			}
			
			public void testHighPriority_MultipleItemsDifferentPriority() {
				TaskList test = new TaskList();
				LinkedList<Task> fullList = createSomeTasks();
				test.tasks = fullList;
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(1));
				correct.add(fullList.get(2));
				correct.add(fullList.get(8));
				correct.add(fullList.get(7));
				correct.add(fullList.get(10));
				assertEquals("Test getHighPriorityTasksByDueDate: testHighPriority_MultipleItemsDifferentPriority"
						, correct, test.getHighPriorityTasksByDueDate());
			}
		}
		TestHighPriority test = new TestHighPriority();
		test.testHighPriority_EmptyList();
		test.testHighPriority_oneItemNotOfHighPriority();
		test.testHighPriority_oneTaskOfHighPriority();
		test.testHighPriority_oneHomeworkItem();
		test.testHighPriority_onePersonalItem();
		test.testHighPriority_multipleHomeworkItems();
		test.testHighPriority_multiplePersonalItems();
		test.testHighPriority_multipleWithSamePriority();
		test.testHighPriority_multipleWithSameDate();
		test.testHighPriority_MultipleItemsDifferentPriority();
	}
	
	@Test
	public void getTasksByDueDate() {
		class TestByDueDate {
			LinkedList<Task> fullList = createSomeTasks();
			
			public void testByDueDate_EmptyList() {
				TaskList test = new TaskList();
					
				LinkedList<Task> correct = new LinkedList<Task>();
				assertEquals("Test getTasksByDueDate: testByDueDate_EmptyList"
						, correct, test.sortByDueDate());
			}
			
			public void testByDueDate_oneHomeworkItem() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(0));
				assertEquals("Test getTasksByDueDate: testByDueDate_oneHomeworkItem"
						, correct, test.sortByDueDate());
			}
			
			public void testByDueDate_onePersonalItem() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(6));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(6));
				assertEquals("Test getTasksByDueDate: testByDueDate_onePersonalItem"
						, correct, test.sortByDueDate());
			}
			
			public void testByDueDate_multipleHomeworkTasks() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				test.addTask(fullList.get(3));
				test.addTask(fullList.get(4));
				test.addTask(fullList.get(5));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(0));
				correct.add(fullList.get(1));
				correct.add(fullList.get(2));
				correct.add(fullList.get(3));
				correct.add(fullList.get(5));
				correct.add(fullList.get(4));
				
				assertEquals("Test getTasksByDueDate: testByDueDate_multipleHomeworkTasks"
						, correct, test.sortByDueDate());
			}
			
			public void testByDueDate_multiplePersonalTasks() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(6));
				test.addTask(fullList.get(7));
				test.addTask(fullList.get(8));
				test.addTask(fullList.get(9));
				test.addTask(fullList.get(10));
				test.addTask(fullList.get(11));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(8));
				correct.add(fullList.get(9));
				correct.add(fullList.get(7));
				correct.add(fullList.get(10));
				correct.add(fullList.get(6));
				correct.add(fullList.get(11));
				
				assertEquals("Test getTasksByDueDate: testByDueDate_multiplePersonalTasks"
						, correct, test.sortByDueDate());
			}
			
			public void testByDueDate_multipleWithSameDate() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				test.addTask(fullList.get(8));
				test.addTask(fullList.get(9));
				
				LinkedList<Task> correct = new LinkedList<Task>();
				correct.add(fullList.get(1));
				correct.add(fullList.get(2));
				correct.add(fullList.get(8));
				correct.add(fullList.get(9));
				
				assertEquals("Test getTasksByDueDate: testByDueDate_multipleWithSameDate"
						, correct, test.sortByDueDate());
			}
			
		}
		
		TestByDueDate test = new TestByDueDate();
		test.testByDueDate_EmptyList();
		test.testByDueDate_oneHomeworkItem();
		test.testByDueDate_onePersonalItem();
		test.testByDueDate_multipleHomeworkTasks();
		test.testByDueDate_multiplePersonalTasks();
		test.testByDueDate_multipleWithSameDate();	
	}
	
	public void testSaveToFile() {
		class TestSaveToFile {
			LinkedList<Task> fullList = createSomeTasks();
			
			public void saveToFile_emptyList() {
				TaskList test = new TaskList();
				assertEquals("Test: testSaveToFile: saveToFile_emptyList", true, test.saveToFile("test"));
			}
			
			public void saveToFile_fileDoesntExist() {
				TaskList test = new TaskList();
				String testFile = "aRandomFile";
				
				assertEquals("test testSaveToFile: saveToFile_fileDoesntExist"
						, true, test.saveToFile(testFile));
				assertEquals("Test testSaveToFile: the random file has been created"
						, true, new File(testFile).exists());
			}
			
			public void saveToFile_onlyHomeworkTasks() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				
				assertEquals("Test: testSaveToFile: saveToFile_onlyHomeworkTasks", true, test.saveToFile("test"));
			}
			
			public void saveToFile_onlyPersonalItems() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(6));
				test.addTask(fullList.get(7));
				test.addTask(fullList.get(8));
				
				assertEquals("Test: testSaveToFile: saveToFile_onlyPersonalItems", true, test.saveToFile("test"));
			}
			
			public void saveToFile_mixedItems() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				test.addTask(fullList.get(6));
				test.addTask(fullList.get(7));
				test.addTask(fullList.get(8));
				
				assertEquals("Test: testSaveToFile: saveToFile_onlyHomeworkTasks", true, test.saveToFile("test"));
			}
			
			
		}
		
		TestSaveToFile test = new TestSaveToFile();
		test.saveToFile_emptyList();
		test.saveToFile_fileDoesntExist();
		test.saveToFile_onlyHomeworkTasks();
		test.saveToFile_onlyPersonalItems();
		test.saveToFile_mixedItems();
	}
	
	@Test
	public void testReadFromFile() {
		try {
			File newFile = new File("test.ser");
			newFile.createNewFile();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		class ReadFromFile {
			LinkedList<Task> fullList = createSomeTasks();
			
			public void testReadFromFile_readEmptyList() {
				TaskList test = new TaskList();
				test.saveToFile("test");
			}
			
			public void testReadFromFile_fileDoesntExist() {
				TaskList test = new TaskList();
				
				assertEquals("Test testReadFromFile: testReadFromFile_fileDoesntExist"
						, false, test.readFromFile("").isEmpty());
				assertEquals("Test testReadFromFile: reads from default file"
						, "default", test.getFileName());
								
			}
			
			public void testReadFromFile_onlyHomeworkItems() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				
				test.saveToFile("test");
				
				LinkedList<Task> read = test.readFromFile("test");				
				LinkedList<Task> compare = new LinkedList<Task>();
				compare.add(fullList.get(0));
				compare.add(fullList.get(1));
				compare.add(fullList.get(2));
									
				for (int q = 0 ; q < compare.size() ; q++) {
					assertEquals("testReadFromFile_onlyPersonalItems: compare all tasks"
							, true, ((HomeworkTask) read.get(q)).equals(((HomeworkTask)compare.get(q))));
				}				
			}
			
			public void testReadFromFile_onlyPersonalItems() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(6));
				test.addTask(fullList.get(7));
				test.addTask(fullList.get(8));
				
				test.saveToFile("test");
				
				LinkedList<Task> read = test.readFromFile("test");				
				LinkedList<Task> compare = new LinkedList<Task>();
				compare.add(fullList.get(6));
				compare.add(fullList.get(7));
				compare.add(fullList.get(8));
									
				for (int q = 0 ; q < compare.size() ; q++) {
					assertEquals("testReadFromFile_onlyPersonalItems: compare all tasks"
							, true, ((PersonalTask) read.get(q)).equals(((PersonalTask)compare.get(q))));
				}	
			}
						
			public void testReadFromFile_mixedItems() {
				TaskList test = new TaskList();
				test.addTask(fullList.get(0));
				test.addTask(fullList.get(1));
				test.addTask(fullList.get(2));
				test.addTask(fullList.get(6));
				test.addTask(fullList.get(7));
				test.addTask(fullList.get(8));
				
				test.saveToFile("test");
				
				LinkedList<Task> read = test.readFromFile("test");				
				LinkedList<Task> compare = new LinkedList<Task>();
				compare.add(fullList.get(0));
				compare.add(fullList.get(1));
				compare.add(fullList.get(2));
				compare.add(fullList.get(6));
				compare.add(fullList.get(7));
				compare.add(fullList.get(8));
									
				for (int q = 0 ; q < compare.size() ; q++) {
					if (read.get(q) instanceof PersonalTask) {
						assertEquals("testReadFromFile_onlyPersonalItems: compare all tasks"
								, true, ((PersonalTask) read.get(q)).equals(((PersonalTask)compare.get(q))));
					}
					else {
						assertEquals("testReadFromFile_onlyPersonalItems: compare all tasks"
						, true, ((HomeworkTask) read.get(q)).equals(((HomeworkTask)compare.get(q))));
					}
				}	
			}
		}
		
		ReadFromFile test = new ReadFromFile();
		test.testReadFromFile_readEmptyList();
		test.testReadFromFile_fileDoesntExist();
		test.testReadFromFile_onlyHomeworkItems();
		test.testReadFromFile_onlyPersonalItems();
		test.testReadFromFile_mixedItems();
		
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