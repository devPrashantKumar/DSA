package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class SearchInRotatedSortedArrayDuplicateElements {

    // Time: O(log n) average case, O(n) worst case —
    // worst case triggered by arrays like [2,2,2,2,2,2,2] with target
    // not present, where left++/right-- degrades to linear shrinkage
    // Space: O(1) — iterative, no extra structures
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
            } else if (arr[left] <= arr[mid]) {
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
        return false;
    }

    // Time: O(log n) average case, O(n) worst case — same reasoning as iterative:
    // all-duplicate arrays force start++/end-- degradation
    // Space: O(log n) average case, O(n) worst case — call stack depth tracks
    // the same shrinkage as the time complexity, since each recursive
    // call is a stack frame. In the degenerate all-duplicates case,
    // this becomes O(n) stack depth instead of O(log n).
    public static boolean searchRecursive(int[] arr, int target) {
        return searchRecursiveUtil(arr, target, 0, arr.length - 1);
    }

    public static boolean searchRecursiveUtil(int[] arr, int target, int start, int end) {
        if (start > end)
            return false;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target)
            return true;

        if (arr[start] == arr[mid] && arr[mid] == arr[end])
            return searchRecursiveUtil(arr, target, start + 1, end - 1);

        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target < arr[mid])
                return searchRecursiveUtil(arr, target, start, mid - 1);
            else
                return searchRecursiveUtil(arr, target, mid + 1, end);
        } else {
            if (arr[mid] < target && target <= arr[end])
                return searchRecursiveUtil(arr, target, mid + 1, end);
            else
                return searchRecursiveUtil(arr, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 5, 6, 0, 0, 1, 2 };
        int target1 = 0;

        System.out.println(search(nums1, target1));
        System.out.println(searchRecursive(nums1, target1));

        System.out.println("===========================================================================");

        int[] nums2 = { 2, 5, 6, 0, 0, 1, 2 };
        int target2 = 3;

        System.out.println(search(nums2, target2));
        System.out.println(searchRecursive(nums2, target2));

        System.out.println("===========================================================================");

        int[] nums3 = { 1 };
        int target3 = -1;
        System.out.println(search(nums3, target3));
        System.out.println(searchRecursive(nums3, target3));

        System.out.println("===========================================================================");

    }
}
