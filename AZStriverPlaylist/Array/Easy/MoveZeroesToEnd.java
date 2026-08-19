package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;

public class MoveZeroesToEnd {
    /*
     * Time Complexity : O(n)
     */
    public static int[] moveAllZeroesToEnd(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != j) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
        }
        return arr;
    }

    /*
     * Time Complexity : O(n)
     */
    // Hoare's Approach
    public static int[] moveAllZeroesToEndTwoPointer(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < r && arr[l] != 0)
                l++;
            while (l < r && arr[r] == 0)
                r--;

            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input1 = { 2, 0, 0, 7, 8, 0 };
        int[] input11 = { 2, 0, 0, 7, 8, 0 };

        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input1)));
        System.out.println("Input : " + Arrays.toString(input11) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEndTwoPointer(input11)));
        System.out.println("------------------------------------------------------");
        int[] input2 = { 0, 0, 2, 7, 8, 0 };
        int[] input21 = { 0, 0, 2, 7, 8, 0 };

        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input2)));
        System.out.println("Input : " + Arrays.toString(input21) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEndTwoPointer(input21)));
        System.out.println("------------------------------------------------------");
        int[] input3 = { 4, 9, 0, 7, 8, 0 };
        int[] input31 = { 4, 9, 0, 7, 8, 0 };

        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input3)));
        System.out.println("Input : " + Arrays.toString(input31) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEndTwoPointer(input31)));
        System.out.println("------------------------------------------------------");
        int[] input4 = { 0, 2, 0, 7, 8, 0 };
        int[] input41 = { 0, 2, 0, 7, 8, 0 };

        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input4)));
        System.out.println("Input : " + Arrays.toString(input41) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEndTwoPointer(input41)));
        System.out.println("------------------------------------------------------");
    }
}
