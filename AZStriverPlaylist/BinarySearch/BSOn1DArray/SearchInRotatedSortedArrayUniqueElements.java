package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class SearchInRotatedSortedArrayUniqueElements {

    /*
    * Time Complexity : O(log n)
    * Space Complexity : O(1)
    */
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    /*
    * Time Complexity : O(log n)
    * Space Complexity : O(log n) , recursion call stack
    */
    public static int searchRecursive(int[] arr, int target) {
        return searchRecursiveUtil(arr, target, 0, arr.length-1);
    }

    public static int searchRecursiveUtil(int[] arr, int target, int start, int end) {
        if(start>end) return -1;

        int mid = start + (end - start) / 2;
        
        if (arr[mid] == target)
            return mid;

        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target < arr[mid])
                return searchRecursiveUtil(arr, target, start,mid - 1);
            else  
                return searchRecursiveUtil(arr, target, mid+1,end);
        } else {
            if (arr[mid] < target && target <= arr[end])
                return searchRecursiveUtil(arr, target, mid+1,end);
            else
                return searchRecursiveUtil(arr, target, start,mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 4;

        System.out.println(SearchInRotatedSortedArrayUniqueElements.search(nums1, target1));
        System.out.println(SearchInRotatedSortedArrayUniqueElements.searchRecursive(nums1, target1));

        System.out.println("===========================================================================");

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = -1;

        System.out.println(SearchInRotatedSortedArrayUniqueElements.search(nums2, target2));
        System.out.println(SearchInRotatedSortedArrayUniqueElements.searchRecursive(nums2, target2));

        System.out.println("===========================================================================");

        int[] nums3 = { 1 };
        int target3 = -1;
        System.out.println(SearchInRotatedSortedArrayUniqueElements.search(nums3, target3));
        System.out.println(SearchInRotatedSortedArrayUniqueElements.searchRecursive(nums3, target3));

        System.out.println("===========================================================================");

    }
}
