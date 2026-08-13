package AZStriverPlaylist.DynamicProgramming.DPOnStocks;

public class BestTimeToBuyAndSellStockWithTransactionFees {
    /*
     * Time : O(2^n)
     * Space : O(n), recursion stack space
     */
    public static int maxProfitRecursion(int[] prices, int transactionFee) {
        return maxProfitRecursionUtil(prices, transactionFee, 0, true);
    }

    public static int maxProfitRecursionUtil(int[] prices, int transactionFee, int index, boolean buy) {
        if (index == prices.length)
            return 0;
        if (buy) {
            int buyStock = (-prices[index]) +(-transactionFee) + maxProfitRecursionUtil(prices, transactionFee,index + 1, false);
            int skipStock = maxProfitRecursionUtil(prices, transactionFee,index + 1, true);
            return Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionUtil(prices, transactionFee,index + 1, true);
            int skipStock = maxProfitRecursionUtil(prices, transactionFee,index + 1, false);
            return Math.max(sellStock, skipStock);
        }
    }

    public static int maxProfitRecursionMemoization(int[] prices, int transactionFee) {
        Integer[][] dp = new Integer[prices.length][2];
        return maxProfitRecursionMemoizationUtil(prices, transactionFee,0, 1, dp);
    }

    /*
     * Time : O(2*n)
     * Space : O(2*n)+O(n), dp + recursion stack space
     */
    public static int maxProfitRecursionMemoizationUtil(int[] prices, int transactionFee, int index, int buy, Integer[][] dp) {
        if (index == prices.length)
            return 0;
        if (dp[index][buy] != null)
            return dp[index][buy];
        if (buy == 1) {
            int buyStock = (-prices[index]) +(-transactionFee) + maxProfitRecursionMemoizationUtil(prices, transactionFee,index + 1, 0, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, transactionFee,index + 1, 1, dp);
            return dp[index][buy] = Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionMemoizationUtil(prices, transactionFee,index + 1, 1, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, transactionFee,index + 1, 0, dp);
            return dp[index][buy] = Math.max(sellStock, skipStock);
        }
    }

    /*
     * Time : O(n)
     * Space : O(2*n), dp space
     */
    public static int maxProfitRecursionTabulation(int[] prices, int transactionFee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + (-transactionFee) + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }

    /*
     * Time : O(n)
     * Space : O(1)
     */
    public static int maxProfitSpaceOptimized(int[] prices,int transactionFee) {
        int nextBuy = 0;
        int nextSell = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int buy = Math.max(-prices[i] +(-transactionFee) + nextSell,nextBuy);
            int sell = Math.max(prices[i] + nextBuy,nextSell);

            nextBuy = buy;
            nextSell = sell;
        }
        return nextBuy;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int transactionFee = 2;
        System.out.println(maxProfitRecursion(prices,transactionFee));
        System.out.println(maxProfitRecursionMemoization(prices,transactionFee));
        System.out.println(maxProfitRecursionTabulation(prices,transactionFee));
        System.out.println(maxProfitSpaceOptimized(prices,transactionFee));

        System.out.println("-------------------------------");

        int[] prices1 = {1,3,7,5,10,3};
        int transactionFee1 = 3;
        System.out.println(maxProfitRecursion(prices1,transactionFee1));
        System.out.println(maxProfitRecursionMemoization(prices1,transactionFee1));
        System.out.println(maxProfitRecursionTabulation(prices1,transactionFee1));
        System.out.println(maxProfitSpaceOptimized(prices1,transactionFee1));

        System.out.println("-------------------------------");
    }
}