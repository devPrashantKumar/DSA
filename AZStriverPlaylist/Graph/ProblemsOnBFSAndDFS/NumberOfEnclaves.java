package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    private static class Pair {
        int i,j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }

    public static int solveApproach2(int[][] board) {
        boundaryBFS(board);
        int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==1) count++;
            }
        }
        return count;
    }

    public static void boundaryBFS(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int[][] deltaRowCol = {{-1,0,1,0},{0,-1,0,1}};

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(!visited[i][j] && board[i][j]==1 && (i==0 || j==0 || i==board.length-1 || j==board[i].length-1)){
                    queue.offer(new Pair(i,j));
                    visited[i][j]=true;
                    while(!queue.isEmpty()){
                        Pair it = queue.poll();
                        board[it.i][it.j]=0;
                        for(int k=0;k<4;k++){
                            int newRow = deltaRowCol[0][k]+it.i;
                            int newCol = deltaRowCol[1][k]+it.j;
                            if(newRow<0 || newCol<0 || newRow>=board.length || newCol>=board[newRow].length) continue;
                            if(board[newRow][newCol]==1 && !visited[newRow][newCol]){
                                queue.offer(new Pair(newRow, newCol));
                                visited[newRow][newCol]=true;
                            }                           
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] grid10 = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println("grid1 : "+solveApproach2(grid10));
        System.out.println("grid1 : "+Arrays.deepToString(grid10));

        System.out.println("-------------------------------------------------------------");

        int[][] grid20 = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println("grid2 : "+solveApproach2(grid20));
        System.out.println("grid2 : "+Arrays.deepToString(grid20));
        System.out.println("-------------------------------------------------------------");
    }
}
