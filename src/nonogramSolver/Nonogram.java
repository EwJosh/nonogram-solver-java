package nonogramSolver;

public class Nonogram
{
	public Nonogram(int width, int height)
	{
		this.grid = new Tile[height][width];
//		for(Tile[] row: this.grid) {
//			for(Tile t: row) {
//				t = Tile.BLANK;
//			}
//		}
		for(int j = 0; j < this.getHeight(); j++) {
			for(int i = 0; i < this.getWidth(); i++) {
				grid[j][i] = Tile.BLANK;
			}
		}
//		completion = 0;
	}
	
	public int getWidth() {
		return this.grid[0].length;
	}
	
	public int getHeight() {
		return this.grid.length;
	}
	
//	public boolean isCompleted() {
//		return completion >= this.getWidth() * getHeight();
//	}
	
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
	 * Gets the amount of the specified tile type in the given line.
	 * 
	 * @param index The index of the row/column to search
	 * @param isRow true if searching a row, false if searching a column.
	 * @param tileType The type of Tile to count. e.g. Tile.FILL, Tile.SPACE
	 * @return the amount of the specified tile type in the given line
	 */
	public int getTileTypeCount(int index, boolean isRow, Tile tileType) {
		int count = 0;
		if(isRow) {
			int width = this.getWidth();
			for(int i = 0; i < width; i++) {
				if(this.grid[index][i] == tileType)
					count++;
			}
		}
		else {
			int height = this.getHeight();
			for(int j = 0; j < height; j++) {
				if(this.grid[j][index] == tileType)
					count++;
			}
		}
		return count;
	}
	
	public boolean setTile(int x, int y, Tile tileType) {
		if(this.getTile(x, y) == Tile.BLANK) {
			grid[y][x]= tileType;
			return true;
		}
		return false;
	}
	
	/**
	 * Replace all BLANK tiles in the indexed row/column with the specified tile type.
	 * 
	 * @param index The index of the row/column to pour.
	 * @param isRow true if pouring over a row, false if pouring over a column.
	 * @param tileType The type of Tile to pour into the row/column. e.g. Tile.FILL, Tile.SPACE.
	 */
	public void pour(int index, boolean isRow, Tile tileType) {
		if(isRow) {
			int width = this.getWidth();
			for(int i = 0; i < width; i++) {
				if(this.grid[index][i] == Tile.BLANK)
					this.grid[index][i] = tileType;
			}
		}
		else {
			int height = this.getHeight();
			for(int j = 0; j < height; j++) {
				if(this.grid[j][index] == Tile.BLANK)
					this.grid[j][index] = tileType;
			}
		}
	}
	
	public void simpleFill() {
		
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
					solution += "e ";					
			}
			solution += "\n";
		}
		return solution;
	}
	
	private Tile[][] grid;
//	private int completion;
}
