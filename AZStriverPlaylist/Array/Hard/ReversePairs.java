package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;

public class ReversePairs {
    // TC : O(n^2)
    // SC : O(1)
    public static long reversePairs(int[] nums) {
        long reversePairCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2*nums[j])
                    reversePairCount++;
            }
        }
        return reversePairCount;
    }

    // optimised version
    // TC : O(nlogn)
    // SC : O(1)
    public static int reversePairsUsingMergeSort(int[] arr) {
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
        int  j = mid + 1;

        for (int i = start; i <= mid; i++) {
            while (j <= end && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int i = start;
        j = mid + 1;
        int[] tempArr = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                //if(arr[i] > 2*arr[j]) count += (mid-i+1); // this will not work we will miss out some pairs
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
        int[] nums1 = { 1,3,2,3,1 };
        int[] nums2 = { 2,4,3,5,1 };
        int[] nums3 = { 6, 4, 1, 2, 7 };
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output : " + reversePairs(new int[] { 1,3,2,3,1 }));
        System.out.println("Output : " + reversePairsUsingMergeSort(new int[]  { 1,3,2,3,1 }));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output : " + reversePairs(new int[] { 2,4,3,5,1 }));
        System.out.println("Output : " + reversePairsUsingMergeSort(new int[] { 2,4,3,5,1 }));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("Output : " + reversePairs(new int[] { 6, 4, 1, 2, 7 }));
        System.out.println("Output : " + reversePairsUsingMergeSort(new int[] { 6, 4, 1, 2, 7 }));
        System.out.println("---------------------------------------------------");
    }
}
