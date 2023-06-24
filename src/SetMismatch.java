import java.util.Arrays;

public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] nums2 = {};
        System.out.println(Arrays.toString(findErrorNums(nums)));
        System.out.println(Arrays.toString(findErrorNums(nums2)));
    }

    static int[] findErrorNums(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correct = nums[start] - 1;
            if (nums[start] != nums[correct]) {
                swap(nums, start, correct);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{};
    }

    static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
