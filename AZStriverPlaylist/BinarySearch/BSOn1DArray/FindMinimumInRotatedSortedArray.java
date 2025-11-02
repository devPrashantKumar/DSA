package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[left]<=nums[mid]){
                min = Math.min(min,nums[left]);
                left=mid+1;
            }
            else{
                min = Math.min(nums[mid],min);
                right = mid-1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3,4,5,1,2 };
        System.out.println(FindMinimumInRotatedSortedArray.findMin(nums1));
        System.out.println("===========================================================================");

        int[] nums2 = { 4,5,6,7,0,1,2 };
        System.out.println(FindMinimumInRotatedSortedArray.findMin(nums2));
        System.out.println("===========================================================================");

        int[] nums3 = { 11,13,15,17 };
        System.out.println(FindMinimumInRotatedSortedArray.findMin(nums3));
        System.out.println("===========================================================================");

    }
}
