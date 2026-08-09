package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    /*
    * Time Complexity : O(2^n)
    * Space Complexity : O(n) , recursion stack space
    */
    public static boolean canPartition(int[] nums) {
        return canPartitionUtil(nums,0, 0, 0);
    }

    public static boolean canPartitionUtil(int[] nums, int index, int subset1, int subset2) {
        if(index==nums.length){
            return (subset1==subset2);
        }
        boolean chooseSubset1 = canPartitionUtil(nums,index+1, subset1+nums[index],subset2);
        boolean chooseSubset2 = canPartitionUtil(nums,index+1, subset1, subset2+nums[index]);
        return chooseSubset1 || chooseSubset2;
    }

    public static boolean canPartition3(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return canPartitionUtil3(nums,0, totalSum, 0);
    }

    public static boolean canPartitionUtil3(int[] nums, int index, int totalSum, int subset1) {
        if(index==nums.length){
            return (totalSum==2*subset1);
        }
        boolean chooseSubset1 = canPartitionUtil3(nums,index+1, totalSum, subset1+nums[index]);
        boolean chooseSubset2 = canPartitionUtil3(nums,index+1, totalSum, subset1);
        return chooseSubset1 || chooseSubset2;
    }

    public static boolean canPartition2(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%2!=0) return false;
        return SubsetSumEqualToTarget.isSubsetSum(nums, totalSum/2);
    }

    public static boolean canPartitionMemoization(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%2!=0) return false;
        return SubsetSumEqualToTarget.isSubsetSumMemoization(nums, totalSum/2);
    }

    public static boolean canPartitionTabulation(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%2!=0) return false;
        return SubsetSumEqualToTarget.isSubsetSumTabulation(nums, totalSum/2);
    }

    public static boolean canPartitionTabulationSpaceOptimized(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%2!=0) return false;
        return SubsetSumEqualToTarget.isSubsetSumTabulationSpaceOptimised(nums, totalSum/2);
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition3(nums));
        System.out.println(canPartition2(nums));
        System.out.println(canPartitionMemoization(nums));
        System.out.println(canPartitionTabulation(nums));
        System.out.println(canPartitionTabulationSpaceOptimized(nums));

        System.out.println("--------------------------------------------");

        int[] nums1 = {1,2,3,5};
        System.out.println(canPartition(nums1));
        System.out.println(canPartition3(nums1));
        System.out.println(canPartition2(nums1));
        System.out.println(canPartitionMemoization(nums1));
        System.out.println(canPartitionTabulation(nums1));
        System.out.println(canPartitionTabulationSpaceOptimized(nums1));


    }
}
