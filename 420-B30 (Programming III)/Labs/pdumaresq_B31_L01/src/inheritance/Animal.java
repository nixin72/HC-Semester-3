package inheritance;

public abstract class Animal {
	private String animalType;
	private char sex;

	public Animal() {
		animalType = "Unknown";
		sex = 'U';
	}

	public Animal(String animalType) {
		this.animalType = animalType;
		sex = 'U';
	}

	public Animal(String animalType, char s) {
		this.animalType = animalType;
		sex = s;
	}

	public abstract String speak();

	public abstract String move();

	public String getAnimalType() {
		return animalType;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String toString() {
		return getSex() + " " + animalType;
	}
	
	public boolean equals(Object Q) {
		boolean equal = false;
		if ((Q == null) || (!(Q instanceof Animal))) 
			equal = false;
		else if ((this.getAnimalType().equals(((Animal)(Q)).getAnimalType())) && (this.getSex().equals(((Animal)(Q)).getSex()))) {
			equal = true;
		}
		return equal;
	}

	public String getSex() {
		if (sex == 'M')
			return "Male";
		else if (sex == 'F')
			return "Female";
		else
			return "Unknown";
	}
}
