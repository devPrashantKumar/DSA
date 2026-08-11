package AZStriverPlaylist.DynamicProgramming.DPOnStocks;

public class BestTimeToBuyAndSellStock {
    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1)
    */
    public static int maxProfit(int[] arr) {
        int maxiProfit = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            minimum = Math.min(minimum,arr[i]);
            int profit = arr[i]-minimum;
            maxiProfit = Math.max(maxiProfit, profit);
        }
        return maxiProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println("-------------------------------");

        int[] prices1 = {7,6,4,3,1};
        System.out.println(maxProfit(prices1));
        System.out.println("-------------------------------");
    }
}
