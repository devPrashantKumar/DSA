package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    static class Position {
        int row;
        int column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = m > 0 ? image[0].length : 0;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(sr, sc));
        while (!queue.isEmpty()) {
            Position area = queue.poll();
            int row = area.row;
            int column = area.column;
            if (image[row][column] == color)
                continue;
            if (row - 1 >= 0 && image[row - 1][column] == image[row][column]) {
                queue.offer(new Position(row - 1, column));
            }
            if (column + 1 <= n - 1 && image[row][column + 1] == image[row][column]) {
                queue.offer(new Position(row, column + 1));
            }
            if (column - 1 >= 0 && image[row][column - 1] == image[row][column]) {
                queue.offer(new Position(row, column - 1));
            }
            if (row + 1 <= m - 1 && image[row + 1][column] == image[row][column]) {
                queue.offer(new Position(row + 1, column));
            }
            image[row][column] = color;
        }
        return image;
    }

    // using visited
    public static int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = m > 0 ? image[0].length : 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(sr, sc));
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            Position area = queue.poll();
            int row = area.row;
            int column = area.column;
            if (row - 1 >= 0 && image[row - 1][column] == image[row][column] && !visited[row - 1][column]) {
                queue.offer(new Position(row - 1, column));
                visited[row - 1][column] = true;
            }
            if (column + 1 <= n - 1 && image[row][column + 1] == image[row][column] && !visited[row][column + 1]) {
                queue.offer(new Position(row, column + 1));
                visited[row][column + 1] = true;
            }
            if (column - 1 >= 0 && image[row][column - 1] == image[row][column] && !visited[row][column - 1]) {
                queue.offer(new Position(row, column - 1));
                visited[row][column - 1] = true;
            }
            if (row + 1 <= m - 1 && image[row + 1][column] == image[row][column] && !visited[row + 1][column]) {
                queue.offer(new Position(row + 1, column));
                visited[row + 1][column] = true;
            }
            image[row][column] = color;
        }
        return image;
    }

    /*
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n), max recursive stack
     */
    public static void floodFillDFSutil(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = m > 0 ? image[0].length : 0;
        int row = sr;
        int column = sc;
        int sourceColour = image[row][column];
        image[row][column] = color;
        if (row - 1 >= 0 && image[row - 1][column] == sourceColour) {
            floodFillDFSutil(image, row - 1, column, color);
        }
        if (column + 1 <= n - 1 && image[row][column + 1] == sourceColour) {
            floodFillDFSutil(image, row, column + 1, color);
        }
        if (column - 1 >= 0 && image[row][column - 1] == sourceColour) {
            floodFillDFSutil(image, row, column - 1, color);
        }
        if (row + 1 <= m - 1 && image[row + 1][column] == sourceColour) {
            floodFillDFSutil(image, row + 1, column, color);
        }

    }

    public static int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        floodFillDFSutil(image, sr, sc, color);
        return image;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2)));
        System.out.println(
                Arrays.deepToString(floodFill2(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2)));
        System.out.println(
                Arrays.deepToString(floodFillDFS(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2)));
        System.out.println("==============================================================================");
        System.out.println(Arrays.deepToString(floodFill(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 0)));
        System.out.println(Arrays.deepToString(floodFill2(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 0)));
        System.out.println(Arrays.deepToString(floodFillDFS(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 0)));

        System.out.println("==============================================================================");
    }
}
