public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int[] arr3 = {11, 13, 15, 17};
        System.out.println(findMin(arr));
        System.out.println(findMin(arr2));
        System.out.println(findMin(arr3));
    }

    static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        System.out.println("pivot: " + pivot);
        return nums[pivot + 1];
    }

    static  int findPivot(int[] arr) {
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
