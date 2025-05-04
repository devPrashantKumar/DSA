package AZStriverPlaylist.Array;

import java.util.Arrays;

public class RotateMatrixBy90Degress {

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
    public static void main(String[] args) {
        int[][] input1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degress.rotateMatrixBruteForce(input1)));
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degress.rotateMatrixOptimal(input1)));

        int[][] input12 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degress.rotateMatrixBruteForce(input12)));
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(RotateMatrixBy90Degress.rotateMatrixOptimal(input12)));

    
    }    
}