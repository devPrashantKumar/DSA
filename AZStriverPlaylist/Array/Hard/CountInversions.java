package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class CountInversions {

    public static long numberOfInversions(int[] nums) {
        long inversionCount=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]) inversionCount++;
            }
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 7, 1, 3, 5};
        int[] nums2 = { -10, -5, 6, 11, 15, 17 };
        int[] nums3 = { 9, 5, 4, 2};
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " +CountInversions.numberOfInversions(nums1));
        System.out.println("Output : " +CountInversions.numberOfInversions(nums1));
        System.out.println("Output : " +CountInversions.numberOfInversions(nums1));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + CountInversions.numberOfInversions(nums2));
        System.out.println("Output : " + CountInversions.numberOfInversions(nums2));
        System.out.println("Output : " + CountInversions.numberOfInversions(nums2));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output : " + CountInversions.numberOfInversions(nums3));
        System.out.println("Output : " + CountInversions.numberOfInversions(nums3));
        System.out.println("Output : " + CountInversions.numberOfInversions(nums3));

        System.out.println("---------------------------------------------------");
    }
}
