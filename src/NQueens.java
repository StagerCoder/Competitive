public class NQueens {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[5][5];
        System.out.println(placeNQueens(arr, 0));
    }

    static int placeNQueens(boolean[][] arr, int row) {
        if (row == arr.length) {
            displayArr(arr);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < arr[0].length; col++) {
            if (isSafe(arr, row, col)) {
                arr[row][col] = true;
                count += placeNQueens(arr, row + 1);
                arr[row][col] = false;
            }
        }
        return count;
    }

    private static void displayArr(boolean[][] arr) {
        for (boolean[] row : arr) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] arr, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i][col]) {
                return false;
            }

        }
        //Left D
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (arr[row - i][col - i]) {
                return false;
            }
        }
        int maxRight = Math.min(row, arr.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (arr[row - 1][col + 1]) {
                return false;
            }
        }
        return true;
    }


}
