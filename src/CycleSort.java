import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 0, 2};
        System.out.println(Arrays.toString(cycleSort(arr)));
    }

    static int[] cycleSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int correctPosition = arr[start];
            if (start != correctPosition) {
                swap(arr, start, correctPosition);
            } else {
                start++;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
