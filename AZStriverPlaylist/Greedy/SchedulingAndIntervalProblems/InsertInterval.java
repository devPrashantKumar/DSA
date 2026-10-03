package AZStriverPlaylist.Greedy.SchedulingAndIntervalProblems;

import java.util.*;

public class InsertInterval {
    public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s>newInterval[1]){
                result.add(new int[]{newInterval[0],newInterval[1]});
                newInterval[0]=s;
                newInterval[1]=e;
            }
            else if(e<newInterval[0]){
                result.add(new int[]{s,e});
            }
            else{
                if(newInterval[0]<s) s=newInterval[0];
                if(newInterval[1]>e) e=newInterval[1];
                newInterval[0]=s;
                newInterval[1]=e;
            }
        }
        result.add(new int[]{newInterval[0],newInterval[1]});
        return result.toArray(new int[0][]);
    }

    public static int[][] insertNewInterval2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            if(intervals[i][0]<newInterval[0]) newInterval[0] = intervals[i][0];
            if(intervals[i][1]>newInterval[1]) newInterval[1] = intervals[i][1];
            i++;
        }
        result.add(new int[]{newInterval[0],newInterval[1]});
        while(i<intervals.length){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval(new int[][]{{1, 3},{6,9}}, new int[]{2,5})));
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval2(new int[][]{{1, 3},{6,9}}, new int[]{2,5})));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Output : "+Arrays.deepToString(insertNewInterval(new int[][]{{1, 2},{3,5},{6,7},{8,10}}, new int[]{4,8})));
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval2(new int[][]{{1, 2},{3,5},{6,7},{8,10}}, new int[]{4,8})));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Output : "+Arrays.deepToString(insertNewInterval(new int[][]{{1, 2},{3,5},{6,7},{8,10}}, new int[]{1,8})));
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval2(new int[][]{{1, 2},{3,5},{6,7},{8,10}}, new int[]{1,8})));

    }
}
