package AZStriverPlaylist.Array.Easy;

import java.util.Arrays;

public class ConsecutiveOnce {
    /*
     * Two Pointer / Sliding Window Approach
     * Time Complexity : O(n)
     */
    public static int consecutiveOnceInArrayUsingSlidingWindow(int[] arr){
        int maxWindow=0;
        int i=-1;int j=0;
        for(;j<arr.length;j++){
            if(arr[j]==0){
                int window = (j-1)-i;
                maxWindow = Math.max(maxWindow, window);
                i=j;
            }
        }
        maxWindow = Math.max(maxWindow, arr.length-i-1);
        return maxWindow;
    }

    /*
     * Time Complexity : O(n)
     */
    public static int consecutiveOnceInArray(int[] arr){
        int counter=0;
        int maxCounter=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                counter++;
            }
            else{
                maxCounter = Math.max(counter,maxCounter);
                counter=0;
            }
        }
        maxCounter = Math.max(counter,maxCounter);
        return maxCounter;

    }
    public static void main(String[] args) {
        int[] input1 = {1,1,0,1,1,1,0,0,0,1};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+ConsecutiveOnce.consecutiveOnceInArray(input1));
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+ConsecutiveOnce.consecutiveOnceInArrayUsingSlidingWindow(input1));

        System.out.println("------------------------------------------------------");
    }
}
