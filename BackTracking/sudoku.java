public class sudoku {
    public static boolean isSafe(int[][] sud, int row, int col, int num) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (sud[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (sud[i][col] == num) {
                return false;
            }
        }

        // Check 3×3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sud[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Backtracking function to solve Sudoku
    public static boolean solveSudoku(int[][] sud, int row, int col) {

        // If reached end of board, solution found
        if (row == 9) {
            return true;
        }

        // Move to next row
        if (col == 9) {
            return solveSudoku(sud, row + 1, 0);
        }

        // Skip already filled cells
        if (sud[row][col] != 0) {
            return solveSudoku(sud, row, col + 1);
        }

        // Try numbers 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(sud, row, col, num)) {
                sud[row][col] = num;

                if (solveSudoku(sud, row, col + 1)) {
                    return true;
                }

                // Backtrack
                sud[row][col] = 0;
            }
        }

        return false;
    }

    // Print Sudoku grid
    public static void printSudoku(int[][] sud) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sud[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] sudoku = {
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {4, 9, 0, 1, 5, 7, 0, 0, 2},
                {0, 0, 3, 0, 0, 4, 1, 9, 0},
                {1, 8, 5, 0, 6, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 6, 0},
                {9, 6, 0, 4, 0, 5, 3, 0, 0},
                {0, 3, 0, 0, 7, 2, 0, 0, 4},
                {0, 4, 9, 0, 3, 0, 0, 5, 7},
                {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if (solveSudoku(sudoku, 0, 0)) {
            System.out.println("Sudoku Solved Successfully:\n");
            printSudoku(sudoku);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
