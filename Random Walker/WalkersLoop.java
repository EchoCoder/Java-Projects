/**********************************************************************
*
* Programmer: Kenny Lepping
* javac WalkersLoop.java
* java WalkersLoop
*
* Calculates the average distance taken per trial 
*
***********************************************************************
*/

import java.lang.Math;

public class WalkersLoop {

	public static void Distance(int stepNum, int inputT) {

		int x = 0;       // Starting x position
		int y = 0;       // Starting y position    
	
		int step;        // Repeat until walk stepNum steps
		int trialNum = 0;

		double sum = 0;              // For sum of squared distances
		double squaredDistance = 0;  // Calculated every iteration of for loop
		double r;                    // r declared for Math.random()
		double meanSqrdDistance = 0; // Average of T distances initialized
   
		for (trialNum = 0; trialNum < inputT; trialNum++) {
				x = 0;            // Initialize x         
				y = 0;            // Initialize y
				for (step = 0; step < stepNum; step++) { 
					r = Math.random(); // Random method
					if (r <= 0.25) // Implements direction probability
						++x; // East step

					else if (r <= 0.50)  
						--y; // South step

					else if (r <= 0.75) 
						++y; // North step

					else if (r <= 1.00) 
						--x; // West step
				}
				
			squaredDistance = (x * x + y * y); // x squared plus y squared 
			sum += squaredDistance;            // Sum plus squaredDistance for every iteration 
			}
			meanSqrdDistance = sum / inputT; // Mean squared distance (average of the T distances)
			System.out.println("mean squared distance = " + meanSqrdDistance);
	}
}	