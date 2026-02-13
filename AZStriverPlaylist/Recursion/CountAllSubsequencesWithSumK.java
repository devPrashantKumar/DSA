package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAllSubsequencesWithSumK {
    /*
    * Time Complexity : O(n*2^n)
    * Space Complexity : O(n) -> space occupied by recursion stack
    */
    public static int countSubsetsOfSumK(int[] nums, int k) {
        List<Integer> set = new ArrayList<>();
        return generateSubsets(nums,0,set, k);
    }

    public static int generateSubsets(int[] nums, int index, List<Integer> set, int k) {
        if(index==nums.length){
            int sum=0;
            for(int num:set){
                sum+= num;
            }
            return (sum==k) ? 1:0;
        }
        
        int l = generateSubsets(nums,index+1,set,k);
        List<Integer> set2= new ArrayList<>(set);
        set2.add(nums[index]);
        int r = generateSubsets(nums,index+1,set2,k);
        return l+r;
    }

    /*
    * Time Complexity : O(n*2^n)
    * Space Complexity : O(n) -> space occupied by recursion stack
    */
    public static int countSubsetsOfSumKApproach2(int[] nums, int k) {
        List<Integer> set = new ArrayList<>();
        return generateSubsetsApproach2(nums,0,set, k);
    }

    public static int generateSubsetsApproach2(int[] nums, int index, List<Integer> set, int k) {
        if(index==nums.length){
            int sum=0;
            for(int num:set){
                sum+= num;
            }
            return (sum==k) ? 1:0;
        }
        
        int l = generateSubsetsApproach2(nums,index+1,set,k);
        set.add(nums[index]);
        int r = generateSubsetsApproach2(nums,index+1,set,k);
        set.remove(set.size()-1);
        return l+r;
    }

    /*
    * Time Complexity : O(2^n)
    * Space Complexity : O(n) -> space occupied by recursion stack
    */
    public static int countSubsetsOfSumKUsingRunningSumApproach(int[] nums, int k) {
        List<Integer> set = new ArrayList<>();
        return generateSubsetsUsingRunningSumApproach(nums,0,set, k, 0);
    }

    public static int generateSubsetsUsingRunningSumApproach(int[] nums, int index, List<Integer> set, int k, int currentSum) {
        if(index==nums.length){
            return (currentSum==k) ? 1:0;
        }
        
        int l = generateSubsetsUsingRunningSumApproach(nums,index+1,set,k, currentSum);
        set.add(nums[index]);
        int r = generateSubsetsUsingRunningSumApproach(nums,index+1,set,k,currentSum+nums[index]);
        set.remove(set.size()-1);
        return l+r;
    }

    /*
    * Time Complexity : O(n*2^n)
    * Space Complexity : O(1)
    */
    public static int countSubsetsOfSumKUsinBitManipulation(int[] nums, int k) {
        int count=0;
        int numberOfElements = (int) Math.pow(2, nums.length);
        for(int i=0;i<numberOfElements;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0){
                    sum+=nums[j];
                }
            }
            if(sum==k) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int k1 = 5;
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+CountAllSubsequencesWithSumK.countSubsetsOfSumK(nums1, k1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+CountAllSubsequencesWithSumK.countSubsetsOfSumKApproach2(nums1, k1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+CountAllSubsequencesWithSumK.countSubsetsOfSumKUsingRunningSumApproach(nums1, k1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+CountAllSubsequencesWithSumK.countSubsetsOfSumKUsinBitManipulation(nums1,k1));
    }
}
