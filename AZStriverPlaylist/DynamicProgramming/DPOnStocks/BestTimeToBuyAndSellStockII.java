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
        for(int i=0;i<prices.length;i++){
            if(prices[i]>start){
                end = prices[i];
                totalProfit += (end-start);
            }
            start = prices[i];
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println("-------------------------------");

        int[] prices1 = {1,2,3,4,5};
        System.out.println(maxProfit(prices1));
        System.out.println("-------------------------------");

        System.out.println("-------------------------------");

        int[] prices2 = {7,6,4,3,1};
        System.out.println(maxProfit(prices2));
        System.out.println("-------------------------------");
    }
}
