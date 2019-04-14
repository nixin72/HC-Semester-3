package pdumaresq_B30_A01;

import java.util.ArrayList;

public class SingleChoiceQuestion extends Question {
	char type;
	String question;
	String answer;

	public SingleChoiceQuestion(char t, String q, String a) {
		super(t, q, a);
		type = t;
		question = q;
		answer = a;
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
	 * This method is going to take in the instantiated ArrayList of Answer
	 * objects and will check first if the answer is greater than the length of
	 * the array.
	 */
	public boolean checkAnswer(String a, ArrayList<Answer> o) {
		boolean correct = false;
		try {
			if (o.get(Integer.parseInt(a)-1).getCorrect()) {
				correct = true;
			}
		} catch (Exception e) {
			correct = false;
		}
		return correct;
	}
}