package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        List<List<String>> result =new ArrayList<>();
        //for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                placeQueeen(board, 0,j,0,n,result);
            }
        //}
        return result;   
    }

    public static void placeQueeen(boolean board[][] , int row, int col, int queeenNumber, int n, List<List<String>> result){
        if(queeenNumber==n && col==0){
            processBoardAndStoreResult(board,result,n);
            return;
        }
        if(row>=n) return;
        board[row][col]=true;
        boolean queenPlacement = isVaidQueensPlacement(board,row,col,n);
        if(queenPlacement){
            for(int i=0;i<n;i++){
                placeQueeen(board,row+1,i,queeenNumber+1,n,result);
            }
        }
        board[row][col]=false;
    }

    public static boolean isVaidQueensPlacement(boolean[][] board, int row, int col, int n){
        for(int i=0;i<n;i++){
            if(board[row][i] && i!=col) return false;
        }

        for(int i=0;i<n;i++){
            if(board[i][col] && i!=row) return false;
        }

        int i=row, j=col;
        while(i>=0 && j>=0){
            if(board[i][j] && i!=row && j!=col) return false;
            i--;j--;
        }
        i=row; j=col;
        while(i>=0 && j<n){
            if(board[i][j] && i!=row && j!=col) return false;
            i--;j++;
        }

        i=row; j=col;
        while(i<n && j>=0){
            if(board[i][j] && i!=row && j!=col) return false;
            i++;j--;
        }

        i=row; j=col;
        while(i<n && j<n){
            if(board[i][j] && i!=row && j!=col) return false;
            i++;j++;
        }

        return true;
    }

    public static void processBoardAndStoreResult(boolean[][] board, List<List<String>> result, int n){
        List<String> boardRows = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<n;j++){
               if(board[i][j]) str.append("Q");
               else str.append(".");
            }
            boardRows.add(str.toString());
        }
        result.add(boardRows);
    }

    public static void main(String[] args) {
        int n1 = 4;
        System.out.println("input : "+n1);
        System.out.println("output : "+solveNQueens(n1));
    }
}
