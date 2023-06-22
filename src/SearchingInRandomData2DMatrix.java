import java.util.Arrays;

//Use if there is no pattern bcse its the slowest algo of matrix
public class SearchingInRandomData2DMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {18, 2, 3},
                {4, 52, 6},
                {7, 81, 9}
        };
        System.out.println(Arrays.toString(search2DArray(arr, 9)));
    }

    static int[] search2DArray(int[][] arr, int target) {
        int n = arr.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
