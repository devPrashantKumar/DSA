package AZStriverPlaylist.Heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Time Complexity : O(n log n)
 * Space Complexity : O(n)
 */
public class TaskScheduler {
    static class Task implements Comparable<Task>{
        int taskFrequency;
        int executionTime;

        Task(int taskFrequency, int executionTime){
            this.taskFrequency=taskFrequency;
            this.executionTime=executionTime;
        }

        @Override
        public int compareTo(Task task) {
            return Integer.compare(this.taskFrequency, task.taskFrequency)*-1;
        }

        @Override
        public String toString() {
            return "Task [taskFrequency=" + taskFrequency + ", executionTime=" + executionTime + "]";
        }

    }


    public static int leastInterval(char[] tasks, int n) {
        int interval=0; 
        int[] hashTable = new int[26];
        for(char c:tasks){
            hashTable[c-'A']++;
        }
        Queue<Task> pq = new PriorityQueue<>();
        Queue<Task> queue = new LinkedList<>();
        Arrays.stream(hashTable).filter((a)->a>0).forEach((a)->pq.add(new Task(a,0)));
        System.out.println(pq);

        while(!pq.isEmpty() || !queue.isEmpty()){
            if(!queue.isEmpty() && queue.peek().executionTime==interval){
                pq.add(new Task(queue.poll().taskFrequency, interval));
            }

            if(!pq.isEmpty()){
                Task task = pq.poll();
                if(task.taskFrequency-1>0){
                    queue.add(new Task(task.taskFrequency-1, interval+n+1));
                }
            }
            interval++;
        }

        return interval;
    }
    
    public static void main(String[] args) {
        char[] input1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        System.out.println("Output : "+leastInterval(input1, n1));
        System.out.println("-------------------------------------------------------");
        char[] input2 = {'A','C','A','B','D','B'};
        int n2 = 1;
        System.out.println("Output : "+leastInterval(input2, n2));
        System.out.println("-------------------------------------------------------");
        char[] input3 = {'A','A','A','B','B','B'};
        int n3 = 3;
        System.out.println("Output : "+leastInterval(input3, n3));
        System.out.println("-------------------------------------------------------");
    }
}
