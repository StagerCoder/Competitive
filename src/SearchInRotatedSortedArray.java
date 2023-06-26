public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        System.out.println(search(arr, 5));
        System.out.println(search(arr, 7));
        System.out.println(searchWithRecursive(arr3, 2));
        System.out.println(searchWithRecursive(arr3, 34));
    }

    static public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target < nums[0]) {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, pivot);
        }
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            }
            if (nums[start] < nums[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int searchWithRecursive(int[] nums, int target) {
        int pivot = findPivotWithRecursive(nums, 0, nums.length - 1);
        if (pivot == -1) {
            return binarySearchWithRecursive(nums, target, 0, nums.length - 1);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target < nums[0]) {
            return binarySearchWithRecursive(nums, target, pivot + 1, nums.length - 1);
        } else {
            return binarySearchWithRecursive(nums, target, 0, pivot);
        }
    }

    static int findPivotWithRecursive(int[] arr, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (arr[start] > arr[mid]) {
            return findPivotWithRecursive(arr, start, mid - 1);
        } else if (arr[end] < arr[mid]) {
            return findPivotWithRecursive(arr, mid + 1, end);
        } else if (arr[start] == arr[end]) {
            if (arr[start] < arr[start + 1]) {
                return start;
            } else if (arr[start] > arr[start + 1]) {
                return findPivotWithRecursive(arr, start, mid - 1);
            } else {
                return findPivotWithRecursive(arr, start + 1, end - 1);
            }
        } else if (arr[start] < arr[end] && arr[end] > arr[end - 1]) {
            return end;

        }
        return -1;
    }

    static int binarySearchWithRecursive(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (start > end) {
            return -1;
        }
        if (arr[mid] > target) {
            return binarySearchWithRecursive(arr, target, start, mid - 1);
        } else {
            return binarySearchWithRecursive(arr, target, mid + 1, end);
        }

    }
}

