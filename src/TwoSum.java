import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        int[] nums2 = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums2, 6)));
        int[] nums3 = {3, 3};
        System.out.println(Arrays.toString(twoSum(nums3, 6)));
        int[] num4 = {0, 0};
        System.out.println(Arrays.toString(twoSum(num4, 1)));
    }

    //From Brute Force
    static int[] twoSum(int[] nums, int target) {
        int index = 0;
        int index2 = 1;
        int[] ans = {0, 0};
        while (index < nums.length) {
            if (index2 < nums.length && nums[index] + nums[index2] == target) {
                ans[0] = index;
                ans[1] = index2;
                return ans;
            } else if (index2 >= nums.length) {
                index = index + 1;
                index2 = index + 1;
            } else {
                index2 = index2 + 1;
            }
        }
        if (ans[0] == 0 && ans[1] == 0) {
            return new int[]{-1, -1};
        }
        return ans;
    }
}
