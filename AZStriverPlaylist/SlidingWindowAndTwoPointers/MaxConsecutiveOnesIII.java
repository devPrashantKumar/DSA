package AZStriverPlaylist.SlidingWindowAndTwoPointers;

import java.util.Arrays;

import AZStriverPlaylist.StackAndQueues.SumOfSubarrayMinimum;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int maxLen=0;
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]==1) j++;
            else{
                if(k>0){
                    k--; j++;
                }else{
                    while(nums[i]!=0) i++;
                    i++; k++;
                }
            }
            maxLen = Math.max(maxLen, j-i);
        }
        maxLen = Math.max(maxLen, j-i);
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,1,1,0,0,0,1,1,1,1,0 };
        int k1 = 2;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes(nums1,k1));

        int[] nums2 = { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 };
        int k2=3;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes(nums2,k2));
    }
}
