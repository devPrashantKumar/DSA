package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (!isCycleDFSUtil(V, adj, i, visited))
                    return false;
            }
        }
        return true;
    }

    public static boolean isCycleDFSUtil(int V, List<Integer>[] adj, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < adj[node].size(); i++) {
            if (visited[adj[node].get(i)])
                return false;
            if (!isCycleDFSUtil(V, adj, adj[node].get(i), visited))
                return false;
        }
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return isCycle(numCourses, convertToAdjecencyList(numCourses, prerequisites));
    }

    @SuppressWarnings("unchecked")
    public static List<Integer>[] convertToAdjecencyList(int numCourses, int[][] prerequisites){
        List<Integer>[] adj = new List[numCourses];
        for(int i=0;i<numCourses;i++) adj[i] = new ArrayList<>();
        for(int[] prerequisite : prerequisites) adj[prerequisite[0]].add(prerequisite[1]);
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
