/*
 * Cesar A Reyna
 * COSC 2430
 * Professor Steven Larizza
 * 
 * ProgrammingAssignment 1
 * 
 * Write a program that simulates a bouncing ball by computing its height in 
 * feet at each second as time passes on a simulated clock. At time zero, 
 * the ball begins at height zero and has an initial velocity supplied by 
 * the user. (An initial velocity of at least 100 feet per second is a good
 * choice.) After each second(--), change the height by adding the current 
 * velocity; then subtract 32 from velocity. If the new height is less than 
 * zero, multiply both the height and the velocity by -0.5 to simulate the 
 * bounce. Stop at the fifth bounce.
 * 
 * Pseudocode:
 * input = 100
 * output
 * time = 0
 * height = 0.0
 * system.out.println("Time: 0 Height: 0.0 ft.")
 * 0.0 double counts down by 32 updates height.... two variable height and new height
 * 0 integer variable counting up from zero until new height<0
 * print bounce
 * while height>0 bounce counter<5 start counter at 1
 * 
 * 
 * 
 * 
 */

package cosc2430;
import java.util.Scanner;

public class BouncingBall {

	public BouncingBall() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		System.out.println("Supply initial velocity recomended at least 100 feet per second.");
		double velocity = myObj.nextDouble();
		double height = 0.0;
		int count1 = 0, count2 = 0;
		boolean doitdoit = true;
		   //First try gets me output but no bounce.
			while (doitdoit == true)
			{
				System.out.println("Time: " + count1 +" Height: " + height+" ft.");
				height = height+velocity;
				velocity = velocity - 32;
				count1 ++;
				
				if (height <=0)
				{
					System.out.println("Bounce!");
					height=height*-0.5;
					velocity=velocity*-0.5;						
					count2 ++;
				}
				if (count2 >=5)
				{
					doitdoit=false;
					System.out.println("Press any key to end.");
				}
			}
			
			
		
		

	}

}
