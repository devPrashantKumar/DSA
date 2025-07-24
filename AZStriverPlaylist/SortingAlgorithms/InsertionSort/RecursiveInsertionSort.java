package AZStriverPlaylist.SortingAlgorithms.InsertionSort;

import java.util.Arrays;

public class RecursiveInsertionSort {
    /*
     * Best Case: O(n) — already sorted, no shifting inside the loop
     * Worst/Average Case: O(n²) — because each element may need to be compared with all previous elements
     * Space: O(n) due to recursion
     */
    public static void recursiveInsertionSort(int[] arr) {
        recursiveInsertionSortUtil(arr, 0);
    }

    public static void recursiveInsertionSortUtil(int[] arr, int index) {
        if (index == arr.length)
            return;
        int value = arr[index];
        int i;
        for (i = index - 1; i >= 0; i--) {
            if (arr[i] > value) {
                arr[i + 1] = arr[i];
            } else {
                break;
            }
        }
        arr[i + 1] = value;
        recursiveInsertionSortUtil(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 7, 3, 9, 6 };
        RecursiveInsertionSort.recursiveInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
