package AZStriverPlaylist.Array.Hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpaceIII {

    // TC : O((m+n)log(m+n))
    //  SC : O(1)
    // using Gap aaproach (inspired from shell sort)
    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int gap = (len+1)/2;

        while(gap>0){
            int left=0;
            int right = left+gap;
            while(right<len){
                if(left<m && right>=m){
                    swapIfGreater(nums1, nums2, left, right-m);
                }
                else if(left>=m){
                    swapIfGreater(nums2, nums2, left-m, right-m);

                }else{
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;right++;
            }
            if(gap==1) break;
            gap = (gap/2)+(gap%2);
        }

        
    }

    private static void swapIfGreater(int[] nums1, int[] nums2, int ind1, int ind2){
        if(nums1[ind1]>nums2[ind2]){
            int temp = nums1[ind1];
            nums1[ind1] = nums2[ind2];
            nums2[ind2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3 };
        int m = 3;
        int[] nums2 = { 2,5,6 };
        int n = 3;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m + " -> " + Arrays.toString(nums1));
        System.out.println("Input : m -> "+ n + " -> " + Arrays.toString(nums2));
        mergeOptimal(nums1,m, nums2, n);
        System.out.println("Output : nums1->" + Arrays.toString(nums1)+" nums2->" + Arrays.toString(nums2));

        System.out.println("---------------------------------------------------");

        int[] nums11 = { 1 };
        int m1 = 1;
        int[] nums12 = { };
        int n1 = 0;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m1 + " -> " + Arrays.toString(nums11));
        System.out.println("Input : m -> "+ n1 + " -> " + Arrays.toString(nums12));
        mergeOptimal(nums11,m1, nums12, n1);
        System.out.println("Output : " + Arrays.toString(nums11)+" nums2->" + Arrays.toString(nums12));

        System.out.println("---------------------------------------------------");

        int[] nums21 = { };
        int m2 = 0;
        int[] nums22 = { 1 };
        int n2 = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("Input : m -> "+ m2 + " -> " + Arrays.toString(nums21));
        System.out.println("Input : m -> "+ n2 + " -> " + Arrays.toString(nums22));
        mergeOptimal(nums21,m2, nums22, n2);
        System.out.println("Output : " + Arrays.toString(nums21)+" nums2->" + Arrays.toString(nums22));
       
    }
}
