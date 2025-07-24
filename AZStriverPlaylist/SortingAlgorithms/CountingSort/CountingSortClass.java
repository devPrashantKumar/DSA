package AZStriverPlaylist.SortingAlgorithms.CountingSort;

import java.util.Arrays;

public class CountingSortClass {
    /*
     * Stable algorithm
     * Time Complexity - O(n+k)
     * SpaceComplexity - O(k+n)
     * 
     * Calculates the range using the minimum and maximum values
     * to handle arrays with negative numbers.
     */
    public static int[] countingSort(int[] arr){
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        int range = max-min+1;

        int count[] = new int[range];

        for(int i=0;i<arr.length;i++){
            count[arr[i]-min]++;
        }

        for(int i=1;i<range;i++){
            count[i]+=count[i-1];
        }

        int[] output = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            output[count[arr[i]-min]-1] = arr[i];
            count[arr[i]-min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
        return arr;
    }
}
