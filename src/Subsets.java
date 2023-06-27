import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets("", "abc"));
        System.out.println(subsets("", "abcd"));
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(subsetsWithIn(nums));
    }

    static ArrayList<String> subsets(String processed, String up) {
        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(processed);
            return ans;
        }
        String ch = String.valueOf(up.charAt(0));
        ArrayList<String> left = subsets(processed + ch, up.substring(1));
        ArrayList<String> right = subsets(processed, up.substring(1));
        left.addAll(right);
        return left;
    }

    static List<List<Integer>> subsetsWithIn(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int j = 0; j < nums.length; j++) {
            start = 0;
            if (j > 0 && nums[j] == nums[j - 1]) {
                start = end + 1;
            }
            int num = nums[j];
            int size = arrayList.size();
            for (int i = start; i < size; i++) {
                List<Integer> internal = new ArrayList<>(arrayList.get(i));
                internal.add(num);
                if (!arrayList.contains(internal)) {
                    arrayList.add(internal);
                }
            }
        }
        return arrayList;
    }
}
