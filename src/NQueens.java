import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[5][5];
        List<List<String>> ans = placeNQueens(arr, 0);
        System.out.println(ans.size());
    }

    static List<List<String>> placeNQueens(boolean[][] arr, int row) {
        List<List<String>> queen = new ArrayList<>();
        if (row == arr.length) {
            queen.add(makeQueenArr(arr));
            displayArr(arr);
            System.out.println();
            return queen;
        }

        for (int col = 0; col < arr.length; col++) {
            if (isSafe(arr, row, col)) {
                arr[row][col] = true;
                queen.addAll(placeNQueens(arr, row + 1));
                arr[row][col] = false;
            }
        }
        return queen;
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

    private static List<String> makeQueenArr(boolean[][] arr) {
        List<String> ans = new ArrayList<>();
        for (boolean[] row : arr) {
            StringBuilder s = new StringBuilder();
            for (boolean element : row) {
                if (element) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            ans.add(s.toString());
        }
        return ans;
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
            if (arr[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }


}
