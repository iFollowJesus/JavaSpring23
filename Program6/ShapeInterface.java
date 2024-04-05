package java2Program4Arrow;
//ShapeInterface was copied from listing 8.10 as the basic components to draw any shape.
public interface ShapeInterface
{
 /**
 Sets the offset for the shape.
 */
 public void setOffset(int newOffset);
 /**
 Returns the offset for the shape.
 */
 public int getOffset();
 /**
 Draws the shape at lineNumber lines down
 from the current line.
 */
 public void drawAt(int lineNumber);
 /**
 Draws the shape at the current line.
 */
 public void drawHere();
}