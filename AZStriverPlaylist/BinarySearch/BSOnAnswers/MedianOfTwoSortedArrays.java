package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class MedianOfTwoSortedArrays {
    /*
    * Time Complexity : O(m+n)
    * Space Complexity : O(m+n)
    */
    public static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;
        int[] merge = new int[n];
        int i1=0,i2=0,i=0;
        while(i1<nums1.length && i2<nums2.length){
            merge[i++] = (nums1[i1]<=nums2[i2]) ? nums1[i1++] : nums2[i2++];
        }
        while(i1<nums1.length){
            merge[i++] = nums1[i1++];
        }
        while(i2<nums2.length){
            merge[i++] = nums2[i2++];
        }
        
        if(n%2==0){
            return(merge[(n/2)-1]+merge[n/2])/2.0;
        }
        return merge[n/2];
    }

    /*
    * Time Complexity : O(m+n)
    * Space Complexity : O(1)
    */
    public static double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;
        int firstIndex = (n/2)-1;
        int secondIndex = n/2;
        int firstElement = Integer.MIN_VALUE;
        int secondElement = Integer.MAX_VALUE;
        int i1=0,i2=0,i=0;
        while(i1<nums1.length && i2<nums2.length){
            int element = (nums1[i1]<=nums2[i2]) ? nums1[i1++] : nums2[i2++];
            if(i==firstIndex) firstElement = element;
            if(i==secondIndex) secondElement = element;
            i++;
        }
        while(i1<nums1.length){
            int element = nums1[i1++];
            if(i==firstIndex) firstElement = element;
            if(i==secondIndex) secondElement = element;
            i++;
        }
        while(i2<nums2.length){
            int element = nums2[i2++];
            if(i==firstIndex) firstElement = element;
            if(i==secondIndex) secondElement = element;
            i++;
        }
        
        if(n%2==0){
            return(firstElement+secondElement)/2.0;
        }
        return secondElement;
    }

    /*
    * Time Complexity : O(log(min(nums1.length, nums2.length)))
    * Space Complexity : O(1)
    */
    public static double findMedianSortedArraysUsingBS(int[] nums1, int[] nums2) {
        // if (nums1.length > nums2.length) return findMedianSortedArraysUsingBS(nums2, nums1);
        int n = nums1.length+nums2.length;
        int k = (n+1)/2;
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

            if(l1<=r2 && l2<=r1) return evaluateForMedianPartition(l1,l2,r1,r2,n);
            if(l1>r2)  right = mid-1;
            else  left = mid+1;
        }
        return 0.0;
    }

    public static double evaluateForMedianPartition(int l1, int l2, int r1, int r2, int totalElements){
        if(totalElements%2==0)
            return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
        else return Math.max(l1,l2);
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysBruteForce(new int[] { 1,3 }, new int[] { 2 }));
        System.out.println(findMedianSortedArraysBetter(new int[] { 1,3 }, new int[] { 2 }));
        System.out.println(findMedianSortedArraysUsingBS(new int[] { 1,3 }, new int[] { 2 }));

        System.out.println("---------------------------------------------");
        
        System.out.println(findMedianSortedArraysBruteForce(new int[] { 1,2 }, new int[] { 3,4 }));
        System.out.println(findMedianSortedArraysBetter(new int[] { 1,2 }, new int[] { 3,4 }));
        System.out.println(findMedianSortedArraysUsingBS(new int[] { 1,2 }, new int[] { 3,4 }));

        System.out.println("---------------------------------------------");
    }
}
