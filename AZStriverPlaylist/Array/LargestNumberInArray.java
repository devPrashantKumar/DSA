package AZStriverPlaylist.Array;

import java.util.Arrays;

public class LargestNumberInArray {
    // Bruteforce approch
    public static int largestNumber(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public static int largestNumberOptimalApproach(int[] arr){
        int largest = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] input1 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LargestNumberInArray.largestNumber(input1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {2,4,1,7,8,3};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LargestNumberInArray.largestNumberOptimalApproach(input2));

    }
    
}
