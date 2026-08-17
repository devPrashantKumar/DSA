package AZStriverPlaylist.SortingAlgorithms;

import java.util.Arrays;

public class SelectionSortClass {
    /*  NOT CORRECT SELECTION SORT , this is kind of bubble sort
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     * In-Place Algorithm
     * Unstable (due to swapping)
    public static int[] selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    */


    /*  CORRECT SELECTION SORT
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     * In-Place Algorithm
     * Unstable (due to swapping)
     */
    public static int[] selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                int temp= arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=temp;
            }
        }
        return arr;
    }

    /*  CORRECT STABLE SELECTION SORT
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     * In-Place Algorithm
     * stable (due to shifting)
     */
    public static int[] selectionSortStable(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                int minimum = arr[minIndex];
                for(int j=minIndex-1;j>=i;j--){
                    arr[j+1]=arr[j];
                }
                arr[i]=minimum;
            }
        }
        return arr;
    }

    public static int[] selectionSortRecursive(int[] arr){
        selectionSortRecursiveUtil(0, arr);
        return arr;
    }

    public static void selectionSortRecursiveUtil(int index, int[] arr){
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
        selectionSortRecursiveUtil(index+1,arr);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-------------------------------------");

        int[] arr1 = {2,3,1,7,3,9,6};
        selectionSortRecursive(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("-------------------------------------");

        int[] arr2 = {4, 5, 3, 5, 1};
        selectionSortStable(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("-------------------------------------");

        int[] arr12 = {4, 5, 3, 5, 1};
        selectionSortRecursive(arr12);
        System.out.println(Arrays.toString(arr12));

        System.out.println("-------------------------------------");
    }
}
