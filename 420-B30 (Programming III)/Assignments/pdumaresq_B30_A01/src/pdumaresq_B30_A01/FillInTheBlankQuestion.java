package pdumaresq_B30_A01;

import java.util.ArrayList;

public class FillInTheBlankQuestion extends Question {
	private String answer;
	private String question;
	private char type;

	public FillInTheBlankQuestion(char t, String a, String q) {
		super(t, q, a);
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
		return answer;
	}

	/*
	 * This is the overridden checkAnswer method from the abstract method in the
	 * super class. It takes in a single string parameter, which is the user's
	 * answer to the question, and compares their answer to the correct answer.
	 * It will return a boolean variable telling the QuizTake class whether or
	 * not they answered correctly.
	 * 
	 * Takes in a null array of answer objects.
	 */
	public boolean checkAnswer(String a, ArrayList<Answer> o) {
		boolean correct = false;
		if (a.equalsIgnoreCase(answer)) {
			correct = true;
		}
		return correct;
	}
}