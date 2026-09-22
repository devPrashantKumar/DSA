package AZStriverPlaylist.Recursion.MediumProblems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombination(n,k,combination,1,result);
        return result;
    }

    public static void generateCombination(int n, int k,List<Integer> combination, int index,List<List<Integer>> result){
        if(combination.size()==k && n==0){
            result.add(new ArrayList<>(combination));
        } 
        for(int i=index;i<10;i++){
            combination.add(i);
            generateCombination(n-i,k, combination, i+1,result);
            combination.remove(combination.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombination(n,k,combination,1,result);
        return result;
    }

    public static void generateCombination2(int n, int k,List<Integer> combination, int index,List<List<Integer>> result){
        if(combination.size()==k && n==0){
            result.add(new ArrayList<>(combination));
        } 
        if(index==10) return;
        generateCombination(n,k, combination, index+1,result);
        combination.add(index);
        generateCombination(n-index,k, combination, index+1,result);
        combination.remove(combination.size()-1);
    }

    public static void main(String[] args) {
        int n1 = 7;
        int k1=3;
        System.out.println("Input: " + n1 +" "+k1);
        System.out.println(" Output : "+CombinationSumIII.combinationSum(n1,k1));
        System.out.println(" Output : "+CombinationSumIII.combinationSum2(n1,k1));

        int n2 = 9;
        int k2=3;
        System.out.println("Input: " + n2 +" "+k2);
        System.out.println(" Output : "+CombinationSumIII.combinationSum(n2,k2));
        System.out.println(" Output : "+CombinationSumIII.combinationSum2(n2,k2));

    }
}
