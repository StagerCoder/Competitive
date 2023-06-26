import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 356, 74, 256, 34, 786, 22};
        System.out.println(mergeSort(arr, 0, arr.length - 1));

    }

    static ArrayList<Integer> mergeSort(int[] arr, int start, int end) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (start == end) {
            ans.add(arr[start]);
            return ans;
        }
        int mid = start + (end - start) / 2;

        ArrayList<Integer> left = mergeSort(arr, start, mid);
        ArrayList<Integer> right = mergeSort(arr, mid + 1, end);
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) > right.get(j)) {
                ans.add(right.get(j));
                j++;
            } else {
                ans.add(left.get(i));
                i++;
            }
        }
        while (i < left.size()) {
            ans.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            ans.add(right.get(j));
            j++;
        }
        return ans;
    }
}
