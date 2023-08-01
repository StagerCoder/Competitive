import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public static void main(String[] args) {

    }

    public ImplementQueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while (!first.empty()) {
            second.push(first.pop());
        }
        int pop = second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return pop;
    }

    public int peek() {
        while (!first.empty()) {
            second.push(first.pop());
        }
        int peak = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peak;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
