/***********************
 * Programmer: Kenny Lepping
 * 5/3/17
 * javac River.java
 * 
 * 
 * This program updates the river and its cells according to the rules of the project and 
 * provides the toString() method to print it out.
 *
 ***********************/
 
 /* A private integer named length, a private boolean named processed, and a public object array 
 	named river are all declared. A constructor with an integer length is made to create random 
 	animals in the river using the java's random number generator. Below that a getter method is 
 	made to return the length of the river. The numEmpty method iterates through the river a 
 	returns the amount of cells with no animals (null). The addRandom method is used to create  
 	a new animal of a random gender with an age of 0 as a baby when two animals of the same species
 	and different gender collide in the river. The updateCell method is called from the updateRiver
 	method to move animals in accordance with the project's rules such as when two bears of the same
 	gender and different strength collide, the one with the lower strength value dies. The updateRiver
 	method iterates through the river with randomly generated animals from left to right marking them
 	as processed after they are iterated through and then aging them all by one. The toString method
 	returns a string of the current. */
 	
import java.util.ArrayList; // Java's ArrayList utility is imported for storing null cells in the AddRandom(Animal animal) method
import java.util.Random; // Java's Random utility is imported for randomizing movements, gender, whether an animal should move etc.

public class River { // Class name is River because it handles river's information for each cycle

	private Random randGen = new Random(); // A new private random number generator is created for use inside class
	
	private int length; // Private integer length is declared for getting user entered river length from RiverSimulator.java
	private boolean processed; // Private boolean processed is declared for checking if animal has been processed or not

	public Animal[] river; // Public Animal array named river is declared to store the river's animals and empty cells

	public River(int length) { // Constructor for the River class with the int length as its parameter
		this.length = length;  // The length from the constructor's parameter is assigned to River's length variable
		river = new Animal[length]; // Assigns the length of the river to the river array
		// Randomly assign each cell to either a bear, fish, or null:
		for (int i = 0; i < length; i++) { // Loop for iterating through random species or null choices
			int k = randGen.nextInt(3); // Generates random integer from 0 to 2 for randomizing what animals there are and their amount
			switch (k) { // Switches between cases for assigning a bear, fish, or null cell to river
				case 0: // Case 0 for a null cell
					river[i] = null; // Cell at i equals null
					break; // Breaks to go further iterate through loop
				case 1: // Case 1 for a cell with a bear
					river[i] = new Bear(); // Cell at i has a bear
					break; // Breaks to go further iterate through loop
				case 2: // Case 2 for a cell with a fish
					river[i] = new Fish(); // Cell at i has a fish
					break; // Breaks to go further iterate through loop
				default: // Default case 
					break; // Breaks to go further iterate through loop
			}
		}
	}

	public int getLength() { // Getter method for returning the length of the river
		return length; // Returns the river's length
	}

	public int numEmpty() { // Method for returning how many null cells river has
	 
	 	int amountNull = 0; // Int variable amountNull is initialized to 0
	 	
	 	for(int i = 0; i < getLength(); i++) { // Loop for finding null cells
	 		if (river[i] == null) { // If cell is null increment amountNull
	 			amountNull++; // Integer amountNull is incremented
	 		}
	 	}
	 	
	 	return amountNull; // Returns amountNull
	}
	
	public boolean addRandom(Animal animal) { // Method for adding a baby animal to the river
	
		ArrayList<Integer> nullCells = new ArrayList<Integer>(); // ArrayList is created to store where the null cells are
		
		if (numEmpty() == getLength()) { // If river is full, then no baby animal can be added
			return false; // Returns false because baby animal cannot be placed into river
		}
		
		for (int i = 0; i < getLength(); i++) { // Loop iterates through river storing the position of the null cells
			if (river[i] == null) { // If the cell is null, add it to nullCells
				nullCells.add(new Integer(i)); // ArrayList nullCells has greater size the more nulls there are
			}
		}
		
		int k = randGen.nextInt(nullCells.size()); // Int k is assigned a random number based on nullCells size
		animal.age = -1; // Assigns -1 as the baby animals age to print age 0 after all animal ages increment 
		animal.setRandGender(); // Sets a random gender to the baby animal
				
		river[nullCells.get(k)] = animal; // The randomized baby animal is assigned a random null cell position in the river
		return true; // Returns true because a baby animal was created and put into the river
			
	}
	
