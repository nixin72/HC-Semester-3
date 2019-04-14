package b31_l10_recursion;

public class IntArraySorts {
	private static int partition(int[] array, int first, int last) {
		int l = first;
		int r = last;
		int pivot = array[(first + last) / 2];

		while (l <= r) {
			while (array[l] < pivot)
				l++;
			while (array[r] > pivot)
				r--;
			if (l <= r) {
				swap(array, l, r);
				l++;
				r--;
			}
		}
		return l;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void quickSort(int[] array, int first, int last) {
		if (array.length <= 1)
			return;

		int pivot = partition(array, first, last);
		
		if (first < pivot - 1)
			quickSort(array, first, pivot - 1);
		if (pivot < last)
			quickSort(array, pivot, last);
	}

}