package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // not necessary but optimisation bolock
            if (nums[left] <= nums[right]) {
                min = Math.min(nums[left], min);
                break;
            }
            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }
        }
        return min;
    }

    // will not work in case of duplicates
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                // min is somewhere in (mid, right] — pivot is to the right of mid
                left = mid + 1;
            else
                // nums[mid] <= nums[right] means right half is sorted,
                // so min is in [left, mid] — mid could itself be the min
                right = mid;
        }

        return nums[left]; // left == right at this point
    }

    public static int findMinWithDuplicates(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // Minimum is definitely on the right of mid
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is in [left, mid]
                // mid could itself be the minimum
                right = mid;
            } else {
                // nums[mid] == nums[right]
                // Cannot determine which side contains the minimum
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums1));
        System.out.println(findMin2(nums1));
        System.out.println(findMinWithDuplicates(nums1));

        System.out.println("===========================================================================");

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums2));
        System.out.println(findMin2(nums2));
        System.out.println(findMinWithDuplicates(nums2));

        System.out.println("===========================================================================");

        int[] nums3 = { 11, 13, 15, 17 };
        System.out.println(findMin(nums3));
        System.out.println(findMin2(nums3));
        System.out.println(findMinWithDuplicates(nums3));

        System.out.println("===========================================================================");

    }
}
