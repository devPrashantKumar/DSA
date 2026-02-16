package AZStriverPlaylist.Recursion;

import java.util.Arrays;

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solveSudokuUtil(board,0);
    }

    public static boolean solveSudokuUtil(char[][] board, int index) {
        int n = board.length;
        if(index==n*n) return true;
        int row = index/n;
        int col = index%n;
        if(board[row][col]!='.'){
            return solveSudokuUtil(board, index+1);
        }
        else{
            for(int i=1;i<=9;i++){
                if(isValidSudoku(board,index,(char)(i+'0'))){
                    board[row][col]=(char)(i+'0');
                    boolean isValidFound = solveSudokuUtil(board, index+1);
                    if(isValidFound) return true;
                    board[row][col]='.';
                }
            }
        }
        return false;
    }

    public static boolean isValidSudoku(char[][] board, int index, char c) {
        int n = board.length;
        int row = index/n;
        int col = index%n;

        for(int i=0;i<n;i++){
            if(board[row][i]==c || board[i][col]==c) return false;
        }

        int rowStart = 3*(row/3);
        int colStart = 3*(col/3);
        for(int i=rowStart;i<rowStart+3;i++){
            for(int j=colStart;j<colStart+3;j++){
                if(board[i][j]==c) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("input : "+Arrays.deepToString(board));
        solveSudoku(board);
        System.out.println("output : "+Arrays.deepToString(board));
    }
}
