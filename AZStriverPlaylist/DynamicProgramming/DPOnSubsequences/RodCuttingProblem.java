package AZStriverPlaylist.DynamicProgramming.DPOnSubsequences;

public class RodCuttingProblem {
    /*
    * Time Complexity : O(2^n)
    * Space Complexity : O(n) recursion stack space
    */
    public static int rodCutting(int[] price, int n) {
        return rodCuttingUtil(price, n, n);
    }

    public static int rodCuttingUtil(int[] price, int availableRodLength, int rodSize){
        if(rodSize==0) return 0;
        int pickedRod = 0;
        if(availableRodLength-rodSize>=0)
            pickedRod = price[rodSize-1]+rodCuttingUtil(price, availableRodLength-rodSize, rodSize);
        int notPickedRod = rodCuttingUtil(price, availableRodLength, rodSize-1);
        return Math.max(pickedRod, notPickedRod);
    }

    /*
    * Time Complexity : O(n*n)
    * Space Complexity : O(n*n) dp + O(n) recursion stack space
    */
    public static int rodCuttingMemoization(int[] price, int n) {
        Integer[][] dp = new Integer[n+1][n+1]; 
        rodCuttingMemoizationUtil(price, n, n, dp);
        return dp[n][n];
    }

    public static int rodCuttingMemoizationUtil(int[] price, int availableRodLength, int rodSize, Integer[][] dp){
        if(rodSize==0) return 0;

        if(dp[availableRodLength][rodSize]!=null) return dp[availableRodLength][rodSize];
        
        int pickedRod = 0;
        if(availableRodLength-rodSize>=0)
            pickedRod = price[rodSize-1]+rodCuttingMemoizationUtil(price, availableRodLength-rodSize, rodSize, dp);
        int notPickedRod = rodCuttingMemoizationUtil(price, availableRodLength, rodSize-1, dp);
        return dp[availableRodLength][rodSize] = Math.max(pickedRod, notPickedRod);
    }


    /*
    * Time Complexity : O(n*n)
    * Space Complexity : O(n*n) dp space
    */
    public static int rodCuttingTabulation(int[] price, int n) {
        int[][] dp = new int[n+1][n+1]; 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int pickedRod = 0;
                if(j-i>=0)
                    pickedRod = price[i-1]+dp[i][j-i];
                int notPickedRod = dp[i-1][j];
                dp[i][j] = Math.max(pickedRod, notPickedRod);
            }
        }
        return dp[n][n];
    }

    /*
    * Time Complexity : O(n*n)
    * Space Complexity : O(n) dp space
    */
    public static int rodCuttingTabulationSpaceOptimised(int[] price, int n) {
        int[] dp = new int[n+1]; 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int pickedRod = 0;
                if(j-i>=0)
                    pickedRod = price[i-1]+dp[j-i];
                int notPickedRod = dp[j];
                dp[j] = Math.max(pickedRod, notPickedRod);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 8;
        int[] price = {1, 6, 8, 9, 10, 19, 7, 20};
        System.out.println(rodCutting(price, n));
        System.out.println(rodCuttingMemoization(price,n));
        System.out.println(rodCuttingTabulation(price,n));
        System.out.println(rodCuttingTabulationSpaceOptimised(price,n));

        System.out.println("---------------------------------------");

        int n1 = 4;
        int[] price1 = {1, 5, 8, 9};
        System.out.println(rodCutting(price1, n1));
        System.out.println(rodCuttingMemoization(price1,n1));
        System.out.println(rodCuttingTabulation(price1,n1));
        System.out.println(rodCuttingTabulationSpaceOptimised(price1,n1));

        System.out.println("---------------------------------------");
    }
}
