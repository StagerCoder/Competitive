public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
    }

    static void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }
        if (emptyLeft) {
            displayArr(board);
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            char val = Integer.toString(i).charAt(0);
            if (isValidPlace(board, row, col, val)) {
                board[row][col] = val;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    static boolean isValidPlace(char[][] board, int row, int col, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
            if (board[row][i] == value) {
                return false;
            }
        }
        int sqrt = (int) (Math.sqrt(board.length));
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;
        for (int r = rStart; r < rStart + sqrt; r++) {
            for (int c = cStart; c < cStart + sqrt; c++) {
                if (board[r][c] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayArr(char[][] arr) {
        for (char[] row : arr) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
