package AZStriverPlaylist.BitManipulation.Problems;

import java.util.Arrays;

public class FindTwoNumbersThatIsAppearingOddNumberOfTimes {
    /*
     * Time Ccomplexity : O(n)
     */
    public static int[] singleNumber(int[] nums) {
        int num1=0, num2=0;
        int xorOfNumber = Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        int rightMostDifferentBit = ((xorOfNumber & (xorOfNumber-1))^xorOfNumber);
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&rightMostDifferentBit)==0){
                num1 ^= nums[i]; 
            }
            else{
                num2 ^= nums[i];
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        System.out.println("Odd Frquency Numbers : " + Arrays.toString(singleNumber(new int[] {2,2,1,3})));
        System.out.println("Odd Frquency Numbers : " + Arrays.toString(singleNumber(new int[] {4,1,2,1,5,2})));
        System.out.println("Odd Frquency Numbers : " + Arrays.toString(singleNumber(new int[] {1,0})));
        System.out.println("-------------------------------------------------");
    }
}
