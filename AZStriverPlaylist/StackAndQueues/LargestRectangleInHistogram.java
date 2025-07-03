package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int largestRectangle = Integer.MIN_VALUE;
        int[] prevSmaller = prevSmaller(heights);
        int[] nextSmaller = nextSmaller(heights);
        System.out.println(Arrays.toString(prevSmaller));
        System.out.println(Arrays.toString(nextSmaller));
        for(int i=0;i<heights.length;i++){
            int rectangle = (nextSmaller[i]-prevSmaller[i]-1)*heights[i];
            largestRectangle = Math.max(largestRectangle, rectangle);
        }
        return largestRectangle;
    }

    public static int[] prevSmaller(int[] nums) {
        int[] prevSmaller = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while (i < nums.length) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i])
                stk.pop();
            if (stk.isEmpty())
                prevSmaller[i] = -1;
            else
                prevSmaller[i] = stk.peek();
            stk.push(i++);
        }
        return prevSmaller;
    }

    public static int[] nextSmaller(int[] nums) {
        int[] nextSmaller = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = nums.length - 1;
        while (i >= 0) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i])
                stk.pop();
            if (stk.isEmpty())
                nextSmaller[i] = nums.length;
            else
                nextSmaller[i] = stk.peek();
            stk.push(i--);
        }
        return nextSmaller;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + LargestRectangleInHistogram.largestRectangleArea(nums1));

        int[] nums12 = { 2, 4 };
        System.out.println("Input : " + Arrays.toString(nums12));
        System.out.println("output : " + LargestRectangleInHistogram.largestRectangleArea(nums12));
    }
}
