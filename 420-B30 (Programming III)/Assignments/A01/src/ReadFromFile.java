import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {
	private ArrayList<Question> questions;
	
	public ArrayList<Question> readFromFile() {
		try {
			File file = new File("./quizQuestions.txt");
			Scanner read = new Scanner(file);
			
			questions = new ArrayList<Question>();
			while (read.hasNextLine()) {
				String line = read.nextLine();
				char type = line.charAt(0);
				switch (type) {
					case 'F': questions.add(parseFillInTheBlank(line)); break;
					case 'N': questions.add(parseNumeric(line)); break;
					case 'S': questions.add(parseSingleChoice(line)); break;
					case 'M': questions.add(parseMultiChoice(line)); break;
				}
			}
			
			read.close();
		}
		catch (FileNotFoundException e) {
			return null;
		}
//		catch (Exception e) {
//			return null;
//		}
		
		return questions;
	}
	
	private FillInTheBlankQuestion parseFillInTheBlank(String line) {
		line = line.substring(2);		
		int begin = line.indexOf("_")-1;
		int end = line.lastIndexOf("_")+1;
		String question = line.substring(0, begin) + " ________" + line.substring(end);
		String answer = line.substring(begin+2, end-1);
				
		return new FillInTheBlankQuestion(question, answer);
	}
	
	private NumericQuestion parseNumeric(String line) {
		line = line.substring(2);
		int end = line.lastIndexOf("?")+1;
		String question = line.substring(0, end);
		String answer = line.substring(end+2);
		
		return new NumericQuestion(question, answer);
	}
	
	private ChoiceQuestion parseChoiceQuestion(String line) {
		line = line.substring(2);
		int end = line.indexOf("?")!=-1 ? line.indexOf("?") : line.indexOf(".") ;
		
		String question = line.substring(0, end);
		String answer = line.substring(end);
		
		String[] ans = answer.split("(in)?correct");
		ArrayList<Answer> answers = new ArrayList<Answer>();
		for (String a : ans) {
			int split = a.lastIndexOf(",");
			
			answers.add(new Answer(
				a.substring(0, split), 
				a.substring(split).equalsIgnoreCase("correct")
			));
		}
		
		return new ChoiceQuestion(question, answers);
	}
	
	private SingleChoiceQuestion parseSingleChoice(String line) {
		ChoiceQuestion question = parseChoiceQuestion(line);
		
		return new SingleChoiceQuestion(question.question, question.options);
	}
	
	private MultiChoiceQuestion parseMultiChoice(String line) {
		ChoiceQuestion question = parseChoiceQuestion(line);
		
		return new MultiChoiceQuestion(question.question, question.options);
	}
}
