package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length)
            return -1;
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        int left = 1;
        int right = maxPile;
        // int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!calculateHours(mid, h, piles)) {
                left = mid + 1;
            } else {
                // ans = mid;
                right = mid - 1;
            }
        }
        return left;
    }

    public static boolean calculateHours(int k, int h, int[] piles) {
        int hours = 0;
        for (int pile : piles) {
            // hours += pile/k;
            // hours += (pile%k==0) ? 0 : 1;
            hours += (pile + k - 1) / k;
            if (hours > h)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
        System.out.println(minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
        System.out.println(minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
    }
}
