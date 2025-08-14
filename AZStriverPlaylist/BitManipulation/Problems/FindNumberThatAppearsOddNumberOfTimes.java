package AZStriverPlaylist.BitManipulation.Problems;

import java.util.Arrays;

public class FindNumberThatAppearsOddNumberOfTimes {
    /*
     * Time Complexity : O(n)
     */
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    /*
     * Time Complexity : O(n)
     */
    public static int singleNumberUsingStreams(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        System.out.println("Odd Frquency Number : " + singleNumber(new int[] {2,2,1}));
        System.out.println("Odd Frquency Number : " + singleNumber(new int[] {4,1,2,1,2}));
        System.out.println("Odd Frquency Number : " + singleNumber(new int[] {1}));
        System.out.println("-------------------------------------------------");
        System.out.println("Odd Frquency Number : " + singleNumberUsingStreams(new int[] {2,2,1}));
        System.out.println("Odd Frquency Number : " + singleNumberUsingStreams(new int[] {4,1,2,1,2}));
        System.out.println("Odd Frquency Number : " + singleNumberUsingStreams(new int[] {1}));
    }
}
