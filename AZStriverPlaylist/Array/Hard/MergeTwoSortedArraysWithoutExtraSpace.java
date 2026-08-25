package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    // TC : O(m+n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        while(m>0 && n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[index] = nums1[m-1];
                m--;
            }else{
                nums1[index] = nums2[n-1];
                n--;
            }
            index--;
        }

        while(n>0){
            nums1[index] = nums2[n-1];
            n--;
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,0,0,0 };
        int m = 3;
        int[] nums2 = { 2,5,6 };
        int n = 3;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m + " -> " + Arrays.toString(nums1));
        System.out.println("Input : m -> "+ n + " -> " + Arrays.toString(nums2));
        merge(nums1,m, nums2, n);
        System.out.println("Output : " + Arrays.toString(nums1));

        System.out.println("---------------------------------------------------");

        int[] nums11 = { 1 };
        int m1 = 1;
        int[] nums12 = { };
        int n1 = 0;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m1 + " -> " + Arrays.toString(nums11));
        System.out.println("Input : m -> "+ n1 + " -> " + Arrays.toString(nums12));
        merge(nums11,m1, nums12, n1);
        System.out.println("Output : " + Arrays.toString(nums11));

        System.out.println("---------------------------------------------------");

        int[] nums21 = { 0 };
        int m2 = 0;
        int[] nums22 = { 1 };
        int n2 = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m2 + " -> " + Arrays.toString(nums21));
        System.out.println("Input : m -> "+ n2 + " -> " + Arrays.toString(nums22));
        merge(nums21,m2, nums22, n2);
        System.out.println("Output : " + Arrays.toString(nums11));
       
    }
}
