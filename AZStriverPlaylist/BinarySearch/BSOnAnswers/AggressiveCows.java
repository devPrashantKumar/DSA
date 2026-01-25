package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class AggressiveCows {
    /*
    * Time Complexity : O(n * maxPossibleDistance)
    */
    public static int aggressiveCows(int[] nums, int k) {
        if (k == 1) return 0;
        if (k > nums.length) return -1;        
        Arrays.sort(nums);
        int maxDistance = 1;
        int maxPossibleDistance = nums[nums.length-1]-nums[0];
        for(;maxDistance<=maxPossibleDistance;maxDistance++){
            if(!canPlaceCows(nums, k, maxDistance)) break;
        }
        return maxDistance-1;
   
    }

    /*
    * We binary search on the minimum distance because the feasibility function is monotonic —
    * if cows can be placed with distance d, they can also be placed with any smaller distance.
    */

    /*
    * Time Complexity : O(n * log(maxPossibleDistance))
    */
    public static int aggressiveCowsUsingBS(int[] nums, int k) {
        if (k == 1) return 0;
        if (k > nums.length) return -1; 
        Arrays.sort(nums);
        int minPossibleDistance = 1;
        int maxPossibleDistance = nums[nums.length-1]-nums[0];
        int left = minPossibleDistance;
        int right = maxPossibleDistance;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(canPlaceCows(nums,k,mid)) left = mid+1;
            else right = mid-1;
        }
        return right;
    }

    private static boolean canPlaceCows(int[] nums, int k, int dist){
        int lastCow = nums[0];
        int cows=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]-lastCow>=dist){
                cows++;
                lastCow = nums[j];
            }
            if(cows==k) return true;;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[] { 0, 3, 4, 7, 10, 9 }, 4));
        System.out.println(aggressiveCowsUsingBS(new int[] { 0, 3, 4, 7, 10, 9 }, 4));
        System.out.println("---------------------------------------------");
        
        System.out.println(aggressiveCows(new int[] { 4, 2, 1, 3, 6 }, 2));
        System.out.println(aggressiveCowsUsingBS(new int[] { 4, 2, 1, 3, 6 }, 2));
        System.out.println("---------------------------------------------");

        System.out.println(aggressiveCows(new int[] { 10, 1, 2, 7, 5 }, 3));
        System.out.println(aggressiveCowsUsingBS(new int[] { 10, 1, 2, 7, 5 }, 3));
        System.out.println("---------------------------------------------");

    }
}
