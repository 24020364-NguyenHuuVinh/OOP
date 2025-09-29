// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
        int minRow = grid.length;
        int maxRow = -1;
        int minCol = grid[0].length;
        int maxCol = -1;
        boolean found = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ch) {
                    found = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        if (!found) {
            return 0;
        }
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
		return height * width;
	}

    /**
     *
     * @param startR tam row.
     * @param startC tam col.
     * @param dx dx cot.
     * @param dy dy cot.
     * @param target char tam.
     * @return  len nhanh(ca tam).
     */
    private int getLength(int startR, int startC, int dx, int dy, char target) {
        int length = 0;
        int i = startR;
        int j = startC;
        int row = grid.length;
        int col = grid[0].length;
        while (i >= 0 && i < row && j >= 0 && j < col) {
            if (grid[i][j] == target) {
                length++;
                i += dx;
                j += dy;
            } else {
                break;
            }
        }
        return length;
    }
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
        if (grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                char ch = grid[i][j];

                int upLen = getLength(i, j, -1, 0, ch);
                int downLen = getLength(i, j, 1, 0, ch);
                int leftLen = getLength(i, j, 0, -1, ch);
                int rightLen = getLength(i, j, 0, 1, ch);

                if (upLen >= 2 && downLen >= 2 && leftLen >= 2 && rightLen >= 2) {
                    if (upLen == downLen && leftLen == rightLen) {
                        count++;
                    }
                }
            }
        }
		return count;
	}
	
}
