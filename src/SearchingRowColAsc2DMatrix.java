import java.util.Arrays;

public class SearchingRowColAsc2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 27, 38, 49},
                {33, 34, 39, 50}
        };
        System.out.println(Arrays.toString(search(matrix, 34)));
    }

    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
