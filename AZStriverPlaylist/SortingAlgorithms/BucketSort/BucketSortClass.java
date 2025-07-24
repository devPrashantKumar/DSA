package AZStriverPlaylist.SortingAlgorithms.BucketSort;
import java.util.*;

// use bucket sort only when elements are uniformly distributed
public class BucketSortClass {
    /*Time Complexity:
     * Best Case: O(n) (when elements are uniformly distributed across buckets)
     * Average Case: O(n + n log n)
     * Worst Case: O(n^2) (when all elements fall into the same bucket)
     * Space Complexity:
     * Worst Case: O(n + k), where k is the number of buckets and n is the number of elements.    
     * Out-of-Place Algorithm
     * Stable Algorithm
     */
    public static int[] bucketSort(int[] arr){
        int numberOfBuckets = (int) Math.floor(Math.sqrt(arr.length));
        @SuppressWarnings("unchecked")
        List<Integer>[] list = new List[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++) {
            list[i] = new ArrayList<>();
        }
        int maxElement = Arrays.stream(arr).max().orElse(0);
        for(int num:arr){
            int bucketIndex = (num * (numberOfBuckets-1)) / (maxElement); 
            list[bucketIndex].add(num);
        }

        for (List<Integer> bucket : list) {
            Collections.sort(bucket);
        }
        
        int index = 0;
        for (List<Integer> bucket : list) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,7,3,9,6};
        BucketSortClass.bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
