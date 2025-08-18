package AZStriverPlaylist.Greedy;

import java.util.Arrays;

public class JumpGameII {

    public static int jump(int[] nums) {
        int steps = jumpUtil(nums, 0, 0);
        return steps==Integer.MAX_VALUE ? -1 : steps;
    }

    public static int jumpUtil(int[] nums, int index, int jumps) {
        if(index>=nums.length-1) return jumps;
        int minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            minSteps = Math.min(minSteps,jumpUtil(nums, index+i, jumps+1));
        }
        return minSteps;
    }

    public static int jump2(int[] nums) {
        int l=0,r=0;
        int newR = r;
        int jumps=0;
        if(nums.length<=1) return 0;
        while(true){
            for(int i=l;i<=r;i++){
                if(i+nums[i]>newR) newR = i+nums[i];
            }
            jumps++;
            if(newR>=nums.length-1) return jumps;
            if(newR==r) return -1;
            l=r+1;
            r = newR;
        }
    }

    public static int jump3(int[] nums) {
    if (nums.length <= 1) return 0;

    int jumps = 0;
    int l = 0, r = 0;

    while (r < nums.length - 1) {
        int farthest = 0;
        for (int i = l; i <= r; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        if (farthest == r) return -1; // stuck
        l = r + 1;
        r = farthest;
        jumps++;
    }
    return jumps;
}


    public static void main(String[] args) {
        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" min jump : "+jump(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" min jump : "+jump(new int[]{3,2,1,0,4}));

        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" min jump : "+jump2(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" min jump : "+jump2(new int[]{3,2,1,0,4}));

        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" min jump : "+jump3(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" min jump : "+jump3(new int[]{3,2,1,0,4}));
    }
}
