package stacks;

import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		System.out.println("enter string to be reversed");
		String og = scr.nextLine();
		
		String[] end = og.split("\\s");
		String reverse = "";
		for (int q = end.length-1 ; q >= 0 ; q-- ) {
			reverse += end[q] + " ";
		}
		
		System.out.println(reverse);
		
		scr.close();
	}

}
