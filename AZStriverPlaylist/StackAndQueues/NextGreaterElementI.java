package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        int[] nextGreater = new int[nums2.length];
        int[] result = new int[nums1.length];
        Stack<Integer> stk = new Stack<>();
        int i=nums2.length-1;
        while(i>=0){
            while(!stk.isEmpty() && stk.peek()<=nums2[i]) stk.pop();
            if(stk.isEmpty()) nextGreater[i]=-1;
            else nextGreater[i]=stk.peek();
            stk.push(nums2[i]);
            i--;
        }
        for (i=0;i<nums2.length;i++) {
            map.put(nums2[i], nextGreater[i]);
        }
        for (i=0;i<nums1.length;i++) {
            result[i]=map.get(nums1[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println("output : "+Arrays.toString(NextGreaterElementI.nextGreaterElement1(nums1, nums2)));

        int[] nums12 = {2,4}, nums22 = {1,2,3,4};
        System.out.println("output : "+Arrays.toString(NextGreaterElementI.nextGreaterElement1(nums12, nums22)));
    }
}
