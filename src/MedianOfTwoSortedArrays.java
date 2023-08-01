import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1Ex1 = {1, 3};
        int[] num2Ex1 = {2};
        System.out.println(findMedianSortedArrays(num1Ex1, num2Ex1));
        int[] num1Ex2 = {4, 5, 6, 8, 9};
        int[] num2Ex2 = {};
        System.out.println(findMedianSortedArrays(num1Ex2, num2Ex2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> finalArr = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                finalArr.add(nums1[pointer1]);
                pointer1 += 1;
            } else {
                finalArr.add(nums2[pointer2]);
                pointer2 += 1;
            }
        }
        while (pointer1 < nums1.length) {
            finalArr.add(nums1[pointer1]);
            pointer1 += 1;
        }
        while (pointer2 < nums2.length) {
            finalArr.add(nums2[pointer2]);
            pointer2 += 1;
        }
        if (finalArr.size() % 2 != 0) {
            return finalArr.get(finalArr.size() / 2);
        } else {
            int n = finalArr.size() / 2 - 1;
            int n2 = finalArr.size() / 2;
            return (double) (finalArr.get(n) + finalArr.get(n2)) / 2;
        }
    }
}
