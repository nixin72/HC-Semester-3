package pdumaresq_B31_A03_War;

import org.junit.Test;
import junit.framework.TestCase;

public class CardTest extends TestCase {
	@Test
	public void testConstructor() {
		Card testCard = new Card("D", "A");
		assertEquals("Testing that the constructor works"
				,"D", testCard.getSuite());
		assertEquals("Testing that the constructor works"
				,"A", testCard.getRank());
	}
	
	@Test
	public void testGetIndex() {
		Card c1 = new Card("D", "2");
		assertEquals("Finding a card at the beginning of the array"
				, 0, c1.getIndex());
		
		Card c2 = new Card("C", "A");
		assertEquals("Finding a card at the end of the array"
				, 12, c2.getIndex());
	}
	
	@Test
	public void testCompareTo() {
		Card c1 = new Card("D", "A");
		Card c2 = new Card("D", "A");
		assertEquals("Testing two exactly identical cards"
				, 0, c1.compareTo(c2));
		assertEquals("Testing two exactly identical cards"
				, 0, c2.compareTo(c1));
		
		Card c3 = new Card("D","2");
		Card c4 = new Card("H","2");
		assertEquals("Testing two cards of the same rank, different suite"
				, 0, c3.compareTo(c4));
		assertEquals("Testing two cards of the same rank, different suite"
				, 0, c4.compareTo(c3));
		
		Card c5 = new Card("D","2"); 
		Card c6 = new Card("D","3"); 
		assertEquals("Testing two different ranks."
				, 1, c5.compareTo(c6));
		assertEquals("Testing two different ranks."
				, -1, c6.compareTo(c5));
	}
}