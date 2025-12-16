// time complexity is n!

public class nqueens {
    public static boolean isSafe(int[][] board, int r, int c) {
        for (int i = r; i >= 0; i--) {
            if (board[i][c] == 1) {
                return false;
            }
        }

        int row = r, col = c;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = r;
        col = c;
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }

        return true;
    }

    public static boolean queen(int[][] board, int n, int q) {
        if (q == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (isSafe(board, q, i)) {
                board[q][i] = 1;
                if(queen(board, n, q + 1)){
                    flag = true;
                    return true;
                }
                board[q][i] = 0;
            }
        }

        return true && flag;
    }

    public static void main(String[] args) {
        int n = 4;
        int board[][] = new int[4][4];
        int test[][] = new int[4][4];

        queen(board, n, 0);
        return;
    }
}
