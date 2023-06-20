public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {5, 2, 46, 13, 79, 4, 67};
        System.out.println("Index of target: " + linearSearch(arr, 2));
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

