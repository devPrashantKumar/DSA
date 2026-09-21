package AZStriverPlaylist.BeginnerProblems.BasicArrays;

import java.util.Arrays;

public class SumOfArrayElements {

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    */
    public static int sum(int[] arr) {
        int sum=0;
        for(int num:arr){
            sum += num;
        }
        return sum;
    }

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(N) - Recursion Stack
    */
    public static int sumUsingRecursion(int[] arr, int n) {
        if(n==0) return 0;
        return arr[n-1]+sumUsingRecursion(arr, n-1);
    }

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    */
    public static int sumUsingStream(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {
        int[] input1 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+sum(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+sumUsingRecursion(input1,6));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+sumUsingStream(input1));

        System.out.println("------------------------------------------------------");
        int[] input2 = {1,2,2,4,7,8,8};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+sum(input2));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+sumUsingRecursion(input2,7));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+sumUsingStream(input2));

    }
}
