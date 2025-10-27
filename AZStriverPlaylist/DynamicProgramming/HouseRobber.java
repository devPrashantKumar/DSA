package AZStriverPlaylist.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    /*
     * Time Complexity : O(2^n)
     * Space Complexity : O(n)
     */
    public static int rob(int[] nums) {
        return robUtil(nums, nums.length - 1);
    }

    public static int robUtil(int[] nums, int end) {
        if (end < 0)
            return 0;
        int rob = nums[end] + robUtil(nums, end - 2);
        int notRob = robUtil(nums, end - 1);
        return Math.max(rob, notRob);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)+O(n) , (dp array + recursion stack)
     */
    public static int robDPMemoization(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robDPMemoizationUtil(nums, nums.length - 1, dp);
    }

    public static int robDPMemoizationUtil(int[] nums, int end, int[] dp) {
        if (end < 0)
            return 0;
        if (dp[end] != -1)
            return dp[end];
        int rob = nums[end] + robDPMemoizationUtil(nums, end - 2, dp);
        int notRob = robDPMemoizationUtil(nums, end - 1, dp);
        dp[end] = Math.max(rob, notRob);
        return dp[end];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n) (dp array)
     */
    public static int robDPTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int rob = nums[i];
            int notRob = 0;
            if (i > 1)
                rob += dp[i - 2];
            if (i > 0)
                notRob += dp[i - 1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[nums.length - 1];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int robDPTabulationSpaceOptimised(int[] nums) {
        int prev = 0;
        int farPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            int rob = farPrev + nums[i];
            int notRob = prev;
            farPrev = prev;
            prev = Math.max(rob, notRob);
        }
        return prev;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int robDPTabulationSpaceOptimised2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int rob = nums[i];
            int notRob = 0;
            if (i > 1)
                rob += dp[(i - 2) % 2];
            if (i > 0)
                notRob += dp[(i - 1) % 2];
            dp[i % 2] = Math.max(rob, notRob);
        }
        return dp[(nums.length - 1) % 2];
    }

    public static void main(String[] args) {
        int[] nums = { 1,2, 3, 1 };
        System.out.println(rob(nums));
        System.out.println(robDPMemoization(nums)); 
        System.out.println(robDPTabulation(nums));
        System.out.println(robDPTabulationSpaceOptimised(nums));
        System.out.println(robDPTabulationSpaceOptimised2(nums));
        System.out.println("--------------------------------------------------------------------");

        int[] nums2 = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
        System.out.println(robDPMemoization(nums2)); 
        System.out.println(robDPTabulation(nums2));
        System.out.println(robDPTabulationSpaceOptimised(nums2));
        System.out.println(robDPTabulationSpaceOptimised2(nums2));
        System.out.println("--------------------------------------------------------------------");

        int[] nums3 = { };
        System.out.println(rob(nums3));
        System.out.println(robDPMemoization(nums3)); 
        System.out.println(robDPTabulation(nums3));
        System.out.println(robDPTabulationSpaceOptimised(nums3));
        System.out.println(robDPTabulationSpaceOptimised2(nums3));
        System.out.println("--------------------------------------------------------------------");
    }
}
