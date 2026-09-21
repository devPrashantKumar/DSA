package AZStriverPlaylist.BeginnerProblems.BasicArrays;

import java.util.Arrays;

public class CountOfOddNumbersInArray {

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    */
    public static int countOddNumbers(int[] arr) {
        int count=0;
        for(int num:arr){
            count += ((num%2)!=0 ? 1: 0);
        }
        return count;
    }

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    */
    public static int countOddNumbers2(int[] arr) {
        int count=0;
        for(int num:arr){
            //count += (num%2); // will fail when num is negative
            count += (Math.abs(num)%2);
        }
        return count;
    }

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(N) - Recursion Stack
    */
     public static int countOddNumbersUsingRecursion(int[] arr, int n) {
        if(n==0) return 0;
        return ((arr[n-1]%2!=0) ? 1 : 0)+countOddNumbersUsingRecursion(arr, n-1);
    }

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(N) - Recursion Stack
    */
     public static int countOddNumbersUsingRecursion2(int[] arr, int n) {
        if(n==0) return 0;
        return (Math.abs(arr[n-1])%2)+countOddNumbersUsingRecursion2(arr, n-1);
    }

    /*
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    */
    public static int countOddNumbersUsingStream(int[] arr) {
        return (int) Arrays.stream(arr).filter(num->num%2!=0).count();
    }

    public static void main(String[] args) {
        int[] input1 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+countOddNumbers(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+countOddNumbers2(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+countOddNumbersUsingRecursion(input1,input1.length));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+countOddNumbersUsingRecursion2(input1,input1.length));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+countOddNumbersUsingStream(input1));

        System.out.println("------------------------------------------------------");
        int[] input2 = {1,2,2,4,7,8,8};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+countOddNumbers(input2));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+countOddNumbers2(input2));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+countOddNumbersUsingRecursion(input2,input2.length));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+countOddNumbersUsingRecursion2(input2,input2.length));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+countOddNumbersUsingStream(input2));

    }
}
