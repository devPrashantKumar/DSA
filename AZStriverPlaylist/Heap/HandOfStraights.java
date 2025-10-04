package AZStriverPlaylist.Heap;

import java.util.*;
import java.util.stream.Collectors;

public class HandOfStraights {
    /*
     * Time Complexity : O(n*k log n) -> k = number of times element each readded in pq
     * Space Complexity : O(n)
     */
    public static boolean isNStraightHandUsingMinHeap(int[] hand, int groupSize) {
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        pq.addAll(Arrays.stream(hand).boxed().collect(Collectors.toList()));
        int count = 0;
        int lastPopped = -1;
        while (!pq.isEmpty()) {
            if (count == 0) {
                lastPopped = pq.poll();
                count++;
            } else {
                int popped = pq.poll();
                if (popped > lastPopped + 1)
                    return false;
                else if (popped <= lastPopped)
                    queue.add(popped);
                else {
                    lastPopped = popped;
                    count++;
                }
            }

            if (count == groupSize) {
                count = 0;
                pq.addAll(queue);
                queue.clear();
            }
        }
        return (queue.isEmpty() && count == 0);
    }

    /*
     * Time Complexity : O(n * log k) -> k=unique elements
     * Space Complexity : O(k)
     */
    public static boolean isNStraightHandUsingTreeMap(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for (int card : hand) {
            tmap.put(card, tmap.getOrDefault(card, 0) + 1);
        }
        while (!tmap.isEmpty()) {
            int first = tmap.firstKey();
            for (int i = 0; i < groupSize; i++) {
                if (!tmap.containsKey(first + i))
                    return false;
                tmap.put(first + i, tmap.get(first + i) - 1);
                if (tmap.get(first + i) == 0)
                    tmap.remove(first + i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize1 = 3;
        System.out.println("Input1 : " + isNStraightHandUsingMinHeap(input1, groupSize1));
        System.out.println("Input1 : " + isNStraightHandUsingTreeMap(input1, groupSize1));

        System.out.println("==================================================");

        int[] input2 = { 1, 2, 3, 4, 5 };
        int groupSize2 = 4;
        System.out.println("Input2 : " + isNStraightHandUsingMinHeap(input2, groupSize2));
        System.out.println("Input2 : " + isNStraightHandUsingTreeMap(input2, groupSize2));

        System.out.println("==================================================");
    }
}
