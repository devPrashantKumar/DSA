package AZStriverPlaylist.DynamicProgramming.DPOnStocks;

public class BestTimeToBuyAndsellStockIII {

    /*
     * Time : O(2^n)
     * Space : O(n), recursion stack space
     */
    public static int maxProfitRecursion(int[] prices) {
        return maxProfitRecursionUtil(prices, 0, 2, true);
    }

    public static int maxProfitRecursionUtil(int[] prices, int index, int capacity, boolean buy) {
        if (index == prices.length || capacity == 0)
            return 0;
        if (buy) {
            int buyStock = (-prices[index]) + maxProfitRecursionUtil(prices, index + 1, capacity, false);
            int skipStock = maxProfitRecursionUtil(prices, index + 1, capacity, true);
            return Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionUtil(prices, index + 1, capacity - 1, true);
            int skipStock = maxProfitRecursionUtil(prices, index + 1, capacity, false);
            return Math.max(sellStock, skipStock);
        }
    }

    public static int maxProfitRecursionMemoization(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][3][2];
        return maxProfitRecursionMemoizationUtil(prices, 0, 2, 1, dp);
    }

    /*
     * Time : O(2*2*n)
     * Space : O(2*2*n)+O(n), dp + recursion stack space
     */
    public static int maxProfitRecursionMemoizationUtil(int[] prices, int index, int capacity, int buy,
            Integer[][][] dp) {
        if (index == prices.length || capacity == 0)
            return 0;
        if (dp[index][capacity][buy] != null)
            return dp[index][capacity][buy];
        if (buy == 1) {
            int buyStock = (-prices[index]) + maxProfitRecursionMemoizationUtil(prices, index + 1, capacity, 0, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, index + 1, capacity, 1, dp);
            return dp[index][capacity][buy] = Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionMemoizationUtil(prices, index + 1, capacity - 1, 1, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, index + 1, capacity, 0, dp);
            return dp[index][capacity][buy] = Math.max(sellStock, skipStock);
        }
    }

    /*
     * Time : O(n)
     * Space : O(2*2*n), dp space
     */
    public static int maxProfitRecursionTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int cap = 1; cap <= 2; cap++) {
                dp[i][cap][1] = Math.max(-prices[i] + dp[i + 1][cap][0], dp[i + 1][cap][1]);
                dp[i][cap][0] = Math.max(prices[i] + dp[i + 1][cap - 1][1], dp[i + 1][cap][0]);
            }

        }
        return dp[0][2][1];
    }

    /*
     * Time : O(n)
     * Space : O(1)
     */
    public static int maxProfitSpaceOptimized(int[] prices) {
        int nextBuy2 = 0;
        int nextSell2 = 0;

        int nextBuy1 = 0;
        int nextSell1 = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            int buy2 = Math.max(-prices[i] + nextSell2, nextBuy2);
            int sell2 = Math.max(prices[i] + nextBuy1, nextSell2);
            int buy1 = Math.max(-prices[i] + nextSell1, nextBuy1);
            int sell1 = Math.max(prices[i] + 0, nextSell1);

            nextBuy2 = buy2;
            nextSell2 = sell2;

            nextBuy1 = buy1;
            nextSell1 = sell1;
        }
        return nextBuy2;
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfitRecursion(prices));
        System.out.println(maxProfitRecursionMemoization(prices));
        System.out.println(maxProfitRecursionTabulation(prices));
        System.out.println(maxProfitSpaceOptimized(prices));

        System.out.println("-------------------------------");

        int[] prices1 = { 1, 2, 3, 4, 5 };
        System.out.println(maxProfitRecursion(prices1));
        System.out.println(maxProfitRecursionMemoization(prices1));
        System.out.println(maxProfitRecursionTabulation(prices1));
        System.out.println(maxProfitSpaceOptimized(prices1));

        System.out.println("-------------------------------");

        System.out.println("-------------------------------");

        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfitRecursion(prices2));
        System.out.println(maxProfitRecursionMemoization(prices2));
        System.out.println(maxProfitRecursionTabulation(prices2));
        System.out.println(maxProfitSpaceOptimized(prices2));

        System.out.println("-------------------------------");
    }
}
