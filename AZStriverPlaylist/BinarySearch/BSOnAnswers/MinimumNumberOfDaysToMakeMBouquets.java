package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k)
            return -1;
        int maxDay = Arrays.stream(bloomDay).max().orElse(0);
        int left = 1;
        int right = maxDay;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calculateBouquet(bloomDay, m, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return ans;
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
            } else {
                count = 0;
            }
        }
        return (m <= 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 1));
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 2));
        System.out.println(minDays(new int[] { 7, 7, 7, 7, 12, 7, 7 }, 2, 3));
    }
}
