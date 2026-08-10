package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class  TargetSum {

    public static int targetSum(int[] nums, int target) {
        return targetSumUtil(target, nums, 0, 0);
    }

    public static int targetSumUtil(int target, int[] nums, int index, int sum) {
        if(index==nums.length) return (sum==target) ? 1 : 0;     
        int addPositive = targetSumUtil(target, nums, index+1, sum + nums[index]);
        int addNegative = targetSumUtil(target, nums, index+1, sum - nums[index]);
        return addNegative + addPositive;
    }

    public static int targetSum2(int[] nums, int target) {
        return targetSumUtil2(target, nums, nums.length-1, 0);
    }

    public static int targetSumUtil2(int target, int[] nums, int index, int sum) {
        if(index<0) return (sum==target) ? 1 : 0;     
        int addPositive = targetSumUtil2(target, nums, index-1, sum + nums[index]);
        int addNegative = targetSumUtil2(target, nums, index-1, sum - nums[index]);
        return addNegative + addPositive;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 1, 5};
        int target = 4;
        System.out.println(targetSum(nums, target));
        System.out.println(targetSum2(nums, target));
        System.out.println(targetSum(nums, target));
        System.out.println(targetSum(nums, target));

        System.out.println("--------------------------------------------");

        int[] nums1 = {1};
        int target1 = 1;
        System.out.println(targetSum(nums1, target1));
        System.out.println(targetSum2(nums1, target1));
        System.out.println(targetSum(nums1, target1));
        System.out.println(targetSum(nums1, target1));


    }
}
