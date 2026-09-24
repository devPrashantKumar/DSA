package AZStriverPlaylist.Recursion.HardProblems;

import java.util.Arrays;

public class SudokuSolver2 {

    // more optimised , will take less recursion stack space, because we are calling recursion when it is required only
    public static void solveSudoku(char[][] board) {
        solveSudokuUtil(board,0);
    }

    public static boolean solveSudokuUtil(char[][] board, int index) {
        int n = board.length;
        if(index==n*n) return true;
        
        for(int i=index;i<n*n;i++){
            int row = i/n;
            int col = i%n;
            if(board[row][col]=='.'){
                for(int k=1;k<=9;k++){
                    if(isValidSudoku(board,i,(char)(k+'0'))){
                            board[row][col]=(char)(k+'0');
                            boolean isValidFound = solveSudokuUtil(board, i+1);
                            if(isValidFound) return true;
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            
        }
        return true;
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
