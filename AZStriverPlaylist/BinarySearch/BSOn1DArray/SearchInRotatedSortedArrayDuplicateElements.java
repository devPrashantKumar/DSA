package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class SearchInRotatedSortedArrayDuplicateElements {

    public static boolean search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue;
            } else if (arr[left] <= arr[mid]) {
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
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2,5,6,0,0,1,2 };
        int target1 = 0;

        System.out.println(SearchInRotatedSortedArrayDuplicateElements.search(nums1, target1));
        System.out.println("===========================================================================");

        int[] nums2 = { 2,5,6,0,0,1,2 };
        int target2 = 3;

        System.out.println(SearchInRotatedSortedArrayDuplicateElements.search(nums2, target2));
        System.out.println("===========================================================================");

        int[] nums3 = { 1 };
        int target3 = -1;
        System.out.println(SearchInRotatedSortedArrayDuplicateElements.search(nums3, target3));
        System.out.println("===========================================================================");

    }
}
