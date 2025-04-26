package AZStriverPlaylist.Array;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2s {
    
    //brute-force approach
    public static int[] sortArrayUsingBruteForce(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    // better approach
    public static int[] sortArrayUsingOccurenceCounting(int[] arr){
        int zeroes=0,ones=0;
        for(int num:arr){
            if(num==0) zeroes++;
            else if (num==1) ones++;
        }
        for(int i=0;i<zeroes;i++){
            arr[i]=0;
        }
        for(int i=zeroes;i<zeroes+ones;i++){
            arr[i]=1;
        }
        for(int i=zeroes+ones;i<arr.length;i++){
            arr[i]=2;
        }
        return arr;
    }

    // optimal approach
    public static int[] sortArrayUsingDutchNationalFlagAlgo(int[] arr){
        int low=0;
        int mid=0;
        int high = arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] input11 = {0,1,2,0,0,2,2,2,0,2,1,2,0,1,1,1,0,0,0};
        int[] input12 = {0,1,2,0,0,2,2,2,0,2,1,2,0,1,1,1,0,0,0};
        int[] input13 = {0,1,2,0,0,2,2,2,0,2,1,2,0,1,1,1,0,0,0};
        System.out.println("Input : "+Arrays.toString(input11)+"\nOutput : "+Arrays.toString(SortAnArrayOf0s1sAnd2s.sortArrayUsingBruteForce(input11)));
        System.out.println("Input : "+Arrays.toString(input12)+"\nOutput : "+Arrays.toString(SortAnArrayOf0s1sAnd2s.sortArrayUsingOccurenceCounting(input11)));
        System.out.println("Input : "+Arrays.toString(input13)+"\nOutput : "+Arrays.toString(SortAnArrayOf0s1sAnd2s.sortArrayUsingDutchNationalFlagAlgo(input13)));

        System.out.println("------------------------------------------------------");

    }
}
