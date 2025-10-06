package AZStriverPlaylist.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8
    }
}

class KthLargest {
    Queue<Integer> pq;
    int k;

    /*
     * Space Complexity : O(k)
     * Time Complexity : O(n log k)
     */
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }

    }

    /*
     * Time Complexity : O(log k)
     */
    public int add(int val) {
        if (pq.size() < k)
            pq.add(val);
        else if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}