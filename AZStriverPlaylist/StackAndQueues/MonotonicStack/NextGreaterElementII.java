package AZStriverPlaylist.StackAndQueues.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static int[] nextGreaterElement2(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = nums.length - 1;i >= 0;i--) {
            while (!stk.isEmpty() && stk.peek() <= nums[i]) stk.pop();
            stk.push(nums[i]);
        }
        for(int i = nums.length - 1;i >= 0;i--) {
            while (!stk.isEmpty() && stk.peek() <= nums[i]) stk.pop();
            nextGreater[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return nextGreater;
    }

    public static int[] nextGreaterElement2Optimised(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        // First pass: pre-load stack with all elements (right to left)
        // This simulates the "second half" of the circular array
        for (int i = nums.length - 1;i >= 0;i--) {
            stk.push(nums[i]);
        }

        // Second pass: compute next greater for each element (right to left)
        for (int i = nums.length - 1;i >= 0;i--) {
            while (!stk.isEmpty() && stk.peek() <= nums[i]) stk.pop();
            nextGreater[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 1 };
        System.out.println("output : " + Arrays.toString(nextGreaterElement2(nums1)));
        System.out.println("output : " + Arrays.toString(nextGreaterElement2Optimised(nums1)));
        System.out.println("-----------------------------------------------------------");
        
        int[] nums12 = { 1, 2, 3, 4, 3 };
        System.out.println("output : " + Arrays.toString(nextGreaterElement2(nums12)));
        System.out.println("output : " + Arrays.toString(nextGreaterElement2Optimised(nums12)));

    }
}
