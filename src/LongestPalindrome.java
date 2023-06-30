public class LongestPalindrome {
    static int maxLength = 0;
    static int low = 0;
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }
        return s.substring(low, low + maxLength);
    }

    static void expandPalindrome(char[] s, int j, int k) {
        while (j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if (maxLength < k - j - 1) {
            maxLength = k - j - 1;
            low = j + 1;
        }
    }
}
