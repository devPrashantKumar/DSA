package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {
    /*
     * Time Complexity : O(n *2^n)+(2^n * log 2^n)
     * (n*2^n) -> to generate subsets
     * (2^n * log 2^n) -> to sort the final subsets sum
     */
    public static List<Integer> subsets(int[] nums) {
        List<Integer> result = new ArrayList<>();
        generateSubsets(nums,0,0,result);
        Collections.sort(result);
        return result;
    }

    public static void generateSubsets(int[] nums, int index, int sum, List<Integer> result) {
        if(index==nums.length){
            result.add(sum);
            return;
        }
        generateSubsets(nums,index+1,sum,result);
        sum+=nums[index];
        generateSubsets(nums,index+1,sum,result);
        sum -= nums[index];
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
        int[] nums1 = {3,1,2};
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+SubsetSumI.subsets(nums1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+SubsetSumI.subsetsUsinBitManipulation(nums1));
    }
}
