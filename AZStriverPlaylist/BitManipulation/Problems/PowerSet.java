package AZStriverPlaylist.BitManipulation.Problems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /*
     * Time Complexity : O(n * 2^n)
     */
    public static List<List<Integer>> powerSet(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int n = (1 << nums.length); // number of subsets
        for(int i=0;i<n;i++){
            int value=i;
            int k=0;
            List<Integer> set = new ArrayList<>();
            while(value!=0){
                if((value & 1) != 0){
                    set.add(nums[k]);
                }
                k++;
                value = value >> 1;
            }
            ans.add(set); 
        }
        return ans;
    }

    /*
    * Time Complexity: O(n * 2^n), 2^n for generating powerset, n for copying each set into result
    * Auxiliary Space: O(n)
    * Excluding space occupied by the result
    */
    public static List<List<Integer>> powersetUsingBacktracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums,0,new ArrayList<>(),result);
        return result;
    }

    public static void generateSubsets(int[] nums, int index, List<Integer> set, List<List<Integer>> result) {
        if(index==nums.length){
            result.add(new ArrayList<>(set));
            return;
        }
        generateSubsets(nums,index+1,set,result);
        set.add(nums[index]);
        generateSubsets(nums,index+1,set,result);
        set.remove(set.size()-1);
    }

    /*
    * Time Complexity: O(n * 2^n), 2^n for generating powerset, n for copying each set into result
    * Auxiliary Space: O(n)
    * Excluding space occupied by the result
    */
    public static List<List<Integer>> powersetUsingBacktracking2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        powersetUsingForLoopBasedBacktracking(nums,0,new ArrayList<>(),result);
        return result;
    }


    public static void powersetUsingForLoopBasedBacktracking(int[] nums, int index, List<Integer> set, List<List<Integer>> result) {
        result.add(new ArrayList<>(set));
        for(int i=index;i<nums.length;i++){
            set.add(nums[i]);
            powersetUsingForLoopBasedBacktracking(nums,i+1,set,result);
            set.remove(set.size()-1);
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Power Set : " + powerSet(new int[] {1,2,3}));
        System.out.println("Power Set : " + powersetUsingBacktracking(new int[] {1,2,3}));
        System.out.println("Power Set : " + powersetUsingBacktracking2(new int[] {1,2,3}));
        System.out.println("-------------------------------------------------");

        System.out.println("Power Set : " + powerSet(new int[] {4,1,2,1,2}));
        System.out.println("Power Set : " + powersetUsingBacktracking(new int[] {4,1,2,1,2}));
        System.out.println("Power Set : " + powersetUsingBacktracking2(new int[] {4,1,2,1,2}));
        System.out.println("-------------------------------------------------");

        System.out.println("Power Set : " + powerSet(new int[] {0}));
        System.out.println("Power Set : " + powersetUsingBacktracking(new int[] {0}));
        System.out.println("Power Set : " + powersetUsingBacktracking2(new int[] {0}));
        System.out.println("-------------------------------------------------");
    }
}
