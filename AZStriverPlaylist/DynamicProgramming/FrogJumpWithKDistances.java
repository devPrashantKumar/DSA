package AZStriverPlaylist.DynamicProgramming;

public class FrogJumpWithKDistances {
    /*
     * Time Complexity : O(k^n)
     * Space Complexity : O(n), (recursive stack)
     */
    public static int frogJump(int[] heights, int k) {
        return frogJumpUtil(heights, k, heights.length - 1);
    }

    public static int frogJumpUtil(int[] heights, int k, int end) {
        if (end == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; (i <= k && end - i >= 0); i++) {
            int step = Math.abs(heights[end] - heights[end - i]) + frogJumpUtil(heights, k, end - i);
            min = Math.min(step, min);
        }
        return min;
    }

    /*
     * Time Complexity : O(k*n)
     * Space Complexity : O(n)+O(n) , (dp+recursive stack)
     */
    public static int frogJumpMemoization(int[] heights, int k) {
        Integer[] dp = new Integer[heights.length];
        dp[0] = 0;
        frogJumpMemoizationUtil(heights, k, heights.length - 1, dp);
        return dp[heights.length - 1];
    }

    public static int frogJumpMemoizationUtil(int[] heights, int k, int end, Integer[] dp) {
        if (dp[end] != null)
            return dp[end];

        int min = Integer.MAX_VALUE;
        for (int i = 1; (i <= k && end - i >= 0); i++) {
            int step = Math.abs(heights[end] - heights[end - i]) + frogJumpMemoizationUtil(heights, k, end - i, dp);
            min = Math.min(step, min);
        }
        dp[end] = min;
        return dp[end];
    }

    /*
     * Time Complexity : O(k*n)
     * Space Complexity : O(n)
     */
    public static int frogJumpTabulation(int[] heights, int k) {
        Integer[] dp = new Integer[heights.length];
        dp[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; (j <= k && i - j >= 0); j++) {
                int step = Math.abs(heights[i] - heights[i - j]) + dp[i - j];
                min = Math.min(step, min);
            }
            dp[i] = min;
        }
        return dp[heights.length - 1];
    }

    /*
     * IMPORTANT
     * Time Complexity : O(k*n)
     * Space Complexity : O(k)
     */
    public static int frogJumpSpaceOptimized(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[k];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                int cost = Math.abs(heights[i] - heights[i - j]) + dp[(i - j) % k];
                min = Math.min(min, cost);
            }
            dp[i % k] = min;
        }
        return dp[(n - 1) % k];
    }

    public static void main(String[] args) {
        System.out.println(frogJump(new int[] { 10, 5, 20, 0, 15 }, 2));
        System.out.println(frogJumpMemoization(new int[] { 10, 5, 20, 0, 15 }, 2));
        System.out.println(frogJumpTabulation(new int[] { 10, 5, 20, 0, 15 }, 2));
        System.out.println(frogJumpSpaceOptimized(new int[] { 10, 5, 20, 0, 15 }, 2));

        System.out.println("----------------------------------------------------");

        System.out.println(frogJump(new int[] { 15, 4, 1, 14, 15 }, 3));
        System.out.println(frogJumpMemoization(new int[] { 15, 4, 1, 14, 15 }, 3));
        System.out.println(frogJumpTabulation(new int[] { 15, 4, 1, 14, 15 }, 3));
        System.out.println(frogJumpSpaceOptimized(new int[] { 15, 4, 1, 14, 15 }, 3));

        System.out.println("----------------------------------------------------");
    }
}
