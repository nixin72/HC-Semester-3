package pdumaresq_B31_A03_War;

import adts.queue.ListQueue;
import adts.stack.ListStack;

public class War {
	Deck deck = new Deck();

	String player1 = "Player 1";
	String player2 = "Player 2";
	String winner;
	
	int kittySize = 0;

	ListQueue<Card> p1Hand = new ListQueue<Card>();
	ListQueue<Card> p2Hand = new ListQueue<Card>();
	ListStack<Card> p1WarStack = new ListStack<Card>();
	ListStack<Card> p2WarStack = new ListStack<Card>();

	/*
	 * This method will loop through the deck and deal out 
	 * one card to each player, one at a time until the deck
	 * is empty.
	 */
	public void start() {
		deck.shuffle();
		while (deck.size() != 0) {
			p1Hand.enqueue(deck.deal());
			p2Hand.enqueue(deck.deal());
		}
	}
	
	/*
	 * This method will do the same thing, but will call
	 * the test shuffle method instead of the regular 
	 * shuffle method. This method is used in the test 
	 * cases for knowing what the outcome of a play will be.
	 */
	public void testDeal(int numShuffles) {
		deck.testShuffle(numShuffles);
		while (deck.size() != 0) {
			p1Hand.enqueue(deck.deal());
			p2Hand.enqueue(deck.deal());
		}
	}

	public void setPlayer1(String p1) {
		player1 = p1;
	}
	public void setPlayer2(String p2) {
		player2 = p2;
	}
	public String getPlayer1() {
		return player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public int p1HandSize() {
		return p1Hand.size();
	}
	public int p2HandSize() {
		return p2Hand.size();
	}
	public String p1Top() {
		return p1Hand.peek().toString();
	}
	public String p2Top() {
		return p2Hand.peek().toString();
	}
	public String getRoundWinner() {
		return winner;
	}
	public int getKittySize() {
		return kittySize;
	}

	/*
	 * The play method will compare the top cards of either 
	 * player's hand and will determine who wins the round.
	 * If there's a war, the war method will be called. If 
	 * a war occurs, the method will return true, otherwise,
	 * it'll return false; 
	 */
	public boolean play() {
		boolean inWar = false;
		if (!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
			Card p1Top = p1Hand.peek();
			Card p2Top = p2Hand.peek();

			if (p1Top.compareTo(p2Top) == 0) {
				p1WarStack.push(p1Hand.dequeue());
				p2WarStack.push(p2Hand.dequeue());
				inWar = true;
				kittySize = 0;
				war();
			} 
			else if (p1Top.compareTo(p2Top) < 0) {
				p1Hand.enqueue(p1Hand.dequeue());
				p1Hand.enqueue(p2Hand.dequeue());
				winner = player1;
			} 
			else if (p1Top.compareTo(p2Top) > 0) {
				p2Hand.enqueue(p1Hand.dequeue());
				p2Hand.enqueue(p2Hand.dequeue());
				winner = player2;
			}
		}
		return inWar;
	}

	/*
	 * Determines if the game is over based on whether or not 
	 * one of the players has no cards in hand.
	 */
	public boolean isOver() {
		if (p1Hand.isEmpty() ^ p2Hand.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * The war method is kind of a blown up version of the play method. 
	 * With the war method, it will first check the players hand sizes.
	 * If they don't have enough cards for a war, then all the cards in
	 * the other player's hand and the accumulated kitty will go to the 
	 * player in the lead and they'll win. If they do have enough cards
	 * then the stack for each player will be laid out. The top card of 
	 * each stack will be flipped and compared. The player who wins the 
	 * war will receive the whole kitty. If the two cards are identical
	 * again, the method will recall itself and keep appending onto the 
	 * two player's stacks until one player wins the flip. 
	 */
	int numWars = 0;
	public boolean war() {
		numWars++;
		boolean inWar = false;
		if (p1Hand.size() >= 4 && p2Hand.size() >= 4) {
			for (int q = 0; q < 4; q++) {
				p1WarStack.push(p1Hand.dequeue());
				p2WarStack.push(p2Hand.dequeue());
			}
			kittySize = p1WarStack.size()-1 + p2WarStack.size()-1;
			Card p1Top = p1WarStack.peek();
			Card p2Top = p2WarStack.peek();
			
			if (p1Top.compareTo(p2Top) == 0) {
				inWar = true;
				war();
			} 
			else if (p1Top.compareTo(p2Top) < 0) {
				while (!p1WarStack.isEmpty()) {
					p1Hand.enqueue(p1WarStack.pop());
					p1Hand.enqueue(p2WarStack.pop());
				}
				winner = player1;
			} 
			else if (p1Top.compareTo(p2Top) > 0) {
				while (!p2WarStack.isEmpty()) {
					p2Hand.enqueue(p1WarStack.pop());
					p2Hand.enqueue(p2WarStack.pop());
				}
				winner = player2;
			}
		} 
		else {
			if (p1Hand.size() < 4) {
				kittySize += p1HandSize() + 4;
				while (!p1Hand.isEmpty()) {
					p2Hand.enqueue(p1Hand.dequeue());
				}
				p2Hand.enqueue(p1WarStack.pop());
				p2Hand.enqueue(p2WarStack.pop());
				
				winner = player2;
			} 
			else {
				kittySize += p2HandSize() + 4;
				while (!p2Hand.isEmpty()) {
					p1Hand.enqueue(p2Hand.dequeue());
				}
				p1Hand.enqueue(p1WarStack.pop());
				p1Hand.enqueue(p2WarStack.pop());
				
				winner = player1;
			}
		}
		return inWar;
	}
}