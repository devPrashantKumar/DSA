package AZStriverPlaylist.Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static boolean canFinishCourse(int V, List<Integer>[] adj) {
        // 0 = unvisited, 1 = cuurent visited, 2 = visited
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i]==0) {
                if(!canFinishCourseUtil(V, adj, i, visited))
                    return false;
            }
        }
        return true;
    }

    public static boolean canFinishCourseUtil(int V, List<Integer>[] adj, int node, int[] visited) {
        visited[node] = 1;
        for (int i = 0; i < adj[node].size(); i++) {
            if (visited[adj[node].get(i)]==0)
                if (!canFinishCourseUtil(V, adj, adj[node].get(i), visited)) return false;
            if (visited[adj[node].get(i)]==1)
                return false;
        }
        visited[node] = 2;
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
