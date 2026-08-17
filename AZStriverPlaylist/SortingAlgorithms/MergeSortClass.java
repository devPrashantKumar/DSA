package AZStriverPlaylist.SortingAlgorithms;

import java.util.*;

public class MergeSortClass {
  /*
   * Time Complexity : O(n logn)
   * Space Complexity : O(log n)+O(n)
   * O(log n) recursive stack
   * O(n) tempArray required during merge operation
   * not In-Place Algorithm
   * Stable Algorithm
   */
  public static int[] mergeSort(int[] arr) {
    mergeSortUtil(arr, 0, arr.length - 1);
    return arr;
  }

  public static void mergeSortUtil(int[] arr, int start, int end) {
    if (end - start + 1 < 2)
      return;
    int mid = start + (end - start) / 2;
    mergeSortUtil(arr, start, mid);
    mergeSortUtil(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }

  public static void merge(int[] arr, int start, int mid, int end) {
    int i = start, j = mid + 1;
    int[] tempArr = new int[end - start + 1];
    int k = 0;
    while (i <= mid && j <= end) {
      if (arr[i] <= arr[j]) {
        tempArr[k++] = arr[i++];
      } else {
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
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 1, 7, 3, 9, 6 };
    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
