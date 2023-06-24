import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = {1, 1, 2};
        int[] nums3 = {1};
        int[] nums4 = new int[0];
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicates(nums2));
        System.out.println(findDuplicates(nums3));
        System.out.println(findDuplicates(nums4));
    }

    static List<Integer> findDuplicates(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correct = nums[start] - 1;
            if (nums[start] != nums[correct]) {
                swap(nums, start, correct);
            } else {
                start++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }

}
