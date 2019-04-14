package B31_L08_stacks;

import java.util.Scanner;

import gray.adts.stack.LinkedStack;
import gray.adts.stack.Stack;

public class ParenthesisBalancer {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an expression to check if it's balanced");
		String expression = input.nextLine();
		
		input.close();
		if (isBalanced(expression)) {
			System.out.println("The expression is balanced");	
		}
		else {
			System.out.println("The expression is NOT balanced");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean isBalanced(String math) {
		String brackets = math.replaceAll("[^\\(\\)]", "");
		
		Stack<String> balance = new LinkedStack();
		
		for (int q = 0 ; q < brackets.length() ; q++) {
			if (brackets.charAt(q) == '(') {
				balance.push(String.valueOf(brackets.charAt(q)));
			}
			else if (brackets.charAt(q) == ')') {
				try {
					balance.pop();
				} catch (Exception e) {
					return false;
				}		
			}
		}
		return balance.isEmpty();
	}
}
