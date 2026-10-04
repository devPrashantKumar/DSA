package AZStriverPlaylist.SlidingWindowAndTwoPointers;

import java.util.Arrays;

public class MaxConsecutiveOnesIII {
    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1) 
    */
    public static int longestOnes(int[] nums, int k) {
        int maxLen=0;
        int i=0;
        int j=0;
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

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1) 
    */
    public static int longestOnes2(int[] nums, int k) {
        int maxLen=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==1) j++;
            else{
                if(k>0){
                    k--;
                }else{
                    maxLen = Math.max(maxLen, j-i);
                    while(nums[i]!=0) i++;
                    i++;
                }
                j++;
            }
        }
        maxLen = Math.max(maxLen, j-i);
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes(nums1, k1));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes2(nums1, k1));
        System.out.println("---------------------------------------------");

        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k2 = 3;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes(nums2, k2));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes2(nums2, k2));
        System.out.println("---------------------------------------------");

        int[] nums3 = { 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1 };
        int k3 = 3;
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes(nums3, k3));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes2(nums3, k3));
        System.out.println("---------------------------------------------");

        int[] nums4 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k4 = 3;
        System.out.println("Input : " + Arrays.toString(nums4));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes(nums4, k4));
        System.out.println("output : " + MaxConsecutiveOnesIII.longestOnes2(nums4, k4));

    }
}
