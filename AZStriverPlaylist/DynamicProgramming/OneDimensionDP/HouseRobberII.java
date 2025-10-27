package AZStriverPlaylist.DynamicProgramming.OneDimensionDP;

import java.util.Arrays;

public class HouseRobberII {

    public static int robCircular(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int notSelect = robCircularUtil(nums, 0, nums.length - 2);
        int select = nums[nums.length - 1] + robCircularUtil(nums, 1, nums.length - 3);
        return Math.max(notSelect, select);
    }

    public static int robCircularUtil(int[] nums, int start, int end) {
        if (end < start)
            return 0;
        int rob = nums[end] + robCircularUtil(nums, start, end - 2);
        int notRob = robCircularUtil(nums, start, end - 1);
        return Math.max(rob, notRob);
    }

    public static int robCircular2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int notSelect = robCircularUtil2(nums, 0, nums.length - 2);
        int select = robCircularUtil2(nums, 1, nums.length - 1);
        return Math.max(notSelect, select);
    }

    public static int robCircularUtil2(int[] nums, int start, int end) {
        if (end < start)
            return 0;
        int rob = nums[end] + robCircularUtil2(nums, start, end - 2);
        int notRob = robCircularUtil2(nums, start, end - 1);
        return Math.max(rob, notRob);
    }

    public static int robCircularMemoization(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int notSelect = robCircularMemoizationUtil(nums, 0, nums.length - 2, dp1);
        int select = robCircularMemoizationUtil(nums, 1, nums.length - 1, dp2);
        return Math.max(notSelect, select);
    }

    public static int robCircularMemoizationUtil(int[] nums, int start, int end, int[] dp) {
        if (end < start)
            return 0;
        if (dp[end] != -1)
            return dp[end];
        int rob = nums[end] + robCircularMemoizationUtil(nums, start, end - 2, dp);
        int notRob = robCircularMemoizationUtil(nums, start, end - 1, dp);
        dp[end] = Math.max(rob, notRob);
        return dp[end];
    }

    public static int robCircularTabulation(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int notSelect = robCircularTabulationUtil(nums, 0, nums.length - 2);
        int select = robCircularTabulationUtil(nums, 1, nums.length - 1);
        return Math.max(notSelect, select);
    }

    public static int robCircularTabulationUtil(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        for (int i = start; i <= end; i++) {
            int rob = nums[i] + ((i > 1) ? dp[i - 2] : 0);
            int notRob = ((i > 0) ? dp[i - 1] : 0);
            dp[i] = Math.max(rob, notRob);
        }
        return dp[end];
    }

    public static int robCircularTabulationSpaceOptimised(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int notSelect = robCircularTabulationSpaceOptimisedUtil(nums, 0, nums.length - 2);
        int select = robCircularTabulationSpaceOptimisedUtil(nums, 1, nums.length - 1);
        return Math.max(notSelect, select);
    }

    public static int robCircularTabulationSpaceOptimisedUtil(int[] nums, int start, int end) {
        int farprev = 0;
        int prev = 0;
        for (int i = start; i <= end; i++) {
            int rob = nums[i] + farprev;
            int notRob = prev;
            farprev = prev;
            prev = Math.max(rob, notRob);
        }
        return prev;
    }

    public static int robCircularTabulationSpaceOptimisedDP(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int notSelect = robCircularTabulationSpaceOptimisedUtilDP(nums, 0, nums.length - 2);
        int select = robCircularTabulationSpaceOptimisedUtilDP(nums, 1, nums.length - 1);
        return Math.max(notSelect, select);
    }

    public static int robCircularTabulationSpaceOptimisedUtilDP(int[] nums, int start, int end) {
        int[] dp = new int[2];
        for (int i = start; i <= end; i++) {
            int rob = nums[i] + ((i > 1) ? dp[(i-2)%2] : 0);
            int notRob =  ((i > 0) ? dp[(i - 1)%2] : 0);
            dp[i%2] = Math.max(rob, notRob);
        }
        return dp[end%2];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(robCircular(nums));
        System.out.println(robCircular2(nums));
        System.out.println(robCircularMemoization(nums));
        System.out.println(robCircularTabulation(nums));
        System.out.println(robCircularTabulationSpaceOptimised(nums));
        System.out.println(robCircularTabulationSpaceOptimisedDP(nums));

        System.out.println("--------------------------------------------------------------------");

        int[] nums2 = { 2, 3, 2 };
        System.out.println(robCircular(nums2));
        System.out.println(robCircular2(nums2));
        System.out.println(robCircularMemoization(nums2));
        System.out.println(robCircularTabulation(nums2));
        System.out.println(robCircularTabulationSpaceOptimised(nums2));
        System.out.println(robCircularTabulationSpaceOptimisedDP(nums2));

        System.out.println("--------------------------------------------------------------------");

        int[] nums3 = { 2, 2, 3, 1, 2 };
        System.out.println(robCircular(nums3));
        System.out.println(robCircular2(nums3));
        System.out.println(robCircularMemoization(nums3));
        System.out.println(robCircularTabulation(nums3));
        System.out.println(robCircularTabulationSpaceOptimised(nums3));
        System.out.println(robCircularTabulationSpaceOptimisedDP(nums3));

        System.out.println("--------------------------------------------------------------------");
    }
}
