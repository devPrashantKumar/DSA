package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;

public class MaximumProductSubarrayInAnArray {

    // TC : O(n)
    // SC : O(1)
    public static int maxProduct(int[] nums){
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix *= nums[i];
            suffix *= nums[n-1-i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2,3,-2,4 };
        int[] nums2 = { -2,0,-1 };
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " + maxProduct(nums1));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + maxProduct(nums2));

        System.out.println("---------------------------------------------------");
    }
}
