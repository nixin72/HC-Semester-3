package inheritance;

public class Dog extends Pet {
	public Dog() {
		super("dog");
	}

	public Dog(char sex) {
		super("dog", sex);
	}

	public Dog(char sex, String name) {
		super("dog", name, sex);
	}

	public String speak() {
		return "Woof";
	}
}
