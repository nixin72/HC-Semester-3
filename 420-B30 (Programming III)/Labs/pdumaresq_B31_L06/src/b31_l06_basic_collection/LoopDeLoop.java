package b31_l06_basic_collection;

import inheritance.*;
import collection.BasicCollection;

public class LoopDeLoop {
	public static void main(String[] args) {
		// An array of 5 Animals
		Animal[] menagerie = new Animal[5];
		menagerie[0] = new Dog('M', "Jasper");
		menagerie[1] = new Cat('F', "Tess");
		menagerie[2] = new Dog('F', "Kori");
		menagerie[3] = new Lion('M');
		menagerie[4] = new Cat('M', "Tripod");
		for (int i = 0; i < menagerie.length; ++i) {
			System.out.println(menagerie[i].toString());
		}
		System.out.println("\n");
		// Display the menagerie using a for-each loop
		for (Animal q : menagerie) {
			System.out.println(q);
		}
		System.out.println("\n");
		// Create a BasicCollection of 5 Animal objects
		BasicCollection<Animal> animal = new BasicCollection<Animal>();
		for (Animal q : menagerie) {
			animal.add(q);
		} 
		// Display the collection using a for-each loop
		for (Animal q: animal) {
			System.out.println(q);
		}
		System.out.println("\n");
		
	} // main()
} // LoopDeLoop class
