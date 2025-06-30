package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimum {
    /*
     * Time Complexity : O(n^2)
     */
    public static int sumOfSubArrayMinimumsBruteforce(int[] nums) {
        final int MAX_NUM = 1000000007;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                sum = (sum + min) % MAX_NUM;
            }
        }
        return sum;
    }

    /*
     * Time Complexity : O(n)
     */
    public static int sumOfSubArrayMinimums(int[] nums) {
        final int MAX_NUM = 1000000007;
        int sum = 0;
        int[] nextSmalller = nextSmaller(nums);
        //int[] nextSmalller = nextSmallerOrEqual(nums);
        //int[] prevSmaller = prevSmaller(nums);
        int[] prevSmaller = prevSmallerOrEqual(nums);
        for (int i = 0; i < nums.length; i++) {
            // Java evaluates all arithmetic in int unless explicitly told otherwise. If the intermediate product:
            // exceeds Integer.MAX_VALUE (≈ 2.1 * 10⁹), you'll get overflow, even before % MAX_NUM is applied.
            // This is a common trap when doing modulo operations in Java
            // sum = (sum + ((nums[i] * ((i - prevSmaller[i]) * (nextSmalller[i] - i)) % MAX_NUM) % MAX_NUM)%MAX_NUM);
            // sum = (sum + ((nums[i] * (((i - prevSmaller[i]) * (nextSmalller[i] - i)) % MAX_NUM)) % MAX_NUM))%MAX_NUM;
            long left = i - prevSmaller[i];
            long right = nextSmalller[i] - i;
            long contribution = ((left * right) % MAX_NUM * nums[i]) % MAX_NUM;
            sum = (int)((sum + contribution) % MAX_NUM);
        }
        // System.out.println(Arrays.toString(nextSmalller));
        // System.out.println(Arrays.toString(prevSmaller));

        return sum;
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

    public static int[] nextSmallerOrEqual(int[] nums) {
        int[] nextSmallerOrEqual = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = nums.length - 1;
        while (i >= 0) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i])
                stk.pop();
            if (stk.isEmpty())
                nextSmallerOrEqual[i] = nums.length;
            else
                nextSmallerOrEqual[i] = stk.peek();
            stk.push(i--);
        }
        return nextSmallerOrEqual;
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

    public static int[] prevSmallerOrEqual(int[] nums) {
        int[] prevSmallerOrEqual = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while (i < nums.length) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i])
                stk.pop();
            if (stk.isEmpty())
                prevSmallerOrEqual[i] = -1;
            else
                prevSmallerOrEqual[i] = stk.peek();
            stk.push(i++);
        }
        return prevSmallerOrEqual;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 1, 2, 4 };
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + SumOfSubarrayMinimum.sumOfSubArrayMinimumsBruteforce(nums1));
        System.out.println("output : " + SumOfSubarrayMinimum.sumOfSubArrayMinimums(nums1));

        int[] nums12 = { 11, 81, 94, 43, 3 };
        System.out.println("Input : " + Arrays.toString(nums12));
        System.out.println("output : " + SumOfSubarrayMinimum.sumOfSubArrayMinimumsBruteforce(nums12));
        System.out.println("output : " + SumOfSubarrayMinimum.sumOfSubArrayMinimums(nums12));

        int[] nums3 = { 71,55,82,55 };
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + SumOfSubarrayMinimum.sumOfSubArrayMinimumsBruteforce(nums3));
        System.out.println("output : " + SumOfSubarrayMinimum.sumOfSubArrayMinimums(nums3));
    }
}
