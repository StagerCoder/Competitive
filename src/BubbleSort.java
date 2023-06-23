import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                    swapped = true;
                }
            }
            if (!swapped) {
                return arr;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int j) {
        int temp = arr[j + 1];
        arr[j + 1] = arr[j];
        arr[j] = temp;
    }
}
