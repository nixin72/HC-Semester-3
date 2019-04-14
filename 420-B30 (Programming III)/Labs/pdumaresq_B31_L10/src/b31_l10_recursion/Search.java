package b31_l10_recursion;

public class Search {
	public static void main(String[] args) {
		int[] testArray = {1,3,5,9,10,12,22,33,44,55,100};
				
		for ( int q = 0 ; q < testArray.length ; q++ ) {
			int found = binSearch(testArray, 0, testArray.length-1, testArray[q]);
			System.out.println(found);
		}
		
		int found = binSearch(testArray, 0, testArray.length-1, 234);
		System.out.println(found);
	}
	
	
	public static int binSearch(int[] arr, int first, int last, int key) {
		if (first > last) 
			return -1;
		else {
			int mid = (first + last)/2;
			if (key == arr[mid]) 
				return mid;
			else if (key < arr[mid])
				return binSearch(arr, first, mid-1, key);
			else 
				return binSearch(arr, mid+1, last, key);
		}
	}
	
	
}
