package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class MinimumCoins {

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return -1;
        int minCoinsRequired=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ithCoinSelected = coinChange(coins, amount-coins[i]);
            if(ithCoinSelected!=-1){
                minCoinsRequired = 1+Math.min(minCoinsRequired,ithCoinSelected);
            }
        }
        if(minCoinsRequired==Integer.MAX_VALUE) return -1;
        return minCoinsRequired;
    }

    public static int coinChangeMemoization(int[] coins, int amount) {
        Integer[] dp = new Integer[amount+1];
        coinChangeMemoizationUtil(coins, amount,dp);
        return dp[amount];
    }

    public static int coinChangeMemoizationUtil(int[] coins, int amount, Integer[] dp) {
        if(amount==0) return dp[amount]=0;
        if(amount<0) return -1;
        if(dp[amount]!=null) return dp[amount];
        int minCoinsRequired=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ithCoinSelected = coinChangeMemoizationUtil(coins, amount-coins[i],dp);
            if(ithCoinSelected!=-1){
                minCoinsRequired = 1+Math.min(minCoinsRequired,ithCoinSelected);
            }
        }
        if(minCoinsRequired==Integer.MAX_VALUE) return -1;
        return dp[amount]=minCoinsRequired;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeMemoization(coins, amount));

        System.out.println("--------------------------------------------");

        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChangeMemoization(coins1, amount1));

        System.out.println("--------------------------------------------");

        int[] coins2 = {1};
        int amount2 = 0;
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChangeMemoization(coins2, amount2));

    }

}
