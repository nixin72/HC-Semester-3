package pdumaresq_B30_A01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MultiChoiceQuestion extends SingleChoiceQuestion {
	char type;
	String question;
	String answer;
	
	public MultiChoiceQuestion(char t, String q, String a) {
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
	 * This method overrides the checkAnswer method in the SingleChoiceQuestion class. 
	 * It takes in a string and an ArrayList of type Answer.
	 * It then takes the string, which was the user's answer, and will split it into
	 * an array of the chosen options, each option being one number. It then loops 
	 * through the ArrayList of Answer objects and will check if that index in the ArrayList 
	 * has an attribute of correct that is true. It then increments the number of correct
	 * answers by one. If it is correct, it loops through the array of numbers the user 
	 * entered and checks if that answer is equal to current index in the Answer object
	 * ArrayList. Then it just does a bit of boolean algebra to make sure correct is set
	 * appropriately. 
	 */
	public boolean checkAnswer(String a, ArrayList<Answer> o) {
		boolean correct = true;
		try {
			String[] chosen = a.split(",{1} ?");
			Arrays.sort(chosen);
			ArrayList<String> options = new ArrayList<String>();
			for (int i = 0 ; i < o.size() ; i++) {
				if (o.get(i).getCorrect()) { 
					options.add(Integer.toString(o.get(i).getNumber()+1));
				}
			}//outer for
			Collections.sort(options);
						
			for (int q = 0 ; q < options.size() ; q++) {
				if (chosen[q].equals(options.get(q))) {
					correct = correct && true;
				}
				else {
					correct = false;
				}
			}
		}
		//I don't particularly care what exception it throws since I want to handle them all the same. Just return incorrect.
		catch(Exception e) {
			correct = false;
		}//catch
		return correct;
	}//checkAnswer()
}