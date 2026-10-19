package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] nextSmaller(int[] nums){
        Stack<Integer> stk = new Stack<>();
        int[] nextSmaller = new int[nums.length];
        int i=nums.length-1;
        while(i>=0){
            while(!stk.isEmpty() && stk.peek()>=nums[i]) stk.pop();
            if(stk.isEmpty()) nextSmaller[i]=-1;
            else nextSmaller[i]=stk.peek();
            stk.push(nums[i--]);
        }
        return nextSmaller;
    }
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 1 };
        System.out.println("output : " + Arrays.toString(NextSmallerElement.nextSmaller(nums1)));

        int[] nums12 = { 6, 4,1, 2, 3, 4, 3 };
        System.out.println("output : " + Arrays.toString(NextSmallerElement.nextSmaller(nums12)));
    }
}
