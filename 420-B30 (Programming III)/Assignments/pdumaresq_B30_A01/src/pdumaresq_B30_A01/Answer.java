package pdumaresq_B30_A01;

public class Answer {
	String answer;
	boolean correct;
	int number;

	public Answer(int n, String a, boolean c) {
		number = n;
		answer = a;
		correct = c;
	}

	public int getNumber() {
		return number;
	}

	public String getAnswer() {
		return answer;
	}

	public boolean getCorrect() {
		return correct;
	}
}
