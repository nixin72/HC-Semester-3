package pdumaresq_B31_A03_War;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import adts.stack.LinkedStack;

public class WarTest {
	@Test
	public void testStart() {
		War test = new War();
		assertEquals("Make sure p1 has no cards in hand", 0, test.p1Hand.size());
		assertEquals("Make sure p2 has no cards in hand", 0, test.p2Hand.size());
		test.start();
		assertEquals("Make sure p1 has the right # of cards", 26, test.p1Hand.size());
		assertEquals("Make sure p2 has the right # of cards", 26, test.p2Hand.size());
	}

	@Test
	public void testPlay() {
		class TestPlayMethods {
			public void testT1War() {
				War test = new War();

				test.testDeal(3);
//				System.out.println(test.p1Top()); AD
//				System.out.println(test.p2Top()); AH
				assertEquals("compare two cards that are of the same rank.", 0,
						test.p1Hand.peek().compareTo(test.p2Hand.peek()));

				assertTrue("A war has occured.",test.play());
				assertEquals("Multiple wars have occured.", 1, test.numWars);
			}

			public void testP1Wins() {
				War test = new War();

				test.testDeal(5);
//				System.out.println(test.p1Top()); AS
//				System.out.println(test.p2Top()); 10S
				assertEquals("compare two cards that are of the same rank.", -1,
						test.p1Hand.peek().compareTo(test.p2Hand.peek()));

				assertFalse("False indicates that a war has not occured.", test.play());
				assertEquals("Multiple wars have occured.", 0, test.numWars);
				
				assertEquals("", 27, test.p1Hand.size());
				assertEquals("", 25, test.p2Hand.size());
			}

			public void testP2Wins() {
				War test = new War();

				test.testDeal(1);
//				System.out.println(test.p1Top()); 2D
//				System.out.println(test.p2Top()); 6D
				assertEquals("compare two cards that are of the same rank.", 1,
						test.p1Hand.peek().compareTo(test.p2Hand.peek()));

				assertFalse("False indicates that a war has not occured.", test.play());
				assertEquals("Multiple wars have occured.", 0, test.numWars);
				
				assertEquals("", 25, test.p1Hand.size());
				assertEquals("", 27, test.p2Hand.size());
			}
		}

		TestPlayMethods test = new TestPlayMethods();
		test.testT1War();
		test.testP1Wins();
		test.testP2Wins();
	}

	public void testIsOver() {
		War test = new War();
		test.setPlayer1("player 1");
		test.setPlayer2("player 2");
		test.start();

		assertFalse("Game has just started", test.isOver());
		while (!test.p2Hand.isEmpty()) {
			test.p1Hand.enqueue(test.p2Hand.dequeue());
		}
		assertEquals("player 1 has all the cards", 52, test.p1Hand.size());
		assertEquals("player 2 has lost all their cards", 0, test.p2Hand.size());
		assertTrue("The game is over.", test.isOver());
	}

	@Test
	public void testWar() {
		class TestWar {
			public void testPlayer1Wins() {
				War test = new War();
				
				test.testDeal(7);
//				System.out.println(test.p1Top()); 2S
//				System.out.println(test.p2Top()); 2C
				assertTrue("True indicates that a war occured.", test.play());

				assertEquals("A single war has occured", 1, test.numWars);
				assertEquals("", 8, test.getKittySize());
				
				assertEquals("", "Player 1", test.getRoundWinner());
				assertEquals("", 31, test.p1HandSize());
				assertEquals("", 21, test.p2HandSize());
			}

			public void testPlayer2Wins() {
				War test = new War();
				test.testDeal(3);
//				System.out.println(test.p1Top()); AD
//				System.out.println(test.p2Top()); AH
				assertTrue("True indicates that a war occured.", test.play());

				assertEquals("A single war has occured", 1, test.numWars);
				assertEquals("", 8, test.getKittySize());

				assertEquals("", "Player 2", test.getRoundWinner());
				assertEquals("", 21, test.p1HandSize());
				assertEquals("", 31, test.p2HandSize());
			}

			public void testMultipleWars() {
				War test = new War();
				// with the current rigged shuffle method,
				// the only way to force two consecutive
				// wars on the first turn is to swap a few
				// cards. Cards at index 11 and 36
				test.deck.cards.set(11, new Card("C", "Q"));
				test.deck.cards.set(36, new Card("D", "K"));

				test.testDeal(3);

				assertTrue("True indicates that a war occured.", test.play());

				assertEquals("Multiple wars have occured.", 3, test.numWars);
				assertEquals("", 24, test.getKittySize());
				
				assertEquals("", "Player 2", test.getRoundWinner());
				assertEquals("", 13, test.p1HandSize());
				assertEquals("", 39, test.p2HandSize());

			}

			public void testOnePlayerCantContinue() {
				War test = new War();
				test.testDeal(7);
				while (test.p2Hand.size() != 3) {
					test.p2Hand.dequeue();
				}

				LinkedStack<Card> temp = new LinkedStack<Card>();
				while (!test.p1Hand.peek().getRank().equals("8")) {
					temp.push(test.p1Hand.dequeue());
				}

				assertEquals("Player 1 has an 8 on top", "8C", test.p1Hand.peek().toString());
				assertEquals("Player 1 has enough cards in hand for a war", 24, test.p1HandSize());

				assertEquals("Player 2 also has an 8 on top.", "8H", test.p2Hand.peek().toString());
				assertEquals("Player 2 doesn't have enough cards for a war.", 3, test.p2HandSize());

				assertEquals("The total number of cards in both hands"
						, 27, test.p1HandSize() + test.p2HandSize());
				assertEquals("A war has occured", true, test.play());

				assertEquals("Player 1 has all the cards.", 27, test.p1HandSize());

				assertEquals("Player 2 doesn't have any cards in hand.", 0, test.p2HandSize());

			}
		}
		TestWar test = new TestWar();
		test.testPlayer1Wins();
		test.testPlayer2Wins();
		test.testMultipleWars();
		test.testOnePlayerCantContinue();
	}
}