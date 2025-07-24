package AZStriverPlaylist.SortingAlgorithms.BucketSort;

import java.util.Arrays;

public class BucketSortClassTest {
    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        BucketSortClass.bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
