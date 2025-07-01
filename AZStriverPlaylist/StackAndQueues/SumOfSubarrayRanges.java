package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayRanges {

    public static long subArrayRanges(int[] nums) {
        int[] nextSmallest = nextSmallest(nums);
        int[] nextGreatest = nextGreatest(nums);
        int[] prevSmallestOrEqual = prevSmallestOrEqual(nums);
        int[] prevGreatestOrEqual = prevGreatestOrEqual(nums);
        System.out.println(Arrays.toString(nextSmallest));
        System.out.println(Arrays.toString(nextGreatest));
        System.out.println(Arrays.toString(prevSmallestOrEqual));
        System.out.println(Arrays.toString(prevGreatestOrEqual));
        long smallest = 0;
        long greatest = 0;
        for(int i=0;i<nums.length;i++){
            smallest = smallest + (((nextSmallest[i]-i)*(i-prevSmallestOrEqual[i]))*nums[i]);
            greatest = greatest + (((nextGreatest[i]-i)*(i-prevGreatestOrEqual[i]))*nums[i]);
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
