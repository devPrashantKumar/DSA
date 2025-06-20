package AZStriverPlaylist.Recursion;

import java.util.Arrays;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(wordExistsUtil(board, word, i, j, 0,visited)) return true;
            }
        }
        return false;
    }

    public static boolean wordExistsUtil(char[][] board, String word, int row, int column, int index, boolean[][] visited){
        if(index==word.length()) return true;
        if(row <0 || column<0 || row>=board.length || column>=board[0].length) return false;
        if(!visited[row][column] && board[row][column]==word.charAt(index)){
            visited[row][column]=true;
            boolean isExists = wordExistsUtil(board, word, row, column+1, index+1, visited) || 
            wordExistsUtil(board, word, row, column-1, index+1, visited) || 
            wordExistsUtil(board, word, row+1, column, index+1, visited) || 
            wordExistsUtil(board, word, row-1, column, index+1, visited);
            visited[row][column]=false;
            return isExists;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Input : "+Arrays.deepToString(board) +", "+word);
        System.out.println("Output : "+WordSearch.exist(board,word));

        char[][] board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word2 = "SEE";
        System.out.println("Input : "+Arrays.deepToString(board2) +", "+word2);
        System.out.println("Output : "+WordSearch.exist(board2,word2));

        char[][] board3 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word3 = "ABCB";
        System.out.println("Input : "+Arrays.deepToString(board3) +", "+word3);
        System.out.println("Output : "+WordSearch.exist(board3,word3));
    }
}
