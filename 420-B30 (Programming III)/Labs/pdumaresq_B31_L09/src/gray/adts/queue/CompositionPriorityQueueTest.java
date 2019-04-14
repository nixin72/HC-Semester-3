package gray.adts.queue;

import org.junit.Test;

import junit.framework.TestCase;

public class CompositionPriorityQueueTest extends TestCase {
	
	@Test
	public void testEnqueueWithPriority() {
		PriorityQueue<String> q = new CompositionPriorityQueue<String>();
		assertEquals("", 0, q.size());
		
		q.enqueue("A");
		assertEquals("Test to make sure something got added to the list", "A", q.peek());

		q.enqueue(1, "B");
		assertEquals("Test to make sure it got added in the right priority", "B", q.peek());
		
		q.enqueue("C");
		assertEquals("Test to make sure the beginning is still the same", "B", q.peek());
		
		q.enqueue(2, "D");
		assertEquals("Test to make sure that it didn't get added at the front", "B", q.peek());
		
		q.enqueue(1, "E");
		assertEquals("Test to make sure the front has changed again", "E", q.peek());
		
		assertEquals("Check to make sure all the elements got added", 5, q.size());
		
		assertEquals("Test to make sure that the first element get returned", "E", q.dequeue());
		
		assertEquals("Make sure size got decreased", 4, q.size());
		
		assertEquals("Make sure the correct element is getting returned", "B", q.dequeue());
		assertEquals("Make sure the correct element is getting returned", "D", q.dequeue());
		assertEquals("Make sure the correct element is getting returned", "A", q.dequeue());
		
		assertEquals("Make sure isEmpty works, the queue still contains 1", false, q.isEmpty());
		assertEquals("Make sure the size is right", 1, q.size());
		
		assertEquals("Make sure the correct element is getting returned", "C", q.dequeue());
		assertEquals("Test isEmpty again since it should return true now  ", true, q.isEmpty());
	}
	
	

}
