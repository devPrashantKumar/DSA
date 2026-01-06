package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class ThreeSum {
    /*
    * Time Complexity : O(n log n)+ O(n^2)
    * Space Complexity : O(1)
    */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int lastUsed = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=lastUsed){
                int firstElement = nums[i];
                int start = i+1;
                int end = nums.length-1;
                while(start<end){
                    if(nums[start]+nums[end]==(-firstElement)){
                        result.add(List.of(firstElement,nums[start],nums[end]));
                        start++;end--;
                        while(start<end && nums[start]==nums[start-1]) start++;
                        while(end>start && nums[end]==nums[end+1]) end--;
                    }
                    else if(nums[start]+nums[end]<(-firstElement)){
                        start++;
                    }else{
                        end--;
                    }
                }
                lastUsed = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { -1,0,1,2,-1,-4 };
        int[] nums2 = { 0,1,1 };
        int[] nums3 = { 0,0,0};
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " +ThreeSum.threeSum(nums1));
        System.out.println("Output : " +ThreeSum.threeSum(nums1));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + ThreeSum.threeSum(nums2));
        System.out.println("Output : " + ThreeSum.threeSum(nums2));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output : " + ThreeSum.threeSum(nums3));
        System.out.println("Output : " + ThreeSum.threeSum(nums3));

        System.out.println("---------------------------------------------------");
    }
}
