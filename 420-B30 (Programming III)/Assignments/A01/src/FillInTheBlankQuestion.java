public class FillInTheBlankQuestion extends Question {

	public FillInTheBlankQuestion() {
		super();
	}

	public FillInTheBlankQuestion(String question, String answer) {
		super(question, answer);
	}

	@Override
	public boolean checkAnswer(String answer) throws Exception {
		return answer.equals(this.answer);
	}

}
