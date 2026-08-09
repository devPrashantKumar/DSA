package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static int minimumDifference(int[] nums) {
        return minimumDifferenceUtil(nums,0, 0, 0);
    }

    public static int minimumDifferenceUtil(int[] nums, int index, int subset1, int subset2) {
        if(index==nums.length){
            return Math.abs(subset1-subset2);
        }
        int chooseSubset1 = minimumDifferenceUtil(nums,index+1, subset1+nums[index],subset2);
        int chooseSubset2 = minimumDifferenceUtil(nums,index+1, subset1, subset2+nums[index]);
        return Math.min(chooseSubset1,chooseSubset2);
    }

    public static int minimumDifference2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return minimumDifferenceUtil2(nums,0, totalSum, 0);
    }

    public static int minimumDifferenceUtil2(int[] nums, int index, int totalSum, int subset1) {
        if(index==nums.length){
            return Math.abs(totalSum-2*subset1);
        }
        int chooseSubset1 = minimumDifferenceUtil2(nums,index+1,totalSum, subset1+nums[index]);
        int chooseSubset2 = minimumDifferenceUtil2(nums,index+1, totalSum,  subset1);
        return Math.min(chooseSubset1,chooseSubset2);
    }

    public static int minimumDifference3(int[] nums){
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum<0){
            for(int i=0;i<nums.length;i++) nums[i] *= -1;
            totalSum *=-1;
        }
        int minDifference = Integer.MAX_VALUE;
        for(int i=0;i<=totalSum;i++){
            if(SubsetSumEqualToTarget.isSubsetSumTabulationSpaceOptimised(nums,i)){
                minDifference=Math.min(Math.abs(totalSum-2*i), minDifference);
            }
        }
        return minDifference;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,7,3};
        System.out.println(minimumDifference(nums));
        System.out.println(minimumDifference2(nums));
        System.out.println(minimumDifference3(nums));

        System.out.println("--------------------------------------------");

        int[] nums1 = {-36,36};
        System.out.println(minimumDifference(nums1));
        System.out.println(minimumDifference2(nums1));
        System.out.println(minimumDifference3(nums1));

        System.out.println("--------------------------------------------");

        int[] nums2 = {2,-1,0,4,-2,-9};
        System.out.println(minimumDifference(nums2));
        System.out.println(minimumDifference2(nums2));
        System.out.println(minimumDifference3(nums2));

    }
}
