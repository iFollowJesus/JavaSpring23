/*Cesar A Reyna
 * COSC 2430
 * Professor Steven Larizza
 * ProgrammingAssignment 3
 * 3/6/2023
 * 
 * -------------------------------------------------------------------------------------
 *Solve the following problem: 
 *
 *Define a class called TicTacToe. An object of type TicTacToe is a single game of tic-tac-
 *toe. Store the game board as a single two-dimensional array of base type char that has 
 *three rows and three columns. Include methods to add a move, to display the board, to 
 *tell whose turn it is (X or O), to tell whether there is a winner, to say who the winner is, 
 *and to reinitialize the game to the beginning. Write a main method for the class that will 
 *allow two players to enter their moves in turn at the same keyboard. 
 *
 *Add 5 comment lines (comment lines start with //) at the very top of your program with 
 *your name, your class and section, the project number, due date, and a short description 
 *of the program.
 *------------------------------------------------------------------------------------
 *------------------------------------------------------------------------------------
 * 
 * Program Description
 * 
 * The main method is coded to call methods from TicTacToe class as per the problem
 * description. The players are prompted to enter the letter of the corresponding board 
 * location in turn. The program could be more robust it was not tested for erroneous 
 * input, which would probably give some unexpected results. Overall the output is not 
 * bad aesthetically. I found that the assignment asked for a reset
 * method that seemed to go unused, so I utilized it to loop the game and continue playing 
 * if desired. 
 * 
 * 
 */


package project3pack;
import java.util.Scanner;

public class TicTacToeDemo {

	public static void main(String[] args) {
		//declare some useful variables
		int count = 0;
		char xo = 'O';
		boolean winner = false;
		char[][] gameBoard = new char[3][3];
		//create TicTacToe object
		TicTacToe a = new TicTacToe();
		System.out.println("New Game: X goes first. ");
		//Game Loop while winner = false
		while(winner == false)
		{
		gameBoard=a.getBoard();
		a.displayBoard(gameBoard);
		xo = a.tellTurn(xo);
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the letter where you want to place your marker: ");
		String b = s.next();
		char c = b.charAt(0);
		a.addAMove(c, xo);
		/*
		 * commented out repetitive code that didn't match assignment display
		 * gameBoard = a.getBoard(); a.displayBoard(gameBoard);
		 */
		winner = a.isWin();
		if(winner == true)
		{
			a.tellWinner(xo);
			gameBoard=a.getBoard();
			a.displayBoard(gameBoard);
			System.out.println("Game Over!");
			System.out.println("Do you want to play again y/n?");
			b=s.next();
			if(b.equalsIgnoreCase("y"))
					{
						a.reset();
						gameBoard=a.getBoard();
						System.out.println("New Game: X goes first. ");
						count=0;
						winner=false;
						if(xo == 'x' || xo == 'X')
							xo = 'O';
						else
							xo = 'X';
					}
			else
			break;
		}
		else
		{
			count++;
			if (count<8)
				count = count;
			else
			{
				System.out.println("Game Over!");
				System.out.println("Do you want to play again y/n?");
				b=s.next();
				if(b.equalsIgnoreCase("y"))
						{
							a.reset();
							gameBoard=a.getBoard();
							System.out.println("New Game: X goes first. ");
							count=0;
							winner=false;
							if(xo == 'x' || xo == 'X')
								xo = 'O';
							else
								xo = 'X';
						}
				else
				break;
			}
				
			
		}
		
		
			
		
		}
		
		
		
		
	

	}

}
