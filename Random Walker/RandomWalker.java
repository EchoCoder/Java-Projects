/**********************************************************************
*
* Programmer: Kenny Lepping
* javac RandomWalker
* java RandomWalker N
*
* Simulates motion of a random walker for N steps
*
*
***********************************************************************
*/

import java.lang.Math;

public class RandomWalker {
   
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      
      int x = 0;       // Starting x position
      int y = 0;       // Starting y position
      double r;        // Variable for generating random number
      
      int step;
      
      System.out.println("(" + x + ", " + y + ")"); // Origin (0, 0)
            
      for (step = 0; step < N; step++) { // Repeat until walk N steps 
         r = Math.random();
         if (r <= 0.25)                  // 25% probability 
            ++x; // East step
         
         else if (r <= 0.50)  
            --y; // South step
         
         else if (r <= 0.75) 
            ++y; // North step
         
         else if (r <= 1.00) 
            --x; // West step
         
         System.out.println("(" + x + ", " + y + ")"); // Prints (x, y) 
       } 
        
       System.out.println("squared distance = " + (x * x + y * y)); // Prints squared distance 

    }
}
  
