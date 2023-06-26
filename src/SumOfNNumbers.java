public class SumOfNNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfNNumbers(3));
    }

    static int sumOfNNumbers(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNNumbers(n - 1);
    }
}
