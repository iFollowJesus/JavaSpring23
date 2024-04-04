package project3pack;

public class TicTacToe 
{
	private char[][] newBoard = new char[3][3];
	private char[] b = "abcdefghi".toCharArray();
	private int count = 0;
	private int k;
	private boolean winner;
	
	public TicTacToe()
	{
		count=0;
		for(int i =0; i<newBoard.length; i++)
			for(int j=0; j<newBoard[i].length; j++)
			{
				newBoard[i][j] = b[count];
				count++;
			}
				
		
	}
	public char[][] getBoard()
	{
		return newBoard;
	}
	public void addAMove(char a, char xo)
	{
		for(k = 0; k<b.length; k++)
			if (a == b[k])
				for(int i=0; i<newBoard.length; i++)
					for(int j = 0; j<newBoard[i].length; j++)
					{
						if (b[k] == newBoard[i][j])
							newBoard[i][j] = xo;
					}
	}
	public void displayBoard(char [][] anArray)
	{
		for (int row = 0; row < anArray.length; row++)
		 {
		 for (int column = 0; column < anArray[row].length; column++)
		 System.out.print(anArray[row][column] + " | ");
		 System.out.println();
		 System.out.println("--+---+----");
		 }
	}
	public char tellTurn(char xo)
	{
		if (xo == 'x' || xo == 'X')
		{
			System.out.println("O's turn");
			xo = 'O';
			return xo;
		}
		else 
		{
			System.out.println("X's turn");
			xo = 'X';
			return xo;
		}
	}
	public boolean isWin()
	{
		//check rows for win
		for(int i = 0; i<newBoard.length; i++)
		{
			if(newBoard[i][0]==newBoard[i][1]&&newBoard[i][1]==newBoard[i][2])
			{
				winner = true;
				return winner;
			}
			else
				winner = false;
		}
		//check columns for win
		for(int i = 0; i<newBoard.length; i++)
		{
			if(newBoard[0][i]==newBoard[1][i]&&newBoard[1][i]==newBoard[2][i])
			{
				winner = true;
				return winner;
			}
			else
				winner = false;
		}
		//check diagonal for win
		if(newBoard[0][0]==newBoard[1][1]&&newBoard[1][1]==newBoard[2][2])
		{
			winner = true;
			return winner;
		}
		else
			winner = false;
		//check diagonal for win
		if(newBoard[2][0]==newBoard[1][1]&&newBoard[1][1]==newBoard[0][2])
		{
			winner = true;
			return winner;
		}
		else
			winner = false;
		
		return winner;
					

	}
	public void tellWinner(char xo)
	{
		if (xo == 'x' || xo == 'X')
			System.out.println("X is the winner!!");
		else
			System.out.println("O is the winner!!");
	}
	public void reset()
	{
		count=0;
		for(int i =0; i<newBoard.length; i++)
			for(int j=0; j<newBoard[i].length; j++)
			{
				newBoard[i][j] = b[count];
				count++;
			}
	}
}