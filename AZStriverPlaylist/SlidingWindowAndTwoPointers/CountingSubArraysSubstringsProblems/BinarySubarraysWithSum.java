package AZStriverPlaylist.SlidingWindowAndTwoPointers.CountingSubArraysSubstringsProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    // this is wrong approach we will miss out some subarrays in this approach
    // public int numSubarraysWithSum(int[] nums, int goal) {
    //     int i=0;int j=0; int sum=0;int count=0;
    //     while(j<nums.length){
    //         if(sum+nums[j]>goal){
    //             sum -= nums[i++];
    //             while(sum==goal){
    //                 count++;
    //                 sum -= nums[i++];
    //             }
    //         }
    //         else{
    //             sum += nums[j++];
    //             if(sum==goal) count++;
    //         }
    //     }
    //     if(i< nums.length && sum==goal){
    //         sum -= nums[i++];
    //         while(i< nums.length && sum==goal){
    //             count++;
    //             sum -= nums[i++];
    //         }
    //     }
    //     return count;
    // }

    public static int numSubarraysWithSumBetterApproach(int[] nums, int goal) {
        int subArrayCount = 0;
        int sum = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (hmap.containsKey(sum - goal)) {
                subArrayCount += hmap.get(sum - goal);
            }
            hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
        }
        return subArrayCount;
    }


    // this approach work only in case when all elements are positive.
    public static int numSubarraysWithSumMostOptimised(int[] nums, int goal) {
        return numSubarraysWithSumLessThaGoal(nums, goal)-numSubarraysWithSumLessThaGoal(nums, goal-1);
    }

    public static int numSubarraysWithSumLessThaGoal(int[] nums, int goal) {
        if(goal<0) return 0;
        int subArrayCount = 0;
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            subArrayCount += r - l + 1;
            r++;
        }
        return subArrayCount;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 0, 1, 0, 1 };
        int goal1 = 2;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + numSubarraysWithSumBetterApproach(nums1, goal1));
        System.out.println("output : " + numSubarraysWithSumMostOptimised(nums1, goal1));
    }
}
