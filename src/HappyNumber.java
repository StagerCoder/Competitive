public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(5));
        System.out.println(isHappy(19));
    }

    static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        return slow == 1;
    }

    static private int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int remainder = n % 10;
            ans += remainder * remainder;
            n = n / 10;
        }
        return ans;
    }
}
