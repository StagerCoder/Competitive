public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        int[] descArr = {9, 8, 6, 4, 2, 1};
        int[] ascArr = {1, 4, 5, 7, 9};
        System.out.println(orderAgnosticBinarySearch(descArr, 1));
        System.out.println(orderAgnosticBinarySearch(ascArr, 7));
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean des = (arr[start] > arr[end]);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (des && arr[mid] > target || arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
