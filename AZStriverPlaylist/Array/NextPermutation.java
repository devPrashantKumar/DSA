package AZStriverPlaylist.Array;

import java.util.*;

public class NextPermutation {

    public static int[] nextPermutationOptimal(int[] arr) {
        int index1 = -1;
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index1 = i;
                break;
            }
        }

        if (index1 != -1) {
            for (int i = n - 1; i > index1; i--) {
                if (arr[i] > arr[index1]) {
                    swap(arr, index1, i);
                    break;
                }
            }
        }

        reverse(arr, index1+1, arr.length);
        return arr;
    }

    public static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public static void reverse(int[] arr, int ind1, int ind2) {
        int left = ind1;
        int right = ind2 - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    /*
     *  Print all Permutations of a String/Array approach
     * Time Complexity : (n*n!)+(n!*log(n!))+(n*n!)
     */
    public static int[] nextPermutationBruteForce(int[] arr) {
        List<List<Integer>> permutations=allPermutations(arr);
        permutations.sort((e1,e2)->{
            for(int i=0;i<e1.size();i++){
                if(e1.get(i)<e2.get(i)) return -1;
                else if(e1.get(i)>e2.get(i)) return 1;
            }
            return -1;
        });

        int permutationIndex=-1;
        l1 : for(int i=0;i<permutations.size();i++){
            List<Integer> permutation = permutations.get(i);
            for(int j=0;j<arr.length;j++){
                if(arr[j]!=permutation.get(j)){
                    continue l1;
                }
            }
            permutationIndex=i;
        }

        List<Integer> nextPermutation = permutations.get((permutationIndex + 1) % permutations.size());
        return nextPermutation.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     * Time Complexity : (n*n!)
     */
    public static List<List<Integer>> allPermutations(int[] arr) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new ArrayList<>(), arr, new boolean[arr.length]);
        return permutations;
    }
    
    private static void backtrack(List<List<Integer>> permutations, List<Integer> tempList, int[] arr, boolean[] used) {
        if (tempList.size() == arr.length) {
            permutations.add(new ArrayList<>(tempList));
            return;
        }
    
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            tempList.add(arr[i]);
            backtrack(permutations, tempList, arr, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }    

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationBruteForce(input1)));
        int[] input11 = { 1, 2, 3 };
        System.out.println("Input : " + Arrays.toString(input11) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationOptimal(input11)));
        System.out.println("------------------------------------------------------");

        int[] input2 = { 3, 2, 1 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationBruteForce(input2)));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationOptimal(input2)));
        System.out.println("------------------------------------------------------");

        int[] input3 = { 1, 1, 5 };
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationBruteForce(input3)));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationOptimal(input3)));
        System.out.println("------------------------------------------------------");

        int[] input4 = { 1, 3, 2 };
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationBruteForce(input4)));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + Arrays.toString(NextPermutation.nextPermutationOptimal(input4)));
    }

}
