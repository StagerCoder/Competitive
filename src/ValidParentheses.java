import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    static public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(character);
                continue;
            }
            if (character == checker(stack.peek())) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    static private char checker(char s) {
        if (s == '(') {
            return ')';
        } else if (s == '{') {
            return '}';
        } else if (s == '[') {
            return ']';
        } else {
            return '0';
        }
    }
}
