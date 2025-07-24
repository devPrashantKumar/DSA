package AZStriverPlaylist.SortingAlgorithms.InsertionSort;

import java.util.*;

public class InsertionSortClass {
    /* 
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     * In-Place Algorithm
     * Stable Algorithm
     */
    public static int[] InsertionSort(int[] arr){
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

    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        InsertionSortClass.InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
