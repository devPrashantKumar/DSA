package AZStriverPlaylist.Heap;

import java.util.*;

public class TopKFrequentElements {
    /*
     * Time Complexity :O(n + n log n + k log n) -> O(n log n)
     * space Complexity : O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> frequency = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int num:nums){
            frequency.put(num,frequency.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : frequency.entrySet()) {
            pq.offer(entry);
        }
        for(int i=0;(i<k && !pq.isEmpty());i++){
            Map.Entry<Integer,Integer> entry = pq.poll();
            result[i]=entry.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,1,2,2,3};
        int k1 = 2;
        System.out.println("Input : "+ Arrays.toString(input1)+", "+k1);
        System.out.println("Output : "+Arrays.toString(topKFrequent(input1, k1)));
        System.out.println("======================================================================");

        int[] input2 = {1};
        int k2 = 1;
        System.out.println("Input : "+ Arrays.toString(input2)+", "+k2);
        System.out.println("Output : "+Arrays.toString(topKFrequent(input2, k2)));
        System.out.println("======================================================================");

        int[] input3 = {1,2,1,2,1,2,3,1,3,2};
        int k3 = 2;
        System.out.println("Input : "+ Arrays.toString(input3)+", "+k3);
        System.out.println("Output : "+Arrays.toString(topKFrequent(input3, k3)));
        System.out.println("======================================================================");
    }
}
