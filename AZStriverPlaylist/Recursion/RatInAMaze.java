package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {
    public static List<String> findPath(int[][] grid) {
        List<String> result = new ArrayList<>();
        findPathUtil(grid, 0, 0, new boolean[grid.length][grid.length], new StringBuilder(),result);
        return result;
    }

    public static void findPathUtil(int[][] grid, int row, int col, boolean[][] visited,StringBuilder str, List<String> result) {
        int n = grid.length;
        if(row<0 || col<0 || row>=n || col>=n || visited[row][col] || grid[row][col]==0) return;
        if(row==n-1 && col==n-1){
            result.add(str.toString()); 
            return;
        }
        visited[row][col]=true;
        str.append("U");
        findPathUtil(grid, row-1, col, visited, str, result);
        str.deleteCharAt(str.length()-1);
        str.append("D");
        findPathUtil(grid, row+1, col, visited, str, result);
        str.deleteCharAt(str.length()-1);
        str.append("L");
        findPathUtil(grid, row, col-1, visited, str, result);
        str.deleteCharAt(str.length()-1);
        str.append("R");
        findPathUtil(grid, row, col+1, visited, str, result);
        str.deleteCharAt(str.length()-1);
        visited[row][col]=false;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        System.out.println("input grid : "+ Arrays.deepToString(grid1));
        System.out.println("output : "+ findPath(grid1));
    }
}
