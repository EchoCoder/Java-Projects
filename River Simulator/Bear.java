/***********************
 * Programmer: Kenny Lepping
 * Instructor: Dr. Tao
 * Course: CSC220-01
 * Project4  
 * 5/3/17
 * javac Bear.java
 * 
 * This class extends the abstract Animal class for creating a Bear with age limit rules and a gender.
 *
 ***********************/
 
 /* The private int strength variable is declared to be set according to the bear's age. 
 	The public Bear() constructor calls Animal's constructor, sets the bear's age randomly
 	between 0 and 9, then sets the strength based on the bear's age. The Bear() constructor
 	with parameters creates a bear of a specified age and gender setting the strength based 
 	on the age. The setStrength() method creates a strength of 9 - minus the age of the bear
 	if the bear's age is above 4. If the bear's age is 4 or below then the strength is the 
 	age of the bear plus 1. The getStrength() method returns the strength value. The maxAge()
 	method returns true is the bear's age is 9 and false if it is below 9. The incrAge() method
 	adds one year to the age of the bear and returns true if the maxAge() is false. If maxAge()
 	is true, then incrAge() returns false. The toString method makes the species of the animal 
	class a bear putting 'B' instead 'F' to indicate this. */

public class Bear extends Animal { // The Bear class extends the abstract Animal class to use its methods

	private int strength; // A private int named strength is declared for further use

	public Bear() { // Bear constructor uses the Animal class's to create a bear with random gender and age
		super(); // Calls the parent class's constructor
		k = randGen.nextInt(10); // Uses k for random number generating a random age as indicated by the instructions
		age = k; // Integer age = the random number within the fish's age limits (up to 9)
		setStrength(); // Sets the bear's strength based on the bear's age
	}

	public Bear(int bearAge, Gender bearGender) { // Bear constructor for creating a bear of a specified age and gender
		super(bearAge, bearGender); // Calls parent class to create fish of a specified age and gender
		setStrength(); // Sets the bear's strength based on the bear's age
	}

	public void setStrength() { // Method for setting the bear's strength

		if (getAge() > 4) { // If the age of the bear is greater than 4, then the strength is 9 - the bear's age
			strength =  9 - getAge(); // Bear's gets weaker after age 4
		} 
		else { // Bear's strength is age + 1 before the age of 4
			strength = getAge() + 1; // Bear get stronger until age 5
		}
	}

	public int getStrength() { // Getter method for returning the strength of the bear
		setStrength(); // Calls the setter method for the bear's strength
		
		return strength; // Returns the strength of the bear after it was set using setStrength()
	}

	public boolean maxAge() { // Method for checking if the maximum age of the bear has been met
	
		if (getAge() == 9) {  // If the bear's age is at its max (9), return true
			return true; // Returns true for an age of 9
		} 
		else { // Else, the bear's age is not at its max (9), so return false
			return false; // Returns false for an age below 9
		}
	}

	public boolean incrAge() { // Method for incrementing the age of the bear
		if (!maxAge()) {  // If bear did not reach maximum, age, increment that age by 1 and return true
			addAgeYear(); // Increments the bear's age by 1
			return true;  // Returns true if maxAge() is false
		} 
		else { // If bear did reach maximum, age, just return false
			return false; // Returns false if maxAge() is true
		}
	}

	public String toString() {  // Method for printing out the bear
	 
		return "B" + super.toString(); // Returns "B" indicating the bear's species + the parent class's toString() method 
										  
	}
}
