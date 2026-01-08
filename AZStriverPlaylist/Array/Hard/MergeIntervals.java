package AZStriverPlaylist.Array.Hard;

import java.util.*;

public class MergeIntervals {
    /*
    * Time complexity : O(n logn)+O(n)
    */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>end){
                result.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
            else if(intervals[i][1]>end){
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals1 = { {1,3},{2,6},{8,10},{15,18} };
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + Arrays.deepToString(intervals1));
        System.out.println("Output : " +Arrays.deepToString(MergeIntervals.merge(intervals1)));

        System.out.println("---------------------------------------------------");
    }
}
