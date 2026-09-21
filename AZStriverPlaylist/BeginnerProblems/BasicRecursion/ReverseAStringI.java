package AZStriverPlaylist.BeginnerProblems.BasicRecursion;

import java.util.Arrays;
import java.util.List;

public class ReverseAStringI {

    /*
     * Recursive Approach
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N) - Recursion Stack
     */
    public static void reverseString(List<Character> s) {
        reverseStringUtil(s, 0, s.size()-1);
    }

    public static void reverseStringUtil(List<Character> s, int left, int right) {
        if(left>=right) return;
        Character temp = s.get(right);
        s.set(right,s.get(left));
        s.set(left,temp);
        reverseStringUtil(s, left+1, right-1);
    }

    /*
     * Iterative Approach
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static void reverseStringIterativeApproach(List<Character> s) {
        int left = 0;
        int right = s.size()-1;
        while(left<right){
            Character temp = s.get(right);
            s.set(right,s.get(left));
            s.set(left,temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Character> input1=Arrays.asList('h','e','l','l','o');
        System.out.println("Input 1 " + input1);
        reverseString(input1);
        System.out.println("Output 1 "+input1);
        reverseStringIterativeApproach(input1);
        System.out.println("Output 1 "+input1);

        System.out.println("----------------------------------------");

        List<Character> input2=Arrays.asList();
        System.out.println("Input 2 " + input2);
        reverseString(input2);
        System.out.println("Output 2 "+input2);
        reverseStringIterativeApproach(input2);
        System.out.println("Output 2 "+input2);

        System.out.println("----------------------------------------");

        List<Character>input3=Arrays.asList('b','y','e');
        System.out.println("Input 2 " + input3);
        reverseString(input3);
        System.out.println("Output 2 "+input3);
        reverseStringIterativeApproach(input3);
        System.out.println("Output 2 "+input3);
    }
}
