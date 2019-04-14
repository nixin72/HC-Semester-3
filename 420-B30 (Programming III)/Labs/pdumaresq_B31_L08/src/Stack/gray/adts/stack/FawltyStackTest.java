package gray.adts.stack;

import java.util.EmptyStackException;

import junit.framework.TestCase;

public class FawltyStackTest extends TestCase {
	
	public void testStackInstantiation() {
		Stack<String> s = new LinkedStack<String>();
		assertEquals("Test a blank list", 0, s.size());
		assertTrue("Test to see if empty", s.isEmpty());
		try {
			s.peek();
			fail();
		}
		catch (EmptyStackException e) {
			assertTrue("Peeking at an empty stack", true);
		}
		
		try {
			s.pop();
			fail();
		}
		catch (EmptyStackException e) {
			assertTrue("popping off an empty stack", true);
		}
	}
	
	public void testPushingOntoStack() {
		Stack <String> s = new FawltyStack<String>();
		s.push("Trudeau");
		assertEquals("Test a stack of size 1", 1, s.size());
		assertFalse("Make sure it isn't empty", s.isEmpty());
		assertEquals("Make sure it's the right value", "Trudeau", s.peek());
		s.push("Ambrose");
		assertEquals("Test a stack of size 1", 2, s.size());
		assertEquals("Make sure it's the right value", "Ambrose", s.peek());
		s.push("Mulcair");
		assertEquals("Test a stack of size 1", 3, s.size());
		assertEquals("Make sure it's the right value", "Mulcair", s.peek());
	}
	
	public void testCreateEmptyStack() {
		Stack <String> s = new FawltyStack<String> ();
		s.push("Trudeau");
		s.push("Ambrose");
		s.push("Mulcair");
		
		assertEquals("Make sure it's the right value", "Mulcair", s.pop());
		assertEquals("Make sure it's the right value", "Ambrose", s.peek());
		assertEquals("Test a stack of size 1", 2, s.size());
		assertEquals("Make sure it's the right value", "Ambrose", s.pop());
		assertEquals("Make sure it's the right value", "Trudeau", s.peek());
		assertEquals("Test a stack of size 1", 1, s.size());
		assertFalse("Make sure it isn't empty", s.isEmpty());
		assertEquals("Make sure it's the right value", "Trudeau", s.pop());
		assertEquals("Test a stack of size 1", 0, s.size());
		assertTrue("Make sure it isn't empty", s.isEmpty());
	}
}
