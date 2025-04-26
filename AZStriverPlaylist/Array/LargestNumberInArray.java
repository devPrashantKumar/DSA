package AZStriverPlaylist.Array;

import java.util.Arrays;

public class LargestNumberInArray {
    // Bruteforce approch
    /*
     * Time complexity : O(nlogn)
     * Space complexity : O(1)
     */
    public static int largestNumber(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    /*
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static int largestNumberOptimalApproach(int[] arr){
        int largest = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    // this is classic recursion
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n) recursive stack memory
     */
    public static int largestNumberRecursionApproach(int[] arr, int n){
        if(n==0){
            return arr[0];
        }
        return Math.max(arr[n],largestNumberRecursionApproach(arr, n-1));
    }

    public static void main(String[] args) {
        int[] input1 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LargestNumberInArray.largestNumber(input1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LargestNumberInArray.largestNumberOptimalApproach(input2));
        System.out.println("------------------------------------------------------");
        int[] input3 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input3)+" Output : "+LargestNumberInArray.largestNumberRecursionApproach(input3,input3.length-1));
    }
}
