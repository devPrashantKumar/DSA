package AZStriverPlaylist.Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfSortedArrays {

    public static int[] unionBruteforce(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] union(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (i>0 && j>0 && arr1[i] == arr1[i - 1] && arr2[j] == arr2[j - 1]) {
                    i++;
                    j++;
                } else {
                    result.add(arr1[i]);
                    i++;
                    j++;
                }
            }else if(arr1[i]<arr2[j]){
                if (i>0 && arr1[i] == arr1[i - 1]) {
                    i++;
                } else {
                    result.add(arr1[i]);
                    i++;
                }
            }
            else{
                if (j>0 && arr2[j] == arr2[j - 1]) {
                    j++;
                } else {
                    result.add(arr2[j]);
                    j++;
                }
            }
        }
        while (i < arr1.length) {
            if (i>0 && arr1[i] == arr1[i - 1]) {
                i++;
            } else {
                result.add(arr1[i]);
                i++;
            }
        }

        while (j < arr2.length) {
            if (j>0 && arr2[j] == arr2[j - 1]) {
                j++;
            } else {
                result.add(arr2[j]);
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }


    public static int[] unionOptimal(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int lastUsed=Integer.MIN_VALUE;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i]<=arr2[j]){
                if(lastUsed!=arr1[i]){
                    result.add(arr1[i]);
                    lastUsed=arr1[i];
                }
                i++;
            }
            else{
                if(lastUsed!=arr2[j]){
                    result.add(arr2[j]);
                    lastUsed=arr2[j];
                }
                j++;
            }
        }
        while (i < arr1.length) {
            if(lastUsed!=arr1[i]){
                result.add(arr1[i]);
                lastUsed=arr1[i];
            }
            i++;
        }

        while (j < arr2.length) {
            if(lastUsed!=arr2[j]){
                result.add(arr2[j]);
                lastUsed=arr2[j];
            }
            j++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }


    public static void main(String[] args) {
        int[] input11 = {2,2,2,4,7,8,8};
        int[] input12 = {2,4,5,6,6,8,9,9,9,10};
        System.out.println("Input11 : "+Arrays.toString(input11));
        System.out.println("Input12 : "+Arrays.toString(input12));
        System.out.println("Output : "+Arrays.toString(UnionOfSortedArrays.unionBruteforce(input11, input12)));
        System.out.println("Output : "+Arrays.toString(UnionOfSortedArrays.union(input11, input12)));
        System.out.println("Output : "+Arrays.toString(UnionOfSortedArrays.unionOptimal(input11, input12)));

        System.out.println("------------------------------------------------------");
    }
}
