package AZStriverPlaylist.Array;

import java.util.Arrays;

public class KadanesAlgoMaximumSubarray {
    public static int maxSubarraySum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int maxSubarraySum2(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int maxSubarraySumKadanesAlgo(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        int index=-1,startIndex=-1,endIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(sum==0) index=i;
            sum+=arr[i];

            if(sum>maxSum){
                startIndex=index;
                endIndex=i;
            }
            maxSum = Math.max(sum,maxSum);
            if(sum<0) sum=0;
        }

        for(int i=startIndex;i<=endIndex;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySum(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySum2(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input1));

        System.out.println("-------------------------------------------");
        int[] input2 = {1};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySum(input2));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySum2(input2));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input2));

        System.out.println("-------------------------------------------");
        int[] input3 = {5,4,-1,7,8};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySum(input3));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySum2(input3));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input3));

        System.out.println("------------------------------------------------------");
        
    }
}
