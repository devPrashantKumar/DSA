package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class CountSubsetsWithSumK {
    /*
    * Time Complexity : O(2^n)
    * Space Complexity : O(n) , recursion stack space
    */
    public static int perfectSum(int[] arr, int target) {
      return perfectSumUtil(arr, target, 0);
    }

    public static int perfectSumUtil(int[] arr, int target, int index) {
      if(index==arr.length){
        return (target==0) ? 1 : 0;
      }
      int chooseElement = perfectSumUtil(arr, target-arr[index], index+1);
      int notChooseElement = perfectSumUtil(arr, target, index+1);
      return chooseElement + notChooseElement;
    }

    /*
    * Time Complexity : O(n*target)
    * Space Complexity : O(n*target) + O(n) , dp + recursion stack space
    */
    public static int perfectSumMemoization(int[] arr, int target) {
      Integer[][] dp = new Integer[arr.length][target+1]; 
      perfectSumMemoizationUtil(arr, target, 0,dp);
      return dp[0][target];
    }

    public static int perfectSumMemoizationUtil(int[] arr, int target, int index, Integer[][] dp) {
      if(index==arr.length){
        return (target==0) ? 1 : 0;
      }
      if(target<0) return 0;
      if(dp[index][target]!=null) return dp[index][target];
      int chooseElement = perfectSumMemoizationUtil(arr, target-arr[index], index+1,dp);
      int notChooseElement = perfectSumMemoizationUtil(arr, target, index+1,dp);
      return dp[index][target] = (chooseElement +  notChooseElement);
    }

    /*
    * Time Complexity : O(n*target)
    * Space Complexity : O(n*target) , dp space
    */
    public static int perfectSumTabulation(int[] arr, int target) {
      int[][] dp = new int[arr.length+1][target+1]; 
      for(int i=0;i<=arr.length;i++) dp[i][0]=1;
      for(int i=1;i<=arr.length;i++){
        for(int j=1;j<=target;j++){
          int choose = (j-arr[i-1]<0) ? 0 : dp[i-1][j-arr[i-1]];
          int notChoose = dp[i-1][j];
          dp[i][j] = (choose + notChoose);
        }
      }
      return dp[arr.length][target];
    }

    /*
    * Time Complexity : O(n*target)
    * Space Complexity : O(target) , dp space
    */
    public static int perfectSumTabulationSpaceOptimised(int[] arr, int target) {
      int[] dp = new int[target+1]; 
      dp[0]=1;
      for(int i=1;i<=arr.length;i++){
        for(int j=target;j>0;j--){
          int choose = (j-arr[i-1]<0) ? 0 : dp[j-arr[i-1]];
          int notChoose = dp[j];
          dp[j] = (choose + notChoose);
        }
      }
      return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 16, 8, 10};
        int target = 10;
        System.out.println(perfectSum(nums, target));
        System.out.println(perfectSumMemoization(nums, target));
        System.out.println(perfectSumTabulation(nums, target));
        System.out.println(perfectSumTabulationSpaceOptimised(nums, target));

        System.out.println("--------------------------------------------");

        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 5;
        System.out.println(perfectSum(nums1, target1));
        System.out.println(perfectSumMemoization(nums1, target1));
        System.out.println(perfectSumTabulation(nums1, target1));
        System.out.println(perfectSumTabulationSpaceOptimised(nums1, target1));


    }
}
