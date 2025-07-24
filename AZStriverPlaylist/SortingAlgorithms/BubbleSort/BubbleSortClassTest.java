package AZStriverPlaylist.SortingAlgorithms.BubbleSort;
import java.util.Arrays;

public class BubbleSortClassTest {
    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        BubbleSortClass.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
