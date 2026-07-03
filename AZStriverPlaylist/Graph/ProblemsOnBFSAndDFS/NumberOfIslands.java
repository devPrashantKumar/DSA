package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class Pair{
        int a;
        int b;

        Pair(int a, int b){
            this.a=a;
            this.b=b;
        }

    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int provinces=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    queue.offer(new Pair(i, j));
                    visited[i][j]=true;
                    provinces++;
                    while(!queue.isEmpty()){
                        Pair vertex = queue.poll();

                        if(vertex.a-1>=0 && grid[vertex.a-1][vertex.b]=='1' && !visited[vertex.a-1][vertex.b]){
                                queue.offer(new Pair(vertex.a-1, vertex.b));
                                visited[vertex.a-1][vertex.b]=true;
                        }

                        if(vertex.b-1>=0 && grid[vertex.a][vertex.b-1]=='1' && !visited[vertex.a][vertex.b-1]){
                                queue.offer(new Pair(vertex.a, vertex.b-1));
                                visited[vertex.a][vertex.b-1]=true;
                        }

                        if(vertex.b+1<grid[vertex.a].length && grid[vertex.a][vertex.b+1]=='1' && !visited[vertex.a][vertex.b+1]){
                                queue.offer(new Pair(vertex.a, vertex.b+1));
                                visited[vertex.a][vertex.b+1]=true;
                        }

                        if(vertex.a+1<grid.length && grid[vertex.a+1][vertex.b]=='1' && !visited[vertex.a+1][vertex.b]){
                                queue.offer(new Pair(vertex.a+1, vertex.b));
                                visited[vertex.a+1][vertex.b]=true;
                        }
                    }
                }
            }
        }
        return provinces;
    }


    public static int numIslandsRecursion(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int provinces=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    numIslandsRecursionUtil(grid,visited,i,j);
                    provinces++;
                }
            }
        }
        return provinces;
    }

    public static  void numIslandsRecursionUtil(char[][] grid, boolean[][] visited, int i , int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || (grid[i][j]!='1')) return;
        visited[i][j]=true;
        numIslandsRecursionUtil(grid,visited,i-1,j);
        numIslandsRecursionUtil(grid,visited,i,j-1);
        numIslandsRecursionUtil(grid,visited,i,j+1);
        numIslandsRecursionUtil(grid,visited,i+1,j);
    }

    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println("provinces : "+numIslands(grid1));
        System.out.println("provinces : "+numIslandsRecursion(grid1));
        System.out.println("-------------------------------------------------------------");

        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println("provinces : "+numIslands(grid2));
        System.out.println("provinces : "+numIslandsRecursion(grid2));
        System.out.println("-------------------------------------------------------------");
    }

}
