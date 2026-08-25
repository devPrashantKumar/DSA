package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpaceII {

    // TC : O(min(m,n))+O(nlogn)+O(mlogm)
    // SC : O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int leftLargest = m-1;
        int rightSmallest = 0;

        while (leftLargest>=0 && rightSmallest<n) {
            if(nums1[leftLargest]>nums2[rightSmallest]) {
                int temp = nums1[leftLargest];
                nums1[leftLargest] = nums2[rightSmallest];
                nums2[rightSmallest] = temp;
            }else{
                break;
            }
            leftLargest--;
            rightSmallest++;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3 };
        int m = 3;
        int[] nums2 = { 2,5,6 };
        int n = 3;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m + " -> " + Arrays.toString(nums1));
        System.out.println("Input : m -> "+ n + " -> " + Arrays.toString(nums2));
        merge(nums1,m, nums2, n);
        System.out.println("Output : nums1->" + Arrays.toString(nums1)+" nums2->" + Arrays.toString(nums2));

        System.out.println("---------------------------------------------------");

        int[] nums11 = { 1 };
        int m1 = 1;
        int[] nums12 = { };
        int n1 = 0;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m1 + " -> " + Arrays.toString(nums11));
        System.out.println("Input : m -> "+ n1 + " -> " + Arrays.toString(nums12));
        merge(nums11,m1, nums12, n1);
        System.out.println("Output : " + Arrays.toString(nums11)+" nums2->" + Arrays.toString(nums12));

        System.out.println("---------------------------------------------------");

        int[] nums21 = { };
        int m2 = 0;
        int[] nums22 = { 1 };
        int n2 = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m2 + " -> " + Arrays.toString(nums21));
        System.out.println("Input : m -> "+ n2 + " -> " + Arrays.toString(nums22));
        merge(nums21,m2, nums22, n2);
        System.out.println("Output : " + Arrays.toString(nums21)+" nums2->" + Arrays.toString(nums22));
       
    }
}
