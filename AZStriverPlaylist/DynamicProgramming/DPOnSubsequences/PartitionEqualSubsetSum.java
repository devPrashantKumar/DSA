package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class PartitionEqualSubsetSum {

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

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));

        System.out.println("--------------------------------------------");

        int[] nums1 = {1,2,3,5};
        System.out.println(canPartition(nums1));
    }
}
