public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char[] letters3 = {'x', 'x', 'y', 'y'};
        //example 1
        System.out.println(nextGreatestLetter(letters, 'a'));
        //example 2
        System.out.println(nextGreatestLetter(letters, 'c'));
        //example 3
        System.out.println(nextGreatestLetter(letters3, 'z'));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        if (target > letters[end]) {
            return letters[start];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
