package AZStriverPlaylist.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortKSortedArray {
    /*
     * Time Complexity : O(n*log k)
     * Space Complexity : O(log k)
     */
    public static int[] nearlySorted(int[] arr, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        for(;i<arr.length;i++){
            minHeap.offer(arr[i]);
            if(i>=k){
                arr[i-k] = minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            arr[(i++)-k] = minHeap.poll();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        int k1 = 3;
        System.out.println("Input -> arr : "+Arrays.toString(arr1)+" , k : "+k1);
        System.out.println("Output : "+Arrays.toString(nearlySorted(arr1, k1)));
        System.out.println("=================================================================");

        int[] arr2 = {1, 4, 5, 2, 3, 6, 7, 8, 9, 10};
        int k2 = 2;
        System.out.println("Input -> arr : "+Arrays.toString(arr2)+" , k : "+k2);
        System.out.println("Output : "+Arrays.toString(nearlySorted(arr2, k2)));
        System.out.println("=================================================================");
    }
}
