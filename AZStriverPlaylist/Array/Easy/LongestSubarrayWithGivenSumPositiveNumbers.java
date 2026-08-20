package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;

public class LongestSubarrayWithGivenSumPositiveNumbers {

    /*
     * Time Complexity : O(n^2)
     */
    public static int longestSubarrayBruteforce(int[] arr, int k){
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum==k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            } 
        }
        return maxLen;
    }

    /*
     * Time Complexity : O(n)
     */
    // This shrink logic assumes: removing an element from the front always decreases the sum. 
    // That's only guaranteed true if every element is strictly positive. With zeros or negatives, 
    // shrinking the window wouldn't reliably reduce sum, and the two-pointer technique would break — 
    // you'd need a prefix-sum + HashMap approach instead for the general case
    public static int longestSubarray(int[] arr, int k) {
       int maxLen = 0;
        int i=0; 
        int sum=0;
        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            while(sum>k){
                sum -= arr[i];
                i++;
            }
            if(sum==k){
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,1};
        int k1 = 2;
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestSubarrayWithGivenSumPositiveNumbers.longestSubarrayBruteforce(input1,k1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestSubarrayWithGivenSumPositiveNumbers.longestSubarray(input1,k1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {10, 5, 2, 7, 1, 9};
        int k2 = 7;
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestSubarrayWithGivenSumPositiveNumbers.longestSubarrayBruteforce(input2,k2));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestSubarrayWithGivenSumPositiveNumbers.longestSubarray(input2,k2));
        System.out.println("------------------------------------------------------");
        
    }

}
