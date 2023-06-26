public class Palindrome {

    public static void main(String[] args) {
        System.out.println(palindrome(321));
        System.out.println(palindrome(3212331));
    }

    static boolean palindrome(int n) {
        return n == formulate(3232);
    }

    static int formulate(int n) {
        if (n % 10 == n) {
            return 1;
        }
        return Integer.parseInt(n % 10 + String.valueOf(formulate(n / 10)));
    }
}
