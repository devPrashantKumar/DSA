package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class CountInversions {

    // TC : O(n^2)
    // SC : O(1)
    public static long numberOfInversions(int[] nums) {
        long inversionCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    inversionCount++;
            }
        }
        return inversionCount;
    }

    // optimised version
    // TC : O(nlogn)
    // SC : O(1)
    public static int numberOfInversionsUsingMergeSort(int[] arr) {
        return mergeSortUtil(arr, 0, arr.length - 1);
    }

    public static int mergeSortUtil(int[] arr, int start, int end) {
        if (end - start + 1 < 2)
            return 0;
        int mid = start + (end - start) / 2;
        int leftCount = mergeSortUtil(arr, start, mid);
        int rightCount = mergeSortUtil(arr, mid + 1, end);
        int count = merge(arr, start, mid, end);
        return leftCount+rightCount+count;
    }

    public static int merge(int[] arr, int start, int mid, int end) {
        int count=0;
        int i = start, j = mid + 1;
        int[] tempArr = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                count += (mid-i+1);
                tempArr[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while (j <= end) {
            tempArr[k++] = arr[j++];
        }

        for (int n = start; n <= end; n++) {
            arr[n] = tempArr[n - start];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 7, 1, 3, 5 };
        int[] nums2 = { -10, -5, 6, 11, 15, 17 };
        int[] nums3 = { 9, 5, 4, 2 };
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " + CountInversions.numberOfInversions(new int[] { 2, 3, 7, 1, 3, 5 }));
        System.out.println("Output : " + CountInversions.numberOfInversionsUsingMergeSort(new int[]  { 2, 3, 7, 1, 3, 5 }));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + CountInversions.numberOfInversions(new int[] { -10, -5, 6, 11, 15, 17 }));
        System.out.println("Output : " + CountInversions.numberOfInversionsUsingMergeSort(new int[] { -10, -5, 6, 11, 15, 17 }));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output : " + CountInversions.numberOfInversions(new int[] { 9, 5, 4, 2 }));
        System.out.println("Output : " + CountInversions.numberOfInversionsUsingMergeSort(new int[] { 9, 5, 4, 2 }));
        System.out.println("---------------------------------------------------");
    }
}
