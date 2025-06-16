package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfExistsSubsequencesWithSumK {
    public static boolean checkIfExistsSubsetsOfSumK(int[] nums, int k) {
        List<Integer> set = new ArrayList<>();
        return generateSubsets(nums,0,set, k);
    }

    public static boolean generateSubsets(int[] nums, int index, List<Integer> set, int k) {
        if(index==nums.length){
            int sum=0;
            for(int num:set){
                sum+= num;
            }
            return (sum==k) ? true:false;
        }
        
        boolean l = generateSubsets(nums,index+1,set,k);
        List<Integer> set2= new ArrayList<>(set);
        set2.add(nums[index]);
        boolean r = generateSubsets(nums,index+1,set2,k);
        return l||r;
    }

    /*
     * Time Complexity : O(n*2^n)
     */
    public static boolean checkIfExistsSubsetsOfSumKUsinBitManipulation(int[] nums, int k) {
        int numberOfElements = (int) Math.pow(2, nums.length);
        for(int i=0;i<numberOfElements;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0){
                    sum+=nums[j];
                }
            }
            if(sum==k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int k1 =5;
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+CheckIfExistsSubsequencesWithSumK.checkIfExistsSubsetsOfSumK(nums1, k1));
        System.out.println("Input 1 " + Arrays.toString(nums1)+" Output : "+CheckIfExistsSubsequencesWithSumK.checkIfExistsSubsetsOfSumKUsinBitManipulation(nums1,k1));
    }
}
