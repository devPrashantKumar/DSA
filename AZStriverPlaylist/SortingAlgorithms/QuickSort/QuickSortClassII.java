package AZStriverPlaylist.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class QuickSortClassII {
    /*
     * Time Complexity : 
     * average case - O(n log n), 
     * worst case (n^2)) when pivot is smallest or largest element each time
     * Space Complexity : 
     * average case  - O(log n) , recursive stack when pivot is around mid
     * worst case - O(n), recursive stack when pivot is smallest or largest element each time
     * Inplace Sorting Algo
     * Unstable Sorting Algo (due to swapping)
     */
    public static int[] quickSort(int[] arr) {
        quickSortUtil(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSortUtil(int[] arr, int start, int end) {
        if (start < end) {
            randomizePartition2(arr,start,end);
            int partitionPosition = partition2(arr, start, end);
            quickSortUtil(arr, start, partitionPosition - 1);
            quickSortUtil(arr, partitionPosition + 1, end);
        }
    }

    // Hoare's Partition
    private static int partition2(int[] arr, int start, int end) {
        int pivot = arr[end]; 
        int left = start;
        int right = end;

        while (left < right) {
            while (left <= end && arr[left] < pivot)
                left++;
            while (right >= start && arr[right] >= pivot)
                right--;
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // swap(arr, right+1, end);
        // return right+1;

        swap(arr, left, end);
        return left;
    }

    private static void randomizePartition2(int[] arr, int start, int end){
        int random = (int)(Math.random()*(end-start+1))+start;
        swap(arr, random, end);
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp; 
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,7,2,9,6};
        QuickSortClassII.quickSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2,3,1,7,9,6,3};
        QuickSortClassII.quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
