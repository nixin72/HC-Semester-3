package b31_l12_maps;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Name implements Serializable {
	private String firstName;
	private String lastName;

	public Name() {
		super();
	}

	public Name(String f, String l) {
		super();
		firstName = f;
		lastName = l;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean equals(Name name) {
		boolean equal = true;
		equal = equal && (this.firstName.equalsIgnoreCase(name.getFirstName()));
		equal = equal && (this.lastName.equalsIgnoreCase(name.getLastName()));
		return equal;
	}

	public int hashCode() {
		return getFirstName().hashCode() + getLastName().hashCode();
	}
}
