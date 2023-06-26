public class CheckSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println(checkSortedArray(arr, 0));
    }

    static boolean checkSortedArray(int[] n, int i) {
        if (n.length - 1 == i) {
            return true;
        }
        return n[i] < n[i + 1] && checkSortedArray(n, i + 1);
    }
}
