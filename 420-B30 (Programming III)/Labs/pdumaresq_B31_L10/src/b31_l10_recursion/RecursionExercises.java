package b31_l10_recursion;

public class RecursionExercises {
	public RecursionExercises() {
		super();
	}

	public static void printOdds(int n) {
		if (n == 1) {
			System.out.print(1 + " ");
			return;
		}
			
		if (n <= 0) 
			throw new IllegalArgumentException();
		
		printOdds(n-1);	
	
		if (n % 2 != 0) {
			System.out.print(n + " ");
		}			
	}

	public static int calcProduct(int m, int n) {
		if (n <= 0) 
			throw new IllegalArgumentException();
		
		if (n == 1) 
			return m + 0;		
		else {
			return m + calcProduct(m, --n);
		}				
	}
}
