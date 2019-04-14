package pdumaresq_B30_A01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuizTaker {
	static String name;
	static double score = 0;

	@SuppressWarnings("static-access") // static access to methods in the
										// readFromFile class
	public static void main(String[] args) {

		Scanner uInput = new Scanner(System.in);
		readFromFile quiz = new readFromFile();
		ArrayList<Question> questions = new ArrayList<Question>();

		// Creates the quiz from the readFromFile class.
		quiz.createQuiz();
		System.err.println(quiz.getErrorMsg());
		// Welcomes user and prompts for their name. Gets the file name from the
		// readFromFile class and displays it.
		System.out.println("Welcome to Heritage's Quiz Program. " + "Reading in from the file " + quiz.getFileName());
		System.out.print("\nPlease enter your name: ");
		setName(uInput);
		System.out.println("");

		// Creates an ArrayList in the QuizTaker class that's equal to the
		// questions ArrayList in the readFromFile class
		questions = quiz.getQuestions();

		/*
		 * Loops through each question in the ArrayList and displays it. The
		 * user enters their answer. The appropriate checkAnswer method is then
		 * called and it displays whether or not the user is right. If they are,
		 * it increments their score.
		 */
		for (int q = 0; q < questions.size(); q++) {
			System.out.println(questions.get(q).getQuestion());

			if (questions.get(q).getType() == 'S' || questions.get(q).getType() == 'M') {
				// create a string of just the answer portion of the line, just
				// to make string manipulation a little easier.
				String answerLine = "";
				if (questions.get(q).getAnswer().contains("?, ")) {
					answerLine = questions.get(q).getAnswer()
							.substring(questions.get(q).getAnswer().indexOf("?, ") + 3);
				} else if (questions.get(q).getAnswer().contains("., ")) {
					answerLine = questions.get(q).getAnswer()
							.substring(questions.get(q).getAnswer().indexOf("., ") + 3);
				} else {
					answerLine = "ERROR";
				}
				// reading in the number at the beginning since it corresponds
				// to the number of options there are.
				String numOptions = answerLine.substring(0, 1);
				// creating an array of answer object sized equal to the number
				// of different options.
				ArrayList<Answer> options = new ArrayList<Answer>();
				// shortening the string again just to make string manipulation
				// a little easier.
				answerLine = answerLine.substring(3);
				// breaking down the string into segments so that there's just
				// each substring from , to ,
				String breakdown[] = answerLine.split(", ");
				// looping through a for loop until you've gone through for each
				// option.
				for (int z = 0; z < Integer.parseInt(numOptions); z++) {
					int number = z;
					String answer = breakdown[0];
					boolean correct = false;
					if (breakdown[1].equals("correct"))
						correct = true;

					options.add(new Answer(number, answer, correct));
					breakdown = Arrays.copyOfRange(breakdown, 2, breakdown.length);

					System.out.println(number + 1 + ": " + answer);
				}
				System.out.print("Your answer:  ");
				choiceQuestion(uInput, questions, q, options);

			} else if (questions.get(q).getType() == 'F' || questions.get(q).getType() == 'N'){
				System.out.print("Your answer:  ");
				fillInTheBlankNumeric(uInput, questions, q);
			} 
		} // for

		// convert questions.size to a double and calculate the grade, then
		// output it.
		double grade = score / (double) questions.size() * 100;
		System.out.println(name + ", your score was " + grade + "%\nGoodbye.");

		// Close the Scanner object
		uInput.close();

		// calls the outputToFile method passing in the grade variable so that
		// the file is written to.
		outputToFile(grade);

		// exit the program with an exit code 0 to indicate everything is okay.
		System.exit(0);
	}// main

	/*
	 * This method set's the users name. It takes in a Scanner variable so I
	 * don't to instantiate a new one and will simply prompt the user for their
	 * name. Their name is then compared against a regular expression and if it
	 * matches, their name is valid and gets set. Accepts alphabetic characters
	 * and spaces only. Didn't account for things like last names that have a -
	 * in them or a '.
	 */
	private static void setName(Scanner uInput) {
		try {
			name = uInput.nextLine();
			if (!(name.matches("^[a-zA-Z\\s]{1,25}$"))) {
				System.out.print("Please enter a valid name name: ");
				setName(uInput);
			}
		} catch (Exception e) {
			setName(uInput);
		}
	}

	/*
	 * This method takes in all the variables left behind in the main method so
	 * I still have access to them. But I don't need to be looping through all
	 * my string manipulation stuff until the user enters a valid answer so I
	 * just loop through the user input portion of it instead. The answer must
	 * match the regular for the format that I want, otherwise the method will
	 * recall itself so that the user has a chance to retry the question if they
	 * didn't understand how I wanted it inputed.
	 */
	private static void choiceQuestion(Scanner uInput, ArrayList<Question> questions, int q, ArrayList<Answer> options) {
		try {
			String uAnswer = uInput.nextLine();
			String match = "";
			String errorMsg = "";
			if (questions.get(q).getType() == 'S') {
				match = "^([0-9,\\s?])$";
				errorMsg = "'#'.";
			}
			else {
				match = "^([0-9,\\s?])+$";
				errorMsg = "'#, #'.";
			}
			if (!(uAnswer.matches(match))) {
				System.out.print("Please enter a valid answer. It must be in the format of " + errorMsg);
				choiceQuestion(uInput, questions, q, options);
			} else {
				if (questions.get(q).checkAnswer(uAnswer, options)) {
					System.out.println("Correct!\n");
					score++;
				} else {
					System.out.println("Incorrect!\n");
				}
			}
		} catch (Exception e) {
			System.out.println("Incorrect!\n");
		}
	}

	/*
	 * Like the choiceRunner method, this method takes in all the variables from
	 * main method that are needed and matches the user's answer against a 
	 * regular expression. 
	 */
	private static void fillInTheBlankNumeric(Scanner uInput, ArrayList<Question> questions, int q) {
		try {
			String uAnswer = uInput.nextLine();
			String match = "";
			//determines the type of question an determines which regex to use.
			if (questions.get(q).getType() == 'F') {
				match = "^.+$";
			} 
			else {
				match = "^[0-9]+(.[0-9]+)?$";
			} 
			
			//checks if the user's answer matches the regex. if not, recalls the method 
			//so they enter a valid answer.
			if (!(uAnswer.matches(match))) {
				System.out.print("Please enter a valid answer: ");
				fillInTheBlankNumeric(uInput, questions, q);
			}
			else {
				//call the appropriate checkAnswer method tells the user if they're right.
				if (questions.get(q).checkAnswer(uAnswer, null)) {
					System.out.println("Correct!\n");
					score++;
				} else {
					System.out.println("Incorrect!\n");
				}
			}
		} catch (Exception e) {
			System.out.println("Incorrect!");
		}
	}

	/*
	 * This method takes in the grade of the person who took the quiz and will
	 * output it to the file. It handles FileNotFoundExcpetion in case the
	 * something happens to the file name and it handles IOException in case
	 * something invalid is attempted to be written to the file. It writes to
	 * the file formated to have a lot of space between the person's name and
	 * their grade so that the file is nicely format in the end.
	 */
	private static void outputToFile(double grade) {
		FileWriter output;
		try {
			output = new FileWriter(new File("quizScores.txt"), true);

			output.write("\n" + String.format("%-25s%-7s%-3.0f%1s", name, "| ", grade, "%"));
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found, your score was not recorded.");
		} catch (IOException e) {
			System.out.println("There was an error writing to the file, you score could not be recorded.");
		}
	}
}// QuizTaker