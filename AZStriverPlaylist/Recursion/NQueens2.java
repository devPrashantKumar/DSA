package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        placeQueen(board, 0, n, result);
        return result;
    }

    public static void placeQueen(boolean[][] board,
            int row,
            int n,
            List<List<String>> result) {

        if (row == n) {
            processBoardAndStoreResult(board, result, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = true;
                placeQueen(board, row + 1, n, result);
                board[row][col] = false;
            }
        }
    }

    public static boolean isValid(boolean[][] board,
            int row,
            int col,
            int n) {

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }

        // upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        // upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j])
                return false;
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
        System.out.println("input : " + n1);
        System.out.println("output : " + solveNQueens(n1));
    }
}
