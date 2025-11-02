package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindOutHowManyTimesHasAnArrayBeenRotated {

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

    public static void main(String[] args) {
        int[] nums1 = { 3,4,5,1,2 };
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation(nums1));
        System.out.println("===========================================================================");

        int[] nums2 = { 4,5,6,7,0,1,2 };
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation(nums2));
        System.out.println("===========================================================================");

        int[] nums3 = { 11,13,15,17 };
        System.out.println(FindOutHowManyTimesHasAnArrayBeenRotated.findKRotation(nums3));
        System.out.println("===========================================================================");

    }
}
