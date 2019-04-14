package pdumaresq_B31_A02;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings({"serial", "rawtypes"})
public class AddTaskFrame extends JFrame {
	TaskList task;
	String desciption;
	String location;
	
	private JTextField fldTaskNumber;
	private JTextField fldCourseNumber;
	private JTextField fldCourseTeacher;
	private JComboBox cmbxTaskTypeH;
	
	private JComboBox cmbxTaskTypeP;
	private JTextField fldTaskName;
	
	JRadioButton rdbtnHomeworkTask;	
	JLabel lblTaskTypeH;
	JLabel lblTaskNumber;
	JLabel lblCourseNumber;
	JLabel lblCourseTeacher;
	JTextArea txtDescription;
	
	JRadioButton rdbtnPersonalTask;
	JLabel lblTaskTypeP;
	JLabel lblTaskName;
	JTextArea txtLocation;
	
	JLabel lblDueDate;
	JLabel lblDay;
	JLabel lblMonth;
	JLabel lblYear;
	JComboBox cmbxDay;
	JComboBox cmbxMonth;
	JComboBox cmbxYear;
	JLabel lblPriority;
	JComboBox cmbxPriority;
		
	JButton btnAddTask;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTaskFrame frame = new AddTaskFrame(null);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AddTaskFrame(TaskList e) {
		task = e;
				
		setTitle("Add New Task");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 551);
		getContentPane().setLayout(null);
		
		lblTaskTypeH = new JLabel("Task Type:");
		lblTaskTypeH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaskTypeH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaskTypeH.setBounds(15, 52, 124, 20);
		getContentPane().add(lblTaskTypeH);
		
		lblTaskNumber = new JLabel("Task Number:");
		lblTaskNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaskNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaskNumber.setBounds(0, 88, 139, 20);
		getContentPane().add(lblTaskNumber);
		
		lblCourseNumber = new JLabel("Course Number:");
		lblCourseNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourseNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCourseNumber.setBounds(0, 124, 139, 20);
		getContentPane().add(lblCourseNumber);
		
		lblCourseTeacher = new JLabel("Course teacher:");
		lblCourseTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCourseTeacher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCourseTeacher.setBounds(15, 160, 124, 20);
		getContentPane().add(lblCourseTeacher);
		
		fldTaskNumber = new JTextField();
		fldTaskNumber.setBounds(154, 85, 146, 26);
		getContentPane().add(fldTaskNumber);
		fldTaskNumber.setColumns(10);
		
		fldCourseNumber = new JTextField();
		fldCourseNumber.setColumns(10);
		fldCourseNumber.setBounds(154, 121, 146, 26);
		getContentPane().add(fldCourseNumber);
		
		fldCourseTeacher = new JTextField();
		fldCourseTeacher.setColumns(10);
		fldCourseTeacher.setBounds(154, 157, 146, 26);
		getContentPane().add(fldCourseTeacher);
		
		cmbxTaskTypeH = new JComboBox();
		cmbxTaskTypeH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbxTaskTypeH.setBounds(154, 49, 146, 26);
		getContentPane().add(cmbxTaskTypeH);
		cmbxTaskTypeH.setModel(new DefaultComboBoxModel(new String[] {"Lab", "Assignment", "Test", "Reading", "Essay", "Other"}));
		
		lblTaskTypeP = new JLabel("Task Type:");
		lblTaskTypeP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaskTypeP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaskTypeP.setBounds(315, 88, 107, 20);
		getContentPane().add(lblTaskTypeP);
		
		lblTaskName = new JLabel("Task Name:");
		lblTaskName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTaskName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaskName.setBounds(315, 124, 107, 20);
		getContentPane().add(lblTaskName);
		
		cmbxTaskTypeP = new JComboBox();
		cmbxTaskTypeP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbxTaskTypeP.setBounds(437, 85, 146, 26);
		getContentPane().add(cmbxTaskTypeP);
		cmbxTaskTypeP.setEnabled(false);
		cmbxTaskTypeP.setModel(new DefaultComboBoxModel(new String[] {"Appointment", "Bill payment", "Errand", "Other"}));
		
		fldTaskName = new JTextField();
		fldTaskName.setColumns(10);
		fldTaskName.setBounds(437, 124, 146, 26);
		getContentPane().add(fldTaskName);
		fldTaskName.setEnabled(false);
		
		lblDueDate = new JLabel("Due date:");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDueDate.setBounds(670, 26, 118, 20);
		getContentPane().add(lblDueDate);
		
		lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setBounds(608, 52, 69, 20);
		getContentPane().add(lblDay);
		
		lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setBounds(608, 88, 69, 20);
		getContentPane().add(lblMonth);
		
		lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setBounds(608, 124, 69, 20);
		getContentPane().add(lblYear);
		
		cmbxDay = new JComboBox();
		cmbxDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbxDay.setBounds(692, 49, 96, 26);
		getContentPane().add(cmbxDay);
		cmbxDay.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10"
																,"11","12","13","14","15","16","17","18","19","20"
																,"21","22","23","24","25","26","27","28","29","30","31"}));
		
		cmbxMonth = new JComboBox();
		cmbxMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbxMonth.setBounds(692, 85, 96, 26);
		getContentPane().add(cmbxMonth);
		cmbxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June",
																  "July", "August", "September", "October", "November", "December"}));
		
		cmbxYear = new JComboBox();
		cmbxYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbxYear.setBounds(692, 121, 96, 26);
		getContentPane().add(cmbxYear);
		cmbxYear.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018", "2019", "2020"}));
		
		lblPriority = new JLabel("Priority:");
		lblPriority.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPriority.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriority.setBounds(608, 185, 69, 20);
		getContentPane().add(lblPriority);
		
		cmbxPriority = new JComboBox();
		cmbxPriority.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbxPriority.setBounds(692, 182, 63, 26);
		getContentPane().add(cmbxPriority);
		cmbxPriority.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		btnAddTask = new JButton("Add Task");
		btnAddTask.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddTask.setBounds(154, 434, 225, 29);
		getContentPane().add(btnAddTask);
		
		rdbtnHomeworkTask = new JRadioButton("Homework Task");
		rdbtnHomeworkTask.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnHomeworkTask.setSelected(true);
		rdbtnHomeworkTask.setBounds(90, 11, 210, 29);
		getContentPane().add(rdbtnHomeworkTask);
		
		rdbtnPersonalTask = new JRadioButton("Personal Task");
		rdbtnPersonalTask.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnPersonalTask.setBounds(376, 11, 207, 29);
		getContentPane().add(rdbtnPersonalTask);
		
		JButton btnClearAllFields = new JButton("Clear all fields");
		btnClearAllFields.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClearAllFields.setBounds(437, 434, 217, 29);
		getContentPane().add(btnClearAllFields);
		
		txtDescription = new JTextArea();
		txtDescription.setBounds(154, 227, 146, 191);
		getContentPane().add(txtDescription);
		txtDescription.setLineWrap(true);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(32, 227, 107, 20);
		getContentPane().add(lblDescription);
		
		txtLocation = new JTextArea();
		txtLocation.setBounds(437, 227, 146, 191);
		getContentPane().add(txtLocation);
		txtLocation.setEnabled(false);
		txtLocation.setLineWrap(true);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocation.setBounds(336, 227, 86, 20);
		getContentPane().add(lblLocation);
		
		btnClearAllFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearAllFields();				
			}	
		});
		
		rdbtnHomeworkTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setToHomework();
			}
		});
		
		rdbtnPersonalTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setToPersonal();
			}
		});
				
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTask();
			}
		});
	}
	
	/*
	 * Sets the frame to take in a personal task
	 */
	public void setToPersonal() {
		if (rdbtnPersonalTask.isSelected()) {
			rdbtnHomeworkTask.setSelected(false);
			cmbxTaskTypeP.setEnabled(true);
			fldTaskName.setEnabled(true);
			txtLocation.setEnabled(true);
		}
		cmbxTaskTypeH.setEnabled(false);
		fldTaskNumber.setEnabled(false);
		fldCourseNumber.setEnabled(false);
		fldCourseTeacher.setEnabled(false);
		txtDescription.setEnabled(false);
	}
	
	/*
	 * Sets the Frame to take in a homework task.
	 */
	public void setToHomework() {
		if (rdbtnHomeworkTask.isSelected()) {
			rdbtnPersonalTask.setSelected(false);
			cmbxTaskTypeH.setEnabled(true);
			fldTaskNumber.setEnabled(true);
			fldCourseNumber.setEnabled(true);
			fldCourseTeacher.setEnabled(true);
			txtDescription.setEnabled(true);
		}
		rdbtnPersonalTask.setSelected(false);
		cmbxTaskTypeP.setEnabled(false);
		fldTaskName.setEnabled(false);
		txtLocation.setEnabled(false);
	}
	
	/*
	 * This method will simply reset the entire frame to the default 
	 * when the frame is first opened. 
	 */
	public void clearAllFields() {
		rdbtnHomeworkTask.setSelected(true);
		rdbtnPersonalTask.setSelected(false);
		
		cmbxTaskTypeH.setSelectedIndex(0);
		cmbxTaskTypeH.setEnabled(true);
		fldTaskNumber.setText("");
		fldTaskNumber.setEnabled(true);
		fldCourseNumber.setText("");
		fldCourseNumber.setEnabled(true);
		fldCourseTeacher.setText("");
		fldCourseTeacher.setEnabled(true);
		txtDescription.setEnabled(true);
		txtDescription.setText("");
		
		cmbxTaskTypeP.setSelectedIndex(0);
		cmbxTaskTypeP.setEnabled(false);
		fldTaskName.setText("");
		fldTaskName.setEnabled(false);
		txtLocation.setEnabled(false);
		txtLocation.setText("");
		
		cmbxDay.setSelectedIndex(0);
		cmbxMonth.setSelectedIndex(0);
		cmbxYear.setSelectedIndex(0);
		cmbxPriority.setSelectedIndex(0);
	}
	
	/*
	 * This method will read in the due date and priority from the Frame 
	 * and if the date is a valid date then it will call either the 
	 * addPersonalTask() or the addHomeworkTask method. 
	 */
	public void addTask() {
		int day = (int) cmbxDay.getSelectedIndex() + 1;
		int month = (int) cmbxMonth.getSelectedIndex() + 1;
		int year = (int) cmbxYear.getSelectedIndex() + 2016;
		String dueDate = day + "/" + month + "/" + year;
		
		int priority = (int) cmbxPriority.getSelectedIndex() + 1;
		
		if (validateDate(dueDate)) {
			if (rdbtnPersonalTask.isSelected()) {
				addPersonalTask(dueDate, priority);
			}
			else {
				addHomeworkTask(dueDate, priority);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error: the date is invalid."
					, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * This method takes in the date and priority from the addTask method
	 * and will save the rest of the homework task data and will pass them 
	 * to the validateTaskInfo method. If they all return true, then it will 
	 * also then pass all the data to the addHomeworkTask method in the 
	 * TaskList class. Then the frame is closed.
	 */
	public void addHomeworkTask(String d, int p) {
		String taskType = cmbxTaskTypeH.getSelectedItem().toString();
		String taskNumber = fldTaskNumber.getText();
		String courseNumber = fldCourseNumber.getText();
		String courseTeacher = fldCourseTeacher.getText();
		String description = "";
		
		boolean add = true;
		add = add && validateTaskInfo(taskNumber, "^[0-9]{1,10}$", "task number");
		add = add && validateTaskInfo(courseNumber, "^[\\-A-Za-z0-9-]{1,10}$", "course number");
		add = add && validateTaskInfo(courseTeacher, "^[A-Za-z\\.'\\s]{1,20}$", "teacher name");
				
		if (add) {
			Task hmwrk = new HomeworkTask(d, p, taskType, taskNumber, courseNumber, courseTeacher, description);
			task.addTask(hmwrk);
			this.dispose();
		}
	}
	
	/*
	 * This method takes in the date and priority from the addTask method
	 * and will save the rest of the personal task data and will pass them
	 * to the validateTaskInfo method. If they all return true, then it will
	 * also then pass all the data to the addPersonalTask method in the 
	 * TaskList class. Then the frame is closed.  
	 */
	public void addPersonalTask(String d, int p) {
		String taskType = cmbxTaskTypeP.getSelectedItem().toString();
		String taskName = fldTaskName.getText();
		String location = "";

		boolean add = true;
		add = add && validateTaskInfo(taskName, "^[A-Za-z0-9]{1,20}$", "task name");
		
		if(add) {
			Task prsnl = new PersonalTask(d, p, taskType, taskName, location);
			task.addTask(prsnl);
			this.dispose();
		}
	}
	
	/*
	 * This method will take care of validation. It takes in 3 parameters,
	 * the data that the user entered, a regular expression to compare it 
	 * to and the field that the error is in. If the data is invalid, then 
	 * an error message pops up telling you there's an error and lets you 
	 * know what field it's in. 
	 */
	public boolean validateTaskInfo(String uInput, String regex, String field) {
		if (uInput.matches(regex)) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Error: the " + field + " is invalid. Please enter valid information"
					, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean validateDate(String dD) {
		Calendar dueDate = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		dueDate.setLenient(false);
		Date due = null;
		try {
			due = sdf.parse(dD);
			dueDate.setTime(due);
		} catch (ParseException e) {
			System.out.println("Task.java > formatDate() > ParseException e");
		}
		catch (NullPointerException e) {
			System.out.println("Task.java > formatDate() > NullPointerException e");
		}
		
		return true;
	}
}