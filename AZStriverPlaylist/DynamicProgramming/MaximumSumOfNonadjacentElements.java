package AZStriverPlaylist.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumOfNonadjacentElements {
    /*
     * Time Complexity : O(2^n)
     * Space Complexity : O(n)
     */
    public static int maxNonAdjacentSum(int[] nums) {
        return maxNonAdjacentSumUtil(nums, nums.length - 1);
    }

    public static int maxNonAdjacentSumUtil(int[] nums, int end) {
        if (end < 0)
            return 0;
        int maxNonAdjacentSum = nums[end] + maxNonAdjacentSumUtil(nums, end - 2);
        int notmaxNonAdjacentSum = maxNonAdjacentSumUtil(nums, end - 1);
        return Math.max(maxNonAdjacentSum, notmaxNonAdjacentSum);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)+O(n) , (dp array + recursion stack)
     */
    public static int maxNonAdjacentSumDPMemoization(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxNonAdjacentSumDPMemoizationUtil(nums, nums.length - 1, dp);
    }

    public static int maxNonAdjacentSumDPMemoizationUtil(int[] nums, int end, int[] dp) {
        if (end < 0)
            return 0;
        if (dp[end] != -1)
            return dp[end];
        int selectMaxNonAdjacentSum = nums[end] + maxNonAdjacentSumDPMemoizationUtil(nums, end - 2, dp);
        int notSelectMaxNonAdjacentSum = maxNonAdjacentSumDPMemoizationUtil(nums, end - 1, dp);
        dp[end] = Math.max(selectMaxNonAdjacentSum, notSelectMaxNonAdjacentSum);
        return dp[end];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n) (dp array)
     */
    public static int maxNonAdjacentSumDPTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int selectMaxNonAdjacentSum = nums[i];
            int notSelectMaxNonAdjacentSum = 0;
            if (i > 1)
                selectMaxNonAdjacentSum += dp[i - 2];
            if (i > 0)
                notSelectMaxNonAdjacentSum += dp[i - 1];
            dp[i] = Math.max(selectMaxNonAdjacentSum, notSelectMaxNonAdjacentSum);
        }
        return dp[nums.length - 1];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int maxNonAdjacentSumDPTabulationSpaceOptimised(int[] nums) {
        int prev = 0;
        int farPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxNonAdjacentSum = farPrev + nums[i];
            int notSelectMaxNonAdjacentSum = prev;
            farPrev = prev;
            prev = Math.max(maxNonAdjacentSum, notSelectMaxNonAdjacentSum);
        }
        return prev;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int maxNonAdjacentSumDPTabulationSpaceOptimised2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int selectMaxNonAdjacentSum = nums[i];
            int notSelectMaxNonAdjacentSum = 0;
            if (i > 1)
                selectMaxNonAdjacentSum += dp[(i - 2) % 2];
            if (i > 0)
                notSelectMaxNonAdjacentSum += dp[(i - 1) % 2];
            dp[i % 2] = Math.max(selectMaxNonAdjacentSum, notSelectMaxNonAdjacentSum);
        }
        return dp[(nums.length - 1) % 2];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(maxNonAdjacentSum(nums));
        System.out.println(maxNonAdjacentSumDPMemoization(nums));
        System.out.println(maxNonAdjacentSumDPTabulation(nums)); 
        System.out.println(maxNonAdjacentSumDPTabulationSpaceOptimised(nums));
        System.out.println(maxNonAdjacentSumDPTabulationSpaceOptimised2(nums));
        System.out.println("--------------------------------------------------------------------");

        int[] nums2 = { 2, 7, 9, 3, 1 };
        System.out.println(maxNonAdjacentSum(nums2));
        System.out.println(maxNonAdjacentSumDPMemoization(nums2));
        System.out.println(maxNonAdjacentSumDPTabulation(nums2)); 
        System.out.println(maxNonAdjacentSumDPTabulationSpaceOptimised(nums2));
        System.out.println(maxNonAdjacentSumDPTabulationSpaceOptimised2(nums2));
        System.out.println("--------------------------------------------------------------------");

        int[] nums3 = {  };
        System.out.println(maxNonAdjacentSum(nums3));
        System.out.println(maxNonAdjacentSumDPMemoization(nums3));
        System.out.println(maxNonAdjacentSumDPTabulation(nums3)); 
        System.out.println(maxNonAdjacentSumDPTabulationSpaceOptimised(nums3));
        System.out.println(maxNonAdjacentSumDPTabulationSpaceOptimised2(nums3));
        System.out.println("--------------------------------------------------------------------");
    }

}
