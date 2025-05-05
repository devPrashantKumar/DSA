package AZStriverPlaylist.Array;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfSubArrayfSumK {
    /*
     * Time Complexity : O(n);
     * Space Complexity : O(n)
     */
    public static int numberOfSubArray(int[] arr, int k){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        int sum=0;
        int ans=0;
        for(int num:arr){
            sum += num;
            if(hmap.containsKey(sum-k)){
                ans += hmap.get(sum-k);
            }
            hmap.put(sum, hmap.getOrDefault(sum, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,1};
        int k1 = 2;
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+NumberOfSubArrayfSumK.numberOfSubArray(input1,k1));
        System.out.println("------------------------------------------------------");
    }
}
