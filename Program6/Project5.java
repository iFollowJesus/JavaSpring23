package chapter13GUI;

import java.io.*;
import java.util.*;

/* Cesar Reyna
 * COSC 2430
 * Mr. Steven Lariza
 * Programming Assignment 5
 * 02 April 2023
 * 
 * Write a program that checks a text for several formatting and punctuation matters. The
 * program asks for the names of both an input file and an output file. It then copies all the
 * text from the input file to the output file, but with the following two changes: (1) Any
 * string of two or more blank characters is replaced by a single blank; (2) all sentences start
 * with an uppercase letter. All sentences after the first one begin after either a period, a
 * question mark, or an exclamation mark that is followed by one or more whitespace
 * characters.
 * 
 * Program accepts file specified by path in variable fileName.
 * The program iterates through the .txt string by string using the default
 * " " delimeter. The program is looking for sentinels '.' or '!'
 * after locating a sentinel the program moves to the next line and capitalizes the first
 * letter of the first String in this new line.
 * *****BUG found 31 March 2023 6:06am when given a string with the sentinel value in the 
 * *****body of the string the program does not start a new line with the word after the 
 * *****sentinel
 * ---31 March bug fixed 1 April 2023 2:16pm
 * *****BUG found 1 April 2023 2:16 pm a word with a sentinel in it mysteriously isn't present
 * *****in the newout.txt file. 
 * --- 1 April bug fixed 1 April 2023 3:20pm 
 * --- source of the bug line 150 charArray[i] != '!' changed to == '!'. 
 * ****BUG 3 April 2023 4:20pm patched in ? as a sentence end, and output truncated letters after ?
 * ---3 April 2023 bug fixed 3 April 2023 4:50pm variable newLineCharArray was not being reset to 
 * ---null for each new loop iteration added line 91.
 */

public class Project5 {

	public static void main(String[] args) {
		Scanner inputStream;
		String fileName = "out.txt";
		String embededSentinelCase = null;
		char[] charArray;
		char[] newLineCharArray = null;
		boolean hasSentinel = false;
		boolean bugFlagMarch31 = false;
		boolean embededQuestionMark = false;
		int count2 = 0;
		int newLength = 0;
		int charArrayIndexExceptionalCase = 0;
		try {
			inputStream = new Scanner(new File(fileName));
			PrintWriter outputStream = null;
			outputStream = new PrintWriter(new FileOutputStream("newout.txt"));
			int count = 0;
			String line = inputStream.next();
			// System.out.println(line);
			while (line != null) {
				count++;
				++count2;
				// System.out.println("Line at start is "+ line);
				charArray = line.toCharArray();
				for (int i = 0; i < charArray.length; i++) {
					if (charArray[i] != '.' && charArray[i] != '!' && charArray[i]!='?') {
						// intentionally left blank before 31 March BUG detected
						// New code patched in 1 April 2023
						if (hasSentinel == true) {
							if (newLineCharArray == null) {
								newLength = charArray.length - i;
								newLineCharArray = new char[newLength];
							}

							if (i == charArray.length - 1) {
								charArrayIndexExceptionalCase = charArray.length - newLength;
								for (int x = 0; x < newLength; x++) {
									newLineCharArray[x] = charArray[charArrayIndexExceptionalCase + x];
								}
								charArrayIndexExceptionalCase = 0;
								bugFlagMarch31 = true;
							}

							if (newLineCharArray[0] != ' ')
								embededSentinelCase = new String(newLineCharArray);
						}
					} else {
						// Silently detects sentinel.
						// System.out.println(" Sentinel detected: ");
						if(charArray[i]=='?') {
							embededQuestionMark = true;
							hasSentinel = true;
						}else {
							hasSentinel = true;
						}
						
					}
				}
				newLineCharArray = null;
				/*
				 * if(hasSentinel == true && embededQuestionMark == true) { hasSentinel = false;
				 * bugFlagMarch31 = false; }
				 */
				
				//If else block one
				if (hasSentinel == false) {
					if (count2 == 1) {
						line = capitalize(line);
						outputStream.print(line);
					} else {
						// System.out.print(" " + line);
						outputStream.print(" " + line);
					}
				} else if (bugFlagMarch31 == false) {
					// System.out.println(" " + line);
					outputStream.println(" " + line);
					count2 = 0;
				} else if(embededQuestionMark == true && bugFlagMarch31 == false) {
					outputStream.print(" " + line);
					hasSentinel = false;
				}else if(embededQuestionMark == true) {
					outputStream.print(" " + line);
					hasSentinel = false;
				}else {
					line = trunkate(line);
					outputStream.println(" " + line);
				}
				//if else block 2
				if (hasSentinel == false) {
					if (inputStream.hasNext()) {
						if(embededQuestionMark == true){
							embededQuestionMark = false;
							bugFlagMarch31=false;
							line = inputStream.next();
						}
						else if (bugFlagMarch31 == true) {

						} else {
							line = inputStream.next();
					
						}

					} else {
						// outside loop terminator
						line = null;
					}
				} else {
					if (inputStream.hasNext() && embededSentinelCase == null) {
						line = inputStream.next();
						line = capitalize(line);
						hasSentinel = false;

					} else if (inputStream.hasNext() && embededSentinelCase != null) {
						line = embededSentinelCase;
						line = capitalize(line);
						embededSentinelCase = null;
						hasSentinel = false;
						bugFlagMarch31 = false;
						count2 = 0;
						embededQuestionMark = false;
					} else {
						line = null;
					}

				}
			}
			System.out.println(count + " lines written to newout.txt.");
			inputStream.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception thrown, please check filename and path.");
		}
	}

	public static String trunkate(String sentinelLine) {
		char[] charArray;
		char[] tempArray;
		int newLength = 0;
		charArray = sentinelLine.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != '.' && charArray[i] != '!' && charArray[i] != '?') {

			} else if (charArray[i] == '.' || charArray[i] == '!' || charArray[i] == '?') {
				newLength = charArray.length - (i + 1);
				newLength = charArray.length - newLength;
			}
		}
		tempArray = new char[newLength];
		for (int i = 0; i < newLength; i++) {
			tempArray[i] = charArray[i];
		}
		String temp = new String(tempArray);
		sentinelLine = temp;
		return sentinelLine;
	}

	public static String capitalize(String line) {
		char[] charArray = line.toCharArray();
		char capitalLetter = charArray[0];
		capitalLetter = Character.toUpperCase(capitalLetter);
		charArray[0] = capitalLetter;
		String temporary = new String(charArray);
		line = temporary;
		return line;

	}
}
