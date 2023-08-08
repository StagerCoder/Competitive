import java.util.ArrayList;
import java.util.List;

public class StringMatchingInArray {

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        String[] words2 = {"leetcode", "et", "code"};
        String[] words3 = {"blue", "green", "bu"};
        String[] words4 = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        System.out.println(stringMatching(words));
        System.out.println(stringMatching(words2));
        System.out.println(stringMatching(words3));
        System.out.println(stringMatching(words4));
    }

    static List<String> stringMatching(String[] words) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    if (!strings.contains(words[j])) {
                        strings.add(words[j]);
                    }
                }
                if (words[j].contains(words[i])) {
                    if (!strings.contains(words[i])) {
                        strings.add(words[i]);
                    }
                }
            }
        }
        return strings;
    }
}
