package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class MinimumCoins {

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return -1;
        int minCoinsRequired=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ithCoinSelected = coinChange(coins, amount-coins[i]);
            if(ithCoinSelected!=-1){
                minCoinsRequired = Math.min(minCoinsRequired, 1+ithCoinSelected);
            }
        }
        if(minCoinsRequired==Integer.MAX_VALUE) return -1;
        return minCoinsRequired;
    }

    public static int coinChange2(int[] coins, int amount) {
        return coinChange2util(coins, amount, 0);
    }

    public static int coinChange2util(int[] coins, int amount, int index) {
        if(index==coins.length) return (amount==0)? 0 :-1;
        if(amount<0) return -1;

        int ithCoinSelected = coinChange2util(coins, amount-coins[index], index);
        int ithCoinNotSelected = coinChange2util(coins, amount, index+1);

        if(ithCoinSelected==-1 && ithCoinNotSelected==-1) return  -1;
        else if(ithCoinSelected==-1) return ithCoinNotSelected;
        else if(ithCoinNotSelected==-1) return ithCoinSelected+1;
        else if(ithCoinNotSelected<=ithCoinSelected) return ithCoinNotSelected;
        else return ithCoinSelected+1;
        
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
                minCoinsRequired = Math.min(minCoinsRequired, 1+ithCoinSelected);
            }
        }
        if(minCoinsRequired==Integer.MAX_VALUE) return dp[amount] = -1;
        return dp[amount]=minCoinsRequired;
    }

    public static int coinChangeTabulation(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) dp[i][0]=0;

        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                int amountBeforeCoinSelection = (j-coins[i]<0) ? -1 :  dp[i][j-coins[i]];
                int amountNoCoinSelection = (i-1<0) ? -1 : dp[i-1][j];
                if(amountBeforeCoinSelection==-1 && amountNoCoinSelection==-1) dp[i][j] = -1;
                else if(amountBeforeCoinSelection==-1) dp[i][j]=amountNoCoinSelection;
                else if(amountNoCoinSelection==-1) dp[i][j]=amountBeforeCoinSelection+1;
                else if(amountNoCoinSelection<=amountBeforeCoinSelection) dp[i][j] = amountNoCoinSelection;
                else dp[i][j] =  amountBeforeCoinSelection+1;
            }
        }
        return dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
        System.out.println(coinChangeMemoization(coins, amount));
        System.out.println(coinChangeTabulation(coins, amount));

        System.out.println("--------------------------------------------");

        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChange2(coins1, amount1));
        System.out.println(coinChangeMemoization(coins1, amount1));
        System.out.println(coinChangeTabulation(coins1, amount1));

        System.out.println("--------------------------------------------");

        int[] coins2 = {1};
        int amount2 = 0;
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChange2(coins2, amount2));
        System.out.println(coinChangeMemoization(coins2, amount2));
        System.out.println(coinChangeTabulation(coins2, amount2));

        System.out.println("--------------------------------------------");

        int[] coins3 = {9, 6, 5, 1};
        int amount3 = 11;
        System.out.println(coinChange(coins3, amount3));
        System.out.println(coinChange2(coins3, amount3));
        System.out.println(coinChangeMemoization(coins3, amount3));
        System.out.println(coinChangeTabulation(coins3, amount3));

    }

}
