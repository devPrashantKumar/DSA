package AZStriverPlaylist.Array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesInSortedArray {

    public static int[] removeDuplicatesBruteforce(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    } 

    public static int[] removeDuplicates(int[] arr){
        int curr=0;
        for(int i=1;i<arr.length;i++){
            if(arr[curr]!=arr[i]){
                arr[++curr] = arr[i];
            }
        }
        return Arrays.copyOf(arr, curr+1);
    } 
    public static void main(String[] args) {
        int[] input1 = {1,1,3,4,5,7,7,8,8};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+Arrays.toString(RemoveDuplicatesInSortedArray.removeDuplicatesBruteforce(input1)));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+Arrays.toString(RemoveDuplicatesInSortedArray.removeDuplicates(input1)));
        
        System.out.println("------------------------------------------------------");
        int[] input2 = {1,2,2,4,5,8,9};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+Arrays.toString(RemoveDuplicatesInSortedArray.removeDuplicatesBruteforce(input2)));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+Arrays.toString(RemoveDuplicatesInSortedArray.removeDuplicates(input2)));

    }
}
