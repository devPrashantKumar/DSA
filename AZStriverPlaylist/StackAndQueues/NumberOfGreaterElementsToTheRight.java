package AZStriverPlaylist.StackAndQueues;

import java.util.*;

// pending solution
/// https://takeuforward.org/plus/dsa/problems/number-of-greater-elements-to-the-right?source=strivers-a2z-dsa-track&tab=discussion&discussion_id=1449
public class NumberOfGreaterElementsToTheRight {
    public static List<Integer> count_NGE(int[] arr, int[] indices) {
        int n = arr.length;
        int[] countNextGreater = new int[n];
        Stack<Integer>  stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=arr[i]) stk.pop();
            countNextGreater[i]=stk.size();
            stk.push(arr[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<indices.length;i++){
            result.add(countNextGreater[indices[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int[] queries1 = { 0 , 5 };
        System.out.println("output : " + NumberOfGreaterElementsToTheRight.count_NGE(nums1, queries1));

        int[] nums12 = { 1, 2, 3, 4, 1 };
        int[] queries12 = { 0, 3 };
        System.out.println("output : " + NumberOfGreaterElementsToTheRight.count_NGE(nums12, queries12));
    }
}
