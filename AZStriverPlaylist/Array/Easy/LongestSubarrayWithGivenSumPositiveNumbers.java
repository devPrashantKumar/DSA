package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;

public class LongestSubarrayWithGivenSumPositiveNumbers {

    public static int longestSubarray(int[] nums, int k) {
        int i=0;
        int sum=0;
        int maxAns = 0;
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(sum==k) maxAns = Math.max(maxAns,j-i+1);
            else if(sum>k) sum-=nums[i++];
        }
       return maxAns;
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,1};
        int k1 = 2;
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestSubarrayWithGivenSumPositiveNumbers.longestSubarray(input1,k1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {10, 5, 2, 7, 1, 9};
        int k2 = 7;
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestSubarrayWithGivenSumPositiveAndNegativeNumbers.longestSubarray(input2,k2));
        System.out.println("------------------------------------------------------");
        
    }

}
