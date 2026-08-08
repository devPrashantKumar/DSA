package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

import java.util.Arrays;

public class NinjaAndHisFriends {
    /*
     * Time Complexity : O(2^(m+n))
     * Space Complexity : O(m+n) recursion stack depth
     */
    public static int maxChocolates(int[][] grid) {
        return maxChocolatesUtil(0, 0, 0, grid[0].length-1, grid);
    }

    public static int maxChocolatesUtil(int row1, int col1, int row2, int col2, int[][] grid) {
        int[] index = {-1,0,1};
        int maxCollected=0;
        if (row1 >= grid.length || col1 >= grid[0].length || col2>= grid[0].length || row2>=grid.length || col2<0 || col1<0) return 0;
        int chocolates=0;
        if(row1==row2 && col1==col2)
            chocolates+=grid[row1][col1];
        else{
            chocolates+=grid[row1][col1];
            chocolates+=grid[row2][col2];
        }
        for(int i=0;i<index.length;i++){
            for(int j=0;j<index.length;j++){
                int collected = maxChocolatesUtil(row1+1, col1+index[i], row2+1, col2+index[j],grid);
                maxCollected = Math.max(collected,maxCollected);
            }
        }
        return maxCollected+chocolates;   
    }

    public static int maxChocolates2(int[][] grid) {
        return maxChocolatesUtil2(0, 0, grid[0].length-1, grid);
    }

    public static int maxChocolatesUtil2(int row, int col1, int col2, int[][] grid) {
        int[] index = {-1,0,1};
        int maxCollected=0;
        if (row >= grid.length || col1 >= grid[0].length || col2>= grid[0].length || col2<0 || col1<0) return 0;
        int chocolates=0;
        if(col1==col2)
            chocolates+=grid[row][col1];
        else{
            chocolates+=grid[row][col1];
            chocolates+=grid[row][col2];
        }
        for(int i=0;i<index.length;i++){
            for(int j=0;j<index.length;j++){
                int collected = maxChocolatesUtil2(row+1, col1+index[i], col2+index[j],grid);
                maxCollected = Math.max(collected,maxCollected);
            }
        }
        return maxCollected+chocolates;   
    }

    public static int maxChocolatesMemoization(int[][] grid) {
        int[][][][] dp = new int[grid.length][grid[0].length][grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                for(int k=0;k<dp[i][j].length;k++){
                    for(int l=0;l<dp[i][j][k].length;l++){
                        dp[i][j][k][l]=-1;
                    }
                }
            }
        }
        return maxChocolatesMemoizationUtil(0, 0, 0, grid[0].length-1, grid,dp);
    }

    public static int maxChocolatesMemoizationUtil(int row1, int col1, int row2, int col2, int[][] grid,int[][][][] dp) {
        int[] index = {-1,0,1};
        int maxCollected=0;
        if (row1 >= grid.length || col1 >= grid[0].length || col2>= grid[0].length || row2>=grid.length || col2<0 || col1<0) return 0;
        if(dp[row1][col1][row2][col2]!=-1) return dp[row1][col1][row2][col2];

        int chocolates=0;
        if(row1==row2 && col1==col2)
            chocolates+=grid[row1][col1];
        else{
            chocolates+=grid[row1][col1];
            chocolates+=grid[row2][col2];
        }
        for(int i=0;i<index.length;i++){
            for(int j=0;j<index.length;j++){
                int collected = maxChocolatesMemoizationUtil(row1+1, col1+index[i], row2+1, col2+index[j],grid,dp);
                maxCollected = Math.max(collected,maxCollected);
            }
        }
        dp[row1][col1][row2][col2] = maxCollected+chocolates;  
        return dp[row1][col1][row2][col2];
    }

    public static int maxChocolatesMemoization2(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                for(int k=0;k<dp[i][j].length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return maxChocolatesMemoizationUtil2(0, 0, grid[0].length-1, grid,dp);
    }

    public static int maxChocolatesMemoizationUtil2(int row, int col1, int col2, int[][] grid,int[][][] dp) {
        int[] index = {-1,0,1};
        int maxCollected=0;
        if (row >= grid.length || col1 >= grid[0].length || col2>= grid[0].length || col2<0 || col1<0) return 0;
        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];

        int chocolates=0;
        if(col1==col2)
            chocolates+=grid[row][col1];
        else{
            chocolates+=grid[row][col1];
            chocolates+=grid[row][col2];
        }
        for(int i=0;i<index.length;i++){
            for(int j=0;j<index.length;j++){
                int collected = maxChocolatesMemoizationUtil2(row+1, col1+index[i], col2+index[j],grid,dp);
                maxCollected = Math.max(collected,maxCollected);
            }
        }
        dp[row][col1][col2] = maxCollected+chocolates;  
        return dp[row][col1][col2];
    }

    public static void main(String[] args) {

        int [][] grid = {{2, 3, 1, 2},{3, 4, 2, 2},{5, 6, 3, 5}};
        System.out.println(maxChocolates(grid));
        System.out.println(maxChocolates2(grid));

        System.out.println(maxChocolatesMemoization(grid));
        System.out.println(maxChocolatesMemoization2(grid));

        System.out.println("================================================");

        int [][] grid1 = {{1,2},{3,4}};
        System.out.println(maxChocolates(grid1));
        System.out.println(maxChocolates2(grid1));

        System.out.println(maxChocolatesMemoization(grid1));
        System.out.println(maxChocolatesMemoization2(grid1));

        System.out.println("================================================");
    }
}