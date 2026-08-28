package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;

public class LeftRotateArray {
    /*
     * Time Complexity : O(n)
     */
    public static int[] leftRotateBy1(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    /*
     * Time Complexity : O(n*k)
     */
    public static int[] leftRotateByKBruteforce(int[] arr, int k) {
        k = k % arr.length;
        while (k-- > 0) {
            int temp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    /*
     * Time Complexity : O(n+k)
     * Space complexity : O(k)
     */
    public static int[] leftRotateByKBetter(int[] arr, int k) {
        k = k % arr.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }
        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length - k)];
        }
        return arr;
    }

    /*
     * Time Complexity : O(n)
     */
    public static int[] leftRotateByKOptimal(int[] arr, int k) {
        k = k % arr.length;
        for (int i = 0; i < k / 2; i++) {
            swap(arr, i, k - 1 - i);
        }
        for (int i = k; i < k + (arr.length - k) / 2; i++) {
            swap(arr, i, (arr.length - 1) - (i - k));
        }
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
        return arr;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] input1 = { 2, 4, 1, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateBy1(input1)));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKBruteforce(input1, 1)));
        System.out.println("------------------------------------------------------");
        int[] input2 = { 4, 1, 9, 0, 2, 5, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateBy1(input2)));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKBruteforce(input2, 1)));

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        int[] input3 = { 4, 1, 9, 0, 2, 5, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKBruteforce(input3, 3)));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKBruteforce(input3, 10)));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKBetter(input3, 11)));

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        int[] input4 = { 4, 1, 9, 0, 2, 5, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKOptimal(input4, 3)));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKOptimal(input4, 10)));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(LeftRotateArray.leftRotateByKOptimal(input4, 11)));

    }
}
