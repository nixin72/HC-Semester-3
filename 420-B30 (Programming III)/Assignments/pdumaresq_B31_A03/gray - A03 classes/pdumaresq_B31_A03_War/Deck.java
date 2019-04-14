package pdumaresq_B31_A03_War;

import java.util.ArrayList;
import java.util.Collections;

import adts.queue.ListQueue;

public class Deck {
	ArrayList<Card> cards = new ArrayList<Card>(52);
	ListQueue<Card> deck = new ListQueue<Card>(52);
	
	public Deck() {
		String[] suites = new String[]{"D", "H", "C", "S"};
		String[] ranks = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		for (String suite: suites) {
			for (String rank: ranks) {
				Card newCard = new Card(suite, rank);
				cards.add(newCard);
			}
		}
	}
	
	public Deck(ListQueue<Card> e) {
		deck = e;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
		for (Card card: cards) {
			deck.enqueue(card);
		}
	}

	public Card deal() {
		Card top = deck.dequeue();
		return top;
	}
	
	public int size() {
		return deck.size();
	}
	
	/*
	 * This method will create a predictable shuffled
	 * deck so that I can determine based on the number
	 * of times it's been shuffled what the top cards will
	 * be and who will win. 
	 */
	public void testShuffle(int numShuffles) {
		ArrayList<Card> pile1 = new ArrayList<Card>(13);
		ArrayList<Card> pile2 = new ArrayList<Card>(13);
		ArrayList<Card> pile3 = new ArrayList<Card>(13);
		ArrayList<Card> pile4 = new ArrayList<Card>(13);
		
		boolean order = true;
		for (int q = 0 ; q < numShuffles ; q++ ) {
			while (!cards.isEmpty()) {
				pile1.add(cards.remove(0));
				pile2.add(cards.remove(0));
				pile3.add(cards.remove(0));
				pile4.add(cards.remove(0));
			}
			 
			if (order) {
				cards.addAll(pile1);
				cards.addAll(pile2);
				cards.addAll(pile3);
				cards.addAll(pile4);
				order = false;
			} 
			else {
				cards.addAll(pile4);
				cards.addAll(pile3);
				cards.addAll(pile2);
				cards.addAll(pile1);
				order = true;
			}	
			
			pile1.removeAll(pile1);
			pile2.removeAll(pile2);
			pile3.removeAll(pile3);
			pile4.removeAll(pile4);
		}	
		
		while (!cards.isEmpty()) {
			deck.enqueue(cards.remove(0));
		}	
	}
	
	//1 iteration
	//2d 6d 10d ad 5h 9h kh 4c 8c qc 3s 7s js
	//3d 7d jd 2h 6h 10h ah 5c 9c kc 4s 8s qs
	//4d 8d qd 3h 7h jh 2c 6c 10c ac 5s 9s ks 
	//5d 9d kd 4h 8h qh 3c 7c jc 2s 6s 10s as

	//2nd iteration
	//2d 5h 8c js 2h 5c 8s qd 2c 5s 9d qh 2s
	//6d 9h qc 3d 6h 9c qs 3h 6c 9s kd 3c 6s
	//10d kh 3s 7d 10h kc 4d 7h 10c ks 4h 7c 10s
	//ad 4c 7s jd ah 4s 8d jh ac 5d 8h jc as 

	//3rd iteration
	//2d ...................................
	//......................................
	//......................................
	//................................... as

	/*
	 * doing pile1, pile2, pile3, pile4 doesn't work, cards at 
	 * index 0 and 51 will always never change. The order that 
	 * the cards go back into the main stack has to be changed
	 * every time that the pile is shuffled. There's got to be 
	 * at least 2 different orders that I put all the cards in 
	 * to the main stack after pile shuffling them. That way I 
	 * can keep a deck that offers multiple different cards on 
	 * top, while having a deck that stays easily predictable.
	 */
}