package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class CoinChangeII {
    // this approach will not work
    // counts permutations, not combinations.
    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 1;
        if(amount<0) return 0;
        int noOfWays=0;
        for(int i=0;i<coins.length;i++){
            noOfWays += coinChange(coins, amount-coins[i]);
            
        }
        return noOfWays;
    }

    public static int coinChange2(int[] coins, int amount) {
        return coinChange2util(coins, amount, 0);
    }

    // this approach will work
    public static int coinChange2util(int[] coins, int amount, int index) {
        if(index==coins.length) return (amount==0)? 1 : 0;
        if(amount<0) return 0;

        int ithCoinSelected = coinChange2util(coins, amount-coins[index], index);
        int ithCoinNotSelected = coinChange2util(coins, amount, index+1);

        return ithCoinNotSelected+ithCoinSelected;
        
    }
    
    // this approach will work
    public static int coinChange2_2(int[] coins, int amount) {
        return coinChange2_2util(coins, amount, coins.length-1);
    }

    // this approach will work if we required number of ways to achieve the amount
    public static int coinChange2_2util(int[] coins, int amount, int index) {
        if(index<0) return (amount==0)? 1 : 0;
        if(amount<0) return 0;

        int ithCoinSelected = coinChange2_2util(coins, amount-coins[index], index);
        int ithCoinNotSelected = coinChange2_2util(coins, amount, index-1);

        return ithCoinNotSelected+ithCoinSelected;
        
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
        System.out.println(coinChange2_2(coins, amount));

        System.out.println("--------------------------------------------");

        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChange2(coins1, amount1));
        System.out.println(coinChange2_2(coins1, amount1));

        System.out.println("--------------------------------------------");

        int[] coins2 = {10};
        int amount2 = 10;
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChange2(coins2, amount2));
        System.out.println(coinChange2_2(coins2, amount2));

        System.out.println("--------------------------------------------");

        int[] coins3 = {9, 6, 5, 1};
        int amount3 = 11;
        System.out.println(coinChange(coins3, amount3));
        System.out.println(coinChange2(coins3, amount3));
        System.out.println(coinChange2_2(coins3, amount3));

    }
}
