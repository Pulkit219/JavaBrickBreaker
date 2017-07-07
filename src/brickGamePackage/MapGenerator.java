package brickGamePackage;

public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	
	public MapGenerator(int row, int column)
	{
		map = new int[row][column];
	}
}
