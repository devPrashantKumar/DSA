package AZStriverPlaylist.Array.Medium;

import java.util.Arrays;

public class KadanesAlgoMaximumSubarray {
    // bruteforce approach - O(n^2)
    public static int maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // another bruteforce approach - O(n^3)
    public static int maxSubarraySum2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /*
     * Time Complexity : O(n)
     * Optimised approach - Kadanes Algorithm
     */
    public static int maxSubarraySumKadanesAlgo(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int index = -1, startIndex = -1, endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                index = i;
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                startIndex = index;
                endIndex = i;
            }

            if (sum < 0)
                sum = 0;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxSum;
    }

    /*
     * Time Complexity : O(n)
     * Optimised approach - Kadanes Algorithm
     */
    public static int maxSubarraySumKadanesAlgo_2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        boolean started = false;
        int index = -1, startIndex = -1, endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0 && !started) {
                started = true;
                index = i;
            }

            sum += arr[i];

            if (sum > maxSum ||
                (sum == maxSum && i - index > endIndex - startIndex)) {

            maxSum = sum;
            startIndex = index;
            endIndex = i;
        }

            if (sum < 0) {
                started = false;
                sum = 0;
            }
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxSum;
    }

    public static int maxSubarraySumKadanesAlgoWhenEmptySubArrayAllowed(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        int index = -1, startIndex = -1, endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                index = i;
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                startIndex = index;
                endIndex = i;
            }

            if (sum < 0)
                sum = 0;
        }

        if (startIndex >= 0) {
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Empty SubArray");
        }

        return maxSum;
    }

    public static int maxSubarraySumKadanesAlgo2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int lowestSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int maxSumEndingAtI = sum - lowestSum;
            maxSum = Math.max(maxSumEndingAtI, maxSum);
            lowestSum = Math.min(lowestSum, sum);
        }
        return maxSum;
    }

    public static int maxSubarraySum2AllowEmpty(int[] arr) {
        int maxSum = 0; // empty subarray is a valid candidate
        int sum = 0;
        int lowestSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int maxSumEndingAtI = sum - lowestSum;
            maxSum = Math.max(maxSumEndingAtI, maxSum);
            lowestSum = Math.min(lowestSum, sum);
        }
        return maxSum;
    }

    public static int maxSubarraySumKadanesAlgo3(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maxSubarraySum3AllowEmpty(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //sum = Math.max(0, Math.max(arr[i],sum + arr[i]));
            sum = Math.max(0, sum + arr[i]); // reset to 0 (empty), not arr[i]
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum(input1));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2(input1));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input1));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo2(input1));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo3(input1));

        System.out.println("-------------------------------------------");
        int[] input2 = { 1 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum(input2));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2(input2));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input2));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo2(input2));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo3(input2));

        System.out.println("-------------------------------------------");
        int[] input3 = { 5, 4, -1, 7, 8 };
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum(input3));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2(input3));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input3));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo2(input3));
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo3(input3));

        System.out.println("------------------------------------------------------");

        System.out.println("-------------------------------------------");
        int[] input4 = { -5, -4, -1, -7, -8 };
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo2(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo3(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgoWhenEmptySubArrayAllowed(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2AllowEmpty(input4));
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum3AllowEmpty(input4));

        System.out.println("------------------------------------------------------");

        int[] input5 = { 0, 0, -1, 0, 0, 0, -2 };
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo_2(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo2(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgo3(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySumKadanesAlgoWhenEmptySubArrayAllowed(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum2AllowEmpty(input5));
        System.out.println("Input : " + Arrays.toString(input5) + " Output : "
                + KadanesAlgoMaximumSubarray.maxSubarraySum3AllowEmpty(input5));

        System.out.println("------------------------------------------------------");

    }
}
