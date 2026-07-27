package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindOutHowManyTimesHasAnArrayBeenRotated {

    // Time:  O(log n)
    // Space: O(1)
    public static int findKRotation(int[] nums) {
        int index=-1;
        int min = Integer.MAX_VALUE;
        int left=0;
        int right= nums.length-1;
        while (left<=right) {
            int mid = left+(right-left)/2;
            if (nums[left] <= nums[right]) {
                if (nums[left] < min) {
                    min = nums[left];
                    index = left;
                }
                break;
            }
            if(nums[left]<=nums[mid]){
                if(nums[left]<min){
                    min=nums[left];
                    index=left;
                }
                left=mid+1;
            }
            else{
                if(nums[mid]<min){
                    min = nums[mid];
                    index=mid;
                }
                right = mid-1;
            }
        }
        return index;
    
    }


    // Time:  O(log n)
    // Space: O(1)
    public static int findKRotation2(int[] nums) {
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

        return left; // left == right at this point
    }

    public static void main(String[] args) {
        int[] nums1 = { 3,4,5,1,2 };
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation(nums1));
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation2(nums1));

        System.out.println("===========================================================================");

        int[] nums2 = { 4,5,6,7,0,1,2 };
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation(nums2));
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation2(nums2));

        System.out.println("===========================================================================");

        int[] nums3 = { 11,13,15,17 };
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation(nums3));
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation2(nums3));

        System.out.println("===========================================================================");

    }
}
