package nonogramSolver;

public class Nonogram
{
	public Nonogram(int width, int height)
	{
		this.grid = new Tile[height][width];
		for(Tile[] row: this.grid) {
			for(Tile t: row) {
				t = Tile.BLANK;
			}
		}
		completion = 0;
	}
	
	public int getWidth() {
		return this.grid[0].length;
	}
	
	public int getHeight() {
		return this.grid.length;
	}
	
	public boolean isCompleted() {
		return completion >= this.getWidth() * getHeight();
	}
	
	public Tile getTile(int x, int y) {
		return this.grid[y][x];
	}
	
	public Tile[] getRow(int index) {
		return grid[index];
	}
	
	public Tile[] getCol(int index) {
		int height = this.getHeight();
		Tile[] col = new Tile[height];
		for(int j = 0; j < height; j++)
			col[j] = grid[j][index];
		return col;
	}
	
	public Tile[] getLine(int index, boolean isRow) {
		if(isRow)
			return this.getRow(index);
		else
			return this.getCol(index);
	}
	
	/**
	 * Replace all BLANK tiles in the indexed row/column with the specified tile type.
	 * 
	 * @param index The index of the row/column to pour.
	 * @param tileType The type of Tile to pour into the row/column. Either Tile.FILLED or Tile.BLOCKED.
	 * @param isRow true if pouring over a row, false if pouring over a column.
	 */
	public void pour(int index, Tile tileType, boolean isRow) {
		int width = this.getWidth();
		int height = this.getHeight();
		if(isRow) {
			for(int i = 0; i < width; i++) {
				this.grid[index][i] = tileType;
			}
		}
		else {
			for(int j = 0; j < height; j++) {
				this.grid[j][index] = tileType;
			}
		}
	}
	
	@Override
	public String toString()
	{
		String solution = new String();
		for(int j = 0; j < this.getHeight(); j++) {
			for(int i = 0; i < this.getWidth(); i++) {
				if(this.getTile(i, j)==Tile.FILL)
					solution += "1 ";
				else if(this.getTile(i, j)==Tile.SPACE)
					solution += "0 ";
				else if(this.getTile(i, j)==Tile.BLANK)
					solution += "x ";
				else
					solution += "n ";					
			}
			solution += "\n";
		}
		return solution;
	}
	
	private Tile[][] grid;
	private int completion;
}
