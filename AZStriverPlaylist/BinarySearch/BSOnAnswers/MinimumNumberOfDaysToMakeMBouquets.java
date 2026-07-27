package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {

    /*
    * Time Complexity  : O(n * log(maxDay - minDay))
    * Space Complexity : O(1)
    */
    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < 1L * m * k)
            return -1;
        int maxDay = Arrays.stream(bloomDay).max().orElse(0);
        int minDay = Arrays.stream(bloomDay).min().orElse(0);
        int left = minDay;
        int right = maxDay;
        //int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calculateBouquet(bloomDay, m, k, mid)) {
                //ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return left;
    }

    public static boolean calculateBouquet(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    count = 0;
                    m--;
                }
                if(m==0) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 1));
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 2));
        System.out.println(minDays(new int[] { 7, 7, 7, 7, 12, 7, 7 }, 2, 3));
    }
}
