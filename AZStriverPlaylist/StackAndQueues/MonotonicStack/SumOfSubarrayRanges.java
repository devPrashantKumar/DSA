package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayRanges {

    /*
     * TIme Complexity : O(n)
     */
    public static long subArrayRanges(int[] nums) {
        int[] nextSmallest = nextSmallest(nums);
        int[] nextGreatest = nextGreatest(nums);
        int[] prevSmallestOrEqual = prevSmallestOrEqual(nums);
        int[] prevGreatestOrEqual = prevGreatestOrEqual(nums);
        // System.out.println(Arrays.toString(nextSmallest));
        // System.out.println(Arrays.toString(nextGreatest));
        // System.out.println(Arrays.toString(prevSmallestOrEqual));
        // System.out.println(Arrays.toString(prevGreatestOrEqual));
        long smallest = 0;
        long greatest = 0;
        for(int i=0;i<nums.length;i++){
            // this will not work because we are doing arithmatic operation with int so product will overflow
            // This line can overflow before the cast to long, because all operands are of type int,
            // and multiplication of large int values can easily exceed the int range (2^31 - 1 = 2,147,483,647),
            // causing undefined overflow behavior in Java.
            // long min = (long)(((nextSmallest[i]-i)*(i-prevSmallestOrEqual[i]))*nums[i]);
            // long max = (long)(((nextGreatest[i]-i)*(i-prevGreatestOrEqual[i]))*nums[i]);

            // this will work because we are doing arithmatic operation with long so product will not overflow
            // When an expression includes even one long operand, all subsequent operations are promoted to long.
            long min = (long)((1L*(nextSmallest[i]-i)*(i-prevSmallestOrEqual[i]))*nums[i]);
            long max = (long)((1L*(nextGreatest[i]-i)*(i-prevGreatestOrEqual[i]))*nums[i]);
            smallest = smallest + min;
            greatest = greatest + max;
        }
        return greatest-smallest;
    }

    public static int[] nextSmallest(int[] nums){
        int[] nextSmallest = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i=nums.length-1;
        while(i>=0){
            while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]) stk.pop();
            if(stk.isEmpty()) nextSmallest[i]=nums.length;
            else nextSmallest[i] = stk.peek();
            stk.push(i--);
        }
        return nextSmallest;
    }

    public static int[] nextGreatest(int[] nums){
        int[] nextGreatest = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i=nums.length-1;
        while(i>=0){
            while(!stk.isEmpty() && nums[stk.peek()]<=nums[i]) stk.pop();
            if(stk.isEmpty()) nextGreatest[i]=nums.length;
            else nextGreatest[i] = stk.peek();
            stk.push(i--);
        }
        return nextGreatest;
    }

    public static int[] prevSmallestOrEqual(int[] nums){
        int[] prevSmallestOrEqual = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i=0;
        while(i<nums.length){
            while(!stk.isEmpty() && nums[stk.peek()]>nums[i]) stk.pop();
            if(stk.isEmpty()) prevSmallestOrEqual[i]=-1;
            else prevSmallestOrEqual[i] = stk.peek();
            stk.push(i++);
        }
        return prevSmallestOrEqual;
    }

    public static int[] prevGreatestOrEqual(int[] nums){
        int[] prevGreatestOrEqual = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i=0;
        while(i<nums.length){
            while(!stk.isEmpty() && nums[stk.peek()]<nums[i]) stk.pop();
            if(stk.isEmpty()) prevGreatestOrEqual[i]=-1;
            else prevGreatestOrEqual[i] = stk.peek();
            stk.push(i++);
        }
        return prevGreatestOrEqual;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3 };
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + SumOfSubarrayRanges.subArrayRanges(nums1));

        int[] nums12 = { 1,3,3 };
        System.out.println("Input : " + Arrays.toString(nums12));
        System.out.println("output : " + SumOfSubarrayRanges.subArrayRanges(nums12));

        int[] nums3 = {4,-2,-3,4,1};
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + SumOfSubarrayRanges.subArrayRanges(nums3));
    }
}
