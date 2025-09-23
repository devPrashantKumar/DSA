package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayOfSumK {
    /*
     * Time Complexity : O(n^2)
     */
    public static int maxSubArrayBruteforce(int[] arr, int k){
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum==k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            } 
        }
        return maxLen;
    }

    /*
     * Time Complexity : O(n)
     * Space COmplexity : O(n)
     * this solution will work for negative elements also.
     */
    public static int maxSubArrayBetter(int[] arr, int k){
        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum=0;
        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                int len = j-map.get(sum-k);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)){
                map.put(sum, j);
            }
        }
        System.out.println(map);
        return maxLen;
    }
    
    /*
     * Time Complexity : O(n)
     * this solution will not work for negative elements.
     */
    public static int maxSubArrayOptimal(int[] arr, int k){
        int maxLen = Integer.MIN_VALUE;
        int i=0; 
        int sum=0;
        for(int j=0;j<arr.length;j++){
            if(sum<=k){
                sum += arr[j];
            } 
            if(sum==k){
                maxLen = Math.max(maxLen, j-i+1);
            }
            while(sum>k){
                sum -= arr[i];
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] input1 = {2,4,1,0, 0 , 0,7,8,3};
        int k1 = 7;
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MaxSubarrayOfSumK.maxSubArrayBruteforce(input1,k1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MaxSubarrayOfSumK.maxSubArrayBetter(input1,k1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MaxSubarrayOfSumK.maxSubArrayOptimal(input1,k1));
        System.out.println("------------------------------------------------------");
        
    }
}
