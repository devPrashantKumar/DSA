package AZStriverPlaylist.Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixInSpiralForm {

    public static List<Integer> spiralFormMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (top + 1 <= bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            if (right - 1 >= left) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static List<Integer> spiralFormMatrix_2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (top + 1 <= bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }

                if (right - 1 >= left) {
                    for (int i = bottom - 1; i >= top + 1; i--) {
                        list.add(matrix[i][left]);
                    }
                }
            }
            
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] input1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(
                "Input : " + Arrays.deepToString(input1) + " Output : " + MatrixInSpiralForm.spiralFormMatrix(input1));

        int[][] input2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(
                "Input : " + Arrays.deepToString(input2) + " Output : " + MatrixInSpiralForm.spiralFormMatrix(input2));

        int[][] input3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println(
                "Input : " + Arrays.deepToString(input3) + " Output : " + MatrixInSpiralForm.spiralFormMatrix(input3));

        System.out.println("------------------------------------------------------------");

        int[][] input11 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(
                "Input : " + Arrays.deepToString(input11) + " Output : " + MatrixInSpiralForm.spiralFormMatrix_2(input11));

        int[][] input21 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(
                "Input : " + Arrays.deepToString(input21) + " Output : " + MatrixInSpiralForm.spiralFormMatrix_2(input21));

        int[][] input31 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println(
                "Input : " + Arrays.deepToString(input31) + " Output : " + MatrixInSpiralForm.spiralFormMatrix_2(input31));
    }
}