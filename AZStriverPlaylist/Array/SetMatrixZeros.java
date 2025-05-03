package AZStriverPlaylist.Array;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZeros {
    public static int[][] setZeroesSimpleApproch(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<matrix[i].length;k++){
                        if(matrix[i][k]!=0) matrix[i][k]=Integer.MIN_VALUE;
                    }
                    for(int k=0;k<matrix.length;k++){
                        if(matrix[k][j]!=0) matrix[k][j]=Integer.MIN_VALUE;;
                    }
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==Integer.MIN_VALUE) matrix[i][j]=0;
            }
        }
        return matrix;
    }
    
    public static int[][] setZeroesBetterApproch(int[][] matrix){
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(int i:rows){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=0;
            }
        }
        for(int i:columns){
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }
        return matrix;
    }
    
    public static void main(String[] args) {
        int[][] input1 = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Input : "+Arrays.deepToString(input1)+" Output : "+Arrays.deepToString(SetMatrixZeros.setZeroesSimpleApproch(input1)));
        int[][] input12 = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Input : "+Arrays.deepToString(input12)+" Output : "+Arrays.deepToString(SetMatrixZeros.setZeroesBetterApproch(input12)));
    }
}
