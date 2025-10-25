package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Position {
        int row;
        int column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    /*
     * Bruteforce Approach
     * Time Complexity : O((m * n)^2)
     * Space Complexity : O(1)
     */
    public static int orangesRotting(int[][] grid) {
        int time = -1;
        boolean flag = false;
        boolean freshExists = false;
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;

        do {
            time++;
            freshExists = false;
            flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        freshExists = true;
                        if ((i - 1 >= 0 && grid[i - 1][j] == 2)
                                || (i + 1 <= m - 1 && grid[i + 1][j] == 2)
                                || (j - 1 >= 0 && grid[i][j - 1] == 2)
                                || (j + 1 <= n - 1 && grid[i][j + 1] == 2)) {
                            grid[i][j] = 3;
                            flag = true;
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 3)
                        grid[i][j] = 2;
                }
            }
        } while (flag);
        return (freshExists) ? -1 : time;
    }

    /*
     * Bruteforce Approach
     * Time Complexity : O((m * n)^2)
     * Space Complexity : O(1)
     */
    public static int orangesRotting2(int[][] grid) {
        int time = -1;
        boolean flag = false;
        boolean freshExists = false;
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;

        do {
            time++;
            freshExists = false;
            flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 3;
                            flag = true;
                        }
                        if (j + 1 <= n - 1 && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 3;
                            flag = true;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 3;
                            flag = true;
                        }
                        if (i + 1 <= m - 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 3;
                            flag = true;
                        }

                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 3)
                        grid[i][j] = 2;
                    if (grid[i][j] == 1)
                        freshExists = true;
                }
            }
        } while (flag);
        return (freshExists) ? -1 : time;
    }

    /*
     * Optimised Approach
     * Time Complexity : O((m * n))
     * Space Complexity : O(m*n)
     */
    public static int orangesRottingUsingBFS(int[][] grid) {
        int time = -1;
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;
        boolean freshExists = false;
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new Position(i, j));
                if (grid[i][j] == 1)
                    freshExists = true;
            }
        }
        if(!freshExists) return 0;
        while (!queue.isEmpty()) {
            time++;
            int rotten = queue.size();
            for (int i = 0; i < rotten; i++) {
                Position rottenPosition = queue.poll();
                int row = rottenPosition.row;
                int column = rottenPosition.column;
                if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                    grid[row - 1][column] = 2;
                    queue.offer(new Position(row - 1, column));
                }
                if (column + 1 <= n - 1 && grid[row][column + 1] == 1) {
                    grid[row][column + 1] = 2;
                    queue.offer(new Position(row, column + 1));
                }
                if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                    grid[row][column - 1] = 2;
                    queue.offer(new Position(row, column - 1));
                }
                if (row + 1 <= m - 1 && grid[row + 1][column] == 1) {
                    grid[row + 1][column] = 2;
                    queue.offer(new Position(row + 1, column));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
        System.out.println(orangesRotting2(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
        System.out.println(orangesRottingUsingBFS(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));

        System.out.println("---------------------------------------------");
        System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
        System.out.println(orangesRotting2(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
        System.out.println(orangesRottingUsingBFS(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));

        System.out.println("---------------------------------------------");

        System.out.println(orangesRotting(new int[][] { { 0, 2 } }));
        System.out.println(orangesRotting2(new int[][] { { 0, 2 } }));
        System.out.println(orangesRotting2(new int[][] { { 0, 2 } }));

        System.out.println("---------------------------------------------");
        System.out.println(orangesRotting(new int[][] { { 0 } }));
        System.out.println(orangesRotting2(new int[][] { { 0 } }));
        System.out.println(orangesRotting2(new int[][] { { 0 } }));

        System.out.println("---------------------------------------------");
    }
}