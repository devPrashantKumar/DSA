package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    private static class Pair {
        int i,j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }

    public static void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> resultQueue = new LinkedList<>();
        int[][] deltaRowCol = {{-1,0,1,0},{0,-1,0,1}};

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    boolean flag=false;
                    queue.offer(new Pair(i,j));
                    resultQueue.offer(new Pair(i,j));
                    visited[i][j]=true;
                    while(!queue.isEmpty()){
                        Pair it = queue.poll();
                        for(int k=0;k<4;k++){
                            int newRow = deltaRowCol[0][k]+it.i;
                            int newCol = deltaRowCol[1][k]+it.j;
                            if(newRow<0 || newCol<0 || newRow>=board.length || newCol>=board[newRow].length) flag=true;
                            else if(board[newRow][newCol]=='O' && !visited[newRow][newCol]){
                                queue.offer(new Pair(newRow, newCol));
                                resultQueue.offer(new Pair(newRow,newCol));
                                visited[newRow][newCol]=true;
                            }                           
                        }
                    }
                    if(flag){
                        resultQueue.clear();
                    }
                    else{
                        while(!resultQueue.isEmpty()){
                            Pair it = resultQueue.poll();
                            board[it.i][it.j]='X';
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] grid1 = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(grid1);
        System.out.println("provinces : "+Arrays.deepToString(grid1));
        System.out.println("-------------------------------------------------------------");

        char[][] grid2 = {{'X'}};
        solve(grid2);
        System.out.println("provinces : "+Arrays.deepToString(grid2));
        System.out.println("-------------------------------------------------------------");
    }
}
