package AZStriverPlaylist.Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {


    public static int[] canFinishCourse(int V, List<Integer>[] adj) {
        int[] indegree = new int[V];
        int[] result = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        for(List<Integer> edge: adj){
            edge.forEach(a->indegree[a]++);
        }

        for(int i=0;i<V;i++){
            if(indegree[i]==0) queue.add(i);
        }

        int i=0;
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            result[i++] = vertex;
            for(Integer neighbour : adj[vertex]){
                if(indegree[neighbour]>0){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0) queue.add(neighbour);
                }
            }
        }

        if (i != V){
            System.out.println("Cycle detected");
            return new int[]{};
        }

        return result;
    }

    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        return canFinishCourse(numCourses, convertToAdjecencyList(numCourses, prerequisites));
    }

    @SuppressWarnings("unchecked")
    public static List<Integer>[] convertToAdjecencyList(int numCourses, int[][] prerequisites){
        List<Integer>[] adj = new List[numCourses];
        for(int i=0;i<numCourses;i++) adj[i] = new ArrayList<>();
        for(int[] prerequisite : prerequisites) adj[prerequisite[1]].add(prerequisite[0]);
        return adj;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(canFinish(numCourses1, prerequisites1));
        System.out.println("----------------------------------------------------");

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses2, prerequisites2));
        System.out.println("----------------------------------------------------");

    }
}
