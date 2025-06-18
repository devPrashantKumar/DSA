package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
     * Time Comlexity: O(n * 2^t) 
     * where t is number of element in max length combination.
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombination(candidates,target,combination,0,result);
        return result;
    }

    public static void generateCombination(int[] candidates, int target,List<Integer> combination, int index,List<List<Integer>> result){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            combination.add(candidates[i]);
            generateCombination(candidates, target-candidates[i], combination, i,result);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {2,3,6,7};
        int target1 = 7;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target1);
        System.out.println(" Output : "+CombinationSum.combinationSum(candidates1, target1));

        int[] candidates2 = {2};
        int target2 = 1;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target2);
        System.out.println(" Output : "+CombinationSum.combinationSum(candidates2, target2));
    }
}
