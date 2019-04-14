package B31_L08_stacks;

import java.util.Scanner;

import gray.adts.stack.*;

public class Palindrome {
	public Palindrome() {
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string to check if it's a palindrome");
		String palindrome = input.nextLine();
		
		input.close();
		isPalindrome(palindrome);
	}
	
	public static boolean isPalindrome(String palindrome) {
		palindrome = palindrome.replaceAll("\\W", "");
		
		Stack<String> forward = new LinkedStack<String>();
		Stack<String> og = new LinkedStack<String>();
		
		for (int q = 0 ; q < palindrome.length() ; q++) {
			og.push(String.valueOf(palindrome.charAt(q)));
			forward.push(String.valueOf(palindrome.charAt(q)));
		}
		
		Stack<String> reverse = new LinkedStack<String>();
		while (!forward.isEmpty()) {
			reverse.push(forward.pop());
		}
		
		boolean isPalindrome = true;
		while ((!og.isEmpty() || !reverse.isEmpty()) && isPalindrome) {
			String currForward = og.pop();
			String currReverse = reverse.pop();
			
			isPalindrome = isPalindrome && currForward.equalsIgnoreCase(currReverse);
		}
		
		if (isPalindrome) {
			System.out.println("It's a palindrome!!! :D");
		}
		else {
			System.out.println("Not a palindrome");
		}
		return isPalindrome;
	}
}
