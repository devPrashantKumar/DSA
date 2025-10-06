package AZStriverPlaylist.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class ConnectNRopesWithMinimumCost {
    
    /*
     * Time Complexity : O(n log n)
     * Space Complexity : O(n);
     */
    public static int minCost(int[] arr) {
        int cost=0;
        if(arr.length==0) return 0;
        Queue<Integer> pq = new PriorityQueue<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        while(pq.size()!=1){
            int rope1 = pq.poll();
            int rope2 = pq.poll();
            cost += (rope1+rope2);
            pq.add(rope1+rope2);
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] input1 = {4, 3, 2, 6};
        System.out.println("Input1 : "+Arrays.toString(input1));
        System.out.println("Output : "+minCost(input1));
        System.out.println("---------------------------------------------------");

        int[] input2 = {10};
        System.out.println("Input1 : "+Arrays.toString(input2));
        System.out.println("Output : "+minCost(input2));
        System.out.println("---------------------------------------------------");
    }
}
