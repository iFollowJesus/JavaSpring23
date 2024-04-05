package java2Program4Arrow;

//This base class was copied from listing 8.12 on page 668 and renamed to ShapeBase
public abstract class ShapeBase implements ShapeInterface {
	private int offset;
	public ShapeBase() {
		offset = 0;
	}
	
	public ShapeBase(int theOffset) {
		offset = theOffset;
	}
	
	public void setOffset(int newOffset) {
		offset = newOffset;
	}

	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return offset;
	}

	@Override
	public void drawAt(int lineNumber) {
		// TODO Auto-generated method stub
		for(int count =0; count < lineNumber; count++)
			System.out.println();
		drawHere();

	}
	
	public void skipSpaces(int number) {
		for (int count = 0; count < number; count++)
			System.out.print(' ');
	}

	@Override
	public void drawHere() {
		// TODO Auto-generated method stub
		for (int count = 0; count < offset; count++)
			 System.out.print(' '); 
			 System.out.println('*');
	}

}