	public void updateCell(int i) { // Method for updating the cells the river based on the project's rules
	
		int k = randGen.nextInt(3); // Integer k is assigned a random number from 0 to 2. 
		
		Animal placeHolder = river[i]; // Assigns river[i] to a temporary place holder for further use
		river[i] = null; //sets original position to null
		
		if(placeHolder == null) { // If the cell is null, then don't do anything
		}
		
		else if (k == 0) { // If k is 0, then animal does not move
		
			river[i] = placeHolder; // The placeHolder is assigned to river[i]
			
		}
			
		else if (placeHolder.toString().charAt(0) == 'B') { // If the animal is a bear			
			if (k == 1) { // bear can move left
			
				if (i - 1 >= 0) { // If the bear isn't at at the first river cell
					if (river[i - 1] == null) { // If i - 1 is null, the go left
					
						river[i - 1] = placeHolder; // The placeHolder is assigned to river[i - 1]
					}
					
					else if (river[i - 1].toString().charAt(0) == 'F') { // Fish dies if collides with bear
					
						river[i - 1] = placeHolder; // The placeHolder is assigned to river[i - 1]
					}
					
					else if (river[i - 1].toString().charAt(0) == 'B') { // If the animal is a bear	
					
						if (river[i - 1].getGenderChar() == placeHolder.getGenderChar()) { // If the bears are the same gender
						
							if (((Bear)river[i - 1]).getStrength() == ((Bear)placeHolder).getStrength()) { // For same gender bears of equal strength
							
								river[i] = placeHolder; // Both bears survive
							}
							
							else if (((Bear)river[i - 1]).getStrength() >= ((Bear)placeHolder).getStrength()) { // For same gender bears of dffering strength
							} 
							
							else { // Bear with less strength does not survive
							
								river[i - 1] = placeHolder; // The placeHolder is assigned to river[i - 1]
							}
						}
						
						else { // Baby bear is created for colliding bears of different gender
						
							addRandom(new Bear());  // Method for adding a baby bear is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					 
					}
				}
				
				else { // If animal is at beginning of river
				
					if (river[getLength() - 1] == null) { // If last cell of river is null, then move to that cell
					
						river[getLength() - 1] = placeHolder; // The placeHolder is assigned to river[getLength() - 1] 
						
					}
					
					else if (river[getLength() - 1].toString().charAt(0) == 'F') { // If last cell of river has a fish, then fish dies
					
						river[getLength() - 1] = placeHolder; // The placeHolder is assigned to river[getLength() - 1] 
					}
					
					else if (river[getLength() - 1].toString().charAt(0) == 'B') { // If the animal is a bear	
					
						if (river[getLength() - 1].getGenderChar() == placeHolder.getGenderChar()) { // If the bears are the same gender
						
							if(((Bear)river[getLength() - 1]).getStrength() == ((Bear)placeHolder).getStrength()) { // For same gender bears of equal strength
							
								river[i] = placeHolder; // Both bears survive
							}
							
							else if (((Bear)river[getLength() - 1]).getStrength() >= ((Bear)placeHolder).getStrength()) { // For same gender bears of dffering strength
							} 
							
							else { // Bear with less strength does not survive
							
								river[getLength() - 1] = placeHolder; // The placeHolder is assigned to river[getLength() - 1] 
							}
						}
						
						else { // Baby bear is created for colliding bears of different gender
						 
							addRandom(new Bear());  // Method for adding a baby bear is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					
					}
				}
			}
			
			else { // If k == 2 to go right 
			
				if (i + 1 <= getLength() - 1) { // If the bear is not at the last river cell
				
					if (river[i + 1] == null) { // If cell to the right is null, move to that cell
					
						river[i + 1] = placeHolder; // The placeHolder is assigned to river[i + 1]
					}
					
					else if (river[i + 1].toString().charAt(0) == 'F') { // Fish does not survive bear collision
					
						river[i + 1] = placeHolder; // The placeHolder is assigned to river[i + 1]
					}
					
					else if (river[i + 1].toString().charAt(0) == 'B') { // If the animal is a bear
					
						if (river[i + 1].getGenderChar() == placeHolder.getGenderChar()) { // If the bears have the same gender
						
							if (((Bear)river[i + 1]).getStrength() == ((Bear)placeHolder).getStrength()) { // For same gender bears of equal strength
							 
								river[i] = placeHolder; // Both bears survive
							}
							
							else if (((Bear)river[i+1]).getStrength() >= ((Bear)placeHolder).getStrength()) { // For same gender bears of dffering strength
							}
							
							else { // Bear with less strength does not survive
							 
								river[i + 1] = placeHolder; // The placeHolder is assigned to river[i + 1]
							}
						}
						
						else { // Baby bear is created for colliding bears of different gender
						
							addRandom(new Bear());  // Method for adding a baby bear is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					 
					}
				}
				
				else { // If the bear is at the last river cell
				
					if (river[0] == null) { // If the first cell is null, then go to that cell
					
						river[0] = placeHolder; // The placeHolder is assigned to river[0]
					}
					
					else if (river[0].toString().charAt(0) == 'F') { // Fish does not survive bear collision
					
						river[0] = placeHolder; // The placeHolder is assigned to river[0]
					}
					
					else if (river[0].toString().charAt(0) == 'B') { // If the animal is a bear
					
						if (river[0].getGenderChar() == placeHolder.getGenderChar()) { // If the bears have the same gender
						
							if (((Bear)river[0]).getStrength() == ((Bear)placeHolder).getStrength()) { // For same gender bears of equal strength
							
								river[i] = placeHolder; // Both bears survive
							}
							
							else if (((Bear)river[0]).getStrength() >= ((Bear)placeHolder).getStrength()) { // For same gender bears of dffering strength
							}
							
							else { // Bear with less strength does not survive
							
								river[0] = placeHolder; // The placeHolder is assigned to river[0]
							}
						}
						
						else { // Baby bear is created for colliding bears of different gender
						
							addRandom(new Bear());  // Method for adding a baby bear is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					
					}
				}
			}
		}
			
		else { // If the animal is a fish
		
			if (k == 1) { // Fish can move left
			
				if (i - 1 >= 0) { // If the fish isn't at at the first river cell
				
					if (river[i - 1] == null) { // If i - 1 is null, the go left
					
						river[i - 1] = placeHolder; // The placeHolder is assigned to river[i - 1]
					}
					
					else if (river[i - 1].toString().charAt(0) == 'B') { // Fish does not survive bear collision
					
					}
					
					else if (river[i - 1].toString().charAt(0) == 'F') { // If the animal is a fish
					
						if (river[i - 1].getGenderChar() == placeHolder.getGenderChar()) { // If the fish have the same gender
						
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
						
						else { // Baby fish is created for colliding fish of different gender
						
							addRandom(new Fish());  // Method for adding a baby fish is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					 
					}
				}
				
				else { // If animal is at beginning of river
				
					if (river[getLength() - 1] == null) { // If last cell of river is null, then move to that cell
					
						river[getLength() - 1] = placeHolder; // The placeHolder is assigned to river[i - 1]
					}
					
					else if (river[getLength() - 1].toString().charAt(0) == 'B') { // Fish does not survive bear collision
					
					}
					
					else if (river[getLength() - 1].toString().charAt(0) == 'F') { // If the animal is a fish
					
						if (river[getLength() - 1].getGenderChar() == placeHolder.getGenderChar()) { // If the fish have the same gender
						
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
						
						else { // Baby fish is created for colliding fish of different gender
						
							addRandom(new Fish());  // Method for adding a baby fish is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					
					}
				}
			}
			
			else { // If k == 2 to go right 
			
				if (i + 1 <= getLength() - 1) { // If the fish is not at the last river cell
				 
					if (river[i + 1] == null) { // If cell to the right is null, move to that cell
					
						river[i + 1] = placeHolder; // The placeHolder is assigned to river[i + 1]
					}
					
					else if (river[i + 1].toString().charAt(0) == 'B') { // Fish does not survive bear collision
					
					}
					
					else if (river[i + 1].toString().charAt(0) == 'F') { // If the animal is a fish
					
						if (river[i + 1].getGenderChar() == placeHolder.getGenderChar()) { // If the fish have the same gender
						
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
						
						else { // Baby fish is created for colliding fish of different gender
						
							addRandom(new Fish());  // Method for adding a baby fish is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					
					}
				}
				
				else { // If the fish is at the last river cell
				
					if(river[0] == null) { // If the first cell is null, move to that cell
					
						river[0] = placeHolder; // The placeHolder is assigned to river[0]
					}
					
					else if(river[0].toString().charAt(0) == 'B') { // Fish does not survive bear collision
					
					}
					
					else if(river[0].toString().charAt(0) == 'F') { // If the animal is fish
					
						if(river[0].getGenderChar() == placeHolder.getGenderChar()) { // If the fish have the same gender
						
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
						
						else { // Baby fish is created for colliding fish of different gender
						
							addRandom(new Fish());  // Method for adding a baby fish is called
							river[i] = placeHolder; // The placeHolder is assigned to river[i]
						}
					}
					
					else { // Go to next part of the updateCell method
					
					}
				}
			}
		}
	}

	public void updateRiver() { // Method for updating the entire for each cycle
	
		for(int i = 0; i < getLength(); i++) { // Loop for setting whether the animals were processed to false
			if (river[i] != null) { // If the cell contains an animal, set the animal to false
				river[i].setProcessed(false); // Calls the setProcessed method setting the the animal at i to false
			}
		}
			
		for(int i = 0; i < getLength(); i++) { // Loop for updating each cell and setting whether the animal was processed to true
			
				if (river[i] == null || river[i].getProcessed() == true) { // If the the animal has already been processed, don't do anything
				}
				else if (river[i] != null) { // If the animal has not been processed, setProcessed to true and update that animal
				
					river[i].setProcessed(true); // Calls the setProcessed method setting the the animal at i to true
					updateCell(i); // Updates the cell at i if there's an animal there and that animal has not been processed
				}
			
		}
		
		for(int i = 0; i < getLength(); i++) { // Loop for incrementing the age of each animal after each cycle
		
			if(river[i] != null) { // If there's an animal in the cell 
			 
					if(river[i].incrAge() == false) { // If the animal has reached max age
			
						river[i] = null; // Animal dies setting cell that animal was in to null
					}
				
 					else { // If incrAge() is true, add one to the animal's age
				
					}
			}
			
			else { // If the cell is null, don't do anything
				
			}
		}
		
	}

	public String toString() { // Method for printing the river after each cycle

		String riverState = ""; // Initialize the String riverState for further use
		for (int i = 0; i < getLength(); i++) { // Loop for printing out each individual cell of the river
			if (river[i] == null) { // If the cell is null 
				riverState += "––– "; // Print ––– for null cells
			} 
			else { // If cell is not null
				riverState += river[i].toString() + " "; // Print the animal with a space after it
			}
		}
		return riverState; // Print out the entire river for current cycle
	}
}
