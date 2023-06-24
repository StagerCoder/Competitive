public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int[] nums2 = {3, 4, -1, 1};
        int[] nums3 = {7, 8, 9, 11, 12};
        int[] nums4 = {1, 2};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
        System.out.println(firstMissingPositive(nums4));
    }

    static int firstMissingPositive(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correct = nums[start] - 1;
            if (nums[start] > 0 && nums[start] < nums.length && nums[start] != nums[correct]) {
                swap(nums, start, correct);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
