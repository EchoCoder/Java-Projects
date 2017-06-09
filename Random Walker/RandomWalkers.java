/**********************************************************************
*
* Programmer: Kenny Lepping
* javac RandomWalkers.java
* java RandomWalkers N T
*
* Simulates how far away after N steps random walk 
*
***********************************************************************
*/

import java.util.Scanner;
import java.util.InputMismatchException; // The InputMismatchException utility is imported for invalid input

public class RandomWalkers {

	public static void main(String[] args) {
	
		WalkersLoop walkers = new WalkersLoop();
		Scanner input = new Scanner(System.in);
		
		int N = 0;
		int T = 0;
		
		boolean loopTest = true;
		
		while (true) { // Iterates through simulator options while true
			System.out.println("Enter an integer for number of steps above 0. ");  // Prompts user to enter an integer 

			do { // Do while loop for looping back to prompt if input is invalid
				try { // Input entered below can be caught and handled if invalid
					
					N = Integer.parseInt(input.next()); // User input is put into the int N
					
					while (N <= 0) {   // Input less than or equal to 0 is invalid
						System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
						System.out.println("Enter an integer for number of steps above 0. ");  // Prompts user to enter an integer 
						N = Integer.parseInt(input.next()); // User input is put into the int N
					}
					
					if (N > 0) {
						loopTest = false;						
					}

				} catch (Exception e) { // Catches invalid input when input is not an integer
					System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
					System.out.println("Enter an integer for number of steps above 0. "); // Prompts user to enter an integer 
					input.reset(); // Resets back to beginning of loop
				}
			} while (loopTest);
			if (loopTest == false) {
				break;
			}
		}
		
		loopTest = true;
		
		while (true) { // Iterates through simulator options while true
			System.out.println("Enter an integer for number of trials above 0. ");  // Prompts user to enter an integer 

			do { // Do while loop for looping back to prompt if input is invalid
				try { // Input entered below can be caught and handled if invalid
					
					T = Integer.parseInt(input.next()); // User input is put into the int T
					
					while (T <= 0) {   // Input less than or equal to 0 is invalid
						System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
						System.out.println("Enter an integer for number of trials above 0. ");  // Prompts user to enter an integer 
						T = Integer.parseInt(input.next()); // User input is put into the int T
					}
					
					if (T > 0) {
						loopTest = false;						
					}

				} catch (Exception e) { // Catches invalid input when input is not an integer
					System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
					System.out.println("Enter an integer for number of trials above 0. "); // Prompts user to enter an integer 
					input.reset(); // Resets back to beginning of loop
				}
			} while (loopTest);
			if (loopTest == false) {
				break;
			}
		}
		
		walkers.Distance(N, T);
	}
}