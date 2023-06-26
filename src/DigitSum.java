public class DigitSum {
    public static void main(String[] args) {
        System.out.println(sumOfNDigits(1324));
    }

    static int sumOfNDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfNDigits(n / 10);
    }
}