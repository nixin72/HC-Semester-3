package linked_data_structures;

public class ListTraverser {
	
	
	public static void main(String[] args) {
		DoublyLinkedList<String> dwarves = new DoublyLinkedList<String>();
		
		dwarves.addAtEnd("Sneezy");
		dwarves.addAtEnd("Sleepy");
		dwarves.addAtEnd("Dopey");
		dwarves.addAtEnd("Doc");
		dwarves.addAtEnd("Happy");
		dwarves.addAtEnd("Bashful");
		dwarves.addAtEnd("Grumpy");
		
		for (int q = 1 ; q < dwarves.getLength() ; q++) {
			System.out.println(dwarves.getElementAt(q));
		}
		System.out.println("");
		for (int q = dwarves.getLength() ; q > 1 ; q--) {
			System.out.println(dwarves.getElementAt(q-1));
		}
	}

}
