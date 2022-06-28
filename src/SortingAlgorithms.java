import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
	
	/**
	 * Non parameterized construction of this class
	 */
	public SortingAlgorithms() {}
	
	/**
	 * 
	 * @param array : Takes an unsorted array from Binary search class
	 */
	public void BubbleSort(int[] array) {
		long nanoStart = System.nanoTime();										//This start counting time nano seconds.
		long miliStart = System.currentTimeMillis();							//This start counting time in milli seconds.
		System.out.println(Arrays.toString(array));								//printing unsorted version of an array.
		boolean swaping = true;													//swapping boolean for help
		while (swaping){														//while swapping is true its enters the loop
			swaping = false;													//declaring swapping as false
			for (int i = 0; i < array.length - 1; i++) {						//enter for loop for sorting
				if (array[i] > array[i+1]) {									//if something unsorted number found then change swapping to true so while loop can execute again.
					swaping = true;
					int temp = array[i];										//declaring temp variable for swapping
					array[i] = array[i+1];										//swapping values
					array[i+1] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("Bubble Sort: Simple sorting algorithm - O(n2) Complexity -");
		System.out.println();
		System.out.println(Arrays.toString(array));								//printing sorted version of an array.
		long nanoFinish = System.nanoTime();									//This stops the counting of nano seconds.
		long miliFinish = System.currentTimeMillis();							//This stops the counting of milli seconds.
		long allTime = nanoFinish - nanoStart;									//This calculate the time elapsed of nano seconds.
		long allElapsed = miliFinish - miliStart;								//This calculate the time elapsed of milli seconds.
		System.out.println("");
		System.out.println("Time taken in nanoseconds: "+allTime);
		System.out.println("Time taken in milliseconds: "+allElapsed);
	}
		
	/**
	 * 
	 * @param array : Takes an unsorted array from Binary search class
	 */
	public void InsertionSort(int[] array) {
		long nanoStart = System.nanoTime();										//This start counting time nano seconds.
		long miliStart = System.currentTimeMillis();							//This start counting time in milli seconds.
		System.out.println(Arrays.toString(array));								//printing unsorted version of an array.
		for (int i = 1; i < array.length; i++) {								//enter for loop for swapping
			int current = array[i];												//creating int variable for storing array value.
			int j = i-1;														//creating int j variable and set to (i-1)
			while (j>=0 && array[j]>current) {									//checking array value at j is more than current value and j is greater than equal to zero. If both the condition is true then only it enter the while loop.
				array[j+1] = array[j];											//swapping value
				j--;															//decrementing j
			}
			array[j+1] = current;
		}
		System.out.println();
		System.out.println("Insertion Sort: Simple sorting algorithm - O(n2) Complexity -");
		System.out.println();
		System.out.println(Arrays.toString(array));								//printing sorted version of an array.
		long nanoFinish = System.nanoTime();									//This stops the counting of nano seconds.
		long miliFinish = System.currentTimeMillis();							//This stops the counting of milli seconds.
		long allTime = nanoFinish - nanoStart;									//This calculate the time elapsed of nano seconds.
		long allElapsed = miliFinish - miliStart;								//This calculate the time elapsed of milli seconds.
		System.out.println("");
		System.out.println("Time taken in nanoseconds: "+allTime);
		System.out.println("Time taken in milliseconds: "+allElapsed);
	}
	
	/**
	 * 
	 * @param array : Takes an unsorted array from Binary search class
	 */
	public void SelectionSort(int[] array) {
		long nanoStart = System.nanoTime();										//This start counting time nano seconds.
		long miliStart = System.currentTimeMillis();							//This start counting time in milli seconds.
		System.out.println(Arrays.toString(array));								//printing unsorted version of an array.
		for (int i = 0; i < array.length; i++) {								//entering for loop for sorting
			int smallIndex = i;													//setting smallest index in a variable
			for (int j = (i+1); j < array.length; j++) {						//for loop for comparing first variable with other in an array
				if (array[j] < array[smallIndex]) {								//if an variable is small than fist the set that index as smallest
					smallIndex = j;
				}
			}
			int temp = array[i];												//declaring temp variable for swapping
			array[i] = array[smallIndex];										//swapping values
			array[smallIndex] = temp;
		}
		System.out.println();
		System.out.println("Selection Sort: Simple sorting algorithm - O(n2) Complexity -");
		System.out.println();
		System.out.println(Arrays.toString(array));								//printing sorted version of an array.
		long nanoFinish = System.nanoTime();									//This stops the counting of nano seconds.
		long miliFinish = System.currentTimeMillis();							//This stops the counting of milli seconds.
		long allTime = nanoFinish - nanoStart;									//This calculate the time elapsed of nano seconds.
		long allElapsed = miliFinish - miliStart;								//This calculate the time elapsed of milli seconds.
		System.out.println("");
		System.out.println("Time taken in nanoseconds: "+allTime);
		System.out.println("Time taken in milliseconds: "+allElapsed);
	}
	
	/**
	 * 
	 * @param array : Takes an unsorted array from Binary search class
	 */
	public void MergSort(int[] array) {
		/*
		 * In this method merg sorting is taking place, also known as divide and conquer.
		 * In first half of this method, an array is divided into two parts until each array length becomes 1.
		 * The first half is divide portion from the name.
		 * For division of an array, recursion is implemented.
		 */
		int arrayLength = array.length;
		
		if (arrayLength < 2) {
			return;
		}
		int mid = arrayLength / 2;
		int[] left = new int[mid];
		int[] right = new int[arrayLength - mid];
		
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		
		for (int i = mid; i < arrayLength; i++) {
			right[i - mid] = array[i];
		}
		
		MergSort(left);
		MergSort(right);
		
		/**
		 * From her second part, also know as Conquer, is implemented on an array.
		 * Three while loops are used in this part. First while loop is comparing a value and arrange in a sorted manner
		 */
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, j = 0, k = 0;
		
		while(i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			}else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < leftSize) {
			array[k] = left[i];
			i++;
			k++;
		}
		
		while (j < rightSize) {
			array[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	/**
	 * 
	 * @param array : Takes an unsorted array from Binary search class
	 * @param lowIndex : take int value to specify lower index of an array
	 * @param highIndex : take int value to specify higher indesx of an array
	 */
	public void QuickSort(int[] array, int lowIndex, int highIndex) {
		
		if (lowIndex >= highIndex) {
			return;
		}
		
		/*
		 * This part in a method is generating a random pivot from an array.
		 */
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];
		/*
		 * Swapping of random generated pivot to the higher index in an array.
		 */
		int swap = array[pivotIndex];
		array[pivotIndex] = array[highIndex];
		array[highIndex] = swap;
		
		/*
		 * Declaring leftpointer and rightpointer for sorting an array.
		 * If the leftPointer is smaller than rightPointer then only it enters while for sorting.
		 */
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while (leftPointer < rightPointer) {
			/*
			 * if the left pointer is less than or equal to pivot then it increments left pointer value.
			 */
			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			/*
			 * if the right pointer is greater than or equal to pivot then if decrements right pointer value.
			 */
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			/*
			 *swapping the values at left pointer and right pointer by declaring temp variable is taking place
			 */
			int temp = array[leftPointer];
			array[leftPointer] = array[rightPointer];
			array[rightPointer] = temp;
			
		}
		/*
		 * swapping of pivot and higher index is taking place
		 */
		int temp = array[leftPointer];
		array[leftPointer] = array[highIndex];
		array[highIndex] = temp;
		
		/*
		 * Recursion is taking place
		 */
		QuickSort(array, lowIndex, (leftPointer-1));
		QuickSort(array, (leftPointer + 1), highIndex);
	}
}






