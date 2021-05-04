package nonogramSolver;

import java.util.ArrayList;

//	00000
//	01110
//	11111
//	10010
//	01100
//	10111
public class NonogramSolverTester
{
	private static final int[][] COL_KEYS =
		{
			{2,1},
			{2,1},
			{2,2},
			{4},
			{1,1},
		};
	
	private static final int[][] ROW_KEYS =
		{
			{0},
			{2},
			{5},
			{1,1},
			{3},
			{1,3}
		};
	
	public static void main(String[] args) {
		System.out.println("Start");
		NonogramSolverTester tester = new NonogramSolverTester();
		NonogramSolver solver = new NonogramSolver(tester.getColKeys(),tester.getRowKeys());
		System.out.println(solver.getSolutionAsString());
	}
	
	/**
	 * Gets the keys for the columns of the nonogram.
	 * Keys are organized left-to-right, values in the keys are organized top-to-bottom.
	 * 
	 * @return
	 */
	private ArrayList<NonoKey> getColKeys() {
		ArrayList<NonoKey> colKeyList = new ArrayList<>();
		for(int[] c: COL_KEYS)
		{
			NonoKey key = new NonoKey(c);
			colKeyList.add(key);
		}
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
		for(int[] r: ROW_KEYS)
		{
			NonoKey key = new NonoKey(r);
			rowKeyList.add(key);
		}
		return rowKeyList;
	}
}
