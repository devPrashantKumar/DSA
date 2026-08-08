package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class SubsetSumEqualToTarget {
    
    public static boolean isSubsetSum(int[] arr, int target) {
      return isSubsetSumUtil(arr, target, 0);
    }

    public static boolean isSubsetSumUtil(int[] arr, int target, int index) {
      if(index==arr.length){
        return (target==0);
      }
      boolean chooseElement = isSubsetSumUtil(arr, target-arr[index], index+1);
      boolean notChooseElement = isSubsetSumUtil(arr, target, index+1);
      return chooseElement || notChooseElement;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 3};
        int target = 6;
        System.out.println(isSubsetSum(nums, target));

        System.out.println("--------------------------------------------");

        int[] nums1 = {2,3,5};
        int target1 = 6;
        System.out.println(isSubsetSum(nums1, target1));
    }
}
