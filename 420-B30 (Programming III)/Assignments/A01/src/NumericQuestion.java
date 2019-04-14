public class NumericQuestion extends Question {

	public NumericQuestion() {
		super();
	}

	public NumericQuestion(String question, String answer) {
		super(question, answer);
	}

	@Override
	public boolean checkAnswer(String answer) throws Exception {
		boolean correct = false;
		try {
			correct = inRange(Double.parseDouble(answer), Double.parseDouble(this.answer), 0.01);
		}
		catch (NumberFormatException e) {
			throw new Exception("The answer was not formatted properly.");
		}
		
		return correct;
	}
	
	private boolean inRange(double num1, double num2, double precision) {
		return num1 <= num2+precision || num1+precision >= num2;
	}
}