package AZStriverPlaylist.SlidingWindowAndTwoPointers.CountingSubArraysSubstringsProblems;

import java.util.Arrays;

public class CountNumberOfNiceSubarrays {
    public static int numSubarraysWithOddNumbersEqualToGoalMostOptimised(int[] nums, int goal) {
        return numSubarraysWithOddNumbersLessThaGoal(nums, goal)-numSubarraysWithOddNumbersLessThaGoal(nums, goal-1);
    }

    public static int numSubarraysWithOddNumbersLessThaGoal(int[] nums, int goal) {
        if(goal<0) return 0;
        int subArrayCount = 0;
        int l = 0, r = 0;
        int oddNumbers = 0;
        while (r < nums.length) {
            oddNumbers += (nums[r]%2);
            while (oddNumbers > goal) {
                oddNumbers -= (nums[l]%2);
                l++;
            }
            subArrayCount += r - l + 1;
            r++;
        }
        return subArrayCount;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 2, 1, 1 };
        int goal1 = 3;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + numSubarraysWithOddNumbersEqualToGoalMostOptimised(nums1, goal1));
        System.out.println("----------------------------------------------------------------");

        int[] nums2 = { 4, 8, 2 };
        int goal2 = 1;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + numSubarraysWithOddNumbersEqualToGoalMostOptimised(nums2, goal2));
    }
}
