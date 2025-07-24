package AZStriverPlaylist.SortingAlgorithms.HeapSort;

import java.util.Arrays;

public class HeapSortClassTest {
    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        HeapSortClass.heapSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(HeapSortClass.heapSort(new int[]{})));
        System.out.println(Arrays.toString(HeapSortClass.heapSort(new int[]{5})));
        System.out.println(Arrays.toString(HeapSortClass.heapSort(new int[]{7,7})));
    }
}
