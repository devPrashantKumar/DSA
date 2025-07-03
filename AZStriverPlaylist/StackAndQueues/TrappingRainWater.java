package AZStriverPlaylist.StackAndQueues;

import java.util.*;

public class TrappingRainWater {
    public static int trap(int[] height) {
        Set<String> set = new HashSet<>();
        int sum=0;
        int[] prevGreater = prevGreater(height);
        int[] nextGreater = nextGreater(height);
        for(int i=0;i<height.length;i++){
            if(prevGreater[i]==-1 || nextGreater[i]==-1) continue;
            if(set.contains(String.valueOf(prevGreater[i])+"$"+String.valueOf(nextGreater[i]))) continue;
            int area = (nextGreater[i]-prevGreater[i]-1)*(Math.min(height[prevGreater[i]],height[nextGreater[i]])-height[i]);
            set.add(String.valueOf(prevGreater[i])+"$"+String.valueOf(nextGreater[i]));
            sum += area;
        }
        return sum;
    }

    public static int[] prevGreater(int[] nums) {
        int[] prevGreater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while (i < nums.length) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i])
                stk.pop();
            if (stk.isEmpty())
                prevGreater[i] = -1;
            else
                prevGreater[i] = stk.peek();
            stk.push(i++);
        }
        return prevGreater;
    }

    public static int[] nextGreater(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int i = nums.length - 1;
        while (i >= 0) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i])
                stk.pop();
            if (stk.isEmpty())
                nextGreater[i] = -1;
            else
                nextGreater[i] = stk.peek();
            stk.push(i--);
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0,1,0,2,1,0,1,3,2,1,2,1 };
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + TrappingRainWater.trap(nums1));

        int[] nums12 = { 4,2,0,3,2,5 };
        System.out.println("Input : " + Arrays.toString(nums12));
        System.out.println("output : " + TrappingRainWater.trap(nums12));
    }
}
