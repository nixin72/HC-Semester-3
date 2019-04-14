package inheritance;

import shapes.Rectangle;

public class GenericsTypeCheckingEx
{
  public static void main(String[] args)
  {	  
	  Pair<String> sPair = new Pair<String>(new String("brother"),"sister");
	  Pair<Animal> animalPair = new Pair<Animal>(new Cat(), new Dog());
    
      sPair.swapElements();
      System.out.println("String elements are " + sPair.getFirstElement()
                            + ", " + sPair.getSecondElement());
    
      animalPair.setFirstElement(new Lion());
      System.out.println("Animal elements are " + animalPair.toString());
      Object o = animalPair.getSecondElement();
      System.out.println("o is "+ o.toString());
      
      Pair<Rectangle> twoRectangles = new Pair<Rectangle>(new Rectangle(1,2), new Rectangle(2,3));	
	  System.out.println(twoRectangles.toString());
  } // main()
} // GenericsTypeCheckingEx class
