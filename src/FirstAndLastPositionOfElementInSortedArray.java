import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums3 = {};
        //example 1
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        //example 2
        System.out.println(Arrays.toString(searchRange(nums, 6)));
        //example 3
        System.out.println(Arrays.toString(searchRange(nums3, 0)));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        range[0] = search(nums, target, true);
        range[1] = search(nums, target, false);
        return range;
    }

    static int search(int[] arr, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

}
