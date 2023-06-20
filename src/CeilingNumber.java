public class CeilingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7};
        System.out.println(ceilingNumber(arr, 5));
    }

    static int ceilingNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean desc = arr[start] > arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (desc && arr[mid] > target || arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // dont get confuse its an index of element
        return start;
    }

}
