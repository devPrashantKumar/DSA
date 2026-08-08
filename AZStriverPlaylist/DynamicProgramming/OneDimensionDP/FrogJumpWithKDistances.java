package AZStriverPlaylist.DynamicProgramming.OneDimensionDP;

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
     * Time Complexity : O(k^n)
     * Space Complexity : O(n), (recursive stack)
     */
    public static int frogJump2(int[] heights, int k) {
        return frogJumpUtil2(heights, k, 0);
    }

    public static int frogJumpUtil2(int[] heights, int k, int start) {
        if (start == heights.length-1)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; (i <= k && i+start < heights.length); i++) {
            int step = Math.abs(heights[start] - heights[start+i]) + frogJumpUtil2(heights, k, start+i);
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
     * Standard approach
     * Time Complexity : O(k*n)
     * Space Complexity : O(n)+
     */
    public static int frogJumpTabulation(int[] heights, int k) {
        int[] dp = new int[heights.length];
        dp[0]=0;
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
     * Time Complexity : O(k*n)
     * Space Complexity : O(n)
     */
    public static int frogJumpTabulation2(int[] heights, int k) {
        int[] dp = new int[heights.length];
        dp[heights.length-1]=0;
        for (int i = heights.length-2; i >=0 ; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; (j <= k && i + j < heights.length); j++) {
                int step = Math.abs(heights[i] - heights[i + j]) + dp[i + j];
                min = Math.min(step, min);
            }
            dp[i] = min;
        }
        return dp[0];
    }

    
/*
     * IMPORTANT
     * Time Complexity : O(k*n)
     * Space Complexity : O(k)
     */
    public static int frogJumpSpaceOptimized(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[k];
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

    /*
     * IMPORTANT
     * Time Complexity : O(k*n)
     * Space Complexity : O(k)
     */
    public static int frogJumpSpaceOptimized_2(int[] heights, int k) {
        int[] dp = new int[k];
        dp[(heights.length-1)%k]=0;
        for (int i = heights.length-2; i >=0 ; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i + j <heights.length; j++) {
                int cost = Math.abs(heights[i] - heights[i + j]) + dp[(i + j) % k];
                min = Math.min(min, cost);
            }
            dp[i % k] = min;
        }
        return dp[0% k];
    }
    public static void main(String[] args) {
        System.out.println(frogJump(new int[] { 10, 5, 20, 0, 15 }, 2));
        System.out.println(frogJump2(new int[] { 10, 5, 20, 0, 15 }, 2));

        System.out.println(frogJumpMemoization(new int[] { 10, 5, 20, 0, 15 }, 2));

        System.out.println(frogJumpTabulation(new int[] { 10, 5, 20, 0, 15 }, 2));
        System.out.println(frogJumpTabulation2(new int[] { 10, 5, 20, 0, 15 }, 2));

        System.out.println(frogJumpSpaceOptimized(new int[] { 10, 5, 20, 0, 15 }, 2));
        System.out.println(frogJumpSpaceOptimized_2(new int[] { 10, 5, 20, 0, 15 }, 2));

        System.out.println("----------------------------------------------------");

        System.out.println(frogJump(new int[] { 15, 4, 1, 14, 15 }, 3));
        System.out.println(frogJump2(new int[] { 15, 4, 1, 14, 15 }, 3));

        System.out.println(frogJumpMemoization(new int[] { 15, 4, 1, 14, 15 }, 3));

        System.out.println(frogJumpTabulation(new int[] { 15, 4, 1, 14, 15 }, 3));
        System.out.println(frogJumpTabulation2(new int[] { 15, 4, 1, 14, 15 }, 3));

        System.out.println(frogJumpSpaceOptimized(new int[] { 15, 4, 1, 14, 15 }, 3));
        System.out.println(frogJumpSpaceOptimized_2(new int[] { 15, 4, 1, 14, 15 }, 3));

        System.out.println("----------------------------------------------------");
    }
}
