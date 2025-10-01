package AZStriverPlaylist.Array.Medium;

import java.util.Arrays;

public class BestTimeToStockBuyAndSell {
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
        int[] input1 = {7,1,5,3,6,4};

        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+BestTimeToStockBuyAndSell.maxProfit(input1));

        System.out.println("------------------------------------------------------");
        int[] input2 = {7,6,4,3,1};

        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+BestTimeToStockBuyAndSell.maxProfit(input2));
    }
}
