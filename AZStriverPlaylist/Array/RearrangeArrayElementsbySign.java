package AZStriverPlaylist.Array;

import java.util.Arrays;

public class RearrangeArrayElementsbySign {
    /*
     * Time Complexity : O(n)
     * Space Conplexity : O(2*n)
     */
    public static int[] rearrange(int[] arr){
        int[] result = new int[arr.length];
        int[] positive = new int[arr.length/2];
        int[] negative = new int[arr.length/2];
        int pindex=0,nindex=0;
        for(int num: arr){
            if(num>0) positive[pindex++] = num;
            else negative[nindex++] = num;
        }
        for(int i=0;i<result.length;i=i+2){
            result[i] = positive[i/2];
            result[i+1] = negative[i/2];
        }

        return result;
    }

    /*
     * Time Complexity : O(n)
     * Space Conplexity : O(n)
     */
    public static int[] rearrangeBetter(int[] arr){
        int[] result = new int[arr.length];
        int pindex=0,nindex=1;
        for(int num: arr){
            if(num>0){
                result[pindex] = num;
                pindex+=2;
            } 
            else {
                result[nindex] = num;
                nindex+=2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = { 3,1,-2,-5,2,-4 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(RearrangeArrayElementsbySign.rearrange(input1)));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(RearrangeArrayElementsbySign.rearrangeBetter(input1)));
        System.out.println("------------------------------------------------------");
        int[] input2 = { 3,1,-2,-5,2,-4 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(RearrangeArrayElementsbySign.rearrange(input2)));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(RearrangeArrayElementsbySign.rearrangeBetter(input2)));

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        int[] input3 = { 3,1,-2,-5,2,-4};
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(RearrangeArrayElementsbySign.rearrange(input3)));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + Arrays.toString(RearrangeArrayElementsbySign.rearrangeBetter(input3)));

    }
}
