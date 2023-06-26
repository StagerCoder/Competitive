import java.util.ArrayList;

public class NumberofCommonFactors {

    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));
        System.out.println(commonFactors(122, 62));
        System.out.println(factor(122));
        System.out.println(factor(22));

    }

    static int commonFactors(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= min; i++) {
            if (max % i == 0 && min % i == 0)
                count++;
        }
        return count;

        //        ArrayList<Integer> factorOfa = factor(a);
//        ArrayList<Integer> factorOfb = factor(b);
//        ArrayList<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < factorOfa.size(); i++) {
//            if (factorOfb.contains(factorOfa.get(i))) {
//                ans.add(factorOfa.get(i));
//            }
//        }
//        return ans.size();
    }

    static ArrayList<Integer> factor(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (!ans.contains(n)) {
                    ans.add(n);
                }
                if (!ans.contains(n / i)) {
                    ans.add(n / i);
                }
            }
        }
        return ans;
    }
}
