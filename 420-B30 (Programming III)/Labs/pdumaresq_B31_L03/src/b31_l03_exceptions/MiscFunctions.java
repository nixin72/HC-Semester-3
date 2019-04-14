package b31_l03_exceptions;

public class MiscFunctions {

	public MiscFunctions() {
	}

	/**
	 * Calculate the square root of x cubed - 1 Pre-conditions: x must be >= 1
	 * 
	 * @param x
	 *            - a double precision number >= 1
	 * @return the result of the square root of x cubed - 1
	 */
	public double f(double x) {
		double result = 0;

		if (x < 1) {
			throw new ArithmeticException(
					"\nError: Parameter to f(x) must " + "not be less than 1. " + x + " is invalid.");
		}
		result = Math.sqrt(Math.pow(x, 3) - 1);

		return result;
	} // f()

	/**
	 * Displays a message if an array is sorted Pre-conditions: testArray is
	 * non-null 0 < numElements <= testArray.length
	 * 
	 * @param testArray
	 *            - a non-null array of Strings
	 * @param numElements
	 *            - the number of elements in testArray
	 */
	public void checkSorted(String[] testArray, int numElements) {
		boolean sorted = true;
		try {
			String previous = testArray[0];
			int i = 1;
			
			if (numElements < 0) {
				throw new IllegalArgumentException("\nnumElements is less than 0." + " NumElements = " + numElements);
			} else if (numElements == 0) {
				throw new IllegalArgumentException("\nnumElements is 0. " + "NumElements = " + numElements);
			} else if (numElements > testArray.length) {
				throw new IllegalArgumentException(
						"\nnumElements is greater than the size of the array. " + "NumElements = " + numElements);
			}
			
			while (i < numElements && sorted) {

				if (testArray[i].compareTo(previous) < 0) {
					sorted = false;
					throw new UnSortedArrayException("\nError: The array is " + "not sorted");
				}
				previous = testArray[i];
				++i;
			}
		} catch (NullPointerException e) {
			System.out.println("The array has not been initialized");
			System.exit(1);
		} finally {
			if (sorted) {
				System.out.println("The array has been sorted");
			}
		}
	} // checkSorted()
}
