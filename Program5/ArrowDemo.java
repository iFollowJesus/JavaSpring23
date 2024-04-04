package java2Program4Arrow;

import java.util.Scanner;

/* Cesar A Reyna
 * Mr. Steven Lariza
 * COSC 2430
 * Project 4
 * 25 March 2023
 * 
 * The program accepts user input and draws left or right facing arrows with asterisks.
 * much of the code was developed with the use of listings from Java: An Introduction to
 * Problem Solving & Programing Eighth edition Global edition.
 * ArrowDemo.Java was copied from listing 8.15 Tree Demo with the difference that this 
 * program accepts user inputs, and Tree Demo is hard-coded.
 * 
 */

public class ArrowDemo {

	public static void main(String[] args) {

		int tail = 0, base = 0, offset = 0;
		String inputString;
		char[] charachterArray;
		char orientation = 'a';
		boolean outsideFlag = true;
		while (outsideFlag) {
			boolean flag = true;
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter tail lenghth: ");
			tail = s.nextInt();
			while (flag) {
				System.out.println("Please enter base width: ");
				base = s.nextInt();
				if (base % 2 == 0 || base == 1) {
					System.out.println("You have entered an even number for the base. ");
					System.out.println("Only odd numbers are allowed for the base. ");
				} else
					flag = false;
			}
			flag = true;
			while (flag) {
				System.out.println("Left or Right facing arrow? L for left R for right: ");
				inputString = s.next();
				charachterArray = inputString.toCharArray();
				if (charachterArray[0] == 'l' || charachterArray[0] == 'L') {
					orientation = 'L';
					flag = false;
				} else if (charachterArray[0] == 'r' || charachterArray[0] == 'R') {
					orientation = 'R';
					flag = false;
				} else
					System.out.println("invalid input try again: " + inputString);
			}
			// Draw Arrow
			if (orientation == 'L')
				drawArrow(offset, tail, base, orientation);
			else
				drawArrowR(offset, tail, base, orientation);
			System.out.println("Do you want to continue drawing: 1 for yes 2 for no");
			tail = s.nextInt();
			if(tail == 2)
				outsideFlag=false;
		}
	}

	public static void drawArrow(int userOffset, int userTail, int userBase, char userOrientation) {
		System.out.print("Here is your arrow: ");
		ArrowInterface topHalf;
		topHalf = new LeftArrow(userOffset, userTail, userBase, userOrientation);
		drawTop(topHalf);
	}

	private static void drawTop(ArrowInterface topHalf) {
		topHalf.drawAt(1);
	}

	public static void drawArrowR(int userOffset, int userTail, int userBase, char userOrientation) {
		System.out.print("Here is your Arrow: ");
		ArrowInterface topHalf = new RightArrow(userOffset, userTail, userBase, userOrientation);
		drawTop(topHalf);
	}
}
