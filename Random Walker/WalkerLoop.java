/**********************************************************************
*
* Programmer: Kenny Lepping
* javac WalkerLoop.java
* java RandomWalkers N 
*
* Calculates and prints what steps are taken and the squared distance 
*
***********************************************************************
*/

import java.lang.Math;

public class WalkerLoop {
	
	public static void Steps(int stepNum) {
	
		int x = 0; // Starting x position
		int y = 0; // Starting y position
		int step;
		
		for (step = 0; step < stepNum; step++) { // Repeat until walk stepNum steps 

			double r;  // Variable for generating random number

			r = Math.random();
			if (r <= 0.25) // 25% probability 
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