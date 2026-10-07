package AZStriverPlaylist.SlidingWindowAndTwoPointers.CountingSubArraysSubstringsProblems;

import java.util.Arrays;

public class CountNumberOfNiceSubarrays {
    public static int numSubarraysWithOddNumbersEqualToGoalMostOptimised(int[] nums, int k) {
        return numSubarraysWithOddNumbersLessThaGoal(nums, k)-numSubarraysWithOddNumbersLessThaGoal(nums, k-1);
    }

    public static int numSubarraysWithOddNumbersLessThaGoal(int[] nums, int k) {
        if(k<0) return 0;
        int subArrayCount = 0;
        int l = 0, r = 0;
        int oddNumbers = 0;
        while (r < nums.length) {
            oddNumbers += (nums[r]%2);
            while (oddNumbers > k) {
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
        int k1 = 3;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + numSubarraysWithOddNumbersEqualToGoalMostOptimised(nums1, k1));
        System.out.println("----------------------------------------------------------------");

        int[] nums2 = { 4, 8, 2 };
        int k2 = 1;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + numSubarraysWithOddNumbersEqualToGoalMostOptimised(nums2, k2));
    }
}
