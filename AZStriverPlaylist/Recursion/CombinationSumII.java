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

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombination2(candidates,target,combination,0,result);
        return result;
    }

    public static void generateCombination2(int[] candidates, int target,List<Integer> combination, int index,List<List<Integer>> result){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        int previous=-1;
        for(int i=index;i<candidates.length;i++){
            if(previous!=candidates[i]){
                combination.add(candidates[i]);
                generateCombination2(candidates, target-candidates[i], combination, i+1,result);
                combination.remove(combination.size()-1);
            }
            previous = candidates[i];
        }
    }

    public static List<List<Integer>> combinationSumApproach2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinationApproach2(candidates,target,combination,0,-1,result);
        return result;
    }

    public static void generateCombinationApproach2(int[] candidates, int target,List<Integer> combination, int index,int prev,List<List<Integer>> result){
        if(target<0) return;
        if(index == candidates.length && target==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(index>=candidates.length) return;

        if(prev!=candidates[index]){
            generateCombinationApproach2(candidates, target, combination, index+1,prev,result);
        }
        combination.add(candidates[index]);
        generateCombinationApproach2(candidates, target-candidates[index], combination, index+1,candidates[index],result);
        combination.remove(combination.size()-1);
    }

    public static void main(String[] args) {
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println("Input: " + Arrays.toString(candidates1)+" target: "+target1);
        System.out.println("Output : "+CombinationSumII.combinationSum(candidates1, target1));

        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println("Input: " + Arrays.toString(candidates2)+" target: "+target2);
        System.out.println("Output : "+CombinationSumII.combinationSum(candidates2, target2));
        System.out.println("--------------------------------------------------------------------");
        int[] candidates3 = {10,1,2,7,6,1,5};
        int target3 = 8;
        System.out.println("Input: " + Arrays.toString(candidates3)+" target: "+target3);
        System.out.println("Output : "+CombinationSumII.combinationSum2(candidates3, target3));

        int[] candidates4 = {2,5,2,1,2};
        int target4 = 5;
        System.out.println("Input: " + Arrays.toString(candidates4)+" target: "+target4);
        System.out.println("Output : "+CombinationSumII.combinationSum2(candidates4, target4));
        System.out.println("--------------------------------------------------------------------");
        int[] candidates5 = {10,1,2,7,6,1,5};
        int target5 = 8;
        System.out.println("Input: " + Arrays.toString(candidates5)+" target: "+target5);
        System.out.println("Output : "+CombinationSumII.combinationSumApproach2(candidates5, target5));

        int[] candidates6 = {2,5,2,1,2};
        int target6 = 5;
        System.out.println("Input: " + Arrays.toString(candidates6)+" target: "+target6);
        System.out.println("Output : "+CombinationSumII.combinationSumApproach2(candidates6, target6));
        System.out.println("--------------------------------------------------------------------");
    }
}
