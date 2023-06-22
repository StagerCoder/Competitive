public class SearchingInAscOrder2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int[][] matrix2 = {
                {1, 1}
        };
        System.out.println(searchMatrix(matrix, 23));
        System.out.println(searchMatrix(matrix2, 1));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        //if matrix has only one element
        if (matrix != null && matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }
        int row = 0;
        int col = 0;
        try {
            col = matrix[1].length - 1;
        } catch (Exception e) {
            return binarySearch(matrix, target, row, matrix[0].length-1);
        }
        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else {
                return binarySearch(matrix, target, row, col);
            }
        }
        return false;
    }

    static boolean binarySearch(int[][] matrix, int target, int row, int end) {
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
