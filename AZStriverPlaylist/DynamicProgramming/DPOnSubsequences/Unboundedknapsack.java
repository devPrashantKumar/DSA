package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class Unboundedknapsack {
    public static int knapsack(int W, int[] val, int[] wt) {
        return knapsackUtil(W, val, wt, 0);   
    }

    public static int knapsackUtil(int W, int[] val, int[] wt, int index) {
        if(index==wt.length) return 0;

        int select = 0;
        if(W-wt[index]>=0) select = val[index]+knapsackUtil(W-wt[index], val, wt, index);
        int notSelect = knapsackUtil(W, val, wt, index+1);
        return Math.max(select,notSelect);
    }

    public static int knapsackMemoization(int W, int[] val, int[] wt) {
        Integer[][] dp = new Integer[wt.length][W+1]; 
        knapsackMemoizationUtil(W, val, wt, 0,dp);
        return dp[0][W];
        
    }

    public static int knapsackMemoizationUtil(int W, int[] val, int[] wt, int index, Integer[][] dp) {
        if(index==wt.length) return 0;

        if(dp[index][W]!=null) return dp[index][W];

        int select = 0;
        if(W-wt[index]>=0) select = val[index]+knapsackMemoizationUtil(W-wt[index], val, wt, index,dp);
        int notSelect = knapsackMemoizationUtil(W, val, wt, index+1,dp);
        return dp[index][W] = Math.max(select,notSelect);
    }

    public static int knapsackTabulation(int W, int[] val, int[] wt) {
        int[][] dp = new int[wt.length+1][W+1]; 
        for(int i=1;i<=wt.length;i++){
            for(int j=1;j<=W;j++){
                int select = 0;
                if(j-wt[i-1]>=0) select = val[i-1]+dp[i][j-wt[i-1]];
                int notSelect = dp[i-1][j];
                dp[i][j] = Math.max(select,notSelect);
            }
        }
        return dp[wt.length][W];
    }

    public static int knapsackTabulationSpaceOptimised(int W, int[] val, int[] wt) {
        int[] dp = new int[W+1]; 
        for(int i=1;i<=wt.length;i++){
            for(int j=1;j<=W;j++){
                int select = 0;
                if(j-wt[i-1]>=0) select = val[i-1]+dp[j-wt[i-1]];
                int notSelect = dp[j];
                dp[j] = Math.max(select,notSelect);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 10;
        int[] val = {5, 11, 13};
        int[] wt = {2, 4, 6};
        System.out.println(knapsack(W, val, wt));
        System.out.println(knapsackMemoization(W, val, wt));
        System.out.println(knapsackTabulation(W, val, wt));
        System.out.println(knapsackTabulationSpaceOptimised(W, val, wt));

        System.out.println("---------------------------------------");

        int W1 = 8;
        int[] val1 = {10, 40, 50, 70};
        int[] wt1 = {1, 3, 4, 5};
        System.out.println(knapsack(W1, val1, wt1));
        System.out.println(knapsackMemoization(W1, val1, wt1));
        System.out.println(knapsackTabulation(W1, val1, wt1));
        System.out.println(knapsackTabulationSpaceOptimised(W1, val1, wt1));

        System.out.println("---------------------------------------");

    }
}
