package AZStriverPlaylist.SortingAlgorithms.QuickSort;
import java.util.*;
public class QuickSortClassTest {
    public static void main(String[] args) {
        int[] arr = {2,3,1,7,9,6};
        QuickSortClass.quickSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2,3,1,7,9,6,3};
        QuickSortClass.quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
