package AZStriverPlaylist.Greedy;

import java.util.Arrays;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        l1 : for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                int j=i-1;
                while(j>=0){
                    if(nums[j]>i-j) continue l1;
                    j--;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Jump for "+Arrays.toString(new int[]{2,3,1,1,4})+" is possible : "+canJump(new int[]{2,3,1,1,4}));
        System.out.println("Jump for "+Arrays.toString(new int[]{3,2,1,0,4})+" is possible : "+canJump(new int[]{3,2,1,0,4}));

    }
}
