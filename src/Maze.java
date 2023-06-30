import java.util.ArrayList;
import java.util.Arrays;

public class Maze {

    public static void main(String[] args) {
        System.out.println(countWaysToReach(3, 3));
        System.out.println(pathToReach("", 0, 0));
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        boolean[][] mazeWithRes = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        System.out.println(pathToReachWithRestrictions("", mazeWithRes, 0, 0));
        System.out.println(pathToReachWithAllDirections("", mazeWithRes, 0, 0));
        System.out.println(pathToReachWithAllDirections("", maze, 0, 0));
        System.out.println(pathToReachWithAllDirectionsPrint("", maze, 0, 0, path, 0));
    }

    static int countWaysToReach(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int ways = 0;
        ways += countWaysToReach(r - 1, c);
        ways += countWaysToReach(r, c - 1);

        return ways;
    }

    static ArrayList<String> pathToReach(String processed, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == 2 && c == 2) {
            ans.add(processed);
            return ans;
        }
        //Diagonal
        if (r < 2 && c < 2) {
            ans.addAll(pathToReach(processed + "D", r + 1, c + 1));
        }
        //Right
        if (r < 2) {
            ans.addAll(pathToReach(processed + "V", r + 1, c));
        }
        //Down
        if (c < 2) {
            ans.addAll(pathToReach(processed + "H", r, c + 1));
        }

        return ans;
    }

    static ArrayList<String> pathToReachWithRestrictions(String processed, boolean[][] maze, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ans.add(processed);
            return ans;
        }
        if (!maze[r][c]) {
            return new ArrayList<>();
        }
        //Diagonal
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            ans.addAll(pathToReachWithRestrictions(processed + "D", maze, r + 1, c + 1));
        }
        //Right
        if (r < maze.length - 1) {
            ans.addAll(pathToReachWithRestrictions(processed + "V", maze, r + 1, c));
        }
        //Down
        if (c < maze[0].length - 1) {
            ans.addAll(pathToReachWithRestrictions(processed + "H", maze, r, c + 1));
        }

        return ans;
    }

    static ArrayList<String> pathToReachWithAllDirections(String processed, boolean[][] maze, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ans.add(processed);
            return ans;
        }
        if (!maze[r][c]) {
            return new ArrayList<>();
        }
        maze[r][c] = false;
        //Diagonal
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            ans.addAll(pathToReachWithAllDirections(processed + "d", maze, r + 1, c + 1));
        }
        //Right
        if (r < maze.length - 1) {
            ans.addAll(pathToReachWithAllDirections(processed + "D", maze, r + 1, c));
        }
        //Down
        if (c < maze[0].length - 1) {
            ans.addAll(pathToReachWithAllDirections(processed + "R", maze, r, c + 1));
        }
        if (r > 0) {
            ans.addAll(pathToReachWithAllDirections(processed + "U", maze, r - 1, c));
        }
        if (c > 0) {
            ans.addAll(pathToReachWithAllDirections(processed + "L", maze, r, c - 1));
        }
        maze[r][c] = true;
        return ans;
    }

    static ArrayList<Object> pathToReachWithAllDirectionsPrint(String processed, boolean[][] maze, int r, int c, int[][] path, int step) {
        ArrayList<Object> ans = new ArrayList<>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            ans.add(Arrays.deepToString(path));
            ans.add(processed);
            return ans;
        }
        if (!maze[r][c]) {
            return new ArrayList<>();
        }
        maze[r][c] = false;
        path[r][c] = step;
        //Diagonal Down
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            ans.addAll(pathToReachWithAllDirectionsPrint(processed + "dd", maze, r + 1, c + 1, path, step + 1));
        }
        //Diagonal Up
        if (r > 0 && c > 0) {
            ans.addAll(pathToReachWithAllDirectionsPrint(processed + "du", maze, r - 1, c - 1, path, step + 1));
        }
        //Right
        if (r < maze.length - 1) {
            ans.addAll(pathToReachWithAllDirectionsPrint(processed + "D", maze, r + 1, c, path, step + 1));
        }
        //Down
        if (c < maze[0].length - 1) {
            ans.addAll(pathToReachWithAllDirectionsPrint(processed + "R", maze, r, c + 1, path, step + 1));
        }
        //UP
        if (r > 0) {
            ans.addAll(pathToReachWithAllDirectionsPrint(processed + "U", maze, r - 1, c, path, step + 1));
        }
        //Left
        if (c > 0) {
            ans.addAll(pathToReachWithAllDirectionsPrint(processed + "L", maze, r, c - 1, path, step + 1));
        }
        maze[r][c] = true;
        path[r][c] = 0;
        return ans;
    }


}
