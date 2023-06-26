public class CountNoOf0 {
    public static void main(String[] args) {
        System.out.println(countNoOf0(200003030));
    }

    static int countNoOf0(int n) {
        int count = 0;
        if (n % 10 == 0) {
            count += 1;
        }
        if (n % 10 == n) {
            return count;
        }
        return count + countNoOf0(n / 10);
    }
}
