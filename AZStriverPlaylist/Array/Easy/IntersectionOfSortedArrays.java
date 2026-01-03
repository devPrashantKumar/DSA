package AZStriverPlaylist.Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfSortedArrays {

    public static int[] intersectionBruteforce(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                resultSet.add(arr2[i]);
            }
        }
        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersection(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int lastUsed=Integer.MIN_VALUE;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (lastUsed==arr1[i]) {
                    i++;
                    j++;
                } else {
                    result.add(arr1[i]);
                    lastUsed = arr1[i];
                    i++;
                    j++;
                }
            }else if(arr1[i]<arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] input11 = {2,2,2,4,7,8,8};
        int[] input12 = {2,4,5,6,6,8,9,9,9,10};
        System.out.println("Input11 : "+Arrays.toString(input11));
        System.out.println("Input12 : "+Arrays.toString(input12));
        System.out.println("Output : "+Arrays.toString(IntersectionOfSortedArrays.intersection(input11, input12)));
        System.out.println("Output : "+Arrays.toString(IntersectionOfSortedArrays.intersectionBruteforce(input11, input12)));

        System.out.println("------------------------------------------------------");
    }
}
