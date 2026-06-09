package AZStriverPlaylist.SortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class SelectionSortRecursive {
    
    public static int[] selectionSort(int[] arr){
        selectionSortRecursive(0, arr);
        return arr;
    }

    public static void selectionSortRecursive(int index, int[] arr){
        int n = arr.length;
        if(index==n) return;
        int minIndex = index;
        for(int j=index+1;j<n;j++){
            if(arr[j]<arr[minIndex]){
                minIndex=j;
            }
        }
        if(index!=minIndex){
            int temp= arr[minIndex];
            arr[minIndex]=arr[index];
            arr[index]=temp;
        }
        selectionSortRecursive(index+1,arr);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        SelectionSortRecursive.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
