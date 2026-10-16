package AZStriverPlaylist.StackAndQueues.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    /*
     * Time Complexity : O(n)+O(n)
     * O(n) outer for loop
     * O(n) while loop max total execution 
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int asteroid:asteroids){
            if(asteroid>0) stk.push(asteroid);
            else{
                while(true){
                    if(stk.isEmpty() || stk.peek()<0){
                        stk.push(asteroid); break;
                    }else if(stk.peek()==Math.abs(asteroid)){
                        stk.pop(); break;
                    }
                    else if(stk.peek()<Math.abs(asteroid)){
                        stk.pop();
                    }else{
                        break;
                    }
                }
            }
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int asteroid:asteroids){
            if(asteroid>=0) stk.push(asteroid);
            else{
                while(!stk.isEmpty() && stk.peek()>=0 && stk.peek()<Math.abs(asteroid)) stk.pop();
                if(stk.isEmpty() || stk.peek()<0){
                    stk.push(asteroid);
                }else if(!stk.isEmpty() && stk.peek()==Math.abs(asteroid)){
                    stk.pop(); 
                }
            }
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = { 5,10,-5 };
        System.out.println("output : " + Arrays.toString(asteroidCollision(nums1)));
        System.out.println("output : " + Arrays.toString(asteroidCollision2(nums1)));
        System.out.println("----------------------------------------------");
        
        int[] nums12 = { 8,-8 };
        System.out.println("output : " + Arrays.toString(asteroidCollision(nums12)));
        System.out.println("output : " + Arrays.toString(asteroidCollision2(nums12)));
        System.out.println("----------------------------------------------");

        int[] nums3 = { 10,2,-5 };
        System.out.println("output : " + Arrays.toString(asteroidCollision(nums3)));
        System.out.println("output : " + Arrays.toString(asteroidCollision2(nums3)));
        System.out.println("----------------------------------------------");

        int[] nums4 = { 3,5,-6,2,-1,4 };
        System.out.println("output : " + Arrays.toString(asteroidCollision(nums4)));
        System.out.println("output : " + Arrays.toString(asteroidCollision2(nums4)));
        System.out.println("----------------------------------------------");
    }
}
