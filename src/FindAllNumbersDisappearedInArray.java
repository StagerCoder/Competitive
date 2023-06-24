import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 7, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums).toString());
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        int start = 0;
        List<Integer> ans = new ArrayList<>();
        while (start <= nums.length - 1) {
            if (nums[start] == nums[nums[start] - 1]) {
                start++;
            } else if (start != nums[start] - 1) {
                swap(nums, start, nums[start] - 1);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
