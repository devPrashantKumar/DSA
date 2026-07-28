package AZStriverPlaylist.Greedy;

import java.util.Arrays;

public class JumpGame {
    /*
     * Time Complexity : O(n^2)
     */
    public static boolean canJump(int[] nums) {
        l1: for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int j = i - 1;
                while (j >= 0) {
                    if (nums[j] > i - j)
                        continue l1; // found a jump that skips over zero
                    j--;
                }
                return false; // no jump can skip over the zero
            }
        }
        return true;
    }

    /*
     * Time Complexity : O(n)
     */
    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int reach = nums[0];
        for (int i = 1; (i <= reach && i < nums.length - 1); i++) {
            if (i + nums[i] > reach) {
                reach = i + nums[i];
            }
            if (reach >= nums.length - 1)
                return true;
        }

        return (reach >= nums.length - 1) ? true : false;
    }

    /*
     * Time Complexity : O(n)
     */
    public static boolean canJump3(int[] nums) {
        int reach = 0;
        int i = 0;

        for (; (i <= reach && i < nums.length); i++) {
            if (i == 0)
                reach = nums[0];
            else if (i + nums[i] > reach) {
                reach = i + nums[i];
            }
        }
        if (i == nums.length)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Jump for " + Arrays.toString(new int[] { 2, 3, 1, 1, 4 }) + " is possible : "
                + canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println("Jump for " + Arrays.toString(new int[] { 3, 2, 1, 0, 4 }) + " is possible : "
                + canJump(new int[] { 3, 2, 1, 0, 4 }));

        System.out.println("---------------------------------------------------------------");

        System.out.println("Jump for " + Arrays.toString(new int[] { 2, 3, 1, 1, 4 }) + " is possible : "
                + canJump2(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println("Jump for " + Arrays.toString(new int[] { 3, 2, 1, 0, 4 }) + " is possible : "
                + canJump2(new int[] { 3, 2, 1, 0, 4 }));

        System.out.println("---------------------------------------------------------------");

        System.out.println("Jump for " + Arrays.toString(new int[] { 2, 3, 1, 1, 4 }) + " is possible : "
                + canJump3(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println("Jump for " + Arrays.toString(new int[] { 3, 2, 1, 0, 4 }) + " is possible : "
                + canJump3(new int[] { 3, 2, 1, 0, 4 }));
    }
}
