package AZStriverPlaylist.SortingAlgorithms.CountingSort;

import java.util.Arrays;

public class CountingSortClassTest {
    public static void main(String[] args){
        int[] arr = {2,3,1,7,3,9,6};
        CountingSortClass.countingSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {};
        CountingSortClass.countingSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {4, 2, -2, 8, 3, 3, 1};
        CountingSortClass.countingSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
