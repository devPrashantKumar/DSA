package AZStriverPlaylist.DynamicProgramming.DPOnSquares;

public class CountSquareSubmatricesWithAllOnes {
 
    /*
    * this is actually O(min(n,m) · n · m · min(n,m)²) = O(n · m · min(n,m)³), 
    * since for each square size i, checking one square costs O(i²). 
    * Roughly O(n³·m) or O(n⁴) on a square matrix — quite expensive. 
    */
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        int count=0;
        for(int i=1;i<=Math.min(n,m);i++){
            for(int j=0;j<n;j++){
                l1 : for(int k=0;k<m;k++){
                    if(j+i>n || k+i>m) continue;
                    for(int row=j;row<j+i;row++){
                        for(int col=k;col<k+i;col++){
                            if(matrix[row][col]==0) continue l1;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    /*
    * Time Complexity  : O(n × m)
    * Space Complexity : O(n × m)
    */
    public static int countSquaresUsingDP(int[][] matrix) {
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        int count=0;
        int[][] dpMatrix = new int[n][m];
        for(int i=0;i<n;i++) dpMatrix[i][0] = matrix[i][0];
        for(int i=0;i<m;i++) dpMatrix[0][i] = matrix[0][i];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==1) {
                    int up = (i-1>=0) ? dpMatrix[i-1][j] : 0;
                    int left = (j-1>=0) ? dpMatrix[i][j-1] : 0;
                    int upLeft = (i-1>=0 && j-1>=0) ? dpMatrix[i-1][j-1] : 0;
                    dpMatrix[i][j] = Math.min(Math.min(up,left), upLeft)+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count+=dpMatrix[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix1 = { { 0,1,1,1 }, { 1,1,1,1 }, {0,1,1,1 } };
        System.out.println(countSquares(matrix1));
        System.out.println(countSquaresUsingDP(matrix1));

        System.out.println("================================================");
        int[][] matrix2 = { {1,0,1 }, { 1,1,0 }, { 1,1,0 } };
        System.out.println(countSquares(matrix2));
        System.out.println(countSquaresUsingDP(matrix2));

        System.out.println("================================================");
    }
}
