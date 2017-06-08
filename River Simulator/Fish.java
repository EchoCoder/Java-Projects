/***********************
 * Programmer: Kenny Lepping
 * 5/3/17
 * javac Fish.java
 * 
 * This class extends the abstract Animal class for creating a Fish with age limit rules and a gender.
 *
 ***********************/
 
 /* The public Fish constructor calls Animal's constructor and sets the fish's age randomly between 
 	0 and 4. The Fish() constructor with parameters creates a fish of a specified age and gender. 
 	The maxAge() method returns true is the fish's age is 4 and false if it is below 4. The incrAge() 
 	method adds one year to the age of the fish and returns true if the maxAge() is false. If maxAge()
 	is true, then incrAge() returns false. The toString method makes the species of the animal 
	class a fish putting 'F' instead 'B' to indicate this. */

public class Fish extends Animal { // The Fish class extends the abstract Animal class to use its methods
	
	public Fish() { // Fish constructor uses the Animal class's to create a fish with random gender and age
		super(); // Calls the parent class's constructor
		k = randGen.nextInt(5); // Uses k for random number generating a random age as indicated by the instructions
		age = k; // Integer age = the random number within the fish's age limits (up to 4)
	}

	public Fish(int fishAge, Gender fishGender) { // Fish constructor for creating a fish of a specified age and gender
		super(fishAge, fishGender); // Calls parent class to create fish of a specified age and gender
	}	

	public boolean maxAge() { // Method for checking if the maximum age of the fish has been met
		if (getAge() == 4) {  // If the fish's age is at its max (4), return true
			return true; // Returns true for an age of 4
		} 
		else {  // Else, the fish's age is not at its max (4), so return false
			return false; // Returns false for an age below 4
		}
	}

	public boolean incrAge() { // Method for incrementing the age of the fish
		if (!maxAge()) {  // If fish did not reach maximum, age, increment that age by 1 and return true
			addAgeYear(); // Increments the fish's age by 1
			return true;  // Returns true if maxAge() is false
		} 
		else { // If fish did reach maximum, age, just return false
			return false; // Returns false if maxAge() is true
		}
	}

	public String toString() { // Method for printing out the fish 

		return "F" + super.toString(); // Returns "F" indicating the fish's species + the parent class's toString() method
										   
	}

}
