package gray.adts.list;

import gray.adts.list.LinkedList;

@SuppressWarnings({ "serial", "rawtypes" })
public class MyLinkedList<E> extends LinkedList {
	
	public boolean contains(Object e) {		
		return (isEqual(e, size()-1)) ? true : false;
	}
	 
	private boolean isEqual(Object e, int n) {
		if (n < 0) 
			return false; 
		
		if (get(n).equals(e)) 
			return true;
		
		return isEqual(e, --n);
	}
	
}