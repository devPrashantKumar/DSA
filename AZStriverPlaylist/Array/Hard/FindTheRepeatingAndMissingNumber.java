package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;

public class FindTheRepeatingAndMissingNumber {

    public static int[] findMissingRepeatingNumbersUsingMath(int[] nums) {
        long n = nums.length;
        long sn= (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        long s=0,s2=0;
        for(int i=0;i<n;i++){
            s += nums[i];
            s2 += (1L*nums[i]*nums[i]);
        }

        // s  - sn  = X - Y
        // s2 - s2n = X² - Y² = (X - Y)(X + Y)
        long xMinusY = s-sn;
        long xPlusY = (s2-s2n)/xMinusY;

        return new int[]{(int)((xMinusY+xPlusY)/2),(int)((xPlusY-xMinusY)/2)};
    }

    /*
    * Time conplexity : O(n)
    */
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int xorOfAB=0;
        for(int i=0;i<nums.length;i++){
            xorOfAB ^= nums[i];
            xorOfAB ^= (i+1);
        }

        // int bitPosition=0;
        // while(((1<<bitPosition)&xorOfAB)==0){
        //     bitPosition++;
        // }

        // Use int rightMostSetBit = xorOfAB & -xorOfAB; // shortcut 
        int bitPosition = xorOfAB & -xorOfAB;

        int numA=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&(1<<bitPosition))!=0){
                numA ^=nums[i];
            }

            if(((i+1)&(1<<bitPosition))!=0){
                numA ^=(i+1);
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]==numA){
                return new int[]{numA,numA^xorOfAB};
            }
        }

        return new int[]{numA^xorOfAB,numA};

    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 5, 4, 1, 1 };
        int[] nums2 = {1, 2, 3, 6, 7, 5, 7 };
        int[] nums3 = { 6, 5, 7, 1, 8, 6, 4, 3, 2};
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " +Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbersUsingMath(nums1)));
        System.out.println("Output : " +Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbers(nums1)));
        System.out.println("Output : " +Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbers(nums1)));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbersUsingMath(nums2)));
        System.out.println("Output : " + Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbers(nums2)));
        System.out.println("Output : " + Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbers(nums2)));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output : " + Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbersUsingMath(nums3)));
        System.out.println("Output : " + Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbers(nums3)));
        System.out.println("Output : " + Arrays.toString(FindTheRepeatingAndMissingNumber.findMissingRepeatingNumbers(nums3)));

        System.out.println("---------------------------------------------------");
    }
}
