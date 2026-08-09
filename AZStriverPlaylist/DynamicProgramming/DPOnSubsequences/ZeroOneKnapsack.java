package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class ZeroOneKnapsack {
    
    /*
    * Time Complexity : O(2^n)
    * Space Complexity : O(n) , recursion stack space
    */
    public static int knapsack(int W, int[] val, int[] wt) {
        return knapsackUtil(W, val, wt, 0);   
    }

    public static int knapsackUtil(int W, int[] val, int[] wt, int index) {
        if(index==wt.length) return 0;

        int select = 0;
        if(W-wt[index]>=0) select = val[index]+knapsackUtil(W-wt[index], val, wt, index+1);
        int notSelect = knapsackUtil(W, val, wt, index+1);
        return Math.max(select,notSelect);
    }

    /*
    * Time Complexity : O(n*W)
    * Space Complexity : O(n*W) + O(n) , dp + recursion stack space
    */
    public static int knapsackMemoization(int W, int[] val, int[] wt) {
        Integer[][] dp = new Integer[wt.length][W+1]; 
        knapsackMemoizationUtil(W, val, wt, 0,dp);
        return dp[0][W];
        
    }

    public static int knapsackMemoizationUtil(int W, int[] val, int[] wt, int index, Integer[][] dp) {
        if(index==wt.length) return 0;

        if(dp[index][W]!=null) return dp[index][W];

        int select = 0;
        if(W-wt[index]>=0) select = val[index]+knapsackMemoizationUtil(W-wt[index], val, wt, index+1,dp);
        int notSelect = knapsackMemoizationUtil(W, val, wt, index+1,dp);
        return dp[index][W] = Math.max(select,notSelect);
    }


    /*
    * Time Complexity : O(n*W)
    * Space Complexity : O(n*W) , dp space
    */
    public static int knapsackTabulation(int W, int[] val, int[] wt) {
        int[][] dp = new int[wt.length+1][W+1]; 
        for(int i=1;i<=wt.length;i++){
            for(int j=1;j<=W;j++){
                int select = 0;
                if(j-wt[i-1]>=0) select = val[i-1]+dp[i-1][j-wt[i-1]];
                int notSelect = dp[i-1][j];
                dp[i][j] = Math.max(select,notSelect);
            }
        }
        return dp[wt.length][W];
    }

     /*
    * Time Complexity : O(n*W)
    * Space Complexity : O(W) , dp space
    */
    public static int knapsackTabulationSpaceOptimised(int W, int[] val, int[] wt) {
        int[] dp = new int[W+1]; 
        for(int i=1;i<=wt.length;i++){
            for(int j=W;j>0;j--){
                int select = 0;
                if(j-wt[i-1]>=0) select = val[i-1]+dp[j-wt[i-1]];
                int notSelect = dp[j];
                dp[j] = Math.max(select,notSelect);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 4;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        System.out.println(knapsack(W, val, wt));
        System.out.println(knapsackMemoization(W, val, wt));
        System.out.println(knapsackTabulation(W, val, wt));
        System.out.println(knapsackTabulationSpaceOptimised(W, val, wt));

        System.out.println("---------------------------------------");

        int W1 = 3;
        int[] val1 = {1, 2, 3};
        int[] wt1 = {4, 5, 6};
        System.out.println(knapsack(W1, val1, wt1));
        System.out.println(knapsackMemoization(W1, val1, wt1));
        System.out.println(knapsackTabulation(W1, val1, wt1));
        System.out.println(knapsackTabulationSpaceOptimised(W1, val1, wt1));

        System.out.println("---------------------------------------");

        int W2 = 5;
        int[] val2 = {10, 40, 30, 50};
        int[] wt2 = {5, 4, 2, 3};
        System.out.println(knapsack(W2, val2, wt2));
        System.out.println(knapsackMemoization(W2, val2, wt2));
        System.out.println(knapsackTabulation(W2, val2, wt2));
        System.out.println(knapsackTabulationSpaceOptimised(W2, val2, wt2));

        System.out.println("---------------------------------------");
    }

}
