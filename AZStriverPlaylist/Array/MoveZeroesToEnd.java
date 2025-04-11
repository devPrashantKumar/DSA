package AZStriverPlaylist.Array;

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

    public static void main(String[] args) {
        int[] input1 = { 2, 0, 0, 7, 8, 0 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input1)));
        System.out.println("------------------------------------------------------");
        int[] input2 = { 0, 0, 2, 7, 8, 0 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input2)));
        System.out.println("------------------------------------------------------");
        int[] input3 = { 4, 9, 0, 7, 8, 0 };
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input3)));
        System.out.println("------------------------------------------------------");
        int[] input4 = { 0, 2, 0, 7, 8, 0 };
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(MoveZeroesToEnd.moveAllZeroesToEnd(input4)));
        System.out.println("------------------------------------------------------");
    }
}
