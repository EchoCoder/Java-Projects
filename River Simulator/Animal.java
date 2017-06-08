/***********************
 * Programmer: Kenny Lepping
 * 5/3/17
 * javac Animal.java
 * 
 * This class is abstract to be implemented into the Bear and Fish classes 
 *
 ***********************/

/*  The abstract Animal class creates a protected random number generator object named randGen, 
	a protected enumerator named Gender, and needed protected variables for later use. The Animal()
	constructor is used to create a new animal with random necessary attributes while the Animal 
	constructor with parameters is used to create an animal of a specified gender and age. The 
	setProcessed() method is to set an animal to true if processed and false if not while the 
	getProcessed() method returns if the processed variable is true or not. The setRandGender() is used 
	to give a baby animal a random gender when created. The addAgeYear() method is used to add one to the 
	age of animal after a cycle. The getGenderChar() method returns 'F' if the animal is female and 'M' if 
	the animal is male. incrAge() is declared to increment the age of an animal if maxAge() is false. Both
	methods are in the Bear and Fish classes. The toString() method returns the species, gender, and age of 
	animal as a string. For example, a Fish female of age 3 is FF3. 
	 */

import java.util.Random; // Java's Random utility is imported for randomizing gender and age

public abstract class Animal { // The abstract Animal class is the parent class of the Fish and Bear class

	protected Random randGen; // A protected random number generator is declared 

	protected enum Gender { // A protected enum named Gender is created for specifying animal genders
		FEMALE, MALE // Two genders are female and male
	}

	protected int k;   // A protected int named k is declared for holding random numbers
	protected int age; // A protected int named age is declared for holding animal ages
	
	private Gender gender; // A private Gender is declared for holding the animal's genders
	private boolean processed; // A private boolean named processed is created for checking the animal has been processed

	public Animal() { // Animal constructor generating an animal with necessary random biology

		randGen = new Random(); // The random number generator is created 
		
		k = randGen.nextInt(2); // Int k is assigned 0 or 1 randomly 

		if (k == 1) { // If k is 1, then the gender of the animal is female
			gender = gender.FEMALE; // Female is assigned to the gender
		} 
		else { // If k is 2, then the gender of the animal is male
			gender = gender.MALE; // Male is assigned to the gender
		}

	}

	public Animal(int age, Gender gender) {  // Animal constructor generating an animal with specified random biology
		this.age = age; // The age variable from the parameters is assigned to this class's age variable 
		this.gender = gender; // The gender from the parameters is assigned to this class's gender
	}

	public void setProcessed(boolean isProcessed) { // Setter method for setting the animal has been processed or not
	
		processed = isProcessed; // The processed variable is assigned true if processed, and false if not
	
	}
	
	public boolean getProcessed() { // Getter method for returning the processed variable
		return processed; // The boolean processed is returned for use in the River class
	}
	
	public Gender setRandGender() { // Method for assigning a random gender to animals
	
		k = randGen.nextInt(2); // Using k for random number generation as indicated by the instructions
		if (k == 1) {  // If k is 1, then the gender of the animal is female
			return gender = gender.FEMALE; // Female is assigned to the gender
		} 
		else { // If k is 0, then the gender of the animal is male
			return gender = gender.MALE; // Male is assigned to the gender
		}

	}

	public void addAgeYear() { // Method for incrementing the age of animal before the max age
		age += 1;  // Int age is incremented by 1
	}
	
	public int getAge() { // Getter method for returning the age of the animal
		return age; // Returns the age of the animal for further processes
	}

	public char getGenderChar() { // Method for returning the gender character of the animal 
		char genderChar; // A char named genderChar is declared to be assigned 'F' or 'M'

		if (gender == gender.FEMALE) { // If the gender is female, then genderChar is 'F'
			genderChar = 'F'; // The genderChar is assigned 'F'
		} 
		else { // If the gender is male, then genderChar is 'M'
			genderChar = 'M';  // The genderChar is assigned 'M'
		}

		return genderChar; // Returns the genderChar based on animal gender 
	}

	abstract boolean maxAge();  // Declared to be used in the Fish and Bear classes to check their age limits

	abstract boolean incrAge(); // Declared for the Fish and Bear classes to check if the animal's age can be incremented

	public String toString() { // Prints the animal, in the format of the first letter of the species, then gender, then age 

		return "" + getGenderChar() + String.valueOf(getAge()); // Fish and Bear classes provide the species character
																// Format example of a fish: FF2. Example of a bear: BM7
	}

}
