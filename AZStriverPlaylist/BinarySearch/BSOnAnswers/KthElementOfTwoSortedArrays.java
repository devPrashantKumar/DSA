package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class KthElementOfTwoSortedArrays {
     /*
    * Time Complexity : O(log(min(nums1.length, nums2.length)))
    * Space Complexity : O(1)
    */
    public static double kthElement(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length)
            return kthElement(nums2, nums1, k);

        if (k < 1 || k > nums1.length + nums2.length)
            throw new IllegalArgumentException("Invalid k");
        
        int left = Math.max(0, k-nums2.length);
        int right = Math.min(nums1.length,k);
        while(left<=right){
            int mid = left+(right-left)/2;

            int l1=0,l2=0;
            if(mid==0){
                l1 = Integer.MIN_VALUE;
            }else {
                l1 = nums1[mid-1];
            }

            if(k-mid==0){
                l2 = Integer.MIN_VALUE;
            }else {
                l2 = nums2[(k-mid)-1];
            }

            int r1 = (mid<nums1.length) ? nums1[mid] : Integer.MAX_VALUE;
            int r2 = (k-mid<nums2.length) ? nums2[k-mid] : Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
            if(l1>r2)  right = mid-1;
            else  left = mid+1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(kthElement(new int[] { 2, 3, 6, 7, 9 }, new int[] { 1, 4, 8, 10 }, 5));
        System.out.println("---------------------------------------------");
        
        System.out.println(kthElement(new int[] { 100, 112, 256, 349, 770 }, new int[] { 72, 86, 113, 119, 265, 445, 892}, 7));
        System.out.println("---------------------------------------------");
    }

}
