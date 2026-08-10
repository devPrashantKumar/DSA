package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    /*
     * Time Complexity : O(2^n)
     * Space Complexity : O(n) , recursion stack space
     */
    public static int minimumDifference(int[] nums) {
        return minimumDifferenceUtil(nums, 0, 0, 0);
    }

    public static int minimumDifferenceUtil(int[] nums, int index, int subset1, int subset2) {
        if (index == nums.length) {
            return Math.abs(subset1 - subset2);
        }
        int chooseSubset1 = minimumDifferenceUtil(nums, index + 1, subset1 + nums[index], subset2);
        int chooseSubset2 = minimumDifferenceUtil(nums, index + 1, subset1, subset2 + nums[index]);
        return Math.min(chooseSubset1, chooseSubset2);
    }

    /*
     * Time Complexity : O(n)+O(2^n) , sum + branching
     * Space Complexity : O(n) , recursion stack space
     */
    public static int minimumDifference2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return minimumDifferenceUtil2(nums, 0, totalSum, 0);
    }

    public static int minimumDifferenceUtil2(int[] nums, int index, int totalSum, int subset1) {
        if (index == nums.length) {
            return Math.abs(totalSum - 2 * subset1);
        }
        int chooseSubset1 = minimumDifferenceUtil2(nums, index + 1, totalSum, subset1 + nums[index]);
        int chooseSubset2 = minimumDifferenceUtil2(nums, index + 1, totalSum, subset1);
        return Math.min(chooseSubset1, chooseSubset2);
    }

    /*
     * Time Complexity : O(n)+O(2^n) , sum + branching
     * Space Complexity : O(n) , recursion stack space
     */
    public static int minimumDifference2_2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return minimumDifferenceUtil2_2(nums, nums.length - 1, totalSum, 0);
    }

    public static int minimumDifferenceUtil2_2(int[] nums, int index, int totalSum, int subset1) {
        if (index < 0) {
            return Math.abs(totalSum - 2 * subset1);
        }
        int chooseSubset1 = minimumDifferenceUtil2_2(nums, index - 1, totalSum, subset1 + nums[index]);
        int chooseSubset2 = minimumDifferenceUtil2_2(nums, index - 1, totalSum, subset1);
        return Math.min(chooseSubset1, chooseSubset2);
    }

    /*
     * Time Complexity : O(n*totalSum)
     * Space Complexity : O(n*totalSum) + O(n) , dp + recursion stack space
     */
    public static int minimumDifferenceMemoization2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        Integer[][] dp = new Integer[nums.length][totalSum + 1];
        minimumDifferenceMemoizationUtil2(nums, 0, totalSum, 0, dp);
        return dp[0][0];
    }

    public static int minimumDifferenceMemoizationUtil2(int[] nums, int index, int totalSum, int subset1,
            Integer[][] dp) {
        if (index == nums.length) {
            return Math.abs(totalSum - 2 * subset1);
        }
        if (dp[index][subset1] != null)
            return dp[index][subset1];
        int chooseSubset1 = minimumDifferenceMemoizationUtil2(nums, index + 1, totalSum, subset1 + nums[index], dp);
        int chooseSubset2 = minimumDifferenceMemoizationUtil2(nums, index + 1, totalSum, subset1, dp);
        return dp[index][subset1] = Math.min(chooseSubset1, chooseSubset2);
    }

    /*
     * Time Complexity : O(n*totalSum)
     * Space Complexity : O(n*totalSum) + O(n) , dp + recursion stack space
     */
    public static int minimumDifferenceMemoization2_2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        Integer[][] dp = new Integer[nums.length][totalSum + 1];
        minimumDifferenceMemoizationUtil2_2(nums, nums.length - 1, totalSum, 0, dp);
        return dp[nums.length - 1][0];
    }

    public static int minimumDifferenceMemoizationUtil2_2(int[] nums, int index, int totalSum, int subset1,
            Integer[][] dp) {
        if (index < 0) {
            return Math.abs(totalSum - 2 * subset1);
        }
        if (dp[index][subset1] != null)
            return dp[index][subset1];
        int chooseSubset1 = minimumDifferenceMemoizationUtil2_2(nums, index - 1, totalSum, subset1 + nums[index], dp);
        int chooseSubset2 = minimumDifferenceMemoizationUtil2_2(nums, index - 1, totalSum, subset1, dp);
        return dp[index][subset1] = Math.min(chooseSubset1, chooseSubset2);
    }

    /*
     * Time Complexity : O(n*totalSum)
     * Space Complexity : O(n*totalSum) , dp space
     */
    public static int minimumDifferenceTabulation2(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        int[][] dp = new int[n + 1][totalSum + 1];

        // Base case: index == n → |totalSum - 2*subset1|
        for (int s = 0; s <= totalSum; s++) {
            dp[n][s] = Math.abs(totalSum - 2 * s);
        }

        // Fill bottom-up
        for (int index = n - 1; index >= 0; index--) {
            for (int s1 = 0; s1 + nums[index] <= totalSum; s1++) {
                int take = dp[index + 1][s1 + nums[index]];
                int notTake = dp[index + 1][s1];
                dp[index][s1] = Math.min(take, notTake);
            }
            // s1 values where s1+nums[index] > totalSum: only notTake valid
            for (int s1 = totalSum - nums[index] + 1; s1 <= totalSum; s1++) {
                dp[index][s1] = dp[index + 1][s1];
            }
        }
        return dp[0][0];
    }

    /*
     * Time Complexity : O(n*totalSum)
     * Space Complexity : O(n*totalSum) , dp space
     */
    public static int minimumDifferenceTabulation2_2(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        int[][] dp = new int[n + 1][totalSum + 1];

        // Base case: index == -1 → |totalSum - 2*subset1|
        for (int s = 0; s <= totalSum; s++) {
            dp[0][s] = Math.abs(totalSum - 2 * s);
        }

        // Fill bottom-up
        for (int index = 1; index <= n; index++) {
            for (int s1 = 0; s1 + nums[index-1] <= totalSum; s1++) {
                int take = dp[index-1][s1 + nums[index-1]];
                int notTake = dp[index-1][s1];
                dp[index][s1] = Math.min(take, notTake);
            }
            // s1 values where s1+nums[index] > totalSum: only notTake valid
            for (int s1 = totalSum - nums[index-1] + 1; s1 <= totalSum; s1++) {
                dp[index][s1] = dp[index-1][s1];
            }
        }
        return dp[n][0];
    }

    /*
     * Time Complexity : O(n*totalSum)
     * Space Complexity : O(totalSum) , dp space
     */
    public static int minimumDifferenceTabulationSpaceOptimised2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int n = nums.length;
        int[] dp = new int[totalSum + 1];
        for (int s = 0; s <= totalSum; s++)
            dp[s] = Math.abs(totalSum - 2 * s);
        for (int index = n - 1; index >= 0; index--) {
            for (int s = 0; s <= totalSum; s++) {
                int take = (s + nums[index] <= totalSum) ? dp[s + nums[index]] : Integer.MAX_VALUE;
                int notTake = dp[s];
                dp[s] = Math.min(take, notTake);
            }
        }
        return dp[0];
    }

    /*
     * Time Complexity : O(n*totalSum)
     * Space Complexity : O(totalSum) , dp space
     */
    public static int minimumDifferenceTabulationSpaceOptimised2_2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int n = nums.length;
        int[] dp = new int[totalSum + 1];
        for (int s = 0; s <= totalSum; s++)
            dp[s] = Math.abs(totalSum - 2 * s);
        for (int index = 0; index < n; index++) {
            for (int s = 0; s + nums[index] <= totalSum; s++) {
                int take = dp[s + nums[index]];
                int notTake = dp[s];
                dp[s] = Math.min(take, notTake);
            }
        }
        return dp[0];
    }

    /*
     * Time Complexity : O(n*totalSum^2) , totalSum iterations * O(n*totalSum)
     * subset sum check
     * Space Complexity : O(totalSum) , dp space
     */
    public static int minimumDifference3(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum; i++) {
            if (SubsetSumEqualToTarget.isSubsetSumTabulationSpaceOptimised(nums, i)) {
                minDifference = Math.min(Math.abs(totalSum - 2 * i), minDifference);
            }
        }
        return minDifference;
    }

    /*
     * Time Complexity : O(n*totalSum^2) , same order as minimumDifference3, ~half
     * the iterations since i only goes up to totalSum/2
     * Space Complexity : O(totalSum) , dp space
     */
    public static int minimumDifference4(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum / 2; i++) {
            if (SubsetSumEqualToTarget.isSubsetSumTabulationSpaceOptimised(nums, i)) {
                minDifference = Math.min(Math.abs(totalSum - 2 * i), minDifference);
            }
        }
        return minDifference;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 14, 5 };
        System.out.println(minimumDifference(nums));
        System.out.println(minimumDifference2(nums));
        System.out.println(minimumDifference2_2(nums));
        System.out.println(minimumDifferenceMemoization2(nums));
        System.out.println(minimumDifferenceMemoization2_2(nums));
        System.out.println(minimumDifferenceTabulation2(nums));
        System.out.println(minimumDifferenceTabulation2_2(nums));
        System.out.println(minimumDifferenceTabulationSpaceOptimised2(nums));
        System.out.println(minimumDifferenceTabulationSpaceOptimised2_2(nums));
        System.out.println(minimumDifference3(nums));
        System.out.println(minimumDifference4(nums));

        System.out.println("--------------------------------------------");

        int[] nums1 = { 3, 1, 6, 2, 2 };
        System.out.println(minimumDifference(nums1));
        System.out.println(minimumDifference2(nums1));
        System.out.println(minimumDifference2_2(nums1));
        System.out.println(minimumDifferenceMemoization2(nums1));
        System.out.println(minimumDifferenceMemoization2_2(nums1));
        System.out.println(minimumDifferenceTabulation2(nums1));
        System.out.println(minimumDifferenceTabulation2_2(nums1));
        System.out.println(minimumDifferenceTabulationSpaceOptimised2(nums1));
        System.out.println(minimumDifferenceTabulationSpaceOptimised2_2(nums1));
        System.out.println(minimumDifference3(nums1));
        System.out.println(minimumDifference4(nums1));
        System.out.println("--------------------------------------------");

        int[] nums2 = { 2, 2, 2, 9 };
        System.out.println(minimumDifference(nums2));
        System.out.println(minimumDifference2(nums2));
        System.out.println(minimumDifference2_2(nums2));
        System.out.println(minimumDifferenceMemoization2(nums2));
        System.out.println(minimumDifferenceMemoization2_2(nums2));
        System.out.println(minimumDifferenceTabulation2(nums2));
        System.out.println(minimumDifferenceTabulation2_2(nums2));
        System.out.println(minimumDifferenceTabulationSpaceOptimised2(nums2));
        System.out.println(minimumDifferenceTabulationSpaceOptimised2_2(nums2));
        System.out.println(minimumDifference3(nums2));
        System.out.println(minimumDifference4(nums2));
    }
}
