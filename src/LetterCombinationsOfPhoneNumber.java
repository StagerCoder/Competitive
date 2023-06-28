import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    static List<String> letterCombinations(String digits) {
        return pad("", digits);
    }

    static List<String> pad(String processed, String up) {
        List<String> stringList = new ArrayList<>();
        if (up.isEmpty()) {
            if (!processed.isEmpty()) {
                stringList.add(processed);
            }
            return stringList;
        }
        int digit = up.charAt(0) - '1';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char c = (char) ('a' + i);
            stringList.addAll(pad(processed + c, up.substring(1)));
        }
        return stringList;
    }
}
