import java.util.ArrayList;

public class ChoiceQuestion extends Question {	
	public ChoiceQuestion() {
		super();
		options = new ArrayList<Answer>();
	}

	public ChoiceQuestion(String question, ArrayList<Answer> answer) {
		this.question = question;
		this.options = answer;
	}

	@Override
	public boolean checkAnswer(String answer) throws Exception {		
		String[] responses = answer.split(",");
		ArrayList<Answer> answers = new ArrayList<Answer>();
		
		for (String a : responses) {
			answers.add(new Answer(a, true));
		}
		
		return options.containsAll(answers);
	}
}