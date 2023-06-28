import java.util.ArrayList;

public class Permutation {


    public static void main(String[] args) {
        System.out.println(permutation("", "abc"));
    }

    static ArrayList<String> permutation(String processed, String up) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        if (up.isEmpty()) {
            stringArrayList.add(processed);
            return stringArrayList;
        }
        String ch = String.valueOf(up.charAt(0));
        for (int i = 0; i <= processed.length(); i++) {
            String f = processed.substring(0, i);
            String e = processed.substring(i);
            stringArrayList.addAll(permutation(f + ch + e, up.substring(1)));
        }
        return stringArrayList;
    }

//    static List<List<Integer>> permute(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//    }

}
