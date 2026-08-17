package AZStriverPlaylist.SortingAlgorithms;

import java.util.*;

public class InsertionSortClass {
    /* 
     * Time Complexity 
     * Worst/Average case : O(n^2)
     * Best Case : O(n)
     * Space Complexity O(1)
     * In-Place Algorithm
     * Stable Algorithm
     */
    public static int[] insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int element = arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(arr[j]>element){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=element;
        }
        return arr;
    }


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
        int[] arr = {2,3,1,7,3,9,6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("--------------------------------------------");

        int[] arr1 = { 2, 3, 1, 7, 3, 9, 6 };
        recursiveInsertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
