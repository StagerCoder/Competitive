public class FindiBit {

    public static void main(String[] args) {
        System.out.println(findiBit(11011, 3));
        System.out.println(findiBit(110100, 4));
    }

    static String findiBit(int binary, int i) {
        return Integer.toBinaryString(binary & 1 << i - 1);
    }

}
