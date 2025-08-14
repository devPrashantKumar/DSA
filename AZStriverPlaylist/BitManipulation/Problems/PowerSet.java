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

    public static void main(String[] args) {
        System.out.println("Power Set : " + powerSet(new int[] {1,2,3}));
        System.out.println("Power Set : " + powerSet(new int[] {4,1,2,1,2}));
        System.out.println("Power Set : " + powerSet(new int[] {0}));
        System.out.println("-------------------------------------------------");
    }
}
