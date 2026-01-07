package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfSubArrayWithXorK {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int numberOfSubArray(int[] arr, int k){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        int xor=0;
        int ans=0;
        for(int num:arr){
            xor ^= num;
            if(hmap.containsKey(xor^k)){
                ans += hmap.get(xor^k);
            }
            hmap.put(xor, hmap.getOrDefault(xor, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+NumberOfSubArrayWithXorK.numberOfSubArray(input1,k1));
        System.out.println("------------------------------------------------------");

        int[] input2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+NumberOfSubArrayWithXorK.numberOfSubArray(input2,k2));
        System.out.println("------------------------------------------------------");
    }
}
