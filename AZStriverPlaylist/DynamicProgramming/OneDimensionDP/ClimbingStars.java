package AZStriverPlaylist.DynamicProgramming.OneDimensionDP;

public class ClimbingStars {
    /*
     * Time Complexity : O(2^n)
     * Space Complexity : O(n)
     */
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int climbStairsMemoization(int n) {
        int[] dp = new int[n + 1];
        return climbStairsMemoizationUtil(n, dp);
    }

    public static int climbStairsMemoizationUtil(int n, int[] dp) {
        if (n <= 2)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = climbStairsMemoizationUtil(n - 1, dp) + climbStairsMemoizationUtil(n - 2, dp);
        return dp[n];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int climbStairsTabulatiion(int n) {
        if(n<=2) return n;
        int[] dp = new int[n + 1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int climbStairsTabulatiionSpaceOptimised(int n) {
        if(n<=2) return n;
        int farPrev=1;
        int prev=2;
        for(int i=3;i<=n;i++){
            int curr = prev+farPrev;
            farPrev = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairsMemoization(2));
        System.out.println(climbStairsTabulatiion(2));
        System.out.println(climbStairsTabulatiionSpaceOptimised(2));

        System.out.println("---------------------------------------------------");

        System.out.println(climbStairs(3));
        System.out.println(climbStairsMemoization(3));
        System.out.println(climbStairsTabulatiion(3));
        System.out.println(climbStairsTabulatiionSpaceOptimised(3));

        System.out.println("---------------------------------------------------");
    }
}
