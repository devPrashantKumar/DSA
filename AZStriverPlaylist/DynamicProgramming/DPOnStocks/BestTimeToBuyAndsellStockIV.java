package AZStriverPlaylist.DynamicProgramming.DPOnStocks;

public class BestTimeToBuyAndsellStockIV {
    /*
     * Time : O(2^n)
     * Space : O(n), recursion stack space
     */
    public static int maxProfitRecursion(int[] prices, int capacity) {
        return maxProfitRecursionUtil(prices, 0, capacity, true);
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

    public static int maxProfitRecursionMemoization(int[] prices, int capacity) {
        Integer[][][] dp = new Integer[prices.length][capacity + 1][2];
        return maxProfitRecursionMemoizationUtil(prices, 0, capacity, 1, dp);
    }

    /*
     * Time : O(2*k*n)
     * Space : O(2*k*n)+O(n), dp + recursion stack space
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
     * Time : O(k*n)
     * Space : O(2*k*n), dp space
     */
    public static int maxProfitRecursionTabulation(int[] prices, int capacity) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][capacity + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int cap = 1; cap <= capacity; cap++) {
                dp[i][cap][1] = Math.max(-prices[i] + dp[i + 1][cap][0], dp[i + 1][cap][1]);
                dp[i][cap][0] = Math.max(prices[i] + dp[i + 1][cap - 1][1], dp[i + 1][cap][0]);
            }

        }
        return dp[0][capacity][1];
    }

    /*
     * Time : O(k*n)
     * Space : O(k), dp space
     */
    public static int maxProfitSpaceOptimized(int[] prices, int capacity) {
        int[] nextBuy = new int[capacity + 1];
        int[] nextSell = new int[capacity + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            int[] currBuy = new int[capacity + 1];
            int[] currSell = new int[capacity + 1];

            for (int cap = 1; cap <= capacity; cap++) {
                currBuy[cap] = Math.max(-prices[i] + nextSell[cap], nextBuy[cap]);
                currSell[cap] = Math.max(prices[i] + nextBuy[cap - 1], nextSell[cap]);
            }
            nextBuy = currBuy;
            nextSell = currSell;
        }
        return nextBuy[capacity];
    }

    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };
        int capacity = 2;
        System.out.println(maxProfitRecursion(prices, capacity));
        System.out.println(maxProfitRecursionMemoization(prices, capacity));
        System.out.println(maxProfitRecursionTabulation(prices, capacity));
        System.out.println(maxProfitSpaceOptimized(prices, capacity));

        System.out.println("-------------------------------");

        int[] prices1 = { 3, 2, 6, 5, 0, 3 };
        int capacity1 = 2;
        System.out.println(maxProfitRecursion(prices1, capacity1));
        System.out.println(maxProfitRecursionMemoization(prices1, capacity1));
        System.out.println(maxProfitRecursionTabulation(prices1, capacity1));
        System.out.println(maxProfitSpaceOptimized(prices1, capacity1));

        System.out.println("-------------------------------");

    }
}
