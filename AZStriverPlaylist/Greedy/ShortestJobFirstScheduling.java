package AZStriverPlaylist.Greedy;

import java.util.Arrays;

public class ShortestJobFirstScheduling {
    /*
     * Intution
     * Shorter job first always minimises total waiting time because:
     * A short job delays fewer subsequent jobs
     * A long job at the front delays ALL jobs behind it
     */

    /*
     * Time Complexity : O(nlogn + n)
     * Space Complexity : O(1)
     */
    public static long solve(int[] bt) {
        if (bt == null || bt.length == 0)
            return 0;
        Arrays.sort(bt);
        long waitingTime = 0;
        long wait = 0;
        for (int i = 0; i < bt.length; i++) {
            waitingTime += wait;
            wait += bt[i];
        }
        return waitingTime / bt.length;
    }

    /*
     * Time Complexity : O(nlogn + n)
     * Space Complexity : O(1)
     */
    public static long solve2(int[] bt) {
        if (bt == null || bt.length == 0)
            return 0;
        Arrays.sort(bt);
        long waitingTime = 0;
        long noOfJobsWaiting = bt.length - 1;
        for (int i = 0; i < bt.length - 1; i++) {
            waitingTime += (bt[i] * noOfJobsWaiting);
            noOfJobsWaiting--;
        }
        return waitingTime / bt.length;
    }

    public static void main(String[] args) {
        System.out.println("Job Burst Time : " + Arrays.toString(new int[] { 4, 1, 3, 7, 2 }));
        System.out.println("waiting time : " + ShortestJobFirstScheduling.solve(new int[] { 4, 1, 3, 7, 2 }));
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("Job Burst Time : " + Arrays.toString(new int[] { 1, 2, 3, 4 }));
        System.out.println("waiting time : " + ShortestJobFirstScheduling.solve(new int[] { 1, 2, 3, 4 }));
        System.out.println("----------------------------------------------------------------------------------");
    }
}