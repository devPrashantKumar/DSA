package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {
    /*
     * Time Complexity : O(n * 2^n)
     * (2^n * log 2^n) -> to sort the final subsets sum
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, -1, new ArrayList<>(), result);
        return result;
    }

    public static void generateSubsets(int[] nums, int index, int previous,List<Integer> set, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }

        generateSubsets(nums, index + 1,0, set, result);

        if (!(index - 1 >= 0 && nums[index] == nums[index - 1] && previous==0)) {
            set.add(nums[index]);
            previous=1;
            generateSubsets(nums, index + 1,previous, set, result);
            set.remove(set.size() - 1);
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets2(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void generateSubsets2(int[] nums, int index,List<Integer> set, List<List<Integer>> result) {
        result.add(new ArrayList<>(set));
        int previous=Integer.MIN_VALUE;
        for(int i=index;i<nums.length;i++){
            if(previous!=nums[i]){
                set.add(nums[i]);
                generateSubsets2(nums, i+1, set, result);
                set.remove(set.size()-1);
            }
            previous = nums[i];
        }
    }

    /*
     * Time Complexity : O(n *2^n)
     * (2^n) -> all subsets
     * (n) to process each subset
     */
    public static List<List<Integer>> subsetsUsinBitManipulation(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int numberOfElements = (int) Math.pow(2, nums.length);
        l1 : for (int i = 0; i < numberOfElements; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if(j-1>=0 && nums[j]==nums[j-1] &&  ((i & (1 << j-1)) == 0) && ((i & (1 << j)) != 0) ) continue l1; 
                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2 };
        System.out.println("Input 1 " + Arrays.toString(nums1) + " Output : " + SubsetSumII.subsets(nums1));
        System.out.println(
                "Input 1 " + Arrays.toString(nums1) + " Output : " + SubsetSumII.subsetsUsinBitManipulation(nums1));
        System.out.println("Input 1 " + Arrays.toString(nums1) + " Output : " + SubsetSumII.subsets2(nums1));

    }
}
