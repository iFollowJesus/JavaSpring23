/*
 * Cesar A Reyna
 * COSC 2430
 * Professor Steven Larizza
 * ProgrammingAssignment 2
 * --------------------------------------------------------------------
 * The program accepts a string input and then sorts it alphabetically
 * and displays the letters and their frequency.
 * --------------------------------------------------------------------
 */

package cosc2430;

import java.util.Scanner;

/**
 * @author cesar
 *
 */
public class Program2v3 {

	static int c2i(char a) 
	{
		int x = Character.getNumericValue(a) - 10;
		return x;
	}
	
	static char i2c(int x)
	{
		char a = (char) (x + 65);
		return a;
	}
	
	static void chknTrnk(String x) 
	{
		int i = 0;
		int k = x.length();
		// convert my stringy string into a character array so i can do things with it.
		char[] letterArray = x.toCharArray();
		// declare and initialize integer array for countifying
		int[] alphabetSoup = new int[26];
		// set soup to zeros check that we got what we think we got
		for (int j = 0; j < 26; j++)
			alphabetSoup[j] = 0;
		boolean doitdoit = true;
		while (doitdoit) {
			for(i = 0; i<k; i++)
			{
				if(letterArray[i] == '.')
				{
					System.out.println("Sentinel Value '.' detected truncating string. ");
					char[] letterArray2 = new char[i];
					for(int j=0; j<i; j++)
					{
						letterArray2[j]=letterArray[j];
					}
					/*
					 * for(char q: letterArray2) { System.out.print(q); } System.out.println(" ");
					 */
					i = k;
					doitdoit=false;
				}
				else if (letterArray[i]>='A' && letterArray[i]<='Z')
				{
					//add to count of each letter element.
					int zeta = c2i(letterArray[i]);
					alphabetSoup[zeta] = ++alphabetSoup[zeta];
				}
			}
		}
		
		//Trunkate alphabetSoup.
		int l,m,n;
		m = alphabetSoup.length;
		for(l =0; l<m; l++)
		{
			if(alphabetSoup[l] == 0)
			{
				int[] x2 = new int[l];
				for(n = 0; n<l; n++)
				{
					x2[n]=alphabetSoup[n];
				}
				l=m;
				System.out.println("String processed results are: ");
				for(int z=0; z<x2.length; z++)
				{
					System.out.print(x2[z] + " " + i2c(z));
					System.out.println(" ");
				}
			}
		}
	}

	/**
	 * 
	 */
	public Program2v3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean doitdoit = true;
		
		while(doitdoit)
		{
		// Easy does it get the string first!
		System.out.println("Please enter some text followed by a period then press enter. I'll sort your soup! ");
		String letters;
		Scanner scanString = new Scanner(System.in);
		letters = scanString.next();
		letters = letters.toUpperCase();
		chknTrnk(letters);
		
		System.out.println("To process another string enter y if done press any other key and press enter: ");
		letters = scanString.next();
		letters = letters.toUpperCase();
		int l = letters.length();
		char[] lA = new char[l];
		lA=letters.toCharArray();
		if (lA[0] == 'Y')
		{
			doitdoit=true;
		}
		else
		{
			doitdoit=false;
		}
		scanString.close();
		}
		
		

	}

}
