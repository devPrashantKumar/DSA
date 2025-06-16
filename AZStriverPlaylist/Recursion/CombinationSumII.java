package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombination(candidates,target,combination,-1,result);
        return result;
    }

    public static void generateCombination(int[] candidates, int target,List<Integer> combination, int index,List<List<Integer>> result){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        int previous=-1;
        for(int i=index+1;i<candidates.length;i++){
            if(previous!=candidates[i]){
                combination.add(candidates[i]);
                generateCombination(candidates, target-candidates[i], combination, i,result);
                combination.remove(combination.size()-1);
            }
            previous = candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target1);
        System.out.println(" Output : "+CombinationSumII.combinationSum(candidates1, target1));

        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target2);
        System.out.println(" Output : "+CombinationSumII.combinationSum(candidates2, target2));
    }
}
