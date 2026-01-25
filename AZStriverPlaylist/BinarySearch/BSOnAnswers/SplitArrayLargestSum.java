package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        if(k>nums.length) return -1;
        int maxSubArraySum = Arrays.stream(nums).sum();
        int minSubArraySum = Arrays.stream(nums).max().orElse(0);
        int left = minSubArraySum;
        int right = maxSubArraySum;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isDistributionPossible(nums,k,mid)) right = mid-1;
            else left = mid+1;
        }
        return left;
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
         System.out.println(splitArray(new int[] { 7,2,5,10,8 }, 2));
        System.out.println(splitArray(new int[] {7,2,5,10,8 }, 2));
        System.out.println("---------------------------------------------");
        
        System.out.println(splitArray(new int[] { 1,2,3,4,5 }, 2));
        System.out.println(splitArray(new int[] { 1,2,3,4,5 }, 2));
        System.out.println("---------------------------------------------");
    }
}
