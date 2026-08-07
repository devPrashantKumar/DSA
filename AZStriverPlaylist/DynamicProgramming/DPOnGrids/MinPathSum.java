package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

import java.util.Arrays;

public class MinPathSum {
    /*
     * Time Complexity : O(2^(m+n))
     * Space Complexity : O(m+n) recursion stack depth
     */
    public static int minPathSum(int[][] grid) {
        return minPathSumUtil(0, 0, grid);
    }

    public static int minPathSumUtil(int row, int col,int[][] grid) {
        if (row >= grid.length || col >= grid[0].length)
            return -1;
        int goRight = minPathSumUtil(row, col + 1,grid);
        if(goRight!=-1)
            goRight += grid[row][col];

        int goDown = minPathSumUtil(row + 1, col, grid);
        if(goDown!=-1)
            goDown +=  grid[row][col];

        if(goRight==-1 && goDown==-1) return grid[row][col];
        if(goDown==-1) return goRight;
        if(goRight==-1) return goDown;
        return Math.min(goRight ,goDown);
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n)+O(m+n), (dp + recursive stack)
     */
    public static int minPathSumMemoization(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        minPathSumMemoizationUtil(0, 0, grid, dp);
        return dp[0][0];
    }

    public static int minPathSumMemoizationUtil(int row, int col,int[][] grid, int[][] dp) {
        if (row >= grid.length || col >= grid[0].length)
            return -1;

        if(dp[row][col]!=-1) return dp[row][col];

        int goRight = minPathSumMemoizationUtil(row, col + 1,grid,dp);
        if(goRight!=-1)
            goRight += grid[row][col];

        int goDown = minPathSumMemoizationUtil(row + 1, col, grid,dp);
        if(goDown!=-1)
            goDown +=  grid[row][col];

        if(goRight==-1 && goDown==-1) return grid[row][col];
        if(goDown==-1) return goRight;
        if(goRight==-1) return goDown;
        dp[row][col] =  Math.min(goRight ,goDown);
        return dp[row][col];
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n), (dp)
     */
    public static int minPathSumTabulation(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < grid.length; i++)
            dp[i][0] = dp[i-1][0]+grid[i][0];
        for (int i = 1; i < grid[0].length; i++)
            dp[0][i] = dp[0][i-1]+grid[0][i];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j]+Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(n)
     */
    public static int minPathSumTabulationSpaceOptimised(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0]=grid[0][0];
        for (int i = 1; i < grid[0].length; i++)
            dp[i] = dp[i-1]+grid[0][i];


        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                dp[j] = grid[i][j]+Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {

        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumMemoization(grid));
        System.out.println(minPathSumTabulation(grid));
        System.out.println(minPathSumTabulationSpaceOptimised(grid));

        System.out.println("================================================");

        int [][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid1));
        System.out.println(minPathSumMemoization(grid));
        System.out.println(minPathSumTabulation(grid));
        System.out.println(minPathSumTabulationSpaceOptimised(grid));

        System.out.println("================================================");
    }
}