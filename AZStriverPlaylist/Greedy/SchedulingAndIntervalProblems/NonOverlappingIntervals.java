package AZStriverPlaylist.Greedy.SchedulingAndIntervalProblems;

import java.util.*;

public class NonOverlappingIntervals {
    
    public static int maximumNonOverlappingIntervals(int[][] intervals) {
        int count=0;
        Arrays.deepToString(intervals);
        Arrays.sort(intervals,Comparator.comparingInt(interval->interval[1]));
        Arrays.deepToString(intervals);
        int lastEnd = -1;
        for(int i=0;i<intervals.length;i++){
            if(lastEnd>intervals[i][0]){
                count++;
            }else{
                lastEnd = intervals[i][1];
            }
        }
        return count;
    }

     public static void main(String[] args) {
        int[][] jobsInput1 = {{1, 2},{2,3},{3,4},{1,3}};
        System.out.println("Input : "+Arrays.deepToString(jobsInput1));
        System.out.println("Output : "+maximumNonOverlappingIntervals(jobsInput1));
        System.out.println("-----------------------------------------------------------------");

        int[][] jobsInput2 = {{1, 2},{1, 2},{1, 2}};
        System.out.println("Input : "+Arrays.deepToString(jobsInput2));
        System.out.println("Output : "+maximumNonOverlappingIntervals(jobsInput2));
        System.out.println("-----------------------------------------------------------------");

        int[][] jobsInput3 = {{1, 2},{2,3}};
        System.out.println("Input : "+Arrays.deepToString(jobsInput3));
        System.out.println("Output : "+maximumNonOverlappingIntervals(jobsInput3));
    }
}
