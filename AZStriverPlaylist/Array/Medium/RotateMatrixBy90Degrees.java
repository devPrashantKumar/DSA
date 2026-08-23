package AZStriverPlaylist.Array.Medium;

import java.util.Arrays;

public class RotateMatrixBy90Degrees {

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(n^2)
     */
    public static int[][] rotateMatrixBruteForce(int[][] matrix){
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotatedMatrix[j][n-1-i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * intution : (i,j) -> (j, n-1-i) do this 4 time to rotate element at all 4 edges
     */
    public static int[][] rotateMatrixOptimal(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int row=i;
                int col=j;
                int temp1 = matrix[row][col];
                for(int k=0;k<4;k++){
                    int temp2 = matrix[col][n-1-row];
                    matrix[col][n-1-row]=temp1;
                    temp1=temp2;
                    int tempCol=col;
                    col = n-1-row;
                    row = tempCol;
                }
            }
        }
        return matrix;
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * intution : (i,j) -> (j, n-1-i) do this 4 time to rotate element at all 4 edges
     */
    public static int[][] rotateMatrixOptimal_2(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<(n+1)/2;j++){
                int row=i;
                int col=j;
                int temp1 = matrix[row][col];
                for(int k=0;k<4;k++){
                    int temp2 = matrix[col][n-1-row];
                    matrix[col][n-1-row]=temp1;
                    temp1=temp2;
                    int tempCol=col;
                    col = n-1-row;
                    row = tempCol;
                }
            }
        }
        return matrix;
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * intution : (i,j) -> (j, n-1-i) do this 4 time to rotate element at all 4 edges
     */
    public static int[][] rotateMatrixOptimal_2_2(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2;j++){
                int row=i;
                int col=j;
                int temp1 = matrix[row][col];
                for(int k=0;k<4;k++){
                    int temp2 = matrix[col][n-1-row];
                    matrix[col][n-1-row]=temp1;
                    temp1=temp2;
                    int tempCol=col;
                    col = n-1-row;
                    row = tempCol;
                }
            }
        }
        return matrix;
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * intution : 
     *  - find transpose of matrix
     *  - reverse all rows of matrix
     */
    public static int[][] rotateMatrixMostOptimal(int[][] matrix){
        matrix = transposeMatrixOptimal(matrix);
        matrix = reverseRowsInMatrix(matrix);
        return matrix;
    }

    public static int[][] transposeMatrixOptimal(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    public static int[][] reverseRowsInMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] input1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixBruteForce(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixOptimal(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixOptimal_2(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixOptimal_2_2(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixMostOptimal(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));

        int[][] input12 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixBruteForce(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}})));
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixOptimal(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}})));
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixOptimal_2(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}})));
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixOptimal_2_2(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}})));
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degrees.rotateMatrixMostOptimal(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}})));

    }    
}