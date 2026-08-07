package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

import java.util.Arrays;

public class uniquePathsII {
    /*
     * Time Complexity : O(2^(m+n))
     * Space Complexity : O(m+n) recursion stack depth
     */
    public static int uniquePaths(int[][] obstacleGrid) {
        return uniquePathsUtil(0, 0, obstacleGrid);
    }

    public static int uniquePathsUtil(int row, int col, int[][] obstacleGrid) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col]==1)
            return 0;
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1)
            return 1;
        int goRight = uniquePathsUtil(row, col + 1, obstacleGrid);
        int goDown = uniquePathsUtil(row + 1, col, obstacleGrid);
        return goRight + goDown;
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n)+O(m+n), (dp + recursive stack)
     */
    public static int uniquePathsMemoization(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        uniquePathsMemoizationUtil(0, 0, obstacleGrid, dp);
        return dp[0][0];
    }

    public static int uniquePathsMemoizationUtil(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col]==1)
            return 0;
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1)
            return 1;
        if (dp[row][col] != -1)
            return dp[row][col];
        int goRight = uniquePathsMemoizationUtil(row, col + 1, obstacleGrid, dp);
        int goDown = uniquePathsMemoizationUtil(row + 1, col, obstacleGrid, dp);
        dp[row][col] = goRight + goDown;
        return dp[row][col];
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n), (dp)
     */
    public static int uniquePathsTabulation(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0]=1;

        for (int i = 1; i < obstacleGrid.length; i++){
            dp[i][0] = (dp[i-1][0]==0 || obstacleGrid[i][0]==1) ? 0 : 1;
        }
            
        for (int i = 1; i < obstacleGrid[0].length; i++){
            dp[0][i] = (dp[0][i-1]==0 || obstacleGrid[0][i]==1) ? 0 : 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = (obstacleGrid[i][j]==1) ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(n)
     */
    public static int uniquePathsTabulationSpaceOptimised(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0]=1;
        for (int i = 1; i < obstacleGrid[0].length; i++){
            dp[i] = (dp[i-1]==0 || obstacleGrid[0][i]==1) ? 0 : 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[0] = (dp[0]==0 || obstacleGrid[i][0]==1) ? 0 : 1;
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[j] = (obstacleGrid[i][j]==1) ? 0 : dp[j] + dp[j - 1];

            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePaths(obstacleGrid));
        System.out.println(uniquePathsMemoization(obstacleGrid));
        System.out.println(uniquePathsTabulation(obstacleGrid));
        System.out.println(uniquePathsTabulationSpaceOptimised(obstacleGrid));

        System.out.println("================================================");

        int[][] obstacleGrid1 = {{0,1},{0,0}};
        System.out.println(uniquePaths(obstacleGrid1));
        System.out.println(uniquePathsMemoization(obstacleGrid1));
        System.out.println(uniquePathsTabulation(obstacleGrid1));
        System.out.println(uniquePathsTabulationSpaceOptimised(obstacleGrid1));

        System.out.println("================================================");
    }
}
