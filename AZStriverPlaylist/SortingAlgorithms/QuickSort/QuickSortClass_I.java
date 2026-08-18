package AZStriverPlaylist.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class QuickSortClass_I {
    /*
     * Time Complexity : O(n log n), worst case (n^2)
     * Space Complexity : O(1)
     * Inplace Sorting Algo
     * Unstable Sorting Algo
     */
    public static int[] quickSort(int[] arr) {
        quickSortUtil(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSortUtil(int[] arr, int start, int end) {
        if (start < end) {
            randomizePartition(arr,start,end);
            int partitionPosition = partition(arr, start, end);
            quickSortUtil(arr, start, partitionPosition - 1);
            quickSortUtil(arr, partitionPosition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start]; 
        int left = start+1;
        int right = end;

        while (left <= right) {
            if(arr[left]<=pivot) {
                arr[left-1]=arr[left];
                left++;
            }
            else {
                swap(arr,left,right);
                right--;
            }
        }
        arr[right]=pivot;
        return right;
    }

    private static void randomizePartition(int[] arr, int start, int end){
        int random = (int)(Math.random()*(end-start+1))+start;
        swap(arr, random, start);
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp; 
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,7,2,9,6};
        QuickSortClass.quickSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2,3,1,7,9,6,3};
        QuickSortClass.quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
