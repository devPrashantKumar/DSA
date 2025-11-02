package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class SearchInRotatedSortedArrayUniqueElements {

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target <= arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (arr[mid] <= target && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 4;

        System.out.println(SearchInRotatedSortedArrayUniqueElements.search(nums1, target1));
        System.out.println("===========================================================================");

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = -1;

        System.out.println(SearchInRotatedSortedArrayUniqueElements.search(nums2, target2));
        System.out.println("===========================================================================");

        int[] nums3 = { 1 };
        int target3 = -1;
        System.out.println(SearchInRotatedSortedArrayUniqueElements.search(nums3, target3));
        System.out.println("===========================================================================");

    }
}
