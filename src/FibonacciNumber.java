public class FibonacciNumber {


    public static void main(String[] args) {
        System.out.println(fibonacciRecursiveFunction(6));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(22));
    }

    //Recursive
    static int fibonacciRecursiveFunction(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursiveFunction(n - 1) + fibonacciRecursiveFunction(n - 2);
    }

    static int fibonacci(int n) {
        int first = 0;
        int sec = 1;
        int temp;
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            temp = first + sec;
            first = sec;
            sec = temp;
        }
        return sec;
    }

}
