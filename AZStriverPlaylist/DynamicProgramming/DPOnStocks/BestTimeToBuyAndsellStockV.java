package AZStriverPlaylist.DynamicProgramming.DPOnStocks;

public class BestTimeToBuyAndsellStockV {
    /*
     * Time : O(2^n)
     * Space : O(n), recursion stack space
     */
    public static int maxProfitRecursion(int[] prices) {
        return maxProfitRecursionUtil(prices, 0, true);
    }

    public static int maxProfitRecursionUtil(int[] prices, int index, boolean buy) {
        if (index >= prices.length)
            return 0;
        if (buy) {
            int buyStock = (-prices[index]) + maxProfitRecursionUtil(prices, index + 1, false);
            int skipStock = maxProfitRecursionUtil(prices, index + 1, true);
            return Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionUtil(prices, index + 2, true);
            int skipStock = maxProfitRecursionUtil(prices, index + 1, false);
            return Math.max(sellStock, skipStock);
        }
    }

    /*
     * Time : O(2^n)
     * Space : O(n), recursion stack space
     */
    public static int maxProfitRecursion2(int[] prices) {
        return maxProfitRecursionUtil2(prices, 0, 0);
    }

    public static int maxProfitRecursionUtil2(int[] prices, int index, int buy) {
        if (index >= prices.length)
            return 0;
        if (buy==0) {
            int buyStock = (-prices[index]) + maxProfitRecursionUtil2(prices, index + 1, 1);
            int skipStock = maxProfitRecursionUtil2(prices, index + 1, 0);
            return Math.max(buyStock, skipStock);
        } else if(buy==1){
            int sellStock = (prices[index]) + maxProfitRecursionUtil2(prices, index + 1, 2);
            int skipStock = maxProfitRecursionUtil2(prices, index + 1, 1);
            return Math.max(sellStock, skipStock);
        }
        else {
            return maxProfitRecursionUtil2(prices, index + 1, 0);
        }
    }

    public static int maxProfitRecursionMemoization(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return maxProfitRecursionMemoizationUtil(prices, 0, 1, dp);
    }

    /*
     * Time : O(2*n)
     * Space : O(2*n)+O(n), dp + recursion stack space
     */
    public static int maxProfitRecursionMemoizationUtil(int[] prices, int index, int buy, Integer[][] dp) {
        if (index >= prices.length)
            return 0;
        if (dp[index][buy] != null)
            return dp[index][buy];
        if (buy == 1) {
            int buyStock = (-prices[index]) + maxProfitRecursionMemoizationUtil(prices, index + 1, 0, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, index + 1, 1, dp);
            return dp[index][buy] = Math.max(buyStock, skipStock);
        } else {
            int sellStock = (prices[index]) + maxProfitRecursionMemoizationUtil(prices, index + 2, 1, dp);
            int skipStock = maxProfitRecursionMemoizationUtil(prices, index + 1, 0, dp);
            return dp[index][buy] = Math.max(sellStock, skipStock);
        }
    }

    /*
     * Time : O(n)
     * Space : O(2*n), dp space
     */
    public static int maxProfitRecursionTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        dp[n][0] = dp[n][1] = 0;
        dp[n+1][0] = dp[n+1][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }

    /*
     * Time : O(n)
     * Space : O(2*n), dp space
     */
    public static int maxProfitRecursionTabulation2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][3];

        dp[n][0] = dp[n][1] = dp[n][2] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
            dp[i][1] = Math.max(prices[i] + dp[i + 1][2], dp[i + 1][1]);
            dp[i][2] = dp[i + 1][0];

        }
        return dp[0][0];
    }

    /*
     * Time : O(n)
     * Space : O(1)
     */
    public static int maxProfitSpaceOptimized(int[] prices) {
        int nextNextBuy=0;
        int nextBuy = 0;
        int nextSell = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int buy = Math.max(-prices[i] + nextSell,nextBuy);
            int sell = Math.max(prices[i] + nextNextBuy,nextSell);

            nextNextBuy = nextBuy;
            nextBuy = buy;
            nextSell = sell;
        }
        return nextBuy;
    }

    /*
     * Time : O(n)
     * Space : O(1)
     */
    public static int maxProfitSpaceOptimized2(int[] prices) {
        int nextBuy = 0;
        int nextSell = 0;
        int nextCooldown = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int buy = Math.max(-prices[i] + nextSell,nextBuy);
            int sell = Math.max(prices[i] + nextCooldown,nextSell);
            int cooldown = nextBuy;

            nextCooldown = cooldown;
            nextBuy = buy;
            nextSell = sell;
        }
        return nextBuy;
    }

    public static void main(String[] args) {
        int[] prices = { 1,2,3,0,2 };
        System.out.println(maxProfitRecursion(prices));
        System.out.println(maxProfitRecursion2(prices));
        System.out.println(maxProfitRecursionMemoization(prices));
        System.out.println(maxProfitRecursionTabulation(prices));
        System.out.println(maxProfitRecursionTabulation2(prices));
        System.out.println(maxProfitSpaceOptimized(prices));
        System.out.println(maxProfitSpaceOptimized2(prices));

        System.out.println("-------------------------------");

        int[] prices1 = { 1 };
        System.out.println(maxProfitRecursion(prices1));
        System.out.println(maxProfitRecursion2(prices1));
        System.out.println(maxProfitRecursionMemoization(prices1));
        System.out.println(maxProfitRecursionTabulation(prices1));
        System.out.println(maxProfitRecursionTabulation2(prices1));
        System.out.println(maxProfitSpaceOptimized(prices1));
        System.out.println(maxProfitSpaceOptimized2(prices1));

        System.out.println("-------------------------------");

        
    }
}
