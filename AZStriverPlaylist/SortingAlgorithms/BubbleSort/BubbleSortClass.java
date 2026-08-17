package AZStriverPlaylist.SortingAlgorithms.BubbleSort;

import java.util.*;

public class BubbleSortClass {
    /*
     * Time Complexity
     * Best Case : O(n) - only one iteration will happen
     * Average/Worst Case : O(n^2)
     * Space Complexity O(1)
     * In-Place Algorithm
     * Stable Algorithm
     */
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            boolean didSwap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap)
                break;
        }
        return arr;
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(n) recursive stack
     */
    public static void recursiveBubbleSort(int[] arr) {
        recursiveBubbleSortUtil(arr, arr.length);
    }

    public static void recursiveBubbleSortUtil(int[] arr, int n) {
        if (n == 1)
            return;
        boolean didSwap=false;
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = true;
            }
        }
        if(didSwap) recursiveBubbleSortUtil(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 7, 3, 9, 6 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("---------------------------------");

        int[] arr1 = { 2, 3, 1, 7, 3, 9, 6 };
        recursiveBubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
