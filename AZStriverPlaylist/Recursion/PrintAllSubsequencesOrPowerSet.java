package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubsequencesOrPowerSet {
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

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+PrintAllSubsequencesOrPowerSet.subsets(nums1));
    }
}
