package java2Program4Arrow;
/*Left arrow is a conglomerate of Listing 8.13 Rectangle on page 708
 * and of Listing 8.14 Triangle Class on page 710
 * the method for drawing a shape is largely intact with two major differences. 1. that 
 * when the drawTop method is called it in turn calls the drawBottom method so the
 * whole arrow can be drawn by calling one method drawTop. 2. the algorithm for the shape needed to be changed.
 * All of the methods are tested by calling drawTop except for drawHere() which is intended to put a 
 * line of asterisks down the center of where the shape should be drawn.
 * 
 * special case 3 width
 * 1*
 * **tail
 * 1*
 * 
 * for right arrow
 * 12345*
 * *******tail+2
 * 12345*     
 */

public class LeftArrow extends ShapeBase implements ShapeInterface,ArrowInterface {
	private int tail;
	private int width;
	private char orientation;

	// constructors
	public LeftArrow() {
		super();
		tail = 0;
		width = 0;
	}

	public LeftArrow(int theOffset, int theTail, int theWidth, char theOrientation) {
		super(theOffset);
		tail = theTail;
		width = theWidth;
		orientation = theOrientation;
	}

	// methods
	public void set(int newTail, int newWidth, char newOrientation) {
		tail = newTail;
		width = newWidth;
		orientation = newOrientation;
	}

	/*
	 * Algorithm
	 * 
	 * 0 12345*
	 * 1 1234**
	 * 2 123*1*
	 * 3 12*12*
	 * 4 1TAIL TIME
	 */
	public void drawHere() {
		drawTop();
		//drawBottom();
	}
	private void drawTop() {
		// startOfLine == number of spaces to the
		// first '*' on a line. Initially set to the
		// number of spaces before the topmost '*'.
		int startOfLine = 0;
		if (orientation == 'R') {
			startOfLine = getOffset() + tail;
		} else {
			startOfLine = getOffset()+width/2;
		}
		int lineCount = width / 2 - 1;// height above base
		// insideWidth == number of spaces between the
		// two '*'s on a line.
		int insideWidth = 0;
		if(width==3) {
			startOfLine = getOffset() + 1;
			skipSpaces(startOfLine);
			System.out.println('*');
			for(int i=0; i<tail+2;i++) {
				System.out.print('*');
			}
			System.out.println();
			skipSpaces(1);
			System.out.println('*');
		}
		else {
			skipSpaces(startOfLine);
			System.out.println('*');// top '*'
		if (orientation == 'R') {
			for (int count = 0; count < lineCount; count++) {
				skipSpaces(startOfLine);
				System.out.print('*');
				skipSpaces(insideWidth);
				System.out.println('*');
				if(count+1 == lineCount) {
					System.out.print('*');
					for(int i =0; i<tail; i++) {
						System.out.print('*');
					}
					//System.out.print('*');
					skipSpaces(insideWidth+1);
					System.out.print('*');
					System.out.println();
					drawBottom(insideWidth);
				}
				// Down one line, so the inside is 2 spaces wider.
				insideWidth++;
			}
		} else {
			for (int count = 0; count < lineCount; count++) {
				// Down one line, so the first '*' is one more
				// space to the left.
				startOfLine--;
				skipSpaces(startOfLine);
				System.out.print('*');
				skipSpaces(insideWidth);
				System.out.println('*');
				if(count+1 == lineCount) {
					System.out.print('*');
					skipSpaces(insideWidth+1);
					System.out.print('*');
					for(int i =0; i<tail; i++) {
						System.out.print('*');
					}
					System.out.println();
					drawBottom(insideWidth);
				}
				// Down one line, so the inside is 2 spaces wider.
				insideWidth++;
			}

		}
	}

	}
	
	private void drawBottom(int insideWidth) {
		int startOfLine=0;
		if (orientation == 'R') {
			startOfLine = getOffset() + tail;
		} else {
			startOfLine = getOffset();
		}
		int lineCount = width / 2 - 1;// depth below base
		// insideWidth == number of spaces between the
		// two '*'s on a line.
		if (orientation == 'R') {
			for (int count = 0; count < lineCount; count++) {
				skipSpaces(startOfLine);
				System.out.print('*');
				skipSpaces(insideWidth);
				System.out.println('*');
				if(count+1 == lineCount) {
					skipSpaces(startOfLine);
					System.out.print('*');
					System.out.println();
				}
				// Down one line, so the inside is 2 spaces wider.
				insideWidth--;
			}
		} else {
			for (int count = 0; count < lineCount; count++) {
				// Down one line, so the first '*' is one more
				// space to the right.
				startOfLine++;
				skipSpaces(startOfLine);
				System.out.print('*');
				skipSpaces(insideWidth);
				System.out.println('*');
				if(count+1 == lineCount) {
					skipSpaces(startOfLine+1);
					System.out.println('*');
				}
				// Down one line, so the inside is 2 spaces wider.
				insideWidth--;
			}

		}
		
	}

	/*
	 * private void skipSpaces(int number) { for (int count = 0; count < number;
	 * count++) System.out.print(' '); }
	 */

}
