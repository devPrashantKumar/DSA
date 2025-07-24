package AZStriverPlaylist.SortingAlgorithms.BubbleSort;

import java.util.Arrays;

public class RecursiveBubbleSort {
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
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        recursiveBubbleSortUtil(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 7, 3, 9, 6 };
        RecursiveBubbleSort.recursiveBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
