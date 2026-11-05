package AZStriverPlaylist.StackAndQueues;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> indexDeque = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(!indexDeque.isEmpty() && indexDeque.peekFirst() <= i-k){
                indexDeque.pollFirst();
            }

            while(!indexDeque.isEmpty() && arr[indexDeque.peekLast()]<=arr[i]){
                indexDeque.pollLast();
            }

            indexDeque.offerLast(i);

            if(i>=k-1){
                result.add(arr[indexDeque.peekFirst()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // wrong solution
    // public static int[] maxSlidingWindow(int[] arr, int k) {
    //     List<Integer> result = new ArrayList<>();
    //     Deque<Integer> indexDeque = new ArrayDeque<>();
    //     for(int i=0;i<arr.length;i++){
    //         if(!indexDeque.isEmpty() && indexDeque.peekFirst() <= i-k){
    //             indexDeque.pollFirst();
    //         }

    //         while(!indexDeque.isEmpty() && arr[indexDeque.peekFirst()]<=arr[i]){
    //             indexDeque.pollFirst();
    //         }

    //         indexDeque.offerLast(i);

    //         if(i>=k-1){
    //             result.add(arr[indexDeque.peekFirst()]);
    //         }
    //     }
    //     return result.stream().mapToInt(Integer::intValue).toArray();
    // }

    public static void main(String[] args) {
        System.out.println("Output : "+Arrays.toString(maxSlidingWindow(new int[]{4, 0, -1, 3, 5, 3, 6, 8}, 3)));
        System.out.println("Output : "+Arrays.toString(maxSlidingWindow(new int[]{20,25}, 2)));
    }
}
