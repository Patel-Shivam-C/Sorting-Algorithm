import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestSearchSort {

	public static int option;															//Option variable used in menu.
	public static Scanner keys = new Scanner(System.in);								//Scanner class object.

	/**
	 * This method print option in a console and receive user selection
	 */
	public static void menu() {															//Menu method to show user what they can do and ask what they want to do.
		System.out.println("");
		System.out.println("Select your option in the menu below:");
		System.out.println("1. Initialize and populate an array of 20 random intergers.");
		System.out.println("2. Perform a recursive binary search.");
		System.out.println("3. Perform a non-recursive binary search.");
		System.out.println("4. Sort the array.");
		System.out.println("5. Exit.");
		System.out.print("Select you choice: ");
		option = keys.nextInt();
	}
	
	/**
	 * 
	 * @param args : This a main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] copyArr = null;
		int [] randomArray = null;
		int number;
		Binarysearch BS = new Binarysearch();
		
		while (option > -1) {															//While loop to show user menu again after completing one task.
			try {																		//try-catch to handle InputMismatch exception.
				menu();																	//Calling menu method
				switch (option) {														//Switch statement to do task user want to do
				case 1:																	//Case 1 call method from Binarysearch class to generate an array with random numbers between 200 to 1000
					randomArray = new int[1000];
					BS.generateRandomInts(randomArray, 200, 1000);
					copyArr = Arrays.copyOf(randomArray, randomArray.length);			//creating copy of an random array.
					System.out.println(Arrays.toString(randomArray));
					break;
				case 2:																	//Case 2 ask user to enter integer number which they want to find in an array using recursive method.
					System.out.print("Please enter an interger value to search: ");
					number = keys.nextInt();
					
					long start = System.nanoTime();										//This start counting time nano seconds.
					long startTime = System.currentTimeMillis();						//This start counting time in milli seconds.
					
					BS.recursiveBinarySearch(randomArray, number, 999, 0);				//calling recursive method from Binarysearch class.
					
					long finish = System.nanoTime();									//This stops the counting of nano seconds.
					long finishTime = System.currentTimeMillis();						//This stops the counting of milli seconds.
					long time = finish - start;											//This calculate the time elapsed of nano seconds.
					long timeElapsed = finishTime - startTime;							//This calculate the time elapsed of milli seconds.
					System.out.println("");
					System.out.println("Time taken in nanoseconds: "+time);				//printing nano seconds time.
					System.out.println("Time taken in milliseconds: " + timeElapsed);	//printing milli seconds time.
					break;
				case 3:																	//Case 2 ask user to enter integer number which they want to find in an array using iterative method.
					System.out.print("Please enter an interger value to search: ");
					number = keys.nextInt();
					
					long begin = System.nanoTime();										//This start counting time nano seconds.
					long beginTime = System.currentTimeMillis();						//This start counting time in milli seconds.
					
					BS.nonRecursiveBinarySearch(randomArray, number, 999, 0);				//calling iterative method from Binarysearch class.
					
					long end = System.nanoTime();										//This stops the counting of nano seconds.
					long endTime = System.currentTimeMillis();							//This stops the counting of milli seconds.
					long totalTime = end - begin;										//This calculate the time elapsed of nano seconds.
					long totalElapsed = endTime - beginTime;							//This calculate the time elapsed of milli seconds.
					System.out.println("");
					System.out.println("Time taken in nanoseconds: "+totalTime);		//printing nano seconds time.
					System.out.println("Time taken in milliseconds: "+totalElapsed);	//printing milli seconds time.
					break;
				case 4:
					BS.sorting(keys, copyArr);											//calling sorting method from binary class and passing copyArr to it.
					break;
				case 5:
					break;
				default:																//default message is used when user entered any out put other than cases.
					System.out.println("Invalid input, enter option 1-4");
	        break;
				}

				if (option == 5) {														//Case 4 print out Exit message to user.
					System.out.println("Exiting...... \nProgram by Shivam Patel.");
					break;
				}
			}catch(InputMismatchException e) {											//Catch statement
				System.out.println("Invalid input, enter option 1-4");
				keys.next();															//keys.next used for showing menu option again to user
			}
		}
		keys.close();                                  									//closing Scanner
	}
}
