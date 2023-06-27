import java.util.ArrayList;

public class StringSkipper {

    public static void main(String[] args) {
        System.out.println(stringSkipper("", "LLLLSslksklkLKLSLKSLkl y  ijh sj vjv ", "l"));
        System.out.println(stringSkipper("", "LolLola", "o"));
    }

    static String stringSkipper(String processed, String up, String skipElement) {
        if (up.isEmpty()) {
            return processed;
        }
        String ch = String.valueOf(up.charAt(0));
        if (ch.equals(skipElement)) {
            return stringSkipper(processed, up.substring(1), skipElement);
        } else {
            return stringSkipper(processed + ch, up.substring(1), skipElement);
        }
    }

}
