package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumberInArray {
    /*
     * Time compleity : O(n*2)
     */
    public static int missingNumberBruteforce(int[] arr){
        int len = arr.length;
        for(int i=1;i<=len;i++){
            boolean flag=false;
            for(int j=0;j<len;j++){
                if(arr[j]==i){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return i;
            }
        }
        return -1;
    }

    /*
     * Time compleity : O(n)
     * Space Complexity : O(n)
     */
    public static int missingNumberBetter(int[] arr){
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(arr[i]);
        }
        for(int i=1;i<=len;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    /*
     * Time compleity : O(n)
     * Space Complexity : O(1)
     * But there is problem with this approach if number of elements are large then 
     * there sum can exceed Integer.MAX_Value value, in that case, this solution will fail
     */
    public static int missingNumberOptimalUsingSumApproch(int[] arr){
        int len = arr.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum +=arr[i];
        }
        int sumOfNaturalNumbers = (len+1)*(len+2)/2;
        return sumOfNaturalNumbers-sum;
    }
/*
     * Time compleity : O(n)
     * Space Complexity : O(1)
     * this solution will work fine for large numbers also, because xor of two numbers can not exceed there size
     */
    public static int missingNumberOptimalUsingXORApproch(int[] arr){
        int len = arr.length;
        int xor=0;
        for(int i=0;i<len;i++){
            xor ^= arr[i];
            xor ^= (i+1);
        }
        xor ^= arr.length+1;
        return xor;
    }

    public static void main(String[] args) {
        int[] input1 = {1,4,3,7,6,5};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MissingNumberInArray.missingNumberBruteforce(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MissingNumberInArray.missingNumberBetter(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MissingNumberInArray.missingNumberOptimalUsingSumApproch(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+MissingNumberInArray.missingNumberOptimalUsingXORApproch(input1));
        System.out.println("------------------------------------------------------");

    }
}
