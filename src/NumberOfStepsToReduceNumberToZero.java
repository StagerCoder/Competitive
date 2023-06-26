public class NumberOfStepsToReduceNumberToZero {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }

    static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int count = 1;
        return count + numberOfSteps(num % 2 == 0 ? num / 2 : num - 1);
    }
}
