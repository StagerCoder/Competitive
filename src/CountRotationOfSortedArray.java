public class CountRotationOfSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 0, 1, 2, 3};
        System.out.println(countRotations(arr));
    }

    static int countRotations(int[] arr) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return arr.length;
        }
        return pivot + 1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] > arr[start]) {
                start = mid + 1;
            } else if (arr[mid] < arr[end]) {
                end = mid - 1;
            } else if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                if (arr[start] < arr[start + 1]) {
                    return start;
                } else {
                    start++;
                    end--;
                }
            } else if (arr[start] < arr[end]) {
                return end;
            }
        }
        return -1;
    }
}
