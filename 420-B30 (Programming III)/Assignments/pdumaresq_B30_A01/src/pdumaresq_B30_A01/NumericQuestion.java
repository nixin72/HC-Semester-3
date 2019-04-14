package pdumaresq_B30_A01;

import java.util.ArrayList;

public class NumericQuestion extends Question {
	private char type;
	private double answer;
	private String question;

	public NumericQuestion(char t, String q, double a) {
		super(t, q, Double.toString(a));
		question = q;
		answer = a;
		type = t;
	}

	public char getType() {
		return type;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return Double.toString(answer);
	}

	/*
	 * This is the overridden checkAnswer method from the abstract method in the
	 * super class. It takes in a single string parameter, which is the user's
	 * answer to the question, and converts their answer to a double. It then
	 * compares their answer to the correct answer, with a margin of error of
	 * 0.01. It will return a boolean variable telling the QuizTake class
	 * whether or not they answered correctly.
	 * 
	 * takes in a null array of answer objects
	 */
	public boolean checkAnswer(String a, ArrayList<Answer> o) {
		boolean correct = false;
		try {
			double uInput = Double.parseDouble(a);
			if (uInput <= answer + 0.01 && uInput >= answer - 0.01) {
				correct = true;
			}
		} catch (NumberFormatException e) {
			correct = false;
		}
		return correct;
	}
}