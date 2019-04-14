package b31_l06_basic_collection;

import java.util.Iterator;

import collection.BasicCollection;

public class MyFavouriteThings {

	public static void main(String[] args) {
		BasicCollection<String> myFavouriteThings = new BasicCollection<String>();
		myFavouriteThings.add("HTML");
		myFavouriteThings.add("CSS");
		myFavouriteThings.add("JavaScript");
		myFavouriteThings.add("Node.js");
		myFavouriteThings.add("Java");
		myFavouriteThings.add("SQL");
		myFavouriteThings.add("C#");
		
		Iterator<String> iter = myFavouriteThings.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
