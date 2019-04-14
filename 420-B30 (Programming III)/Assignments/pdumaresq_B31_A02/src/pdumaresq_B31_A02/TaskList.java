package pdumaresq_B31_A02;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class TaskList implements Serializable {
	LinkedList<Task> tasks = new LinkedList<Task>();
	private String currentErrorMessage;
	private static String DEFAULT_FILE = "default";
	String fileName = DEFAULT_FILE;
	
	public LinkedList<Task> readFromFile(String fn) {
		try {
			FileInputStream file = new FileInputStream(fn + ".ser");
			ObjectInputStream read = new ObjectInputStream(file);
			
			TaskList newTaskList = (TaskList) read.readObject();
			tasks = newTaskList.getAllTasks();
			
			read.close();
			file.close();
			
		} 
		catch (FileNotFoundException e) {
			System.err.println("ToDoListFrame.java > readFromFile() > FileNotFoundException e");
			setErrorMsg("The file could not be found. Reading in from a default file \"" + DEFAULT_FILE + ".ser\"");
			try {
				newFile(DEFAULT_FILE);
				setFileName(DEFAULT_FILE);
				File newFile = new File(DEFAULT_FILE + ".ser");
				newFile.createNewFile();
				readFromFile(DEFAULT_FILE);
			} 
			catch (IOException e1) {
				setErrorMsg("The file could not be found. Your tasks could not be retrieved.");
				System.err.println("ToDoListFrame.java > readFromFile() > IOException e1");
			}
		}
		catch(NullPointerException e) {
			System.err.println("ToDoListFrame.java > readFromFile() > NullPointerException e");
			//catches a null file name getting passed in.
		}		
		catch (EOFException e) {
			setErrorMsg("The file \"" + getFileName() + ".ser\" contains no tasks.");
			System.err.println("ToDoListFrame.java > readFromFile() > EOFException e");
		}
		catch (IOException e) {
			setErrorMsg("The file could not be read. \nAn unexpected error occured "
					+ "while reading from the file \"" + getFileName() + ".ser\".");
			System.err.println("ToDoListFrame.java > readFromFile() > IOException e");
		} 
		catch (ClassNotFoundException e) {
			setErrorMsg("The file could not be read. An unexpected error occured.");
			System.err.println("ToDoListFrame.java > readFromFile() > ClassNotFoundException e");
		}
		catch (ClassCastException e) {
			setErrorMsg("The file could not be read. An unexpected error occured.");
			System.err.println("ToDoListFrame.java > readFromFile() > ClassCastException e");
		}
		if (tasks.isEmpty()) {
			setErrorMsg("The file \"" + getFileName() + ".ser\" contains no tasks");
		}
		return tasks;
	}
	
	/*
	 * This method will just take in a String from a JOptionPane pane and will save to a new
	 * file with that file name. If the file already exists, it'll just let the user know 
	 * that it's overriding that file. 
	 */
	public boolean saveAs(String fN) {
		try {
			if (!fN.equals(null) && !fN.equals("")) {
				if (new File(fN + ".ser").exists()) {
					return false;
				}
				else {
					saveToFile(fN);
				}
			}
		}
		catch (NullPointerException e1) {
			System.err.println("ToDoListFrame.java > saveAs() > NullPointerException e");
		}
		return true;
	}
	
	public boolean saveToFile(String fileName) {
		boolean correct = false;
		try {
			FileOutputStream file = new FileOutputStream(fileName + ".ser");
			ObjectOutputStream write = new ObjectOutputStream(file);

			write.writeObject(this);
			
			write.close();
			file.close();
			correct = true;
		} 
		catch (FileNotFoundException e) {
			System.err.println("ToDoListFrame.java > saveToFile() > FileNotFoundException e");
			
			newFile(fileName);
			saveToFile(fileName);
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.err.println("ToDoListFrame.java > saveToFile() > IOException e");
		}
		return correct;
	}
	
	public void newFile(String fileName) {
		try {
			File newFile = new File(fileName + ".ser");
			if (!newFile.exists()) {
				newFile.createNewFile();
				
				TaskList newList = new TaskList();
				
				newList.saveToFile(fileName);
				tasks = newList.readFromFile(fileName);
				setFileName(fileName);
			}
			else {
				readFromFile(fileName);
			}
		}
		catch (IOException e) {
			System.err.println("ToDoListFrame.java > newFile() > IOException e");
		}
		catch (NullPointerException e) {
			System.err.println("ToDoListFrame.java > newFile() > NullPointerException e");
		}
	}
	
	/*
	 * Add a single task to the LinkedList
	 */
	public boolean addTask(Task t) {
		return tasks.add(t);
	}
	
	/*
	 * Removes a single task from the LinkedList
	 */
	public boolean removeTask(Task t) {	
		return tasks.remove(t);
	}

	public LinkedList<Task> getAllTasks() {
		return tasks;
	}
	
	public LinkedList<Task> sortByDueDate() {
		LinkedList<Task> sortedTasks = new LinkedList<Task>();
		Iterator<Task> iter = tasks.iterator();
		while (iter.hasNext()) {
			sortedTasks.add(iter.next());
		}

		Collections.sort(sortedTasks, compareDueDate);
		tasks = sortedTasks;
		return sortedTasks;
	}

	public LinkedList<Task> sortByPriority() {
		LinkedList<Task> sortedTasks = new LinkedList<Task>();
		Iterator<Task> iter = tasks.iterator();
		while (iter.hasNext()) {
			sortedTasks.add(iter.next());
		}

		Collections.sort(sortedTasks, comparePriority);
		tasks = sortedTasks;
		return sortedTasks;
	}

	public LinkedList<Task> findNextDueTask() {
		LinkedList<Task> e = sortByDueDate();
		LinkedList<Task> sortedTasks = new LinkedList<Task>();

		Iterator<? extends Task> iter = e.iterator();

		if (iter.hasNext()) {
			long soonestDue = iter.next().getDueDate().getTimeInMillis();

			while (iter.hasNext()) {
				Task check = iter.next();
				if (check.getDueDate().getTimeInMillis() <= soonestDue) {
					soonestDue = check.getDueDate().getTimeInMillis();
				}
			}
			iter = e.iterator();
			while (iter.hasNext()) {
				Task check = iter.next();
				if (check.getDueDate().getTimeInMillis() == soonestDue) {
					sortedTasks.add(check);
				}
			}
		}
		return sortedTasks;
	}

	public LinkedList<Task> getHighPriorityTasksByDueDate() {
		LinkedList<Task> e = sortByDueDate();
		LinkedList<Task> sortedTasks = new LinkedList<Task>();
		Iterator<? extends Task> iter = e.iterator();

		int highest = 4;
		while (iter.hasNext()) {
			Task check = iter.next();
			if (check.getPriority() < highest) {
				highest = check.getPriority();
			}
		}
		iter = e.iterator();
		while (iter.hasNext()) {
			Task check = iter.next();
			if (check.getPriority() == highest) {
				sortedTasks.add(check);
			}
		}
		return sortedTasks;
	}

	/*
	 * The next methods are used by the two different sort 
	 * methods to be able to sort according to the due date
	 * or the priority. 
	 * 
	 * The comparePriority method is like the compareTo method 
	 * in the Task class, it's purpose is just to com
	 */
	public int comparePriority(Task t1, Task t2) {
		int equal = 0;
		if (t1.getPriority() < t2.getPriority()) {
			equal = -1;
		} else if (t1.getPriority() > t2.getPriority()) {
			equal = 1;
		}
		return equal;
	}

	transient Comparator<Task> comparePriority = new Comparator<Task>() {
		@Override
		public int compare(Task t1, Task t2) {
			return comparePriority(t1, t2);
		}
	};

	transient Comparator<Task> compareDueDate = new Comparator<Task>() {
		@Override
		public int compare(Task t1, Task t2) {
			return (int) t1.compareTo(t2);
		}
	};
	
	/*
	 * Accessors and mutators
	 */
	public void setFileName(String fN) {
		fileName = fN;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setErrorMsg(String err) {
		currentErrorMessage = err;
	}
	
	
	public String getErrorMsg() {
		return currentErrorMessage;
	}
}