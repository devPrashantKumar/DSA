package AZStriverPlaylist.Heap;

import java.util.Arrays;


public class ConvertMinHeapToMaxHeap {
    /*
     * Time Complexity : O(n)
     */
    public static int[] minToMaxHeap(int[] nums) {
        int lastNonLeafNode = (nums.length/2)-1;
        for(int i=lastNonLeafNode;i>=0;i--){
            heapify(nums, i);
        }
        return nums;
    }

    public static void heapify(int[] nums, int index){
        int lc = (2*index)+1;
        int rc = (2*index)+2;

        int largest = index;
        if(lc<nums.length && nums[largest]<nums[lc]) largest = lc;
        if(rc<nums.length && nums[largest]<nums[rc]) largest=rc;
        if(largest!=index){
            swap(nums,index,largest);
            heapify(nums, largest);
        }
    }

    public static void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    public static void main(String[] args) {
        int[] input1 = {};
        System.out.println("input min-heap : "+Arrays.toString(input1));
        System.out.println("output max-heap"+Arrays.toString(minToMaxHeap(input1)));
        System.out.println("==================================================================");

        int[] input2 = {10, 20, 30, 21, 23};
        System.out.println("input min-heap : "+Arrays.toString(input2));
        System.out.println("output max-heap : "+Arrays.toString(minToMaxHeap(input2)));
        System.out.println("==================================================================");

        int[] input3 = {-5, -4, -3, -2, -1};
        System.out.println("input min-heap : "+Arrays.toString(input3));
        System.out.println("output max-heap"+Arrays.toString(minToMaxHeap(input3)));
        System.out.println("==================================================================");
    }
}
