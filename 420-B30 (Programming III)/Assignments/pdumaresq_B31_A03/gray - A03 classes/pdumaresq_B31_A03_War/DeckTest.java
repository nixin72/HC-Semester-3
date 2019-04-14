package pdumaresq_B31_A03_War;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {
	@Test 
	public void testDefaultConstructor() {
		Deck test = new Deck();
		assertEquals("Cards are instantiated"
				, 52, test.cards.size());
		
		assertEquals("Deck isn't made yet. Shuffle does this."
				, 0, test.size());
	}
	
	@Test
	public void testShuffle() {
		Deck test = new Deck();
		assertEquals("Cards are instantiated, but deck isn't made"
				, 0, test.size());
		
		test.shuffle();
		assertEquals("Deck is made, all cards have been added."
				, 52, test.size());
	}
	
	@Test
	public void testDealCards() {
		Deck test = new Deck();
		assertEquals("Cards are instantiated, but deck isn't made"
				, 0, test.size());
		
		test.shuffle();
		assertEquals("Deck is made, all cards have been added."
				, 52, test.size());
		
		while (test.size() > 0) {
			assertEquals("Make sure that deal returns the right card"
					, test.deck.peek(), test.deal());
		}
		
		assertEquals("Make sure deck of non-dealt cards is now empty"
				, 0, test.size());
	}
	
	@Test
	public void testTestShuffle() {
		Deck test = new Deck();
		test.testShuffle(0);
		assertEquals("", 52, test.size());
		assertEquals("", "2D", test.deck.peek().toString());
	}
}