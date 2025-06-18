package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSumII {
    /*
     * Time Complexity : O(2^n)+(2^n * log 2^n)
     * (2^n) -> to generate subsets
     * (2^n * log 2^n) -> to sort the final subsets sum
     */ 
    public static List<List<Integer>> subsets(int[] nums) {
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
     * Time Complexity : O(n *2^n)+(2^n * log 2^n)
     * (n*2^n) -> to generate subsets
     * (2^n * log 2^n) -> to sort the final subsets sum
     */
    public static List<Integer> subsetsUsinBitManipulation(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int numberOfElements = (int) Math.pow(2, nums.length);
        for(int i=0;i<numberOfElements;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0){
                    sum+=nums[j];
                }
            }
            result.add(sum);
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2};
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+SubsetSumII.subsets(nums1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+SubsetSumI.subsetsUsinBitManipulation(nums1));
    }
}
