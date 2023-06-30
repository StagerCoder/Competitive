import java.util.ArrayList;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.println(dieRoll("", 6, 4));
        System.out.println(countDieRoll("", 6, 4));
    }

    static ArrayList<String> dieRoll(String processed, int customFace, int target) {
        ArrayList<String> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(processed);
            return ans;
        }

        for (int i = 1; i <= customFace && i <= target; i++) {
            ans.addAll(dieRoll(processed + i, customFace, target - i));
        }
        return ans;
    }

    static int countDieRoll(String processed, int customFace, int target) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= customFace && i <= target; i++) {
            count += countDieRoll(processed + i, customFace, target - i);
        }
        return count;
    }
}
