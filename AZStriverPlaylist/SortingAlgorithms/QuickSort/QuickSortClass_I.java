package AZStriverPlaylist.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class QuickSortClass_I {
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

    // combination of Hoar's and Lamuto
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; 
        int left = start;
        int right = end-1;

        while (left <= right) {
            if(arr[left]<=pivot) {
                left++;
            }
            else {
                swap(arr,left,right);
                right--;
            }
        }
        swap(arr,left,end);
        return left;
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
        int[] arr = {6,5,4,3,2,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {7, 4, 1, 5, 3};
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {7};
        quickSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        quickSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {1,2,3,4,5,6};
        quickSort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}
