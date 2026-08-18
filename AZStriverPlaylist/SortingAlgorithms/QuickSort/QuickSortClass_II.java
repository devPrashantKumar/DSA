package AZStriverPlaylist.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class QuickSortClass_II {
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
            randomizePartition(arr,start,end);
            int partitionPosition = partition(arr, start, end);
            quickSortUtil(arr, start, partitionPosition - 1);
            quickSortUtil(arr, partitionPosition + 1, end);
        }
    }

    // Lomuto Partition
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; 
        int left = start;
        int right = end;
        int i = left-1;
        for(int j=left;j<=right;j++){
            if(arr[j]<=pivot) {
                swap(arr, ++i, j);
            }
        }
        return i;
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
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2,3,1,7,9,6,3};
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
