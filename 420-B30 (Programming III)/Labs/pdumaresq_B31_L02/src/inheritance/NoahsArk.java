package inheritance;

public class NoahsArk
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static void main(String[] args)
  {
    
    Animal firstAnimal[] = new Animal[10];
    Animal secondAnimal[] = new Animal[10];
   
    Pair<String> sexPair = new Pair<String>("Female", "Male");
            
    firstAnimal[0] = new Dog('F');
    secondAnimal[0] = new Dog('M', "Jasper");
    firstAnimal[1] = new Cat('M', "Tripod");
    secondAnimal[1] = new Cat('F', "Tess");
    firstAnimal[2] = new Lion('F');
    secondAnimal[2] = new Lion('M');
    
    Pair<Animal> animalPair[] = new Pair[10];
    int numPairs = 0;
    
    while (firstAnimal[numPairs] != null) {
    	animalPair[numPairs]= new Pair(firstAnimal[numPairs], secondAnimal[numPairs]);
    	numPairs++;
    }
    System.out.println("There are " + numPairs + " pairs of animals in the ark.");
    
   for (int w = 0 ; w < numPairs ; w++) {
    	System.out.println("Pair[" + w + "] is " + animalPair[w].toString());
    	
    	if (!(animalPair[w].getFirstElement().getSex().equals(sexPair.getFirstElement()))) {
    		animalPair[w].swapElements();
    	}
   }
    
    System.out.println("After swapping: ");
    
    for (int q = 0 ; q < numPairs ; q++) {
    	System.out.println("Pair[" + q + "] is " + animalPair[q].toString());
    }
      
	for ( int q = 0 ; q < numPairs ; q++ ) {
		if ((animalPair[q].getFirstElement().getSex().equals(sexPair.getSecondElement()) 
				&& animalPair[q].getFirstElement().getAnimalType().equals("Lion"))
				|| 
				(animalPair[q].getSecondElement().getSex().equals(sexPair.getSecondElement())
				&& animalPair[q].getSecondElement().getAnimalType().equals("Lion"))) {
			System.out.println("Index of pair with male lion is " + q);
		}
	}
        
	System.out.println("The ark sounds like:");
	for ( int z = 0 ; z < numPairs ; z++ ) {
		System.out.print(animalPair[z].getFirstElement().speak() + " ");
		System.out.print(animalPair[z].getFirstElement().speak() + " ");
	}
  } // main()
} // NoahsArk class
