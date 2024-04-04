package java2Program4Arrow;
//a copy and paste from right arrow with minor adjustments for the special case of width 3, also it excludes
//handling of left arrows.
public class RightArrow extends ShapeBase implements ShapeInterface, ArrowInterface {
	// variable declaration
	private int tail;
	private int width;
	private char orientation;

	// constructors
	public RightArrow() {
		super();
		tail = 0;
		width = 0;
	}

	public RightArrow(int theOffset, int theTail, int theWidth, char theOrientation) {
		super(theOffset);
		tail = theTail;
		width = theWidth;
		orientation = theOrientation;
	}

	// methods
	@Override
	public void set(int newTail, int newWidth, char newOrientation) {
		tail = newTail;
		width = newWidth;
		orientation = newOrientation;
	}
	
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
			startOfLine = getOffset() + width / 2;
		}
		if (width == 3) {
			startOfLine = getOffset() + tail;
			skipSpaces(startOfLine);
			System.out.println('*');
			for (int i = 0; i < tail + 2; i++) {
				System.out.print('*');
			}
			System.out.println();
			skipSpaces(startOfLine);
			System.out.println('*');
		} else {
			int lineCount = width / 2 - 1;// height above base
			skipSpaces(startOfLine);
			System.out.println('*');// top '*'
			// insideWidth == number of spaces between the
			// two '*'s on a line.
			int insideWidth = 0;
			if (orientation == 'R') {
				for (int count = 0; count < lineCount; count++) {
					skipSpaces(startOfLine);
					System.out.print('*');
					skipSpaces(insideWidth);
					System.out.println('*');
					if (count + 1 == lineCount) {
						System.out.print('*');
						for (int i = 0; i < tail; i++) {
							System.out.print('*');
						}
						// System.out.print('*');
						skipSpaces(insideWidth + 1);
						System.out.print('*');
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
		int startOfLine = 0;
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
				if (count + 1 == lineCount) {
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
				if (count + 1 == lineCount) {
					skipSpaces(startOfLine + 1);
					System.out.println('*');
				}
				// Down one line, so the inside is 2 spaces wider.
				insideWidth--;
			}

		}

	}

}
