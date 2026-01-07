package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;
import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static int longestSubarray(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int sum=0;
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hmap.containsKey(sum)){
                int length = i-hmap.get(sum);
                maxLength = Math.max(length,maxLength);
            }
            hmap.putIfAbsent(sum,i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LargestSubarrayWith0Sum.longestSubarray(input1));
        System.out.println("------------------------------------------------------");
        int[] input2 = {2, 10, 4};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LargestSubarrayWith0Sum.longestSubarray(input2));
        System.out.println("------------------------------------------------------");
    }
}
