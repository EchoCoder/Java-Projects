/***********************
 * Programmer: Kenny Lepping
 * Instructor: Dr. Tao
 * Course: CSC220-01
 * Project4  
 * 5/3/17
 * javac *.java 
 * java RiverSimulator 
 *
 * This class prompts the user to create a random river or exit, enter the length, and enter the number cycles.
 * The random river is then created with the user entered length and cycles and the whole process is repeated.
 *
 ***********************/
 
 /* The main method prints a welcome message to the user and then calls the RiverPrompt method 
 	to ask the user for input and then print the river based on that input and in accordance with
 	the project's rules. In the RiverPrompt method, scanner and river objects are instantiated, a 
 	boolean named loopTest is initialized to true, and the integers userOption, riverLength, and 
 	userCycles are initialized to 0 for further use. The River Ecosystem Simulator is announced,
 	then the user is prompted to enter 1 to create a random river and 2 to exit the program. If 
 	1 is chosen, then the user is prompted to enter the length of the river, and then the number 
 	of cycles for animals in the river to go through. Invalid is appropriately handled using do 
 	while loops with if statements to check invalid integers, and try catch blocks to handle non
 	integer input. After the length and number of cycles are entered, the riverInLength object
	brings the riverLength value to River.java's constructor, the initial river is printed using
	River.java's toString method, and the number of cycles entered are iterated through calling 
	River.java's the updateRiver and toString methods to print the river after it is updated each 
	cycle. */

import java.util.Scanner; // Java's Scanner utility is imported for user input
import java.util.InputMismatchException; // The InputMismatchException utility is imported for invalid input

public class RiverSimulator { // The class is named RiverSimulator 
	public static void main(String[] args) { // The main method welcomes the user to the River Ecosystem Simulator

		System.out.println("Welcome to CSC220 River Ecosystem Simulator!"); // Prints welcoming statement

		RiverPrompt(); // Calls the RiverPrompt method to start the river simulation
	}

	public static void RiverPrompt() { // This method is for going through simulations of the river

		Scanner input = new Scanner(System.in); // A new Scanner object named input for user input is made
		River riverInLength; // A River object named riverInLength is made to call River's methods
		boolean loopTest = true; // A boolean named loopTest is made for do while loop processes

		int userOption = 0;  // Integer named userOption is made for creating a random river (1) or exiting the program (2)
		int riverLength = 0; // Integer named riverLength is made for holding the user entered length of the river
		int userCycles = 0;  // Integer userCycles is made for the user entered number of cycles for the river to go through
		while (true) { // Iterates through simulator options while true
			System.out.println("\nRiver Ecosystem Simulator\nPlease choose: 1 (random river) 2 (exit)"); // Prompts user to create a random river or exit the program

			do { // Do while loop for looping back to prompt if input is invalid
				try { // Input entered below can be caught and handled if invalid
					
					userOption = Integer.parseInt(input.next()); // User input is put into the int userOption

					while (userOption < 1 || userOption > 2) {   // Input less than 1 or greater than 2 is invalid so loop finds this
						System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
						System.out.println("\nRiver Ecosystem Simulator\nPlease choose: 1 (random river) 2 (exit)"); // Prompts user again to create a random river or exit the program
						userOption = Integer.parseInt(input.next()); // User input is put into the int userOption
					}

					if (userOption == 1) { // If userPoint is 1, then loop is exited to create a random river
						System.out.println("Creating a random river..."); // Displays that random river is being created
						break; // Breaks out of loop
					}

					if (userOption == 2) { // If userPoint is 2, then loop is exited to exit program
						System.out.println("Goodbye!"); // Program displays Goodbye! when the program is exited
						break; // Breaks out of loop
					}

					loopTest = false; // The boolean loopTest is set to false exiting loop
				} catch (Exception e) { // Catches invalid input when input is not an integer
					System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
					System.out.println("\nRiver Ecosystem Simulator\nPlease choose: 1 (random river) 2 (exit)"); // Prompts user again to create a random river or exit the program
					input.reset(); // Resets back to beginning of loop
				}

			} while (loopTest); // Loop iterates as long as loopTest is true

			if (userOption == 2) // If loop breaks with userOption equaling 2 then while loop is exited exiting the program
				break; // Breaks out of loop

			loopTest = true; // Sets loopTest to true so next do while loop can iterate

			System.out.println("Enter the river length (an integer bigger than 0):"); // Prompts user to enter the length of the river

			do { // Do while loop for looping back to prompt if input is invalid
				try { // Input entered below can be caught and handled if invalid
					riverLength = Integer.parseInt(input.next()); // User entered length for the river is put into riverLength

					while (riverLength <= 0) { // Input less than or equal to 0 is invalid so while loop checks for this
						System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
						System.out.println("\nEnter the river length (an integer bigger than 0):"); // Prompts user to enter the length of the river again 
						riverLength = Integer.parseInt(input.next()); // User entered length for the river is put into riverLength
					}

					loopTest = false; // The boolean loopTest is set to false exiting loop

				} catch (Exception e) { // Catches invalid input when input is not an integer
					System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
					System.out.println("\nEnter the river length (an integer bigger than 0):"); // Prompts user to enter the length of the river again 
					input.reset(); // Resets back to beginning of loop
				}

			} while (loopTest); // Loop iterates as long as loopTest is true

			if (riverLength > 0) { // If user entered river length is valid, then program goes to next prompt

				loopTest = true; // Sets loopTest to true so next do while loop can iterate

				System.out.println("Enter the number of cycles (an integer bigger than 0):"); // Prompts user to the number of cycles for the river

				do { // Do while loop for looping back to prompt if input is invalid
					try { // Input entered below can be caught and handled if invalid
						userCycles = Integer.parseInt(input.next()); // User entered cycle amount is put into userCycles
						
						while (userCycles <= 0) { // As long as userCycles is negative or equal to 0, program does nothing as indicated in the directions
							userCycles = Integer.parseInt(input.next()); // User entered cycle amount is put into userCycles
						}

						loopTest = false; // The boolean loopTest is set to false exiting loop
					} catch (Exception e) { // Catches invalid input when input is not an integer
						System.out.println("Invalid selection. Please try again."); // Displays that input is invalid
						System.out.println("\nEnter the number of cycles (an integer bigger than 0):"); // Prompts user to the number of cycles for the river
						input.reset(); // Resets back to beginning of loop
					}
				} while (loopTest); // Loop iterates as long as loopTest is true
				
			}
			
			riverInLength = new River(riverLength); // The River object riverInLength put riverLength as parameter for River's constructor
			System.out.println("Initial River:"); 	// Tells user that the random river before it is cycled is going to be displayed
			System.out.println(riverInLength.toString()); // Prints initial randomized river before its cycles
			
			for(int j = 1; j <= userCycles; j++) { // Loop for iterating through the river's cycles
			
				System.out.println("After Cycle " + j); // Displays which cycle is being printed
				riverInLength.updateRiver(); // Updates the river based the project rules for the animals in the river
				System.out.println(riverInLength.toString()); // Prints the river after it has been cycled
			}
		
		}
	}
}
