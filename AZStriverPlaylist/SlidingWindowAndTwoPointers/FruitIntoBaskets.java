package AZStriverPlaylist.SlidingWindowAndTwoPointers;

import java.util.Arrays;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int maxFruilts = 0;
        int fruitCount = 0;
        int i = -1, j = -1;
        for (int k = 0; k < fruits.length; k++) {
            if (i == -1 && j == -1) {
                i = k;
            } else if (j == -1 && fruits[k] != fruits[i]) {
                j = k;
            } else if (j == -1 && fruits[i] == fruits[k]) {
                i = k;
            } else {
                if (fruits[k] == fruits[i]) {
                    i = k;
                } else if (fruits[k] == fruits[j]) {
                    j = k;
                } else {
                    if (i > j) {
                        j = k;
                        fruitCount = (k - i);
                    } else {
                        i = k;
                        fruitCount = (k - j);
                    }
                }
            }
            fruitCount++;
            maxFruilts = Math.max(maxFruilts, fruitCount);
        }
        return maxFruilts;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 1 };
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + FruitIntoBaskets.totalFruit(nums1));

        int[] nums12 = { 0, 1, 2, 2 };
        System.out.println("Input : " + Arrays.toString(nums12));
        System.out.println("output : " + FruitIntoBaskets.totalFruit(nums12));

        int[] nums3 = { 1, 2, 3, 2, 2 };
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + FruitIntoBaskets.totalFruit(nums3));
    }
}
