package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int left=0;
        int right=nums.length-1;
        while (left<=right) {
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                ans = mid;
                // we can break beacuse elements are distinct, 
                // if  elements are not distinct then we can not use break, we again need to check element in left half
                if(nums[mid]==target) break;  
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        System.out.println(searchInsert(nums1, 5)); 
        System.out.println(searchInsert(nums1, 2));
        System.out.println(searchInsert(nums1, 7));
        System.out.println(searchInsert(nums1, 0));
        System.out.println(searchInsert(nums1, 3));
        System.out.println("---------------------------------------------");
    }
}
