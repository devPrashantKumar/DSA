package AZStriverPlaylist.SlidingWindowAndTwoPointers.CountingSubArraysSubstringsProblems;

import java.util.*;

public class SubarraysWithKDifferentIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k)-subarraysWithAtMostKDistinct(nums, k-1);
    }

    public static int subarraysWithAtMostKDistinct(int[] nums, int k) {
        if(k<0) return 0;
        Map<Integer,Integer> hmap = new HashMap<>();
        int subArrayCount = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            hmap.put(nums[r], hmap.getOrDefault(nums[r],0)+1);
            while (hmap.size()>k) {
                hmap.put(nums[l], hmap.get(nums[l])-1);
                if(hmap.get(nums[l])==0) 
                    hmap.remove(nums[l]);
                l++;
            }
            subArrayCount += r - l + 1;
            r++;
        }
        return subArrayCount;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 1, 2, 3 };
        int k1 = 2;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + subarraysWithKDistinct(nums1, k1));
        System.out.println("----------------------------------------------------------------");

        int[] nums2 = { 1, 2, 1, 3, 4 };
        int k2 = 3;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + subarraysWithKDistinct(nums2, k2));
    }
}
