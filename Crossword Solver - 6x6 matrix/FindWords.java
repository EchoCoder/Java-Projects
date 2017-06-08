/*****************************   
* Programmer: Kenny Lepping    
* 4/7/17
* javac FindWords.java
* java FindWords < 0606matrix
* 
* This program finds words in a character matrix using a dictionary, then prints them out.
* 
* 
******************************
*/ 

/* In the main method, this program scans all of the words from a dictionary named "words"
	and stores them in string array named wordlist. Then, a new string array named
	letterArray is made to store a character matrix named 0606matrix. The character matrix 
	gets stored while all of the spaces in the matrix are removed to check for words later. 
	Nested for loops are made to iterate through the characters in letterArray using the
	substring method. These iterations are stored in a string variable named wordMain.
	Then, an if statement checks if the string stored in wordMain matches with a word in the
	"words" dictionary. This is done using the checkword method that returns true if a word
	matches and false if it doesn't. If checkword returns true, then the word is printed
	followed by a new line.   */

import java.util.Scanner; // Imports the java utility Scanner
import java.io.*;         // Imports the java.io package

public class FindWords {  // Class name is FindWords
	
    // search word in the array list
    // return true if found, otherwise false
    // please finish this method
    public static boolean checkword(String[] list, String word) { // Method to check if the word variable matches with a word in the dictionary 
		for(int i = 0; i < list.length; i++) { // Used to iterate through all of the words in the dictionary
			if(list[i].length() < 2) // Makes sure the word is not less than 2 letters
				continue;            // Goes onto next if statement 
					
			if(word.equals(list[i])) { // Checks if word matches with a word in the dictionary 
				return true;           // Returns true if word is valid
			}
		}
        return false;                  // Returns false if there is no match with the dictionary
    }
    
    public static void main(String[] args) { // Main method for scanning and iterating through dictionary and character matrix
        // read words from file "words"
        // the words are saved to array wordlist
        // Please do not change this part
        String[] wordlist = new String[99171]; 
        int index=0; 
        try{
	    
            Scanner in = new Scanner(new FileReader("words"));
        
            while(in.hasNextLine()){
                wordlist[index]=in.nextLine();
                index++;
                
            }
				
        }catch(IOException e){
			e.printStackTrace();
        }
        

        // fill the following part
        // read the matrix
        // save the letters of the matrix to a 2D array
              	
		Scanner inFS = new Scanner(System.in); // New scanner is created for character matrix
    	int rows = inFS.nextInt(); // Scans for row number above character matrix
    	int cols = inFS.nextInt(); // Scans for column number above character matrix
       
    	String[] letterArray = new String[rows]; // String array named letterArray created to store character matrix
    	
    	String wordMain = ""; // For storing iterations of all of the characters in the character matrix
    
    	int i = 0; // For iterating through for loops
    
    	inFS.nextLine(); // Skipping to next line    	
    	for (i = 0; i < rows; i++) { // Iterates through all of the rows in the character matrix
    		letterArray[i] = inFS.nextLine(); // Stores row of characters in letterArray[i]
    		letterArray[i] = letterArray[i].replaceAll("\\s+",""); // Takes away the spaces from the character matrix
    	}	
    	    	
    	// fill the following part
        // checks the sequences of letters
        // to see whether they are words or not
    	   	
    	for (i = 0; i < rows; i++) { // Iterates through all of the strings in letterArray
    		for (int beginIndex = 0; beginIndex < cols; beginIndex++) { // Iterates through first index in substring method
	   	    	for (int endIndex = beginIndex + 2; endIndex <= rows; endIndex++) { // Iterates through last index in substring method
        	    	wordMain = letterArray[i].substring(beginIndex, endIndex);      // Assigns iterations of all character combinations in letterArray to wordMain
        	    	if(checkword(wordlist, wordMain)) { // Uses the checkword method to see if wordMain matches with a word in the dictionary
						System.out.println(wordMain);   // If the checkword method returns true, then wordMain is printed
					}	
	        	}
        	}
	}    
    	
    }
 
}
