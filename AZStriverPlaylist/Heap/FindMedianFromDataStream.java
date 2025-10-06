package AZStriverPlaylist.Heap;

import java.util.*;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1); // arr = [1]
        medianFinder.addNum(2); // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    int count = 0;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    /*
     * Time Complexity : O(2 * log n/2)
     */
    public void addNum(int num) {
        if (count % 2 == 0) {
            if (maxHeap.isEmpty() || num <= minHeap.peek())
                maxHeap.offer(num);
            else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        } else {
            if (num >= maxHeap.peek())
                minHeap.offer(num);
            else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
        }
        //System.out.println("maxHead : "+maxHeap);
        //System.out.println("minHeap : "+minHeap);
        count++;
    }

    /*
     * Time Complexity : O(1)
     */
    public double findMedian() {
        if(maxHeap.isEmpty()) return 0;
        if (count % 2 == 0)
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}