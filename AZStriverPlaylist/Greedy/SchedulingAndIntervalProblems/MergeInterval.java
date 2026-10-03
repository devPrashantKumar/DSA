package AZStriverPlaylist.Greedy.SchedulingAndIntervalProblems;

import java.util.*;

public class MergeInterval {
    public static int[][] mergeInterval(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int ns = intervals[0][0];
        int ne = intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s>ne){
                result.add(new int[]{ns,ne});
                ns=s;
                ne=e;
            }
            else if(e<ns){
                result.add(new int[]{s,e});
            }
            else{
                if(ns<s) s=ns;
                if(ne>e) e=ne;
                ns=s;
                ne=e;
            }
        }
        result.add(new int[]{ns,ne});
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3},{2,6},{8,10},{15,18}};
        System.out.println("Output : "+Arrays.deepToString(mergeInterval(intervals1)));
        System.out.println("-----------------------------------------------------------------");

        int[][] intervals2 = {{1, 4},{4,5}};
        System.out.println("Output : "+Arrays.deepToString(mergeInterval(intervals2)));
        System.out.println("-----------------------------------------------------------------");

        int[][] intervals3 = {{1, 2},{3,5},{6,7},{8,10}};
        System.out.println("Output : "+Arrays.deepToString(mergeInterval(intervals3)));
    }
}
