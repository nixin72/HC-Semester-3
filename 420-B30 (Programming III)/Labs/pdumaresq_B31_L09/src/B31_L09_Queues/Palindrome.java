package B31_L09_Queues;

import gray.adts.stack.ListStack;
import gray.adts.queue.ListQueue;

import gray.adts.stack.Stack;
import gray.adts.queue.Queue;

public class Palindrome {
	public Palindrome() {
	}

	public boolean isPalindrome(String str) {
		Stack<Character> palindromeStack = new ListStack<Character>();
		Queue<Character> palindromeQueue = new ListQueue<Character>();

		str = str.toUpperCase();
		str = str.replaceAll("\\W", "");
		
		for (int i = 0; i < str.length(); ++i) {
			palindromeStack.push(str.charAt(i));
			palindromeQueue.enqueue(str.charAt(i));
		}	
		
		for (int i = 0; i < str.length(); ++i)
			if (palindromeStack.pop() != palindromeQueue.dequeue()) 
				return false;					

		return true;
	}
}
