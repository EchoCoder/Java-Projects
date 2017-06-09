/*****************************   
* Programmer: Kenny Lepping   
* 3/26/17
* javac WordUnscrambler.java
* java WordUnscrambler
*
* This class processes the word from words.txt based on user input and displays the results
*  
******************************
*/ 

import java.util.*;
import java.util.InputMismatchException; // The InputMismatchException utility is imported for invalid input

public class WordCalculations {

	public static String Scramble(Random random, String inputString) { // Method to scramble word
    	char wordLetters[] = inputString.toCharArray(); // Converts string into a character array
		
		for(int c = 0; c < inputString.length(); c++) { 	// Used to scramble the letters of the word  
			int x = random.nextInt(wordLetters.length - 1); // Random number range is within word indexes
			while (x == c) { 								// Makes sure same index is not swapped	
				x = random.nextInt(wordLetters.length - 1); // Assigns new random number to x within range of wordLetters' indexes while x == c
			}
			char tempChar = wordLetters[x]; // Letters are scrambled
    		wordLetters[x] = wordLetters[c];  
    		wordLetters[c] = tempChar;
		} 
    	
    	return new String(wordLetters); // Returns new scrambled word
	}
	
	public static String SwapLetters(String wordSolver, int userIndexA, int userIndexB) { // Method to unscramble word from player input
		char solvingWord[] = wordSolver.toCharArray(); // Converts string into a character array

    	char tempChar = solvingWord[userIndexA];  	   // Swaps letters from player input
	    solvingWord[userIndexA] = solvingWord[userIndexB];  
	    solvingWord[userIndexB] = tempChar;
          
		wordSolver = new String(solvingWord); // A new scrambled or unscrambled word is assigned to wordSolver 
			
		return wordSolver; // Returns scrambled or unscrambled word	
	}

	public static void StringDisplay(String wordDisplay1, String wordDisplay2) { // Displays player input options
		int i; // Variable i is declared for loops
		
		for (i = 0; i < wordDisplay1.length() + 2; i++) { // Displays horizontal lines above word based on length of word
			System.out.print("-");
		}
		System.out.print("\n ");  // A new line with a space after it to indent index numbers
		
		for (i = 0; i < wordDisplay1.length(); i++) { 	  // Displays index numbers on top of word
			System.out.print(i + "");
		}
		System.out.println("");  // A new line is outputted for scrambled to be under its indexes
		
		System.out.println(" " + wordDisplay2); 		  // Scrambled word is displayed
		
		for (i = 0; i < wordDisplay1.length() + 2; i++) { // Displays horizontal lines below word based on length of word
			System.out.print("-");
		}
		System.out.println("\n"); // Two new lines are outputted creating space for player options
		
		System.out.println("Enter 1 to swap letters."); // Player option to swap letters
		System.out.println("Enter 2 to solve."); 		// Player option to show solved word
		System.out.println("Enter 3 to quit.\n"); 		// Player option to quit the game
		
		return; // Returns to GameLoop method
	}
	
	public static void GameLoop(String scrambledWord2 , String wordToScramble2, Scanner scan) { // Displays game and takes user input 
		String tempScrambledWord = ""; // For assigning scrambled word temporarily
		char pluralS = 's';  // Is at end of steps if more than one step to solve is taken
		
		int stepCounter = 0; // Is for counting number of steps taken to solve word
		int userNum = 0; 	 // Is initialized to 0 because variable is user input
		
		int userIndexA = 0;  // For holding the first user entered index
		int userIndexB = 0;  // For holding the second user entered index
		
		while (scrambledWord2 != wordToScramble2) { // Loops until the word is solved
		
			StringDisplay(wordToScramble2, scrambledWord2); // Displays player options
			
			try {
				userNum = Integer.parseInt(scan.next()); // Takes user input after options are displayed
			} catch (Exception e) {
				scan.reset(); // Resets back to beginning of loop
			}
			
			if (userNum != 1 && userNum != 2 && userNum != 3) { // If player does not follow instructions, "Invalid Input." is displayed
				System.out.println("Invalid Input.");
			}
			else { // If 1, 2, or 3 are entered, then goes to switch statement for further processes
			
				switch (userNum) { // Considers user input
					case 1: 	   // If user enters 1
						
							try {
								System.out.println("Enter the indexes separated by spaces"); // Prompts user to enter enter indexes
								userIndexA = Integer.parseInt(scan.next()); // Input for first number in index swap
								userIndexB = Integer.parseInt(scan.next()); // Input for second number in index swap
								// Makes sure user input is valid:
								while (userIndexA < 0 || userIndexB < 0 || userIndexA > wordToScramble2.length()-1 || userIndexB > wordToScramble2.length()-1) {   // Loops if user for input is valid	
								
									System.out.println("Invalid indices. Please enter a value between and including 0 and " + (wordToScramble2.length()-1) + "."); // Prompts user to enter new indexes
									userIndexA = Integer.parseInt(scan.next()); // Input for first number in index swap
									userIndexB = Integer.parseInt(scan.next()); // Input for second number in index swap									
								
								}
								stepCounter++; // Steps to solve increments
							} catch (Exception e) {
								System.out.println("Invalid indices."); // Displays that input is invalid
								scan.reset(); // Resets back to beginning of loop
							}
												
						break; // Stops iteration of prompting user for input

					case 2: // If user enters 2
						System.out.println("Scrambled word solved is " + wordToScramble2 + ".\n"); // Displays solved word
						break; // Stops game
					
					case 3: // If user enters 3
						System.out.println("Game Quit.\n"); // Displays that the game has been quit
						break; // Stops game
					
					}
			}
			if (userNum == 2 || userNum == 3) { // Game is ended if user input is 2 or 3
					break;
			}
		
			tempScrambledWord = scrambledWord2; // The scrambled word is assigned to the temporary version
			
			if (userNum == 1) { // Makes sure letters are only swapped when 1 and user indexes are entered
				scrambledWord2 = SwapLetters(tempScrambledWord, userIndexA, userIndexB); // Temporary word has letters swapped then assigned to the scrambled word
			}
			
			if (scrambledWord2.equals(wordToScramble2)) { // Checks if the scrambled word has been solved
				if (stepCounter > 1) { // If more than one step was taken to solve, then 's' is added to step
					System.out.println("\nCongratulations! You unscrambled the word " + wordToScramble2 + " in " + stepCounter + " step" + pluralS + ".\n"); // Congratulations message is displayed 
				}
				else { // If only one step was taken, step is displayed
					System.out.println("\nCongratulations! You unscrambled the word " + wordToScramble2 + " in " + stepCounter + " step.\n"); // Congratulations message is displayed 
				}
				break; // Game ends if word is solved. If not, GameLoop continues.
			}
					
		}
		return; // Returns to main method
	} 
}