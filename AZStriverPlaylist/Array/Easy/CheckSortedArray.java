package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;

public class CheckSortedArray {

    public static boolean checkIfArrayIsSorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] input1 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+CheckSortedArray.checkIfArrayIsSorted(input1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {1,2,2,4,7,8,8};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+CheckSortedArray.checkIfArrayIsSorted(input2));

    }
}