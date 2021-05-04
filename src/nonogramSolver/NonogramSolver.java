package nonogramSolver;

import java.util.ArrayList;

/**
 * TEMP: list of solution methods
 * 
 * Simple Fills:	Fill any tiles where all extremes will overlap.
 * Simple Spaces:	Space any tiles where all extremes cannot reach.
 * Forcing:	Space any tiles where a section cannot fit. (More specific Simple Spaces)
 * Glue:	Filling tiles where pushing a section that starts near or against a block/wall will always overlap. (More specific simple fills)
 * Joining and splitting:	Check to see whether a section can or cannot be placed given the current fills.
 * Punctuate:		Enclose each section with a space
 * 
 * @author Edward Josh Hermano
 */
public class NonogramSolver
{
	public NonogramSolver(ArrayList<NonoKey> colKeysList, ArrayList<NonoKey> rowKeysList) {
		this.colKeysList = colKeysList;
		this.rowKeysList = rowKeysList;
		
		this.nonogram = new Nonogram(colKeysList.size(), rowKeysList.size());
	}
	
	
	public String getSolutionAsString() {
		this.solve();
		int height = nonogram.getHeight();
		int width = nonogram.getWidth();
		
		return nonogram.toString();
	}
	
	private void solve() {
		int test = 0;
		while(!nonogram.isCompleted() && test < 1) {
			System.out.println("solve " + test);
			this.processList(this.colKeysList, false);
			this.processList(this.rowKeysList, true);
			test++;
		}
	}
	
	private void processList(ArrayList<NonoKey> keys, boolean isRow) {
		for(int i = 0; i < keys.size(); i++) {
			simpleFill(nonogram.getLine(i, isRow), keys.get(i));
		}
	}
	
	private void simpleFill(Tile[] tiles, NonoKey key) {
		if(key.get(0)==0)
			nonogram.pour(i, Tile.SPACE);
		else if(keys.get(i).get(0)==nonogram.getWidth() && isRow ||
				keys.get(i).get(0)==nonogram.getHeight() && !isRow)
			nonogram.pour(i, Tile.FILL, isRow);
	}
	
	private ArrayList<NonoKey> colKeysList;
	private ArrayList<NonoKey> rowKeysList;
	private Nonogram nonogram;
}