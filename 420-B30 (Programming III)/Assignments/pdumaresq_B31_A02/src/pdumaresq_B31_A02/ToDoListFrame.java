package pdumaresq_B31_A02;


//java.awt
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//java.io
import java.io.File;
//java.util
import java.util.Iterator;
import java.util.LinkedList;

//javax.swing
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ToDoListFrame extends JFrame implements ActionListener {
	TaskList task = new TaskList();
		
	private static String DEFAULT_FILE = "default.ser";
	String fileName;
	private String lastUsedDisplay = "DBDD";
		
	private static JPanel contentPane;
	
	JMenuBar menuBar;
	private JMenu mnDisplayBy;
	private JMenuItem mntmDueDate_1;
	private JMenuItem mntmNextDueTasks;
	private JMenuItem mntmByPriority;
	private JMenuItem mntmHighPriorityTasks;
	private JMenuItem mntmAddNewTask;
	private JMenuItem mntmSaveChanges;
	private JMenu mnFile;
	private JMenuItem menuAddTask;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmNewFile;

	
	private LinkedList<JButton> taskDisplay;
	private JPanel displayTasks;
	private JScrollPane scrollBar;
	private JScrollPane scrollingBar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDoListFrame frame = new ToDoListFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);									
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ToDoListFrame() {
		String file = JOptionPane.showInputDialog("<html><h2>Please enter the name of the "
					+"<br />file you'd like to read from.</h2></html>");
		task.setFileName(file);
		
		try {
			if (!(new File(file+".ser").exists()) || file.equals(null) || file.equals("")) {
				task.setFileName("default");
				JOptionPane.showMessageDialog(null, "<html><h2>The file could not be found. "
						+ "<br />Reading in from the default file \"" 
						+ task.getFileName() + ".ser\"</h2></html>", "Error", JOptionPane.ERROR_MESSAGE);	
			}	
			if (task.readFromFile(file).isEmpty()) {
				JOptionPane.showMessageDialog(null, "<html><h2>" + task.getErrorMsg()+"</h2></html>"
					, "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		} 
		catch (NullPointerException e) {
			System.err.println("ToDoListFrame.java > ToDoListFrame() > NullPointerException e");
			JOptionPane.showMessageDialog(null, "<html><h2>Reading in from the default file \"" 
					+ task.getFileName() + ".ser\"</h2></html>", "Error", JOptionPane.ERROR_MESSAGE);
			
			if (task.readFromFile(DEFAULT_FILE).isEmpty()) {
				JOptionPane.showMessageDialog(null, "<html><h2>" + task.getErrorMsg()+"</h2></html>"
						, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		setTitle("To do list");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuBar.add(mnFile);

		mntmNewFile = new JMenuItem("New file");
		mntmNewFile.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnFile.add(mntmNewFile);
		mntmNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				task.newFile(JOptionPane.showInputDialog("Please name the file: "));
				resetFrame();
				redrawTasks();
			}
		});
		
		mntmSaveChanges = new JMenuItem("Save");
		mntmSaveChanges.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnFile.add(mntmSaveChanges);
		mntmSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				task.saveToFile(task.getFileName());
			}
		});

		mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnFile.add(mntmSaveAs);
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!task.saveAs(JOptionPane.showInputDialog("Save file as: "))) {
					JOptionPane.showMessageDialog(null, "The file " + task.getFileName() 
							+ ".ser already exists. The tasks have been saved to that file.", "Error"
							, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		mntmAddNewTask = new JMenuItem("Add new task");
		mntmAddNewTask.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnFile.add(mntmAddNewTask);
		mntmAddNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTask();
			}
		});

		mnDisplayBy = new JMenu("display by...");
		mnDisplayBy.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuBar.add(mnDisplayBy);

		mntmDueDate_1 = new JMenuItem("Due Date");
		mntmDueDate_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnDisplayBy.add(mntmDueDate_1);
		mntmDueDate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
				displayByDueDate();
			}
		});

		mntmNextDueTasks = new JMenuItem("Next Due Tasks");
		mntmNextDueTasks.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnDisplayBy.add(mntmNextDueTasks);
		mntmNextDueTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
				displayNextDueTasks();
			}
		});

		mntmByPriority = new JMenuItem("By Priority");
		mntmByPriority.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnDisplayBy.add(mntmByPriority);
		mntmByPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
				displayByPriority();
			}
		});

		mntmHighPriorityTasks = new JMenuItem("High Priority Tasks");
		mntmHighPriorityTasks.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnDisplayBy.add(mntmHighPriorityTasks);
		mntmHighPriorityTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFrame();
				displayHighPriority();
			}
		});

		menuAddTask = new JMenuItem("Add new task");
		menuAddTask.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuBar.add(menuAddTask);
		menuAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTask();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollingBar = new JScrollPane();
		scrollingBar.setPreferredSize(new Dimension(600,600));
		contentPane.add(scrollingBar);
		
		displayTasks = new JPanel();
		scrollingBar.setViewportView(displayTasks);
		displayTasks.setLayout(new BoxLayout(displayTasks, BoxLayout.Y_AXIS));
		
		scrollBar = new JScrollPane();
		displayTasks.add(scrollBar);
		
		
		//mntmDueDate_1.doClick();
	}
	
	@SuppressWarnings("static-access")
	private void addTask() {
		AddTaskFrame frame = new AddTaskFrame(task);
			
		class CustomerWindowListener implements WindowListener {
			@Override
			public void windowActivated(WindowEvent arg0) {}
			@Override
			public void windowClosed(WindowEvent arg0) {
				resetFrame();				
				redrawTasks();
			}
			@Override
			public void windowDeactivated(WindowEvent arg0) {}
			@Override
			public void windowDeiconified(WindowEvent arg0) {}
			@Override
			public void windowIconified(WindowEvent arg0) {}
			@Override
			public void windowOpened(WindowEvent arg0) {}
			@Override
			public void windowClosing(WindowEvent e) {}
		}
		
		frame.addWindowListener((WindowListener) new CustomerWindowListener());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);	
	}
	
	private void displayByDueDate() {
		taskDisplay = new LinkedList<JButton>();
		LinkedList<Task> sortedList = task.sortByDueDate();
		lastUsedDisplay = "DBDD";
		
		displayTasks(sortedList, "displayByDueDate");
	}
	
	private void displayNextDueTasks() {
		taskDisplay = new LinkedList<JButton>();
		LinkedList<Task> sortedList = task.findNextDueTask();
		lastUsedDisplay = "DNDT";
		
		displayTasks(sortedList, "displayNextDueTasks");
	}
	
	private void displayByPriority() {
		taskDisplay = new LinkedList<JButton>();
		LinkedList<Task> sortedList = task.sortByPriority();
		lastUsedDisplay = "DBP";
		
		displayTasks(sortedList, "displayByPriority");
	}
	
	private void displayHighPriority() {
		taskDisplay = new LinkedList<JButton>();
		LinkedList<Task> sortedList = task.getHighPriorityTasksByDueDate();
		lastUsedDisplay = "DHP";
		
		displayTasks(sortedList, "displayHighPriority");
	}
	
	/*
	 * This method will take in a sorted linkedList of tasks 
	 * and a String saying where the method was called from. 
	 * it will then check if the LinkedList contains any tasks.
	 * If it doesn't, It'll just tell the user it's empty. If 
	 * it does contain tasks, it will loop through the linkedList
	 * and add items to the taskDisplay LinkedList of JButtons.
	 * It will then add all those buttons to the frame.  
	 */
	public void displayTasks(LinkedList<Task> e, String callFrom) {
		Iterator<Task> iter = e.iterator();
		if (iter.hasNext()) {
			int i = 0;
			contentPane.setLayout(new GridLayout(e.size(), 1));
			
			while (iter.hasNext()) {
				Task add = iter.next();

				taskDisplay.add(new JButton(add.toString()));
				taskDisplay.get(i).addActionListener(this);
				
				displayTasks.add(taskDisplay.get(i));
				i++;
			}
			displayTasks.revalidate();
		}
		else {
			JTextArea error = new JTextArea("Error: there are no tasks in the file " 
					+ task.getFileName() + ".\n"+ callFrom);
			error.setEditable(false);
			displayTasks.add(error);	
		}
	}
	
	/*
	 * This method will call the confirmDelete method just to make sure the 
	 * user wants to delete the current task. If they do, it will create a 
	 * linkedList of buttons using the original linked list instance variable.
	 * it will also create a linkedList of tasks using the TaskList classes's 
	 * current LinkedList. it will loop through the LinkedList of buttons and 
	 * check if the current button is the source of the event currently getting
	 * fired. If it is, it'll call the removeTask method in the tasks class using 
	 * an index that is incremented with the loop counter. It then clears the 
	 * frame and recalls the displayTasks method using the modified LinkedList.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (confirmDelete()) {
			LinkedList<JButton> tasks = taskDisplay;
			LinkedList<Task> tasks2 = task.getAllTasks();
			
			Iterator<JButton> iter = tasks.iterator();
			
			int index = 0;
			while (iter.hasNext()) {
				if (e.getSource().equals(tasks.get(index))) {
					task.removeTask(tasks2.get(index));
				}
				
				iter.next();
				index++;
			}
			resetFrame();
			redrawTasks();
		}
	}
	
	public void resetFrame() {
		displayTasks.removeAll();
		displayTasks.revalidate();
		displayTasks.repaint();
	}
	
	public void redrawTasks() {
		switch (lastUsedDisplay) {
			case ("DBDD"): displayByDueDate();
				break;
			case ("DNDT"): displayNextDueTasks();
				break;
			case ("DBP"): displayByPriority();
				break;
			case ("DHP"): displayHighPriority();
		}	
	}
	
	/*
	 * This will get called by the actionPerformed method just to confirm
	 * that the user does actually want to delete the current task. If they
	 * click the yes button, the method will return true.
	 */
	public boolean confirmDelete() {
		int selected = JOptionPane.showConfirmDialog(null,
                "Would you like to delete this task?", "Confirm delete",
                JOptionPane.YES_NO_OPTION);
		
		if (selected == 0) {
			return true;
			
		}
		return false;
	}
}