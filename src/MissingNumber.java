public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int[] nums2 = {0, 1};
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber(nums2));
        System.out.println(missingNumber(nums3));
    }

    static int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int correctPosition = nums[start];
            if (start != correctPosition) {
                try {
                    swap(nums, start, correctPosition);
                } catch (Exception e) {
                    start++;
                }
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

}
