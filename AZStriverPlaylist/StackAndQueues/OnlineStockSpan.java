package AZStriverPlaylist.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class OnlineStockSpan {

    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public OnlineStockSpan() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
        
    }
    
    public int next(int price) {
        int count=1;
        while(!stk1.isEmpty() && stk1.peek()<=price){
            stk1.pop();
            count += stk2.pop();
        }
        stk1.push(price);
        stk2.push(count);
        return count;
        
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
