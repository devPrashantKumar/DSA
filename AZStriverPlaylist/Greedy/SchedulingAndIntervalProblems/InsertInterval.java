package AZStriverPlaylist.Greedy.SchedulingAndIntervalProblems;

import java.util.*;

public class InsertInterval {
    public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();;
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

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3},{6,9}};
        int[] newInterval1 = {2,5};
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval(intervals1, newInterval1)));
        System.out.println("-----------------------------------------------------------------");

        int[][] intervals2 = {{1, 2},{3,5},{6,7},{8,10}};
        int[] newInterval2 = {4,8};
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval(intervals2, newInterval2)));
        System.out.println("-----------------------------------------------------------------");

        int[][] intervals3 = {{1, 2},{3,5},{6,7},{8,10}};
        int[] newInterval3 = {1,8};
        System.out.println("Output : "+Arrays.deepToString(insertNewInterval(intervals3, newInterval3)));
    }
}
