package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class PaintersPartition {
    
    private static final int MOD = 10000003;


    public static int paint(int k, int timePerUnit, int[] nums) {
        int maxTime = Arrays.stream(nums).sum();
        int minTime = Arrays.stream(nums).max().orElse(0);
        int left = minTime;
        int right = maxTime;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isDistributionPossible(nums,k,mid)) right = mid-1;
            else left = mid+1;
        }
        //return left*timePerUnit;
        return (int) ((left % MOD) * (timePerUnit % MOD) % MOD);

    }

    public static boolean isDistributionPossible(int[] nums, int k, int subArraySum){
        int currentSubArraySum=0;
        for(int i=0;i<nums.length;i++){
            if(currentSubArraySum+nums[i]>subArraySum){
                currentSubArraySum = nums[i];
                k--;
                if(k==0) return false;
            }
            else{
                currentSubArraySum += nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(paint(2,5, new int[] { 1, 10 }));
        System.out.println(paint(2,5, new int[] {1, 10 }));
        System.out.println("---------------------------------------------");
        
        System.out.println(paint(10,1,new int[] { 1, 8, 11, 3 }));
        System.out.println(paint(10,1,new int[] { 1, 8, 11, 3 }));
        System.out.println("---------------------------------------------");
    }
}
