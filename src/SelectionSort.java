import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1 - i; j > 0; j--) {
                int largestNumber = largestNumberIndex(arr, arr.length - 1 - j);
                swap(arr, j, largestNumber);
            }
        }
        return arr;
    }

    static int largestNumberIndex(int[] arr, int j) {
        int max = 0;
        for (int i = 0; i < arr.length - j; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
