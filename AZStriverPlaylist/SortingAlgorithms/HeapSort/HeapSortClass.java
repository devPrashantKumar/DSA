package AZStriverPlaylist.SortingAlgorithms.HeapSort;

import java.util.Arrays;

public class HeapSortClass {
    public static int[] heapSort(int[] arr){
        int lastIndex = arr.length/2-1;
        // build heap
        for(int i = lastIndex;i>=0;i--){
            maxHeapify(arr,arr.length,i);
        }
        //extract max
        for(int i=0;i<arr.length-1;i++){
            extractMax(arr,arr.length-i);
        }
        return arr;
    }

    private static void maxHeapify(int[] arr, int length, int index){
        int maxIndex = index;
        if(2*index+1<length && arr[2*index+1]>arr[maxIndex]){
            maxIndex = 2*index+1;
        }
        if(2*index+2<length && arr[2*index+2]>arr[maxIndex]){
            maxIndex = 2*index+2;
        }

        if(maxIndex!=index){
            int temp = arr[maxIndex];
            arr[maxIndex]=arr[index];
            arr[index]=temp;
            maxHeapify(arr, length, maxIndex);
        }
    }

    private static void extractMax(int[] arr, int heapSize){
        int temp = arr[heapSize-1];
        arr[heapSize-1] = arr[0];
        arr[0] = temp;
        maxHeapify(arr, heapSize-1, 0);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        HeapSortClass.heapSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(HeapSortClass.heapSort(new int[]{})));
        System.out.println(Arrays.toString(HeapSortClass.heapSort(new int[]{5})));
        System.out.println(Arrays.toString(HeapSortClass.heapSort(new int[]{7,7})));
    }
}
