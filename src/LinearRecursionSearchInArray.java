import java.util.ArrayList;

public class LinearRecursionSearchInArray {
    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 2, 3, 18, 4, 4, 4};
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(search(arr, 4, 0));
        System.out.println(searchAll(arr, 4, 0, ans));
    }

    static int search(int[] n, int target, int index) {
        if (n[index] == target) {
            return index;
        }
        if (n.length - 1 == index) {
            return -1;
        }
        return search(n, target, index + 1);
    }

    static ArrayList<Integer> searchAll(int[] n, int target, int index, ArrayList<Integer> ans) {
        if (n[index] == target) {
            ans.add(index);
        }
        if (n.length - 1 == index) {
            return ans;
        }
        return searchAll(n, target, index + 1, ans);
    }

}
