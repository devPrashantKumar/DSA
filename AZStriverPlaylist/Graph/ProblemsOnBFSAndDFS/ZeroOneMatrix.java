package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    static class TripletPair {
        int i,j,dist;
        TripletPair(int i, int j, int dist){
            this.i = i;
            this.j=j;
            this.dist=dist;
        }
    }

    /*
        Your solution is not correct for the 01 Matrix problem. 
        The main issue is that you are performing multiple independent BFS traversals,
        one from each 0, while marking cells as visited permanently. 
        This prevents later BFS traversals from updating distances with shorter paths.
    */
    // public static int[][] updateMatrix(int[][] mat) {
    //     int[][] result = new int[mat.length][mat[0].length];
    //     boolean[][] visited = new boolean[mat.length][mat[0].length];
    //     Queue<TripletPair> queue = new LinkedList<>();
    //     int[] deltaRow = {-1,0,1,0};
    //     int[] deltaColumn = {0,-1,0,1};
    //     for(int i=0;i<mat.length;i++){
    //         for(int j=0;j<mat[i].length;j++){
    //             if(!visited[i][j] && mat[i][j]==0){
    //                 queue.offer(new TripletPair(i, j, 0));
    //                 visited[i][j]=true;
    //                 while(!queue.isEmpty()){
    //                     TripletPair tripletPair = queue.poll();
    //                     result[tripletPair.i][tripletPair.j]=tripletPair.dist;
    //                     for(int k=0;k<4;k++){
    //                         int nextRow = tripletPair.i+deltaRow[k];
    //                         int nextColumn = tripletPair.j+deltaColumn[k];
    //                         if(validPosition(nextRow,nextColumn, mat.length, mat[0].length) && !visited[nextRow][nextColumn] && mat[nextRow][nextColumn]==1){
    //                             queue.offer(new TripletPair(nextRow, nextColumn, tripletPair.dist+1));
    //                             visited[nextRow][nextColumn]=true;
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return result;
    // }
    
    /*
    * Every cell is enqueued once.
    * Time: O(m × n)
    * Space: O(m × n)
    */
    public static int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<TripletPair> queue = new LinkedList<>();
        int[] deltaRow = {-1,0,1,0};
        int[] deltaColumn = {0,-1,0,1};
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    queue.offer(new TripletPair(i, j, 0));
                    visited[i][j]=true;
                }
            }
        }
        while(!queue.isEmpty()){
            TripletPair tripletPair = queue.poll();
            result[tripletPair.i][tripletPair.j]=tripletPair.dist;
            for(int k=0;k<4;k++){
                int nextRow = tripletPair.i+deltaRow[k];
                int nextColumn = tripletPair.j+deltaColumn[k];
                if(validPosition(nextRow,nextColumn, mat.length, mat[0].length) && !visited[nextRow][nextColumn] && mat[nextRow][nextColumn]==1){
                    queue.offer(new TripletPair(nextRow, nextColumn, tripletPair.dist+1));
                    visited[nextRow][nextColumn]=true;
                }
            }
        }
        return result;
    }

    public static boolean validPosition(int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(updateMatrix(new int[][] { { 0,0,0 }, { 0, 1, 0 }, { 0, 0, 0 } })));
        System.out.println(
                Arrays.deepToString(updateMatrix(new int[][] { { 0,0,0 }, { 0, 1, 0 }, { 1,1,1 } })));
    }
}
