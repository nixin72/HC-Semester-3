package pdumaresq_B30_A01;

import java.util.ArrayList;

public abstract class Question {

	protected static char typeCode;
	protected static String question;
	String answer;
	
	/*
	 * default Constructor
	 */
	protected Question() {
		typeCode = '?';
		question = "Unknown";
	}
	
	/*
	 * The primary constructor for a question Object. Each question must have 
	 * a type and a question, the answer is dependent on the type, so any way 
	 * the question is answered is determined by a child class. 
	 */
	protected Question(char t, String q, String a) {
		typeCode = t;
		question = q;
		answer = a;
	}
	
	/*
	 * Accessor and Mutator Methods for the Question object.
	 */
	protected void setType(char t) {
		typeCode = t;
	}
	
	protected void setQuestion(String q) {
		question = q;
	}
	
	public char getType() {
		return typeCode;
	}
	
	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
	/*
	 * Abstract method to check the answer in the child classes. 
	 * All of question type classes at the bottom of the hierarchy will
	 * override this method to check if for that specific type of question.
	 */
	protected abstract boolean checkAnswer(String a, ArrayList<Answer> o);
}