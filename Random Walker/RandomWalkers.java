/**********************************************************************
*
* Programmer: Kenny Lepping
* javac RandomWalkers.java
* java RandomWalkers N T
*
* Simulates how far away after N steps random walk 
*
*
***********************************************************************
*/

import java.lang.Math;

public class RandomWalkers {

   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]); // Convert string to integer
      int T = Integer.parseInt(args[1]);
      int x = 0;       // Starting x position
      int y = 0;       // Starting y position       
      int trialNum;    // For number of trials in for loop
      
      int step;        // Repeat until walk N steps
      
      double sum = 0;              // For sum of squared distances
      double squaredDistance = 0;  // Calculated every iteration of for loop
      double r;                    // r declared for Math.random()
      double meanSqrdDistance = 0; // Average of T distances initialized
       
      for (trialNum = 0; trialNum < T; trialNum++) {
         x = 0;            // Initialize x         
         y = 0;            // Initialize y
         for (step = 0; step < N; step++) { 
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
       meanSqrdDistance = sum / T; // Mean squared distance (average of the T distances)
       System.out.println("mean squared distance = " + meanSqrdDistance);
       
   }
}