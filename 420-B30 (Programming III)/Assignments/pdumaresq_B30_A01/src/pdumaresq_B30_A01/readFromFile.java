package pdumaresq_B30_A01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFromFile {
	static File quizQuestions = null;
	static Scanner read;
	static ArrayList<Question> questions = new ArrayList<Question>();
	static String fileName;
	static String error = "";

	/*
	 * Accessor method for the questions ArrayList. This makes it accessible
	 * from the QuizTaker class.
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}

	/*
	 * This method will create the quiz. It opens the file quizQuestions.txt and
	 * instantiates a Scanner object to read from it. It then loops through
	 * every line in the file and generates a question out of it.
	 */
	public static void createQuiz() {
		try {
			setFileName("quizQuestions.txt");
			quizQuestions = new File(getFileName());
			read = new Scanner(quizQuestions);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		// Loops through the file until there's no lines left in it.
		while (read.hasNextLine()) {
			String fileLine = read.nextLine();

			/*
			 * Saves the variable for the type as the character at the first
			 * index in the fileLine String
			 */
			char type = fileLine.charAt(0);

			/*
			 * If the question is a fill in the blank question, then it will
			 * generate a question by finding the substring starting at the
			 * first character in the question until the first underscore in the
			 * fileLine string. Then it prints out a blank line to indicate to
			 * the user where the blank space in the question is located. It
			 * then prints out anything in the question after the index of the
			 * last underscore in the line and ends by printing out a period.
			 */
			if (type == 'F') {
				try {
					String question = fileLine.substring((3), fileLine.indexOf('_')) + "_________"
							+ fileLine.substring(fileLine.lastIndexOf('_') + 1, fileLine.lastIndexOf('.') + 1);
					String answer = fileLine.substring(fileLine.indexOf('_') + 1, fileLine.lastIndexOf('_'));
					
					if (question.matches("^([0-9A-Za-z\\s]*)(_________)([0-9A-Za-z\\s]*).$") && answer.matches("^.+$")) {
						Question fillInTheBlank = new FillInTheBlankQuestion(type, answer, question);
						questions.add(fillInTheBlank);
					}
					else {
						setErrorMsg();
					}
				} catch (IndexOutOfBoundsException e) {
					setErrorMsg();
				}
			}

			/*
			 * The numeric questions are a little easier than fill in the blank
			 * since the answer is always in the same place. This question will
			 * generate a string for the question that's the substring starting
			 * at the beginning of the question (taking off a space and type
			 * from the beginning) and then ending the substring at last index
			 * of the question mark. It then saves the answer in a double
			 * variable which is the substring at the last index of the comma
			 * followed by the rest of the characters. It tries to take the
			 * blank spaces off the beginning so it easily converts into a
			 * double. Then it adds the new NumericQuestion object to the
			 * questions ArrayList.
			 */
			else if (type == 'N') {
				try {
					String question = fileLine.substring(3, fileLine.lastIndexOf('?') + 1);
					double answer = Double.parseDouble(fileLine.substring(fileLine.lastIndexOf("?, ") + 2));
					
					if (question.matches("^.+\\?$")) {
						Question numeric = new NumericQuestion(type, question, answer);
						questions.add(numeric);		
					}
					else {
						setErrorMsg();
					}
				}
				catch (NumberFormatException e) {
					setErrorMsg();
				}
			}

			/*
			 * This is the handling for a single choice type question. It will
			 * first take the substring of the beginning of question until the
			 * question mark and will save that in the question variable. It
			 * then takes the rest of the question and saves it in the answer
			 * variable and then passes those to a new SingleChoiceQuestion
			 * Object and add that question to the questions ArrayList.
			 */
			else if (type == 'S') {
				try {
					String question = "";
					String answer = "";
					if (fileLine.contains("?, ")) {
						question = fileLine.substring(3, fileLine.lastIndexOf('?') + 1);
						answer = fileLine.substring(fileLine.lastIndexOf("?, "));
					} else if (fileLine.contains("., ")) {
						question = fileLine.substring(3, fileLine.lastIndexOf('.') + 1);
						answer = fileLine.substring(fileLine.lastIndexOf("., "));
					}
					
					if (question.matches("^.+((\\?)|(\\.))$") 
								&& answer.matches("^((\\?|\\.),\\s)([0-9],\\s)(([A-Za-z\\s]{1,20}),\\s(correct|incorrect)(,\\s)?)+$")) {
						Question singleChoice = new SingleChoiceQuestion(type, question, answer);
						questions.add(singleChoice);
					}
					else {
						setErrorMsg();
					}
				}
				catch (Exception e) {
					setErrorMsg();
				}
			}
			/*
			 * This is the handling for a multiple choice type questions. It will
			 * first take the substring of the beginning of question until the
			 * question mark and will save that in the question variable. It
			 * then takes the rest of the question and saves it in the answer
			 * variable and then passes those to a new SingleChoiceQuestion
			 * Object and add that question to the questions ArrayList.
			 */
			else if (type == 'M') {
				String question = fileLine.substring(3, fileLine.lastIndexOf('?') + 1);
				String answer = fileLine.substring(fileLine.lastIndexOf("?, "));

				if (question.matches("^.+((\\?)|(\\.))$") 
						&& answer.matches("^(\\?,\\s)([0-9],\\s)(([A-Za-z\\s]{1,20}),\\s(correct|incorrect)(,\\s)?)+$")) {
					Question multiChoice = new MultiChoiceQuestion(type, question, answer);
					questions.add(multiChoice);
				}
				else {
					setErrorMsg();
				}
			} else {
				setErrorMsg();
			}
		} // while (read.hasNextLine())
	}// createQuiz()

	/*
	 * Methods to set an error message to display to the user at the beginning of the quiz
	 * that some lines in the file have errors.
	 */
	public static void setErrorMsg() {
		error = "----- There's an error in the file. Some questions may have been skipped. -----\n\n";
	}
	
	public static String getErrorMsg() {
		return error;
	}
	
	/*
	 * These method are in here just because I want the file name accessible
	 * from outside the readFromFile class since it get's accessed when
	 * welcoming the user to the quiz. So I'm making the file name accessible.
	 */
	private static void setFileName(String fN) {
		fileName = fN;
	}

	public static String getFileName() {
		return fileName;
	}
}