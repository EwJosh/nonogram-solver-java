package nonogramSolver;

import java.util.ArrayList;

public class Nonogram
{
	public Nonogram(int width, int height, ArrayList<NonoKey> colKeysList, ArrayList<NonoKey> rowKeysList) {
		grid = new Tile[height][width];
		for(Tile[] row: grid) {
			for(Tile t: row) {
				t = Tile.BLANK;
			}
		}
		
		this.colKeysList = colKeysList;
		this.rowKeysList = rowKeysList;
	}
	
	private Tile[][] grid;
	private ArrayList<NonoKey> colKeysList;
	private ArrayList<NonoKey> rowKeysList;
}