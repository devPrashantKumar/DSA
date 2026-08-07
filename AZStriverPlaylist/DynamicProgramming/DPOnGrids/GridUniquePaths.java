package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

import java.util.Arrays;

public class GridUniquePaths {
    /*
     * Time Complexity : O(2^(m+n))
     * Space Complexity : O(m+n) recursion stack depth
     */
    public static int uniquePaths(int m, int n) {
        return uniquePathsUtil(0, 0, m, n);
    }

    public static int uniquePathsUtil(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1)
            return 1;
        if (row >= m || col >= n)
            return 0;
        int goRight = uniquePathsUtil(row, col + 1, m, n);
        int goDown = uniquePathsUtil(row + 1, col, m, n);
        return goRight + goDown;
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n)+O(m+n), (dp + recursive stack)
     */
    public static int uniquePathsMemoization(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        uniquePathsMemoizationUtil(0, 0, m, n, dp);
        return dp[0][0];
    }

    public static int uniquePathsMemoizationUtil(int row, int col, int m, int n, int[][] dp) {
        if (row == m - 1 && col == n - 1)
            return 1;
        if (row >= m || col >= n)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int goRight = uniquePathsMemoizationUtil(row, col + 1, m, n, dp);
        int goDown = uniquePathsMemoizationUtil(row + 1, col, m, n, dp);
        dp[row][col] = goRight + goDown;
        return dp[row][col];
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n), (dp)
     */
    public static int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(n)
     */
    public static int uniquePathsTabulationSpaceOptimised(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePathsMemoization(m, n));
        System.out.println(uniquePathsTabulation(m, n));
        System.out.println(uniquePathsTabulationSpaceOptimised(m, n));

        System.out.println("================================================");

        int m1 = 3;
        int n1 = 2;
        System.out.println(uniquePaths(m1, n1));
        System.out.println(uniquePathsMemoization(m1, n1));
        System.out.println(uniquePathsTabulation(m1, n1));
        System.out.println(uniquePathsTabulationSpaceOptimised(m1, n1));

        System.out.println("================================================");
    }
}
