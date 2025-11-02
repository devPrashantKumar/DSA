package AZStriverPlaylist.BinarySearch.BSOn1DArray;

class FindFirstAndLastPositionOfElementInSortedArray {
    // Time Complexity : O(logn)
    // Space Complexity : O(1)
    public static int firstOccurence(int[] arr, int x) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Time Complexity : O(logn)
    // Space Complexity : O(1)
    public static int lastOccurence(int[] arr, int x) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Time Complexity : O(logn)
    // Space Complexity : O(1)
    public static int firstOccurenceUsingLowerBound(int[] arr, int x) {
        int ans = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (ans == arr.length || arr[ans] != x) ? -1 : ans;
    }

    // Time Complexity : O(logn)
    // Space Complexity : O(1)
    public static int lastOccurenceUsingUpperBound(int[] arr, int x) {
        if (arr.length == 0)
            return -1;
        int ans = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (ans - 1 >= 0 && arr[ans - 1] == x) ? ans - 1 : -1;
    }

    // Time Complexity : O(logn)
    // Space Complexity : O(1)
    public static int lastOccurenceUsingFloor(int[] arr, int x) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (ans == -1 || arr[ans] != x) ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.firstOccurence(nums1, target1));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurence(nums1, target1));
        System.out
                .println(FindFirstAndLastPositionOfElementInSortedArray.firstOccurenceUsingLowerBound(nums1, target1));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurenceUsingUpperBound(nums1, target1));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurenceUsingFloor(nums1, target1));

        System.out.println("===========================================================================");

        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.firstOccurence(nums2, target2));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurence(nums2, target2));
        System.out
                .println(FindFirstAndLastPositionOfElementInSortedArray.firstOccurenceUsingLowerBound(nums2, target2));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurenceUsingUpperBound(nums2, target2));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurenceUsingFloor(nums2, target2));

        System.out.println("===========================================================================");

        int[] nums3 = { 5, 7, 7, 8, 8, 10 };
        int target3 = 0;
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.firstOccurence(nums3, target3));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurence(nums3, target3));
        System.out
                .println(FindFirstAndLastPositionOfElementInSortedArray.firstOccurenceUsingLowerBound(nums3, target3));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurenceUsingUpperBound(nums3, target3));
        System.out.println(FindFirstAndLastPositionOfElementInSortedArray.lastOccurenceUsingFloor(nums3, target3));

    }
}