/**
 * 
 */
package inheritance;

/**
 * @author 1523066
 *
 */
public class TestInheritance {

	public static void main(String[] args) {
		Lion simba = new Lion();
		Lion mufasa = new Lion('M');
		Dog theExcitedStupidOne = new Dog();
		Dog theSmartOneThatYouAlwaysShowOff = new Dog('F');
		Dog theRidiculouslyCuteOne = new Dog('M', "fluff");
		
		Cat grumpyCat = new Cat();
		Cat Garfield = new Cat('M');
		Cat kitkat = new Cat('F', "Yum");

		System.out.println(simba.toString());
		System.out.println(mufasa.toString());
		System.out.println(theExcitedStupidOne.toString());
		System.out.println(theSmartOneThatYouAlwaysShowOff.toString());
		System.out.println(theRidiculouslyCuteOne.toString());
		System.out.println(grumpyCat.toString());
		System.out.println(Garfield.toString());
		System.out.println(kitkat.toString());
		
		//Test Objects
		Dog aRandomDog = new Dog('M', "fluff");
		Dog aDogWithADifferentName = new Dog('M', "bluff");
		Lion lionWithADifferentSex = new Lion('F');
		Lion aCopyOfMufasa = new Lion('M');
		
		//True
		System.out.println("\nComparing two dogs with random attributes: " + theRidiculouslyCuteOne.equals(aRandomDog)); 
		//false
		System.out.println("Comparing two dogs with different names: " + theRidiculouslyCuteOne.equals(aDogWithADifferentName));
		//false
		System.out.println("Comparing a lion and a cat: " + simba.equals(grumpyCat));
		//false
		System.out.println("Comparing two lions with different sex: " + mufasa.equals(lionWithADifferentSex));
		//true
		System.out.println("Comparing two identical Lions: " + mufasa.equals(aCopyOfMufasa));
		
		
		
	}
}
