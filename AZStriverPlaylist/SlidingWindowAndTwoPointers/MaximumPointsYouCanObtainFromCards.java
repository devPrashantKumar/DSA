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


    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,4,5,6,1 };
        int k1 = 3;
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums1, k1));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums1, k1));


        int[] nums2 = {2,2,2 };
        int k2 = 2;
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums2, k2));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums2, k2));



        int[] nums3 = { 9,7,7,9,7,7,9 };
        int k3 = 7;
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums3, k3));
        System.out.println("output : " + MaximumPointsYouCanObtainFromCards.maxScore(nums3, k3));
    }
}
