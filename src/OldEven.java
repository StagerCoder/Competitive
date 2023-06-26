public class OldEven {

    public static void main(String[] args) {
        System.out.println(isOdd(6));
        System.out.println(isOdd(18));
    }

    static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
