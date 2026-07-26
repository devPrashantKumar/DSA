package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class CountOccurrencesOfANumberInASortedArrayWithDuplicates {

    public static int countOccurence(int[] arr, int x) {
        int firstOccurence = FindFirstAndLastPositionOfElementInSortedArray.firstOccurence(arr, x);
        return (firstOccurence == -1) ? 0
                : (FindFirstAndLastPositionOfElementInSortedArray.lastOccurence(arr, x) - firstOccurence) + 1;
    }
    
    public static void main(String[] args) {
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        
        System.out.println(CountOccurrencesOfANumberInASortedArrayWithDuplicates.countOccurence(nums1, target1));

        System.out.println("===========================================================================");

        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 5;
    
        System.out.println(CountOccurrencesOfANumberInASortedArrayWithDuplicates.countOccurence(nums2, target2));

        System.out.println("===========================================================================");

        int[] nums3 = { 5, 7, 7, 8, 8, 10 };
        int target3 = 0;
        System.out.println(CountOccurrencesOfANumberInASortedArrayWithDuplicates.countOccurence(nums3, target3));

    }
}
