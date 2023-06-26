public class LCM {

    public static void main(String[] args) {
        System.out.println(lcm(2, 7));
        System.out.println(lcm(100, 18));
    }

    static int lcm(int a, int b) {
        return a * b / gcd_hcf(a, b);
    }

    static int gcd_hcf(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd_hcf(b % a, a);
    }
}
