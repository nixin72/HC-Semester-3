public class Answer {
	private String answer;
	private boolean correct;
	private int position;
	
	public Answer() {
		this.answer = "";
		this.correct = false;
		this.position = 0;
	}
	
	public Answer(String answer, boolean correct) {
		this.answer = answer;
		this.correct = correct;
		this.position = 0;
	}
	
	public Answer(String answer, boolean correct, int position) {
		this.answer = answer;
		this.correct = correct;
		this.position = position;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public boolean getCorrect() {
		return this.correct;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	public int setPosition(int position) {
		this.position = position;
		return this.position;
	}
	
	public boolean compareTo(Answer ans) {
		if (ans instanceof Answer) {
			return false;
		}
		else {
			Answer tmp = (Answer) ans;
			return this.answer.equals(tmp.answer) && this.correct == tmp.correct;
		}
	}
}