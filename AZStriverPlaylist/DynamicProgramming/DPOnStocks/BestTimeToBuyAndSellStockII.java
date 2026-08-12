package AZStriverPlaylist.DynamicProgramming.DPOnStocks;

public class BestTimeToBuyAndSellStockII {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > start) {
                end = prices[i];
                totalProfit += (end - start);
            }
            start = prices[i];
        }
        return totalProfit;
    }

    public static int maxProfitRecursion(int[] prices) {
        return maxProfitRecursionUtil(prices, 0, true);
    }

    public static int maxProfitRecursionUtil(int[] prices, int index, boolean buy) {
        if (index == prices.length)
            return 0;
        if (buy) {
            int buyStock = (-prices[index]) + maxProfitRecursionUtil(prices, index + 1, false);
            int skipStock = maxProfitRecursionUtil(prices, index + 1, true);
            return Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionUtil(prices, index + 1, true);
            int skipStock = maxProfitRecursionUtil(prices, index + 1, false);
            return Math.max(sellStock, skipStock);

        }
    }

    public static int maxProfitRecursionMemoization(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return maxProfitRecursionMemoizationUtil(prices, 0, 1, dp);
    }

    public static int maxProfitRecursionMemoizationUtil(int[] prices, int index, int buy, Integer[][] dp) {
        if (index == prices.length)
            return 0;
        if (dp[index][buy] != null)
            return dp[index][buy];
        if (buy == 1) {
            int buyStock = (-prices[index]) + maxProfitRecursionMemoizationUtil(prices, index + 1, 0, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, index + 1, 1, dp);
            return dp[index][buy] = Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionMemoizationUtil(prices, index + 1, 1, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, index + 1, 0, dp);
            return dp[index][buy] = Math.max(sellStock, skipStock);

        }
    }

    public static int maxProfitRecursionTabulation(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[0][0]=0;
        dp[0][1] = Integer.MIN_VALUE / 2;

        for(int i=1;i<=prices.length;i++){
            dp[i][0] = Math.max(prices[i-1]+dp[i-1][1], dp[i-1][0]);
            dp[i][1] = Math.max(-prices[i-1]+dp[i-1][0], dp[i-1][1]);
        }
        return dp[prices.length][0];
    }

    public static int maxProfitTabulation2(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n + 1][2];

    // dp[i][0] -> cannot buy / holding stock
    // dp[i][1] -> can buy

    for (int i = n - 1; i >= 0; i--) {

        // Can buy
        dp[i][1] = Math.max(
                -prices[i] + dp[i + 1][0],
                dp[i + 1][1]
        );

        // Can sell
        dp[i][0] = Math.max(
                prices[i] + dp[i + 1][1],
                dp[i + 1][0]
        );
    }

    return dp[0][1];
}

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitRecursion(prices));
        System.out.println(maxProfitRecursionMemoization(prices));
        System.out.println(maxProfitRecursionTabulation(prices));
        System.out.println(maxProfitTabulation2(prices));

        System.out.println("-------------------------------");

        int[] prices1 = { 1, 2, 3, 4, 5 };
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfitRecursion(prices1));
        System.out.println(maxProfitRecursionMemoization(prices1));
        System.out.println(maxProfitRecursionTabulation(prices1));
        System.out.println(maxProfitTabulation2(prices1));

        System.out.println("-------------------------------");

        System.out.println("-------------------------------");

        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfitRecursion(prices2));
        System.out.println(maxProfitRecursionMemoization(prices2));
        System.out.println(maxProfitRecursionTabulation(prices2));
        System.out.println(maxProfitTabulation2(prices2));

        System.out.println("-------------------------------");
    }
}
