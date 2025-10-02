package AZStriverPlaylist.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class kthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            if(minHeap.size()<k){
                minHeap.offer(num);
            }
            else if(num>minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,1,5,6,4};
        int k1 = 2;
        System.out.println("Input -> nums : "+Arrays.toString(nums1)+", k :"+k1);
        System.out.println("Output : "+kthLargestElementInAnArray.findKthLargest(nums1, k1));
        System.out.println("===============================================================================");


        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        System.out.println("Input -> nums : "+Arrays.toString(nums2)+", k :"+k2);
        System.out.println("Output : "+kthLargestElementInAnArray.findKthLargest(nums2, k2));
        System.out.println("===============================================================================");
    }
}
