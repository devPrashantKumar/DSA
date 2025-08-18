package AZStriverPlaylist.Greedy;

import java.util.Arrays;

public class JumpGameII {

    public static int jump(int[] nums) {
        return jumpUtil(nums, 0, 0);
    }

    public static int jumpUtil(int[] nums, int index, int jumps) {
        if(index>=nums.length-1) return jumps;
        int minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            minSteps = Math.min(minSteps,jumpUtil(nums, index+i, jumps+1));
        }
        return minSteps;
    }
    public static void main(String[] args) {
        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" min jump : "+jump(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" min jump : "+jump(new int[]{3,2,1,0,4}));

        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" min jump : "+jump(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" min jump : "+jump(new int[]{3,2,1,0,4}));

        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" min jump : "+jump(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" min jump : "+jump(new int[]{3,2,1,0,4}));
    }
}
