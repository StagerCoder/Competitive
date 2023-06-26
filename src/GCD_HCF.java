public class GCD_HCF {
    public static void main(String[] args) {
        System.out.println(gcd_hcf(2, 9));
    }

    static int gcd_hcf(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd_hcf(b % a, a);
    }
}
