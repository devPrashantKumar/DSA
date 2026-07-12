package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.*;

public class NumberOfDistinctIslands {

    static class Pair2{
        int a;
        int b;

        Pair2(int a, int b){
            this.a=a;
            this.b=b;
        }

    }

    static class Pair{
        int a;
        int b;
        char dir;

        Pair(int a, int b, char dir){
            this.a=a;
            this.b=b;
            this.dir=dir;
        }

    }

    //✅ DFS using traversal signature (direction + backtracking)
    public static int numIslandsRecursion(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> uniqueIslands = new HashSet<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    StringBuilder str = new StringBuilder();
                    numIslandsRecursionUtil(grid,visited,i,j,'O',str);
                    uniqueIslands.add(str.toString());
                }
            }
        }
        return uniqueIslands.size();
    }

    public static  void numIslandsRecursionUtil(char[][] grid, boolean[][] visited, int i , int j,char dir, StringBuilder str) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || (grid[i][j]!='1')) return;
        visited[i][j]=true;
        str.append(dir);
        numIslandsRecursionUtil(grid,visited,i-1,j,'U',str);
        numIslandsRecursionUtil(grid,visited,i,j-1,'L',str);
        numIslandsRecursionUtil(grid,visited,i,j+1,'R',str);
        numIslandsRecursionUtil(grid,visited,i+1,j,'D',str);
        str.append('B');
    }

    /*  this approach is wrong BFS
        BFS has no concept of backtracking, so the generated signature is not guaranteed to uniquely identify the island shape
        The traversal-string method is specifically designed for DFS.
        Trying to reproduce it with BFS will not work because:
            BFS explores level by level.
            DFS explores one path completely before returning.

        There is no equivalent of:
            str.append('B');
        in BFS.
    */
    // public static int numIslands(char[][] grid) {
    //     boolean[][] visited = new boolean[grid.length][grid[0].length];
    //     Queue<Pair> queue = new LinkedList<>();
    //     Set<String> uniqueIslands = new HashSet<>();
    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid[i].length;j++){
    //             if(grid[i][j]=='1' && !visited[i][j]){
    //                 StringBuilder str = new StringBuilder();
    //                 queue.offer(new Pair(i, j,'O'));
    //                 visited[i][j]=true;
    //                 while(!queue.isEmpty()){
    //                     Pair vertex = queue.poll();
    //                     str.append(vertex.dir);

    //                     if(vertex.a-1>=0 && grid[vertex.a-1][vertex.b]=='1' && !visited[vertex.a-1][vertex.b]){
    //                             queue.offer(new Pair(vertex.a-1, vertex.b,'U'));
    //                             visited[vertex.a-1][vertex.b]=true;
    //                     }else{
    //                         str.append("'B");
    //                     }

    //                     if(vertex.b-1>=0 && grid[vertex.a][vertex.b-1]=='1' && !visited[vertex.a][vertex.b-1]){
    //                             queue.offer(new Pair(vertex.a, vertex.b-1,'L'));
    //                             visited[vertex.a][vertex.b-1]=true;
    //                     }else{
    //                         str.append("'B");
    //                     }

    //                     if(vertex.b+1<grid[vertex.a].length && grid[vertex.a][vertex.b+1]=='1' && !visited[vertex.a][vertex.b+1]){
    //                             queue.offer(new Pair(vertex.a, vertex.b+1,'R'));
    //                             visited[vertex.a][vertex.b+1]=true;
    //                     }else{
    //                         str.append("'B");
    //                     }

    //                     if(vertex.a+1<grid.length && grid[vertex.a+1][vertex.b]=='1' && !visited[vertex.a+1][vertex.b]){
    //                             queue.offer(new Pair(vertex.a+1, vertex.b,'D'));
    //                             visited[vertex.a+1][vertex.b]=true;
    //                     }else{
    //                         str.append("'B");
    //                     }
    //                 }
    //                 uniqueIslands.add(str.toString());
    //             }
    //         }
    //     }
    //     return uniqueIslands.size();
    // }

    public static int numIslandsBFSRelativeCoordinates(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair2> queue = new LinkedList<>();
        Set<ArrayList<String>> uniqueIslands = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    int startRow = i;
                    int startCol=j;
                    ArrayList<String> list = new ArrayList<>();
                    queue.offer(new Pair2(i, j));
                    visited[i][j]=true;
                    while(!queue.isEmpty()){
                        Pair2 vertex = queue.poll();
                        list.add(coordinateKey(vertex.a-startRow,vertex.b-startCol));

                        if(vertex.a-1>=0 && grid[vertex.a-1][vertex.b]=='1' && !visited[vertex.a-1][vertex.b]){
                                queue.offer(new Pair2(vertex.a-1, vertex.b));
                                visited[vertex.a-1][vertex.b]=true;
                        }

                        if(vertex.b-1>=0 && grid[vertex.a][vertex.b-1]=='1' && !visited[vertex.a][vertex.b-1]){
                                queue.offer(new Pair2(vertex.a, vertex.b-1));
                                visited[vertex.a][vertex.b-1]=true;
                        }

                        if(vertex.b+1<grid[vertex.a].length && grid[vertex.a][vertex.b+1]=='1' && !visited[vertex.a][vertex.b+1]){
                                queue.offer(new Pair2(vertex.a, vertex.b+1));
                                visited[vertex.a][vertex.b+1]=true;
                        }

                        if(vertex.a+1<grid.length && grid[vertex.a+1][vertex.b]=='1' && !visited[vertex.a+1][vertex.b]){
                                queue.offer(new Pair2(vertex.a+1, vertex.b));
                                visited[vertex.a+1][vertex.b]=true;
                        }
                    }
                    uniqueIslands.add(list);
                }
            }
        }
        return uniqueIslands.size();
    }

    public static String coordinateKey(int a, int b){
        return new StringBuilder().append(a).append('_').append(b).toString();
    }

    public static int numIslandsRecursionDFSRelativeCoordinates(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<ArrayList<String>> uniqueIslands = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    ArrayList<String> list = new ArrayList<>();
                    numIslandsRecursionDFSRelativeCoordinatesUtil(grid,visited,i,j,i,j,list);
                    uniqueIslands.add(list);
                }
            }
        }
        return uniqueIslands.size();
    }

    public static  void numIslandsRecursionDFSRelativeCoordinatesUtil(char[][] grid, boolean[][] visited, int i , int j, int startRow, int startCol, ArrayList<String> list) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || (grid[i][j]!='1')) return;
        visited[i][j]=true;
        list.add(coordinateKey(i-startRow, j-startCol));
        numIslandsRecursionDFSRelativeCoordinatesUtil(grid,visited,i-1,j,startRow,startCol,list);
        numIslandsRecursionDFSRelativeCoordinatesUtil(grid,visited,i,j-1,startRow,startCol,list);
        numIslandsRecursionDFSRelativeCoordinatesUtil(grid,visited,i,j+1,startRow,startCol,list);
        numIslandsRecursionDFSRelativeCoordinatesUtil(grid,visited,i+1,j,startRow,startCol,list);
    }

    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //System.out.println("islands : "+numIslands(grid1));
        System.out.println("islands : "+numIslandsRecursion(grid1));
        System.out.println("islands : "+numIslandsBFSRelativeCoordinates(grid1));
        System.out.println("islands : "+numIslandsRecursionDFSRelativeCoordinates(grid1));

        System.out.println("-------------------------------------------------------------");

        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        //System.out.println("islands : "+numIslands(grid2));
        System.out.println("islands : "+numIslandsRecursion(grid2));
        System.out.println("islands : "+numIslandsBFSRelativeCoordinates(grid2));
        System.out.println("islands : "+numIslandsRecursionDFSRelativeCoordinates(grid2));

        System.out.println("-------------------------------------------------------------");

        char[][] grid3 = {{'1','1','0','1','1'},{'1','0','0','0','0'},{'0','0','0','0','1'},{'1','1','0','1','1'}};
        //System.out.println("islands : "+numIslands(grid3));
        System.out.println("islands : "+numIslandsRecursion(grid3));
        System.out.println("islands : "+numIslandsBFSRelativeCoordinates(grid3));
        System.out.println("islands : "+numIslandsRecursionDFSRelativeCoordinates(grid3));

        System.out.println("-------------------------------------------------------------");
    }

}
