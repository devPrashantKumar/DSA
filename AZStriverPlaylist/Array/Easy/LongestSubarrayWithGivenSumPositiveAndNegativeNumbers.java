package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWithGivenSumPositiveAndNegativeNumbers {

    public static int longestSubarray(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int sum=0;
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hmap.containsKey(sum-k)){
                int length = i-hmap.get(sum-k);
                maxLength = Math.max(length,maxLength);
            }
            hmap.putIfAbsent(sum,i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input1 = {10, 5, 2, 7, 1, 9};
        int k1 = 5;
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestSubarrayWithGivenSumPositiveAndNegativeNumbers.longestSubarray(input1,k1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {-3, 2, 1};
        int k2 = 6;
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestSubarrayWithGivenSumPositiveAndNegativeNumbers.longestSubarray(input2,k2));
        System.out.println("------------------------------------------------------");
    }

}
