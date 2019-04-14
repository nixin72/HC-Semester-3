import java.util.ArrayList;
import java.util.Scanner;

public class QuizRunner {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		ReadFromFile reader = new ReadFromFile();
		ArrayList<Question> questions = reader.readFromFile();
		if (questions == null) {
			System.out.println("Could not read from file. Aborting.");
			System.exit(-1);
		}
		
		int numQuestions, numCorrect = numQuestions = 0;
		for (Question q : questions) {
			System.out.print(q.getQuestion().trim() + "\r\n");
			if (q instanceof ChoiceQuestion) {
				for (Answer a : q.options) {
					System.out.println();
				}
				System.out.println("choice");
			}
			
			String answer = input.nextLine();
			
			try {
				if (q.checkAnswer(answer)) {
					System.out.println("Correct!");
					numCorrect++;
				}
				else {
					System.out.println("Incorrect!");
				}
			} catch (Exception e) {
				System.out.println("Incorrect.");
			}
			finally {
				numQuestions++;
			}
		}
		
		System.out.println("Your score was " + ((double)numCorrect / (double)numQuestions)*100d);
		System.out.println("Goodbye!");
		input.close();
	}
}