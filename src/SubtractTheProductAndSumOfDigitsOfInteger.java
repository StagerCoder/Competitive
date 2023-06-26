public class SubtractTheProductAndSumOfDigitsOfInteger {

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(23433));
    }

    static int subtractProductAndSum(int n) {
        return productOfDigits(n) - sumOfDigits(n);
    }

    static int productOfDigits(int n) {
        if (n % 10 == n) {
            return n;
        }
        return n % 10 * productOfDigits(n / 10);
    }

    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }
}
