package gray.adts.list;

import junit.framework.TestCase;

public class MyLinkedListTest extends TestCase {

	@SuppressWarnings("unchecked")
	public void testContains() {
		LinkedList<String> list = new MyLinkedList<String>();
		assertEquals("", 0, list.size());
		
		list.add("Ambrose");
		assertEquals("", 1, list.size());
		list.add("Trudeau");
		assertEquals("", 2, list.size());
		list.add("Mulcair");
		assertEquals("", 3, list.size());
		list.add("May");
		assertEquals("", 4, list.size());
		
		assertTrue("", list.contains("Ambrose"));
		assertTrue("", list.contains("May"));
		assertTrue("List does contain Mulcair", list.contains("Mulcair"));
		assertFalse("", list.contains("Harper"));
	}
	
}
