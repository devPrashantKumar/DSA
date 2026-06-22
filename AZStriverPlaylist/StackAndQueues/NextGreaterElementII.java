package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static int[] nextGreaterElement2(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = nums.length - 1;
        while (i >= 0) {
            while (!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            stk.push(nums[i--]);
        }
        i = nums.length - 1;
        while (i >= 0) {
            while (!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            if (stk.isEmpty())
                nextGreater[i] = -1;
            else
                nextGreater[i] = stk.peek();
            stk.push(nums[i--]);
        }
        return nextGreater;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        // First pass: pre-load stack with all elements (right to left)
        // This simulates the "second half" of the circular array
        int i = nums.length - 1;
        while(i >= 0) {
            stk.push(nums[i--]);
        }

        // Second pass: compute next greater for each element (right to left)
        i = nums.length - 1;
        while(i >= 0) {
            while (!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            nextGreater[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i--]);
        }

        return nextGreater;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 1 };
        System.out.println("output : " + Arrays.toString(NextGreaterElementII.nextGreaterElement2(nums1)));

        int[] nums12 = { 1, 2, 3, 4, 3 };
        System.out.println("output : " + Arrays.toString(NextGreaterElementII.nextGreaterElement2(nums12)));
    }
}
