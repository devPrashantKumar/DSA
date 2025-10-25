package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

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
            if(image[row][column]==color) continue;
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
}
