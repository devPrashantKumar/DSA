package AZStriverPlaylist.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSequencingProblem {
    static class Job {
        int jobId;
        int deadline;
        int profit;

        public Job(int jobId, int deadline, int profit){
            this.jobId = jobId;
            this.deadline=deadline;
            this.profit=profit;
        }
    }

    /*
     * Time Complexity : O(nlogn + n*d) , d->maxDeadline
     * Space Complexity : O(n)
     */
    public static int[] jobScheduling(int[][] Jobs) {
        int maxProfit = 0;
        int jobsExecuted = 0;
        List<Job> jobs = new ArrayList<>();
        int maxDeadline = -1;
        for(int[] job : Jobs){
            jobs.add(new Job(job[0], job[1], job[2]));
            maxDeadline = Math.max(maxDeadline, job[1]);
        }
        jobs.sort(Comparator.comparing((Job item)->item.profit).reversed());
        int[] scheduling = new int[maxDeadline+1];
        for(Job job : jobs){
            for(int i=job.deadline;i>=1;i--){
                if(scheduling[i]==0){
                    scheduling[i]=job.jobId;
                    jobsExecuted++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{jobsExecuted,maxProfit};
    }

    public static void main(String[] args) {
        int[][] jobsInput1 = {{1, 4, 20},{2,1,10},{3,1,40},{4,1,30}};
        System.out.println("Input : "+Arrays.deepToString(jobsInput1));
        System.out.println("Output : "+Arrays.toString(jobScheduling(jobsInput1)));
        System.out.println("-----------------------------------------------------------------");

        int[][] jobsInput2 = {{1, 2, 100},{2,1,19},{3,2,27},{4,1,25},{5,1,15}};
        System.out.println("Input : "+Arrays.deepToString(jobsInput2));
        System.out.println("Output : "+Arrays.toString(jobScheduling(jobsInput2)));
    }
}
