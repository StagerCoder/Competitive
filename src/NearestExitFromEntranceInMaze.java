
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
        return doIT("", maze, entrance[0], entrance[1], entrance, -1);
    }

    static int doIT(String processed, char[][] maze, int row, int col, int[] entrance, Integer min) {
        if (maze[row][col] == '+') {
            return -1;
        }
        if (row != entrance[0] || col != entrance[1]) {
            if (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1) {
                if (min == -1 && processed.length() > 0) {
                    min = processed.length();
                } else if (min > -1 && processed.length() > 0) {
                    return Math.min(processed.length(), min);
                }
                return min;
            }
        }
        maze[row][col] = '+';
        if (row < maze.length - 1) {
            int ans = doIT(processed + "D", maze, row + 1, col, entrance, min);
            if (ans != -1) {
                if (min != -1) {
                    min = Math.min(ans, min);
                } else {
                    min = ans;
                }

            }
        }
        if (col < maze[0].length - 1) {
            int ans = doIT(processed + "R", maze, row, col + 1, entrance, min);
            if (ans != -1) {
                if (min != -1) {
                    min = Math.min(ans, min);
                } else {
                    min = ans;
                }

            }
        }
        if (col > 0) {
            int ans = doIT(processed + "L", maze, row, col - 1, entrance, min);
            if (ans != -1) {
                if (min != -1) {
                    min = Math.min(ans, min);
                } else {
                    min = ans;
                }

            }
        }
        if (row > 0) {
            int ans = doIT(processed + "U", maze, row - 1, col, entrance, min);
            if (ans != -1) {
                if (min != -1) {
                    min = Math.min(ans, min);
                } else {
                    min = ans;
                }

            }
        }
        maze[row][col] = '.';
        return min;
    }
}
