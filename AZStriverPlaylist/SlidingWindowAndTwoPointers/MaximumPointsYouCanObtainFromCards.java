package AZStriverPlaylist.SlidingWindowAndTwoPointers;

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {

    /*
     * Time Complexity : O(2^k)
     * Space Complexity : O(log k) -> space taken by recursive stack 
     */
    public static int maxScore(int[] cardPoints, int k) {
        return maxScoreUtil(cardPoints, k, 0, cardPoints.length-1, 0);
    }

    public static int maxScoreUtil(int[] cardPoints, int k, int start, int end, int points) {
        if(k==0 || start<0 || start>=cardPoints.length || end<0 || end>=cardPoints.length) return points;
        int pickStart = maxScoreUtil(cardPoints, k-1, start+1, end, points+cardPoints[start]);
        int pickEnd = maxScoreUtil(cardPoints, k-1, start, end-1, points+cardPoints[end]);

        return (pickStart>pickEnd) ? pickStart : pickEnd;
    }


    /*
     * we need to remove k cards from start and end so that removed cards some is maximum,
     * instead of maximizing that we can minimize the sum of n-k cards in window
     */
    public static int maxScoreUsingSlidingWindow(int[] cardPoints, int k) {
        int ans=Integer.MAX_VALUE;
        int totalPoints = Arrays.stream(cardPoints).sum();
        int n = cardPoints.length;
        int windowSize = n-k;
        if(windowSize<=0) return totalPoints;
        int windowPoints=0;
        for(int i=0;i<windowSize;i++){
            windowPoints+= cardPoints[i];
        }
        ans = Math.min(ans, windowPoints);
        int l=0;
        for(int i=windowSize;i<n;i++){
            windowPoints+= cardPoints[i];
            windowPoints -= cardPoints[l++];
            ans = Math.min(ans, windowPoints);
        }
        return totalPoints-ans;
    }


    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,4,5,6,1 };
        int k1 = 3;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums1, k1));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScoreUsingSlidingWindow(nums1, k1));


        int[] nums2 = {2,2,2 };
        int k2 = 2;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums2, k2));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScoreUsingSlidingWindow(nums2, k2));



        int[] nums3 = { 9,7,7,9,7,7,9 };
        int k3 = 7;
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums3, k3));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScoreUsingSlidingWindow(nums3, k3));
    }
}
