package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

import java.util.Arrays;

public class Triangle {
    /*
     * Time Complexity : O(2^n), n = number of rows
     * Space Complexity : O(n) recursion stack depth
     */
    public static int minimumTotal(int[][] grid) {
        return minimumTotalUtil(0, 0, grid);
    }

    public static int minimumTotalUtil(int row, int col, int[][] grid) {
        if (row >= grid.length || col >= grid[row].length)
            return Integer.MAX_VALUE;

        int goDown = minimumTotalUtil(row + 1, col, grid);
        if (goDown != Integer.MAX_VALUE)
            goDown += grid[row][col];

        int goDownRight = minimumTotalUtil(row + 1, col + 1, grid);
        if (goDownRight != Integer.MAX_VALUE)
            goDownRight += grid[row][col];

        if (goDown == Integer.MAX_VALUE && goDownRight == Integer.MAX_VALUE)
            return grid[row][col];
        if (goDown == Integer.MAX_VALUE)
            return goDownRight;
        if (goDownRight == Integer.MAX_VALUE)
            return goDown;
        return Math.min(goDownRight, goDown);
    }

    /*
     * Time Complexity : O(2^n), n = number of rows
     * Space Complexity : O(n) recursion stack depth
     */
    public static int minimumTotal2(int[][] grid) {
        return minimumTotalUtil2(0, 0, grid);
    }

    public static int minimumTotalUtil2(int row, int col, int[][] grid) {
        if (row == grid.length - 1)
            return grid[row][col];

        int goDown = minimumTotalUtil2(row + 1, col, grid);
        int goDownRight = minimumTotalUtil2(row + 1, col + 1, grid);

        return grid[row][col] + Math.min(goDown, goDownRight);
    }

    /*
     * Time Complexity : O(n^2), n = number of rows
     * Space Complexity : O(n^2) dp + O(n) recursion stack
     */
    public static int minimumTotalMemoization(int[][] grid) {
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return minimumTotalMemoizationUtil(0, 0, grid, dp);
    }

    public static int minimumTotalMemoizationUtil(int row, int col, int[][] grid, int[][] dp) {
        if (row >= grid.length || col >= grid[row].length)
            return Integer.MAX_VALUE;

        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        int goDown = minimumTotalMemoizationUtil(row + 1, col, grid, dp);
        int goDownRight = minimumTotalMemoizationUtil(row + 1, col + 1, grid, dp);

        if (goDown == Integer.MAX_VALUE && goDownRight == Integer.MAX_VALUE)
            return grid[row][col];

        goDown += grid[row][col];
        goDownRight += grid[row][col];

        dp[row][col] = Math.min(goDownRight, goDown);
        return dp[row][col];
    }

    /*
     * Time Complexity : O(n^2), n = number of rows
     * Space Complexity : O(n^2) dp + O(n) recursion stack
     */
    public static int minimumTotalMemoization2(int[][] grid) {
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return minimumTotalMemoizationUtil2(0, 0, grid, dp);
    }

    public static int minimumTotalMemoizationUtil2(int row, int col, int[][] grid, int[][] dp) {
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

         if (row == grid.length - 1)
            return dp[row][col] = grid[row][col];

        int goDown = minimumTotalMemoizationUtil2(row + 1, col, grid, dp);
        int goDownRight = minimumTotalMemoizationUtil2(row + 1, col + 1, grid, dp);
        return dp[row][col] = grid[row][col] + Math.min(goDown, goDownRight);
    }

    /*
     * Time Complexity : O(n^2), n = number of rows
     * Space Complexity : O(n^2), (dp)
     */
    public static int minimumTotalTabulation(int[][] grid) {
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[i + 1];
        }
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int upleft = dp[i - 1][j - 1];
                int up = Integer.MAX_VALUE;
                if (j <= i - 1)
                    up = dp[i - 1][j];
                dp[i][j] = grid[i][j] + Math.min(up, upleft);
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < dp[grid.length - 1].length; i++)
            minPath = Math.min(minPath, dp[grid.length - 1][i]);
        return minPath;
    }

    /*
     * Time Complexity : O(n^2), n = number of rows
     * Space Complexity : O(n)
     */
    public static int minimumTotalTabulationSpaceOptimised(int[][] grid) {
        int[] dp = new int[grid[grid.length - 1].length];
        dp[0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            int diagonal = dp[0];
            dp[0] += grid[i][0];
            for (int j = 1; j <= i; j++) {
                int temp = dp[j];
                int upleft = diagonal;
                int up = Integer.MAX_VALUE;
                if (j <= i - 1)
                    up = dp[j];
                dp[j] = grid[i][j] + Math.min(up, upleft);
                diagonal = temp;
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++)
            minPath = Math.min(minPath, dp[i]);
        return minPath;
    }

    /*
     * Time Complexity : O(n^2), n = number of rows
     * Space Complexity : O(n)
     */
    public static int minimumTotalTabulationSpaceOptimised2(int[][] grid) {
        int[] dp = new int[grid[grid.length - 1].length];
        dp[0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            for (int j = i; j > 0; j--) {
                int upleft = dp[j - 1];
                int up = Integer.MAX_VALUE;
                if (j <= i - 1)
                    up = dp[j];
                dp[j] = grid[i][j] + Math.min(up, upleft);
            }
            dp[0] += grid[i][0];
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++)
            minPath = Math.min(minPath, dp[i]);
        return minPath;
    }

    public static void main(String[] args) {

        int[][] grid = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        System.out.println(minimumTotal(grid));
        System.out.println(minimumTotal2(grid));

        System.out.println(minimumTotalMemoization(grid));
        System.out.println(minimumTotalMemoization2(grid));

        System.out.println(minimumTotalTabulation(grid));
        System.out.println(minimumTotalTabulationSpaceOptimised(grid));
        System.out.println(minimumTotalTabulationSpaceOptimised2(grid));

        System.out.println("================================================");

        int[][] grid2 = { { 10 } };
        System.out.println(minimumTotal(grid2));
        System.out.println(minimumTotal2(grid2));

        System.out.println(minimumTotalMemoization(grid2));
        System.out.println(minimumTotalMemoization2(grid2));

        System.out.println(minimumTotalTabulation(grid2));
        System.out.println(minimumTotalTabulationSpaceOptimised(grid2));
        System.out.println(minimumTotalTabulationSpaceOptimised2(grid2));

        System.out.println("================================================");
    }
}