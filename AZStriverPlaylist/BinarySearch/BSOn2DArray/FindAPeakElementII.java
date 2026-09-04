package AZStriverPlaylist.BinarySearch.BSOn2DArray;

import java.util.Arrays;

public class FindAPeakElementII {
    // wrong approach
    // public static int[] findPeakGrid(int[][] mat) {
    //     if(mat.length==0) return new int[]{-1,-1};
    //     int n = mat.length;
    //     int m = mat[0].length; 
    //     int rowStart = 0;
    //     int rowEnd = n-1;
    //     int colStart = 0;
    //     int colEnd = m-1;
    //     while(rowStart<=rowEnd && colStart<=colEnd){
    //         int rowMid = rowStart+(rowEnd-rowStart)/2;
    //         int colMid = colStart+(colEnd-colStart)/2;

    //         if(checkPeak(mat,rowMid,colMid)) return new int[]{rowMid,colMid};
    //         if(rowMid-1>=0 && mat[rowMid-1][colMid]>mat[rowMid][colMid]){
    //             rowEnd = rowMid-1;
    //         }
    //         else if(rowMid+1<n && mat[rowMid+1][colMid]>mat[rowMid][colMid]){
    //             rowStart = rowMid+1;
    //         }
    //         else if(colMid-1>=0 && mat[rowMid][colMid-1]>mat[rowMid][colMid]){
    //             colEnd = colMid-1;
    //         }
    //         else{
    //             colStart = colMid+1;
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }

    // public static boolean checkPeak(int[][] mat, int row, int col){
    //     return (
    //         (row-1>=0 && mat[row-1][col]>mat[row][col]) ||
    //         (col-1>=0 && mat[row][col-1]>mat[row][col]) ||
    //         (row+1<mat.length && mat[row+1][col]>mat[row][col]) ||
    //         (col+1<mat[0].length && mat[row][col+1]>mat[row][col]) 
    //     ) ? false : true;
    // }

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;

            // Find maximum element in this column
            int maxRow = 0;
            for (int row = 1; row < n; row++) {
                if (mat[row][midCol] > mat[maxRow][midCol]) {
                    maxRow = row;
                }
            }

            // Check left and right neighbors
            int leftValue = midCol > 0 ? mat[maxRow][midCol - 1] : -1;
            int rightValue = midCol < m - 1 ? mat[maxRow][midCol + 1] : -1;

            // Current element is a peak
            if (mat[maxRow][midCol] > leftValue && mat[maxRow][midCol] > rightValue) {
                return new int[]{maxRow, midCol};
            }

            if (leftValue > mat[maxRow][midCol]) {
                right = midCol - 1;
            }
            else {
                left = midCol + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1,4},{3,2}};
        int[][] nums2 = {{10,20,15},{21,30,14},{7,16,32}};
        int[][] nums3 = {{1,3}};

        System.out.println(Arrays.toString(findPeakGrid(nums1)));
        System.out.println(Arrays.toString(findPeakGrid(nums2)));
        System.out.println(Arrays.toString(findPeakGrid(nums3)));
    }
}
