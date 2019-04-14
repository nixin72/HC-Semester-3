package list;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		LinkedList<String> test = new LinkedList();
		test.add("one");
		test.add("two");
		test.add("three");
		test.add("four");
		test.reverse();
	}
	
	public void test() {
		
	}
	
	

}
