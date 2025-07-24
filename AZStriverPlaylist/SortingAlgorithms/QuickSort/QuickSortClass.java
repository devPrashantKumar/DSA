package AZStriverPlaylist.SortingAlgorithms.QuickSort;

public class QuickSortClass {
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
        int left = start;
        int right = end;

        while (left < right) {
            while (left <= end && arr[left] <= pivot)
                left++;
            while (right >= start && arr[right] > pivot)
                right--;
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // swap(arr, right, start);
        // return right;

        swap(arr, left-1, start);
        return left-1;
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
}
