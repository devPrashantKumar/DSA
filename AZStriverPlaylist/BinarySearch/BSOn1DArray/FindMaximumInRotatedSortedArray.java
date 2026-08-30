package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindMaximumInRotatedSortedArray {
    public static int findMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // not necessary but optimisation bolock
            if (nums[left] <= nums[right]) {
                max = Math.max(nums[right], max);
                break;
            }
            if (nums[left] <= nums[mid]) {
                max = Math.max(max, nums[mid]);
                left = mid + 1;
            } else {
                max = Math.max(nums[right], max);
                right = mid - 1;
            }
        }
        return max;
    }
    /* 
    Root cause — classic binary search gotcha
    When right - left == 1, left-biased rounding ((right-left)/2 truncates down) makes mid == left. If your "keep searching this side" branch does left = mid (not left = mid + 1), and mid already equals left, nothing advances — the loop can never terminate.
    The rule to remember: if your branch keeps mid as a still-valid candidate using left = mid, you must use right-biased rounding instead: mid = left + (right - left + 1) / 2.
    */
   public static int findMax2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // int mid = left + (right - left) / 2; not working
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] < nums[left])
                // max is somewhere in [left, mid)  — pivot is to the left of mid
                right = mid - 1;
            else
                // nums[mid] >= nums[right] means left half is sorted,
                // so max is in [mid, right] — mid could itself be the max
                left = mid;
        }

        return nums[left]; // left == right at this point
    }

    public static int findMaxWithDuplicates(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // int mid = left + (right - left) / 2; not working
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[left]) {
                // Maximum is definitely on the left of mid
                right = mid - 1;
            } else if (nums[mid] > nums[left]) {
                // Maximum is in [mid, right]
                // mid could itself be the maximum
                left = mid;
            } else {
                // nums[mid] == nums[left]
                // Cannot determine which side contains the maximum
                left++;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 5, 1, 2 };
        System.out.println(findMax(nums1));
        System.out.println(findMax2(nums1));
        System.out.println(findMaxWithDuplicates(nums1));

        System.out.println("===========================================================================");

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMax(nums2));
        System.out.println(findMax2(nums2));
        System.out.println(findMaxWithDuplicates(nums2));

        System.out.println("===========================================================================");

        int[] nums3 = { 11, 13, 15, 17 };
        System.out.println(findMax(nums3));
        System.out.println(findMax2(nums3));
        System.out.println(findMaxWithDuplicates(nums3));

        System.out.println("===========================================================================");

    }
}
