import java.util.ArrayList;

public abstract class Question {
	protected String question;	
	protected String answer;
	protected ArrayList<Answer> options;
	
	protected Question() {
		this.question = "";
		this.answer = "";
	}
	
	protected Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public abstract boolean checkAnswer(String answer) throws Exception;
}