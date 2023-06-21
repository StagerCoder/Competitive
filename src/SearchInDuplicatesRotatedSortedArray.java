public class SearchInDuplicatesRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        System.out.println(search(arr, 1));
    }

    static boolean search(int[] nums, int target) {
        int ans = searchInRotatedArray(nums, target);
        if (ans == -1) {
            return false;
        }
        return true;
    }

    static int searchInRotatedArray(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[0] > target) {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        } else {
            return binarySearch(arr, target, 0, pivot);
        }
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

    static int binarySearch(int[] arr, int target, int start, int end) {
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
