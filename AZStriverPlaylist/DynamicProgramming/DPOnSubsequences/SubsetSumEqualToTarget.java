package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class SubsetSumEqualToTarget {
    /*
    * Time Complexity : O(2^n)
    * Space Complexity : O(n) , recursion stack space
    */
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

    /*
    * Time Complexity : O(n*target)
    * Space Complexity : O(n*target) + O(n) , dp + recursion stack space
    */
    public static boolean isSubsetSumMemoization(int[] arr, int target) {
      Boolean[][] dp = new Boolean[arr.length][target+1]; 
      isSubsetSumMemoizationUtil(arr, target, 0,dp);
      return dp[0][target];
    }

    public static boolean isSubsetSumMemoizationUtil(int[] arr, int target, int index, Boolean[][] dp) {
      if(index==arr.length){
        return (target==0);
      }
      if(target<0) return false;
      if(dp[index][target]!=null) return dp[index][target];
      boolean chooseElement = isSubsetSumMemoizationUtil(arr, target-arr[index], index+1,dp);
      boolean notChooseElement = isSubsetSumMemoizationUtil(arr, target, index+1,dp);
      return dp[index][target] = (chooseElement || notChooseElement);
    }

    /*
    * Time Complexity : O(n*target)
    * Space Complexity : O(n*target) , dp space
    */
    public static boolean isSubsetSumTabulation(int[] arr, int target) {
      boolean[][] dp = new boolean[arr.length+1][target+1]; 
      for(int i=0;i<=arr.length;i++) dp[i][0]=true;
      for(int i=1;i<=arr.length;i++){
        for(int j=1;j<=target;j++){
          boolean choose = (j-arr[i-1]<0) ? false : dp[i-1][j-arr[i-1]];
          boolean notChoose = dp[i-1][j];
          dp[i][j] = (choose || notChoose);
        }
      }
      return dp[arr.length][target];
    }

    /*
    * Time Complexity : O(n*target)
    * Space Complexity : O(target) , dp space
    */
    public static boolean isSubsetSumTabulationSpaceOptimised(int[] arr, int target) {
      boolean[] dp = new boolean[target+1]; 
      dp[0]=true;
      for(int i=1;i<=arr.length;i++){
        for(int j=target;j>0;j--){
          boolean choose = (j-arr[i-1]<0) ? false : dp[j-arr[i-1]];
          boolean notChoose = dp[j];
          dp[j] = (choose || notChoose);
        }
      }
      return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 3};
        int target = 6;
        System.out.println(isSubsetSum(nums, target));
        System.out.println(isSubsetSumMemoization(nums, target));
        System.out.println(isSubsetSumTabulation(nums, target));
        System.out.println(isSubsetSumTabulationSpaceOptimised(nums, target));

        System.out.println("--------------------------------------------");

        int[] nums1 = {2,3,5};
        int target1 = 6;
        System.out.println(isSubsetSum(nums1, target1));
        System.out.println(isSubsetSumMemoization(nums1, target1));
        System.out.println(isSubsetSumTabulation(nums1, target1));
        System.out.println(isSubsetSumTabulationSpaceOptimised(nums1, target1));


    }
}
