package AZStriverPlaylist.Greedy;

import java.util.Arrays;

public class ShortestJobFirstScheduling {

    public static long solve(int[] bt) {
        Arrays.sort(bt);
        long waitingTime=0;
        long wait=bt.length-1;
        for(int i=0;i<bt.length-1;i++){
            waitingTime += (bt[i]*wait);
            wait--;
        }
        return waitingTime/bt.length;
    }

    public static void main(String[] args) {
        System.out.println("Job Burst Time : "+Arrays.toString(new int[]{4, 1, 3, 7, 2}));
        System.out.println("waiting time : "+ShortestJobFirstScheduling.solve(new int[]{4, 1, 3, 7, 2}));
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("Job Burst Time : "+Arrays.toString(new int[]{1,2,3,4}));
        System.out.println("waiting time : "+ShortestJobFirstScheduling.solve(new int[]{1,2,3,4}));
        System.out.println("----------------------------------------------------------------------------------");
    }
}