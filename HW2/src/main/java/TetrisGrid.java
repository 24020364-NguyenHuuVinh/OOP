//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

    private boolean[][] grid;
    private int width;
    private int height;

    /**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
        this.width = grid.length;
        if (this.width > 0) {
            this.height = grid[0].length;
        } else {
            this.height = 0;
        }
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
        if (width < 1 || height < 1) {
            return;
        }
        boolean[][] newGird = new boolean[width][height];
        int targetCol = 0;
        for (int j = 0; j < height; j++) {
            boolean check = false;
            for (int i = 0; i < width; i++) {
                if (!grid[i][j]) {
                    check = true;
                    break;
                }
            }
            if (check) {
                for (int i = 0; i < width; i++) {
                    newGird[i][targetCol] = grid[i][j];
                }
                targetCol++;
            }
        }
        this.grid = newGird;
    }
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
