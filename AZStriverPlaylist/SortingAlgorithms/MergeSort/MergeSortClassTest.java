package AZStriverPlaylist.SortingAlgorithms.MergeSort;

import java.util.*;

public class MergeSortClassTest {
    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        MergeSortClass.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
