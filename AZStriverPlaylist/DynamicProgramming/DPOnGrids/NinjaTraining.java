package AZStriverPlaylist.DynamicProgramming.DPOnGrids;

public class NinjaTraining {
    public static int ninjaTraining(int[][] matrix) {
        return ninjaTrainingUtil(matrix, -1, matrix.length - 1);
    }

    public static int ninjaTrainingUtil(int[][] matrix, int lastUsed, int end) {
        if (end < 0)
            return 0;
        int zeroSelect=0,oneSelect=0,twoSelect=0;
        if (lastUsed == -1 || lastUsed == 1 || lastUsed == 2 ) {
            zeroSelect = matrix[end][0] + ninjaTrainingUtil(matrix, 0, end - 1);
        }
        if (lastUsed == -1 || lastUsed == 0 || lastUsed == 2 ) {
            oneSelect = matrix[end][1] + ninjaTrainingUtil(matrix, 1, end - 1);
        }
        if (lastUsed == -1 || lastUsed == 0 || lastUsed == 1 ) {
            twoSelect = matrix[end][2] + ninjaTrainingUtil(matrix, 2, end - 1);
        }
        return Math.max(zeroSelect,Math.max(oneSelect, twoSelect));
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{10, 40, 70},{20,50,80},{30,60,90}};
        System.out.println(ninjaTraining(matrix1));
        System.out.println("================================================");
        int[][] matrix2 = {{70, 40, 10},{180,20,5},{200,60,30}};
        System.out.println(ninjaTraining(matrix2));
        System.out.println("================================================");
    }
}
