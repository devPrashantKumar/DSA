package AZStriverPlaylist.Heap;

import java.util.*;

public class ReplaceEachArrayElementByItsCorresondingRank {
    /*
     * Time Complexity : O(n^2)
     * Auxilary Space Complexity : O(1)
     */
    public static int[] rankArrayBruteforce(int[] nums){
        int[] arr = Arrays.copyOf(nums,nums.length);
        Set<Integer> set = new HashSet<>();
        int[] rank = new int[arr.length];
        for(int j=0;j<arr.length;j++){
            for(int i=0;i<arr.length;i++){
                if(arr[j]>arr[i]){
                    set.add(arr[i]);
                }
            }
            rank[j] = set.size();
            set.clear();
        }
        return rank;
    }

    /*
     * Time Complexity : O(n log n)
     * Auxilary Space Complexity : O(n)
     */
    public static int[] rankArrayUsingSorting(int[] nums){
        int[] arr = Arrays.copyOf(nums,nums.length);
        int[][] utilArray = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            utilArray[i][0]=arr[i];
            utilArray[i][1]=i;
        }
        Arrays.sort(utilArray, (a,b)->a[0]-b[0]);
        int rank=-1;
        int lastUsed = Integer.MIN_VALUE;
        for(int[] ele :utilArray){
            if(ele[0]!=lastUsed) rank++;
            arr[ele[1]]=rank;
            lastUsed=ele[0];
        }
        return arr;
    }

    /*
     * Time Complexity : O(n log n)
     * Auxilary Space Complexity : O(n)
     */
    public static int[] rankArrayUsingSorting2(int[] nums){
        int[] arr = Arrays.copyOf(nums,nums.length);
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int lastUsed = Integer.MIN_VALUE;
        int rank=-1;
        for(int ele : arr){
            if(ele!=lastUsed){
                rank++;
                map.put(ele, rank);
                lastUsed=ele;
            }
        }
        arr = Arrays.copyOf(nums,nums.length);
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    /*
     * Time Complexity : O(n log n)
     * Auxilary Space Complexity : O(n)
     */
    public static int[] rankArrayUsingMinHeap(int[] nums){
        int[] arr = Arrays.copyOf(nums,nums.length);
        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        for(int i=0;i<arr.length;i++){
            pq.offer(new int[]{arr[i],i});
        }
        int rank=-1;
        int lastUsed = Integer.MIN_VALUE;

// Iterating over a PriorityQueue does not give sorted order.
// The internal array of PriorityQueue is a heap, so iteration produces elements in heap-array order, not sorted order.
// ✅ Fix: You must poll elements from the priority queue:
//         for(int[] ele :pq){
        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            if(ele[0]!=lastUsed) rank++;
            arr[ele[1]]=rank;
            lastUsed=ele[0];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 5, 70, 2};
        System.out.println("Input : "+Arrays.toString(arr1));
        System.out.println("Output : "+Arrays.toString(rankArrayBruteforce(arr1)));
        System.out.println("Output : "+Arrays.toString(rankArrayUsingSorting(arr1)));
        System.out.println("Output : "+Arrays.toString(rankArrayUsingSorting2(arr1)));
        System.out.println("Output : "+Arrays.toString(rankArrayUsingMinHeap(arr1)));

        System.out.println("==========================================================");

        int[] arr2 = {100, 2, 70, 2};
        System.out.println("Input : "+Arrays.toString(arr2));
        System.out.println("Output : "+Arrays.toString(rankArrayBruteforce(arr2)));
        System.out.println("Output : "+Arrays.toString(rankArrayUsingSorting(arr2)));
        System.out.println("Output : "+Arrays.toString(rankArrayUsingSorting2(arr2)));
        System.out.println("Output : "+Arrays.toString(rankArrayUsingMinHeap(arr2)));

        System.out.println("==========================================================");
    }
}
