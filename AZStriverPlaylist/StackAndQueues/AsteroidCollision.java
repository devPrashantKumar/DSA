package AZStriverPlaylist.StackAndQueues;

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

    public static void main(String[] args) {
        int[] nums1 = { 5,10,-5 };
        System.out.println("output : " + Arrays.toString(AsteroidCollision.asteroidCollision(nums1)));

        int[] nums12 = { 8,-8 };
        System.out.println("output : " + Arrays.toString(AsteroidCollision.asteroidCollision(nums12)));

        int[] nums3 = { 10,2,-5 };
        System.out.println("output : " + Arrays.toString(AsteroidCollision.asteroidCollision(nums3)));
    }
}
