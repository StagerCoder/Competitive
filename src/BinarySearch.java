public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 6, 7, 8, 9};
        System.out.println("Index of Element: " + binarySearch(arr, 5));
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}