/*****************************   
* Programmer: Kenny Lepping   
* 3/26/17
* javac WordUnscrambler.java
* java WordUnscrambler
*
* A game the unscrambles letters in words from the file words.txt based on user input.
* 
******************************
*/ 

/* 	This program is a game that takes a word from the list in "words.txt" and scrambles it. 
	The program then displays the indexes of the scrambled word above the scrambled word.
	The player is then prompted to enter 1 to swap letters in the word, 2 to show the word 
	solved, and 3 to quit the game. When 1 is entered, the player is prompted to enter two 
	indexes to swap within range of the word. This is repeated until the word is solved, 
	or the player chooses the the option to display the solved word or quit the game. When 
	the scrambled word is solved from the player swapping letters, a message is displayed 
	congratulating the player and telling them how many steps were taken to solve the 
	scrambled word. */
	
import java.util.*; // All java utilities are imported
import java.io.*; // Imports java.io package

public class WordUnscrambler { // Class name is WordUnscrambler
		
	public static void main(String[] args) throws IOException { // Main method throws IOException
		Scanner inFS = null; // Scanner created for inFS
    	Random randGen = new Random(); // Random number generator is created
    	Scanner scan = new Scanner(System.in); // Player input scanner uses System.in
    	WordCalculations word = new WordCalculations();
    	    	
    	String wordToScramble = ""; // Initialized for unscrambled word
    	ArrayList<String> wordList = new ArrayList<String>(); // Creates ArrayList for words.txt 
    	String unScrambledWord = ""; // Used to hold word solved or being solved
    	String scrambledWord = ""; 	 // Holds scrambled word
    	
    	int lineNum = 0; // Used in loop to choose line with a word
    	
    	File file = new File("words.txt"); // Opens file named words.txt
    	inFS = new Scanner(file); 	// Scanner for file a word in words.txt
    	
    	while(inFS.hasNextLine()) { // Iterates as long as there is a word to read
    		unScrambledWord = inFS.nextLine();// Assigns word chosen to unScrambledWord
    		wordList.add(unScrambledWord); 	  // Adds new word to wordList
    	}
    	
		lineNum = randGen.nextInt(wordList.size()); // Assigns a random line number to lineNum
		
		wordToScramble = wordList.get(lineNum); 	// Random word is chosen
		scrambledWord = word.Scramble(randGen, wordToScramble); // Word chosen is scrambled
		
		while (scrambledWord.equals(wordToScramble)) { 	   // Checks if word needs to scrambled 
			scrambledWord = word.Scramble(randGen, wordToScramble); // Word is scrambled
		}
		
		word.GameLoop(scrambledWord, wordToScramble, scan); // Game processes are carried out
		inFS.close(); // Closes file
		
	}	
}
	
	
	
		
	
	