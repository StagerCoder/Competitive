
//Problem With Time Complex
public class NearestExitFromEntranceInMaze {

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}};
        int[] entrance = new int[]{1, 2};
        char[][] maze2 = new char[][]{
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}};
        int[] entrance2 = new int[]{1, 0};
        char[][] maze3 = new char[][]{{'.', '+'}};
        int[] entrance3 = {0, 0};
        char[][] maze4 = new char[][]{{'.'}};
        int[] entrance4 = new int[]{0, 0};
        System.out.println(nearestExit(maze, entrance));
        System.out.println(nearestExit(maze2, entrance2));
        System.out.println(nearestExit(maze3, entrance3));
        System.out.println(nearestExit(maze4, entrance4));
    }

    static int nearestExit(char[][] maze, int[] entrance) {
        return doIT("", maze, entrance[0], entrance[1], entrance, Integer.MAX_VALUE);
        //return doItDifferently(maze, entrance, entrance[0], entrance[1], Integer.MAX_VALUE, 0);
    }

    static int doIT(String processed, char[][] maze, int row, int col, int[] entrance, Integer min) {
        if (maze[row][col] == '+') {
            return Integer.MAX_VALUE;
        }
        if (row != entrance[0] || col != entrance[1]) {
            if (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) {
                if (min == Integer.MAX_VALUE && processed.length() > 0) {
                    min = processed.length();
                } else if (min < Integer.MAX_VALUE && processed.length() > 0) {
                    return Math.min(processed.length(), min);
                }
                return min;
            }
        }
        maze[row][col] = '+';
        if (row < maze.length - 1) {
            min = Math.min(doIT(processed + "D", maze, row + 1, col, entrance, min), min);
        }
        if (col < maze[0].length - 1) {
            min = Math.min(doIT(processed + "R", maze, row, col + 1, entrance, min), min);
        }
        if (col > 0) {
            min = Math.min(doIT(processed + "L", maze, row, col - 1, entrance, min), min);
        }
        if (row > 0) {
            min = Math.min(doIT(processed + "U", maze, row - 1, col, entrance, min), min);
        }
        maze[row][col] = '.';
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    static int doItDifferently(char[][] maze, int[] entrance, int row, int col, int min, int step) {
        if (maze[row][col] == '+') {
            return Integer.MAX_VALUE;
        }
        if (entrance[0] != row || entrance[1] != col) {
            if (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length) {
                if (min == Integer.MAX_VALUE && step > 0) {
                    return step;
                } else if (min == Integer.MAX_VALUE && step == 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Math.min(step, min);
                }
            }
        }
        maze[row][col] = '+';
        //UP
        if (row > 0) {
            min = Math.min(doItDifferently(maze, entrance, row - 1, col, min, step + 1), min);
        }
        //Down
        if (row < maze.length - 1) {
            min = Math.min(doItDifferently(maze, entrance, row + 1, col, min, step + 1), min);
        }
        //Left
        if (col > 0) {
            min = Math.min(doItDifferently(maze, entrance, row, col - 1, min, step + 1), min);
        }
        //Right
        if (col < maze[0].length - 1) {
            min = Math.min(doItDifferently(maze, entrance, row, col + 1, min, step + 1), min);
        }
        maze[row][col] = '.';
        if (min == Integer.MAX_VALUE && step > 0) {
            return step;
        } else if (min == Integer.MAX_VALUE && step == 0) {
            return -1;
        } else {
            return min;
        }
    }
}
