package java2Program4Arrow;
//this interface was copied from Listing 8.11 on page 677 it is renamed as
//RightArrow and the parameters are changed from (int,int) to (int,int,char)
public interface ArrowInterface extends ShapeInterface {
	/**
	 Sets the arrows dimensions and orientation.
	 */
	void set(int newTail, int newWidth, char newOrientation);

}
