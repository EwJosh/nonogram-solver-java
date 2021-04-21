package nonogramSolver;

import java.util.ArrayList;

//	00000
//	01110
//	11111
//	10010
//	01100
public class NonogramSolver
{
	private static final int[][] COL_KEYS =
		{
			{2},
			{2,1},
			{2,1},
			{3},
			{1},
		};
	
	private static final int[][] ROW_KEYS =
		{
			{2},
			{2,1},
			{2,1},
			{3},
			{1},
		};
	
	public static void main(String[] args) {
		NonogramSolver solver = new NonogramSolver();
		Nonogram test = new Nonogram(NonogramSolver.WIDTH,NonogramSolver.HEIGHT,solver.getColKeys(),solver.getRowKeys());
	}
	
	/**
	 * Gets the keys for the columns of the nonogram.
	 * Keys are organized left-to-right, values in the keys are organized top-to-bottom.
	 * 
	 * @return
	 */
	private ArrayList<NonoKey> getColKeys() {
		ArrayList<NonoKey> colKeyList = new ArrayList<>();
		ArrayList<Integer> colA = new ArrayList<>(2);
		ArrayList<Integer> colB = new ArrayList<>(2);
		ArrayList<Integer> colC = new ArrayList<>(2);
		ArrayList<Integer> colD = new ArrayList<>(2);
		ArrayList<Integer> colE = new ArrayList<>(2);
		return colKeyList;
	}
	
	/**
	 * Gets the keys for the row of the nonogram.
	 * Keys are organized top-to-bottom, values in the keys are organized left-to-right.
	 * 
	 * @return
	 */
	private ArrayList<NonoKey> getRowKeys() {
		ArrayList<NonoKey> rowKeyList = new ArrayList<>();
		return rowKeyList;
	}
	
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
}
