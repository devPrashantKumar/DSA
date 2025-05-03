package AZStriverPlaylist.Array;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequenceInAnArray {
    /*
     * BruteForce approach
     * Time Complexity : O(nLogn+ n)
     */
    public static int longestSequenceLength(int[] arr){
        Arrays.sort(arr);
        int lastElement=Integer.MIN_VALUE;
        int count=0;
        int longest=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==lastElement) continue;
            
            if(arr[i]==lastElement+1){
                count++;
                lastElement=arr[i];
            }else{
                longest = Math.max(longest, count);
                count=1;
                lastElement=arr[i];
            }
        }
        longest = Math.max(longest, count);
        return longest;

    }
    
    /* 
     * Time Complexity : O(2*n)
     * Space Complexity : O(n)
     */
    public static int longestSequenceLengthOptimal(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int longest=0;
        for(int num:arr){
            set.add(num);
        }
        // Iterating over set instead of arr: Prevents checking duplicate numbers more than once.
        for(int num:set){
            if(!set.contains(num-1)){
                int counter=1;
                while(set.contains(++num))counter++;
                longest = Math.max(longest, counter);
            }
        }
        return longest;
    }
    
    public static void main(String[] args) {
        int[] input1 = {100,4,200,1,3,2};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestConsecutiveSequenceInAnArray.longestSequenceLengthOptimal(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestConsecutiveSequenceInAnArray.longestSequenceLength(input1));

        System.out.println("------------------------------------------------------");
        int[] input2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestConsecutiveSequenceInAnArray.longestSequenceLengthOptimal(input2));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestConsecutiveSequenceInAnArray.longestSequenceLength(input2));

        System.out.println("------------------------------------------------------");
        int[] input3 = {1,0,1,2};
        System.out.println("Input : "+Arrays.toString(input3)+" Output : "+LongestConsecutiveSequenceInAnArray.longestSequenceLengthOptimal(input3));
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestConsecutiveSequenceInAnArray.longestSequenceLength(input2));

    }

}
