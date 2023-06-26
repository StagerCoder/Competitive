public class FindUnique {

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 4, 6, 4};
        System.out.println(findUnique(arr));
    }

    static int findUnique(int[] arr) {
        int unique = 0;
        for (int j : arr) {
            //Xor  only one should be 1
            //logic 22 33 44 going to give 0
            unique ^= j;
        }
        return unique;
    }
}
