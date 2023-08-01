import java.util.Stack;

public class MinimumInsertionsToBalanceParenthesesString {

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))"));
        System.out.println(minInsertions("())"));
        System.out.println(minInsertions("))())("));
        System.out.println(minInsertions("(((((("));
        System.out.println(minInsertions(")))))))"));
        System.out.println(minInsertions("()())))()"));
        System.out.println(minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))"));
    }

    static public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                count += 2;
            } else {
                if (!stack.isEmpty() && s.length() - i > 1 && s.charAt(i + 1) == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        i += 1;
                        count -= 2;
                    } else {
                        count += 1;
                        stack.push(c);
                        stack.push(s.charAt(i + 1));
                        i += 1;
                    }
                } else {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        count -= 1;
                        stack.push(c);
                    } else {
                        if (s.length() - i > 1 && s.charAt(i + 1) == ')') {
                            count += 1;
                            i += 1;
                        } else {
                            count += 2;
                            stack.push(c);
                        }

                    }
                }
            }
        }
        return count;
    }

}
