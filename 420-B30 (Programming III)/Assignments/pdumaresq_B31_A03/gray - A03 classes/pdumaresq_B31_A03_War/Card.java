package pdumaresq_B31_A03_War;

public class Card {
	String suite;
	String rank;
	
	public Card(String s, String r) {
		suite = s;
		rank = r;
	}
	
	public String getSuite() {
		return suite;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String toString() {
		return rank + suite;
	}
	
	
	public int compareTo(Card c) {
		int compare;
		if (c.getIndex() == this.getIndex()) {
			compare = 0;
		}
		else if (c.getIndex() < this.getIndex()) {
			compare = -1;
		}
		else {
			compare = 1;
		}
		return compare;
	}
	
	/*
	 * index in the array is used for comparison in the 
	 * compareTo method since I can't compare the literal
	 * values. 
	 */
	public int getIndex() {
		int foundIndex = 0;
		String[] ranks = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		for ( int q = 0 ; q < ranks.length ; q++ ) {
			if (getRank().equals(ranks[q])) {
				foundIndex = q;
			}
		}
		return foundIndex;
	}
}