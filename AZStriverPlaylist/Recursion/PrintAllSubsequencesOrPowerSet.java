package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubsequencesOrPowerSet {
    /*
    * Time Complexity : O(n*2^n)
    * Space Complexity : O(n) -> space occupied by recursion stack
    */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        generateSubsets(nums,0,set,result);
        return result;
    }

    public static void generateSubsets(int[] nums, int index, List<Integer> set, List<List<Integer>> result) {
        if(index==nums.length){
            result.add(set);
            return;
        }
        generateSubsets(nums,index+1,set,result);
        List<Integer> set2= new ArrayList<>(set);
        set2.add(nums[index]);
        generateSubsets(nums,index+1,set2,result);
    }

    /*
    * Time Complexity : O(n*2^n)
    * Space Complexity : O(1)
    */
    public static List<List<Integer>> subsetsUsinBitManipulation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int numberOfElements = (int) Math.pow(2, nums.length);
        for(int i=0;i<numberOfElements;i++){
            List<Integer> set = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0){
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+PrintAllSubsequencesOrPowerSet.subsets(nums1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+PrintAllSubsequencesOrPowerSet.subsetsUsinBitManipulation(nums1));
    }
}
