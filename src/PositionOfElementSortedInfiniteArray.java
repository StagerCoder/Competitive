public class PositionOfElementSortedInfiniteArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 78, 100, 122, 144, 146, 234};
        System.out.println(findElement(arr, 5));
    }

    static int findElement(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (arr[end] < target) {
            int temp = start;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return search(arr, target, start, end);
    }

    static int search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
