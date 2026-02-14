package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
     * n = number of candidates
     * T = target
     * m = smallest value in candidates
     * t = T / m → maximum possible length of a combination
     * Time Comlexity: O(n^t) 
     * Space Complexity O(t)
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

    /*
     * n = number of candidates
     * T = target
     * m = smallest value in candidates
     * t = T / m → maximum possible length of a combination
     * Time Comlexity: O(n^t) 
     * Space Complexity O(t)
     */
    public static List<List<Integer>> combinationSumApproach2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombinationApproach2(candidates,target,combination,0,result);
        return result;
    }

    public static void generateCombinationApproach2(int[] candidates, int target,List<Integer> combination, int index,List<List<Integer>> result){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(index>=candidates.length) return;

        generateCombinationApproach2(candidates, target, combination, index+1,result);
        combination.add(candidates[index]);
        generateCombinationApproach2(candidates, target-candidates[index], combination, index,result);
        combination.remove(combination.size()-1);
    }

    public static void main(String[] args) {
        int[] candidates1 = {2,3,6,7};
        int target1 = 7;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target1);
        System.out.println("Output : "+CombinationSum.combinationSum(candidates1, target1));

        int[] candidates2 = {2};
        int target2 = 1;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target2);
        System.out.println("Output : "+CombinationSum.combinationSum(candidates2, target2));
        System.out.println("-----------------------------------------------------------------------------");
        int[] candidates3 = {2,3,6,7};
        int target3 = 7;
        System.out.println("Input: " + Arrays.toString(candidates3)+" target: "+target3);
        System.out.println("Output : "+CombinationSum.combinationSumApproach2(candidates3, target3));

        int[] candidates4 = {2};
        int target4 = 1;
        System.out.println("Input: " + Arrays.toString(candidates4)+" target: "+target4);
        System.out.println("Output : "+CombinationSum.combinationSumApproach2(candidates4, target4));
        System.out.println("-----------------------------------------------------------------------------");
    }
}
