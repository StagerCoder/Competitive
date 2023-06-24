import java.util.Arrays;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate(nums2));
    }

    static int findDuplicate(int[] nums) {
        int start = 0;
        while (start <= nums.length - 1) {
            if (nums[start] == nums[nums[start] - 1]) {
                start++;
            } else if (start != nums[start] - 1) {
                swap(nums, start, nums[start] - 1);
            } else {
                start++;
            }
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            if (i != nums[i] - 1) {
                return nums[i];
            }
        }
        return 0;
    }

    static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
