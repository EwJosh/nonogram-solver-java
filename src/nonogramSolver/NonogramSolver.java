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
	
	public void testMethod() {
		this.nonogram.setTile(5, 0, Tile.FILL);
		this.nonogram.setTile(4, 0, Tile.FILL);
		this.nonogram.setTile(3, 0, Tile.FILL);
		
	}
	
	public String keysToString() {
		String keyString = "Column Keys:\n\t";
		for(NonoKey k: colKeysList) {
			keyString += "{";
			for(int i = 0; i < k.size(); i++) {
				keyString += k.get(i);
				if(i < k.size()-1)
					keyString += ", ";
			}
			keyString += "}";
		}
		keyString += "\nRow Keys:\n\t";
		for(NonoKey k: rowKeysList) {
			keyString += "{";
			for(int i = 0; i < k.size(); i++) {
				keyString += k.get(i);
				if(i < k.size()-1)
					keyString += ", ";
			}
			keyString += "}";
		}
		return keyString;
	}
	
	public void printNonogram() {
		System.out.println(this.nonogram);
	}
	
	public String getSolutionAsString() {
		this.solve();
		return nonogram.toString();
	}
	
	/**
	 * Returns true if all NonoKeys are marked as complete.
	 * @return true if all NonoKeys are marked as complete.
	 */
	private boolean isAllComplete() {
		for(NonoKey k: colKeysList)
			if(!k.isComplete())
				return false;
		for(NonoKey k: rowKeysList)
			if(!k.isComplete())
				return false;
		return true;
	}
	
	/**
	 * Generates a solution for the nonogram.
	 * The head method for processing the entire nonogram.
	 */
	private void solve() {
		int test = 0;
		while(!this.isAllComplete() && test < 1) {
			printNonogram();
			System.out.println("Solve turn: " + test);
//			this.processList(this.colKeysList, false);
			this.processList(this.rowKeysList, true);
			test++;
		}
	}
	
	/**
	 * Processes the key-list of rows/columns and fills or spaces the respective nonogram line as needed.
	 * The main logic of which method should be performed on the line.
	 *  
	 * @param keys Key-list of row/column keys
	 * @param isRow true if the given key-list is for rows, false if for columns
	 */
	private void processList(ArrayList<NonoKey> keys, boolean isRow) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i).isComplete()) {		//Skip line if key is marked as completed.
				System.out.println(isRow +""+ i + ": ISCOMPLETE");	//TESTING. DELETE LATER
				continue;
			}
			
			pour(keys.get(i), i, isRow);
			simpleFill(keys.get(i), i, isRow);
			simpleSpace(keys.get(i), i, isRow);
		}
	}
	
	/**
	 * Tries to pour the line with all spaces or all fills, if logic allows.
	 * 
	 * @param key
	 * @param index
	 * @param isRow
	 */
	private void pour(NonoKey key, int index, boolean isRow) {
		int length = nonogram.getLine(0, isRow).length;		// Length of the line (width or height for row or column, respectively).
		int keySum = key.getSum();							// Sum of values in the key.
		
		// If key is 0 or line of fills matches key, pour the rest with spaces and mark complete.
		if(keySum == 0 || keySum == nonogram.getTileTypeCount(index, isRow, Tile.FILL)) {
			System.out.println(isRow +""+ index + ": SPACE POUR");	//TESTING. DELETE LATER
			nonogram.pour(index, isRow, Tile.SPACE);
			key.complete();
		}
		// If key equals line length or line of blanks matches the i0nverse of key, pour the rest with fills and mark complete.
		else if(keySum == length || (length - keySum) == nonogram.getTileTypeCount(index, isRow, Tile.SPACE)) {
			System.out.println(isRow +""+ index + ": FILL POUR");	//TESTING. DELETE LATER
			nonogram.pour(index, isRow, Tile.FILL);
			key.complete();
		}
	}
	
	/**
	 * Fills the middle of the blanks
	 * 
	 * @param key
	 * @param index
	 * @param isRow
	 */
	private void simpleFill(NonoKey key, int index, boolean isRow) {
		int length = nonogram.getLine(0, isRow).length;
		int keySum = key.getSum();
		
		if(keySum > length/2 && key.size() == 1)
			for(int i = length - 1 - keySum; i <= keySum; i++) {
				if(isRow)
					nonogram.setTile(i, index, Tile.FILL);
				else
					nonogram.setTile(index, i, Tile.FILL);
			}
	}
	
	/**
	 * Spaces the edges of the blanks if the fills cannot reach.
	 * 
	 * @param key
	 * @param index
	 * @param isRow
	 */
	private void simpleSpace(NonoKey key, int index, boolean isRow) {
		int length = nonogram.getLine(0, isRow).length;
		int keySum = key.getSum();
		
		// Left/Up check
		// Right/Down check
	}
	
	private ArrayList<NonoKey> colKeysList;
	private ArrayList<NonoKey> rowKeysList;
	private Nonogram nonogram;
}