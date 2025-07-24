package AZStriverPlaylist.SortingAlgorithms.InsertionSort;
import java.util.Arrays;

public class InsertionSortClassTest {
    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        InsertionSortClass.InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
