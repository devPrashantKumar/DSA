package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class BookAllocationProblem {
    /*
    * Time Complexity : O (log (maxPages-minPages))
    */
    public static int findPages(int[] nums, int m) {
        if(m>nums.length) return -1;
        int maxPages = Arrays.stream(nums).sum();
        int minPages = Arrays.stream(nums).max().orElse(0);
        int left = minPages;
        int right = maxPages;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isDistributionPossible(nums,m,mid)) right = mid-1;
            else left = mid+1;
        }
        return left;
    }

    public static boolean isDistributionPossible(int[] nums, int m, int pages){
        int pagesSum=0;
        for(int i=0;i<nums.length;i++){
            if(pagesSum+nums[i]>pages){
                pagesSum = nums[i];
                m--;
                if(m==0) return false;
            }
            else{
                pagesSum += nums[i];
            }
        }
        if(m>1) return true;
        return true;
    }

    public static void main(String[] args) {
         System.out.println(findPages(new int[] { 25, 46, 28, 49, 24 }, 4));
        System.out.println(findPages(new int[] { 25, 46, 28, 49, 24 }, 4));
        System.out.println("---------------------------------------------");
        
        System.out.println(findPages(new int[] { 12, 34, 67, 90 }, 2));
        System.out.println(findPages(new int[] { 12, 34, 67, 90 }, 2));
        System.out.println("---------------------------------------------");
        
       

        System.out.println(findPages(new int[] { 15, 17, 20 }, 2));
        System.out.println(findPages(new int[] { 15, 17, 20 }, 2));
        System.out.println("---------------------------------------------");

    }


}
