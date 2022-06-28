import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Binarysearch {
	/**
	 * SecureRandom class to generate random numbers
	 */
	SecureRandom ran = new SecureRandom();
	
	private int index = 19;
	private int userNum;
	
	/**
	 * Default constructor
	 */
	public Binarysearch() {
	}
	
	/**
	 * 
	 * @param randArr : array name to generate it.
	 * @param min : from which minimum number random method should start generating number
	 * @param max : till which maximum number random method should generate number
	 * @return : give random number between ranges
	 */
	public int generateRandomInts (int randArr[], int min, int max) {
		int i = 0;
		int randomInt = 0;
		while (i < randArr.length) {						//this while loop generate number until the array is full
			randomInt = min + ran.nextInt(max-min+1);		//generate random integer number
			randArr[i] = randomInt;							// storing random integers in an array
			i++;
		}
		return randomInt;
	}
	
	/**
	 * 
	 * @param randArr : Take numbers (from an arrays) from the below methods to print remaining numbers after every search.
	 * @param minmax : minmax identity from which index in the array this method should start printing method
	 * @param index : index tell method till what index this method should print numbers
	 */
	public void remainingElements(int randArr[], int minmax, int index) {
		
//		for (int i=0; i <= randArr.length - (index - minmax); i++) { //this for loop is used to for printing remaining number in reverses hill pattern.
//			System.out.print(" ");
//		}
		
		for (int i=minmax; i<=index; i++) {					//this for loop to print remaining numbers from an array.
			System.out.print(randArr[i]+" ");
		}	
//		System.out.println("");
	}
	
	/**
	 * This method do iterative binary search.
	 * @param randArr : Take array from the main class.
	 * @param num : What number is to be find.
	 * @param max : What number is of first index.
	 * @param min : What number is of last index.
	 * @return : if the number is found method return index number, if it's not found return -1.
	 */
	public int nonRecursiveBinarySearch(int randArr[], int num, int max, int min) {
		try {
			Arrays.sort(randArr);
			remainingElements(randArr, min, max);
			System.out.println("");
			while (min <= max) {								//While loop to find number in an array.
				index = min +((max - min)/2);					//"index" variable decide the middle index of an array}
				if (randArr[index] == num) {					//if the number is found in an array then this if statement is called
					System.out.println(randArr[index]);			
					System.out.println(" ");
					userNum = num;								//and print out message.
					System.out.println(userNum +" was found at index position "+index+": Iterative Binay Search" );
					return index;
				}else if (randArr[index] > num) {				//if the middle index number is greater than number which is searched
					max = index - 1;							//then this if statement change original max index and assign new max index
				}else if (randArr[index] < num) {				//if the middle index number is less than number which is searched
					min = index + 1;							//then this if statement change original minimum index and assign new minimum index
				}
				remainingElements(randArr, min, max);			//Method called to print remaining element after each binary search.
				System.out.println("");
			}
			System.out.println("");								//If the number is not found then this print out number not found message.
			System.out.println(num+" not found in the array.");
			System.out.println("");			
		}catch (NullPointerException e) {
			System.out.println(" ");
			System.out.println("Still array is not declare.");
			System.out.println(" ");
		}
		return -1;
	}
	
	/**
	 * This method do recursive binary search
	 * @param randArr : Take array from the main class.
	 * @param num : What number is to be find.
	 * @param max : What number is of first index.
	 * @param min : What number is of last index.
	 * @return : if the number is found method return index number, if it's not found return -1.
	 */
	public int recursiveBinarySearch(int randArr[],int num, int max, int min) {
		try {
			Arrays.sort(randArr);
			if (min <= max) {
				remainingElements(randArr, min, max);
				index = min + ((max - min)/2);						//"index" variable decide the middle index of an array
				if (randArr[index] == num) {						//if the number is found in an array then this if statement is called
					System.out.println("");
					System.out.println(randArr[index]);
					System.out.println("");
					userNum = num;
					System.out.println(userNum +" was found at index position "+index+": rescursive Binay Search" );
					return index;
				}else {
					if (randArr[index] > num) {						//if the middle index number is less than number which is searched
						max = index - 1;							//then this if statement change original minimum index and assign new minimum index
					}else if (randArr[index] < num) {				//if the middle index number is less than number which is searched
						min = index + 1;							//then this if statement change original minimum index and assign new minimum index
					}
					System.out.println("");
					recursiveBinarySearch(randArr, num, max, min);	//this part is calling this method itself.
				}
			}else {													//If the number is not found then this print out number not found message.
				System.out.println("");
				System.out.println(num+" not found in the array.");
				System.out.println("");
			}
		}catch (NullPointerException e) {
			System.out.println(" ");
			System.out.println("Still array is not declare.");
			System.out.println(" ");
		}
		return -1;
	}
	
	private String option;					//declaring private variable for storing user option.
	/**
	 * 
	 * @param keys : Take scanner class reference for taking user output
	 */
	/*
	 * This method is used to print sorting option and to receive user section.
	 */
	public void subMenu(Scanner keys) {
		System.out.println("B. Bubble Sort");
		System.out.println("I. Insertion Sort");
		System.out.println("S. Selection Sort");
		System.out.println("M. Merg Sort");
		System.out.println("Q. Quick Sort");
		System.out.println("R. Return to main menu");
		System.out.print("Enter your options: ");
		option = keys.next();
	}
	
	/**
	 * 
	 * @param keys : Take scanner class reference.
	 * @param array	: Take an array from main method from different class.
	 */
	public void sorting(Scanner keys, int[] array) {
		SortingAlgorithms sa = new SortingAlgorithms();									//Object of Sorting Algorithm class
		subMenu(keys);																	//calling Submenu method for giving user an option
		while (option != null) {
			if ("B".equalsIgnoreCase(option)) {
				
				int[] Bubble = Arrays.copyOf(array, array.length);						//making copy of "array" array.
				sa.BubbleSort(Bubble);													//Calling Bubble sort method from Sorting Algorithm class
				
			}else if ("I".equalsIgnoreCase(option)) {
				
				int[] Insertion = Arrays.copyOf(array, array.length);					//making copy of "array" array.
				sa.InsertionSort(Insertion);											//Calling Insertion sort method from Sorting Algorithm class
				
			}else if ("S".equalsIgnoreCase(option)) {
				
				int[] Selection =  Arrays.copyOf(array, array.length);					//making copy of "array" array.
				sa.SelectionSort(Selection);											//Calling selection sort method from Sorting Algorithm class
				
			}else if ("M".equalsIgnoreCase(option)) {
				int[] Merg = Arrays.copyOf(array, array.length);						//making copy of "array" array.
				
				long nanoStart = System.nanoTime();										//This start counting time nano seconds.
				long miliStart = System.currentTimeMillis();							//This start counting time in milli seconds.
				
				System.out.println(Arrays.toString(Merg));								//Printing unsorted array.
				System.out.println();
				sa.MergSort(Merg);														//Calling Merg sort method from Sorting Algorithm class
				System.out.println("Merg Sort: Recursive Divide-And-Conquer - O(n log n) Complexity-");
				System.out.println();
				System.out.println(Arrays.toString(Merg));								//Printing sorted array after merg sorting
				
				long nanoFinish = System.nanoTime();									//This stops the counting of nano seconds.
				long miliFinish = System.currentTimeMillis();							//This stops the counting of milli seconds.
				long allTime = nanoFinish - nanoStart;									//This calculate the time elapsed of nano seconds.
				long allElapsed = miliFinish - miliStart;								//This calculate the time elapsed of milli seconds.
				System.out.println("");
				System.out.println("Time taken in nanoseconds: "+allTime);				//printing nano seconds time.
				System.out.println("Time taken in milliseconds: "+allElapsed);			//printing milli seconds time.
			}else if ("Q".equalsIgnoreCase(option)) {
				int[] Quick = Arrays.copyOf(array, array.length);						//making copy of "array" array.
				
				long nanoStart = System.nanoTime();										//This start counting time nano seconds.
				long miliStart = System.currentTimeMillis();							//This start counting time in milli seconds.
				
				System.out.println(Arrays.toString(Quick));							//Printing unsorted array.
				System.out.println();
				sa.QuickSort(Quick, 0 , (Quick.length -1));								//Calling Quick sort method from Sorting Algorithm class
				System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity-");
				System.out.println();
				System.out.println(Arrays.toString(Quick));								//Printing sorted array after quick sorting
				
				long nanoFinish = System.nanoTime();									//This stops the counting of nano seconds.
				long miliFinish = System.currentTimeMillis();							//This stops the counting of milli seconds.
				long allTime = nanoFinish - nanoStart;									//This calculate the time elapsed of nano seconds.
				long allElapsed = miliFinish - miliStart;								//This calculate the time elapsed of milli seconds.
				System.out.println("");
				System.out.println("Time taken in nanoseconds: "+allTime);				//printing nano seconds time.
				System.out.println("Time taken in milliseconds: "+allElapsed);			//printing milli seconds time.
			}else if ("R".equalsIgnoreCase(option)) {
				break;
			}else {
				System.out.println("Invalid input \nPlease try again");
			}
			System.out.println("");
			subMenu(keys);
		}
	}
}
