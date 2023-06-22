
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(splitArray(arr, 2));
    }

    static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        if (k == 1) {
            return end;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid) {
                    count += 1;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (count > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

}
