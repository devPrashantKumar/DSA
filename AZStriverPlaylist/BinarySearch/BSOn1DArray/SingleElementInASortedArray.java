package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class SingleElementInASortedArray {

    /*
    * Time Complexity : O(log n)
    * Space Complexity : O(1)
    */
    public static int singleNonDuplicate(int[] nums){
        if(nums.length%2==0) return -1;
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(checkSingle(nums, mid)) return nums[mid];
            if(mid%2==0){
                if(mid+1<nums.length && nums[mid+1]==nums[mid]) left = mid+2;
                else right = mid-2;
            }else{
                if(nums[mid-1]==nums[mid]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }

    /*
    * Time Complexity  : O(log n)
    * Space Complexity : O(1)
    */
    public static int singleNonDuplicate2(int[] nums) {
        if(nums.length%2==0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // force mid to be even
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1])
                // pairing intact up to here — single is further right
                left = mid + 2;
            else
                // pairing broken — single is at mid or to the left
                right = mid;
        }

        return nums[left]; // left == right, the single element
    }

    public static boolean checkSingle(int[] nums, int index){
        if(index-1>=0 && nums[index-1]==nums[index]) return false;
        if(index+1<nums.length && nums[index+1]==nums[index]) return false;
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums1 = { 1,1,2,3,3,4,4,8,8 };
        System.out.println(SingleElementInASortedArray.singleNonDuplicate(nums1));
        System.out.println(SingleElementInASortedArray.singleNonDuplicate2(nums1));

        System.out.println("===========================================================================");

        int[] nums2 = { 3,3,7,7,10,11,11 };
        System.out.println(SingleElementInASortedArray.singleNonDuplicate(nums2));
        System.out.println(SingleElementInASortedArray.singleNonDuplicate2(nums2));

        System.out.println("===========================================================================");

        int[] nums3 = { 11,13,15,17 };
        System.out.println(SingleElementInASortedArray.singleNonDuplicate(nums3));
        System.out.println(SingleElementInASortedArray.singleNonDuplicate2(nums3));

        System.out.println("===========================================================================");

    }
}
