package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

import java.util.Arrays;

public class NinjaTraining {
    /*
     * Time Complexity : O(3^n)
     * Space Complexity : O(n)
     */
    public static int ninjaTraining(int[][] matrix) {
        return ninjaTrainingUtil(matrix, -1, matrix.length - 1);
    }

    public static int ninjaTrainingUtil(int[][] matrix, int lastUsed, int end) {
        if (end < 0)
            return 0;
        int zeroSelect = 0, oneSelect = 0, twoSelect = 0;
        if (lastUsed == -1 || lastUsed == 1 || lastUsed == 2) {
            zeroSelect = matrix[end][0] + ninjaTrainingUtil(matrix, 0, end - 1);
        }
        if (lastUsed == -1 || lastUsed == 0 || lastUsed == 2) {
            oneSelect = matrix[end][1] + ninjaTrainingUtil(matrix, 1, end - 1);
        }
        if (lastUsed == -1 || lastUsed == 0 || lastUsed == 1) {
            twoSelect = matrix[end][2] + ninjaTrainingUtil(matrix, 2, end - 1);
        }
        return Math.max(zeroSelect, Math.max(oneSelect, twoSelect));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)+O(n), (dp + recursive stack)
     */
    public static int ninjaTrainingDPMemoization(int[][] matrix) {
        int[][] dp = new int[matrix.length][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return ninjaTrainingDPMemoizationUtil(matrix, -1, matrix.length - 1, dp);
    }

    public static int ninjaTrainingDPMemoizationUtil(int[][] matrix, int lastUsed, int end, int[][] dp) {
        if (end < 0)
            return 0;
        if (lastUsed != -1 && dp[end][lastUsed] != -1)
            return dp[end][lastUsed];
        int zeroSelect = 0, oneSelect = 0, twoSelect = 0;
        if (lastUsed == -1 || lastUsed == 1 || lastUsed == 2) {
            zeroSelect = matrix[end][0] + ninjaTrainingDPMemoizationUtil(matrix, 0, end - 1, dp);
        }
        if (lastUsed == -1 || lastUsed == 0 || lastUsed == 2) {
            oneSelect = matrix[end][1] + ninjaTrainingDPMemoizationUtil(matrix, 1, end - 1, dp);
        }
        if (lastUsed == -1 || lastUsed == 0 || lastUsed == 1) {
            twoSelect = matrix[end][2] + ninjaTrainingDPMemoizationUtil(matrix, 2, end - 1, dp);
        }
        int result = Math.max(zeroSelect, Math.max(oneSelect, twoSelect));
        if (lastUsed != -1)
            dp[end][lastUsed] = result;
        return result;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n), (dp)
     */
    public static int ninjaTrainingDPTabulation(int[][] matrix) {
        if (matrix==null || matrix.length==0) return 0;
        int[][] dp = new int[matrix.length][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.arraycopy(matrix[0], 0, dp[0], 0, 3);

        for(int i=1;i<matrix.length;i++){
            dp[i][0] = Math.max(matrix[i][0] + dp[i-1][1], matrix[i][0] + dp[i-1][2]);
            dp[i][1] = Math.max(matrix[i][1] + dp[i-1][0], matrix[i][1] + dp[i-1][2]);
            dp[i][2] = Math.max(matrix[i][2] + dp[i-1][0], matrix[i][2] + dp[i-1][1]);
        }

        return  Math.max(dp[matrix.length-1][0], Math.max(dp[matrix.length-1][1], dp[matrix.length-1][2]));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int ninjaTrainingDPTabulationSpaceOptimised(int[][] matrix) {
        if (matrix==null || matrix.length==0) return 0;
        int[][] dp = new int[2][3];
        System.arraycopy(matrix[0], 0, dp[0], 0, 3);

        for(int i=1;i<matrix.length;i++){
            dp[i%2][0] = Math.max(matrix[i][0] + dp[(i-1)%2][1], matrix[i][0] + dp[(i-1)%2][2]);
            dp[i%2][1] = Math.max(matrix[i][1] + dp[(i-1)%2][0], matrix[i][1] + dp[(i-1)%2][2]);
            dp[i%2][2] = Math.max(matrix[i][2] + dp[(i-1)%2][0], matrix[i][2] + dp[(i-1)%2][1]);
        }

        return  Math.max(dp[(matrix.length-1)%2][0], Math.max(dp[(matrix.length-1)%2][1], dp[(matrix.length-1)%2][2]));
    }

    public static void main(String[] args) {
        int[][] matrix1 = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        System.out.println(ninjaTraining(matrix1));
        System.out.println(ninjaTrainingDPMemoization(matrix1));
        System.out.println(ninjaTrainingDPTabulation(matrix1));
        System.out.println(ninjaTrainingDPTabulationSpaceOptimised(matrix1));

        System.out.println("================================================");
        int[][] matrix2 = { { 70, 40, 10 }, { 180, 20, 5 }, { 200, 60, 30 } };
        System.out.println(ninjaTraining(matrix2));
        System.out.println(ninjaTrainingDPMemoization(matrix2));
        System.out.println(ninjaTrainingDPTabulation(matrix2));
        System.out.println(ninjaTrainingDPTabulationSpaceOptimised(matrix2));

        System.out.println("================================================");

        int[][] matrix3 = { };
        System.out.println(ninjaTraining(matrix3));
        System.out.println(ninjaTrainingDPMemoization(matrix3));
        System.out.println(ninjaTrainingDPTabulation(matrix3));
        System.out.println(ninjaTrainingDPTabulationSpaceOptimised(matrix3));

        System.out.println("================================================");
    }
}
