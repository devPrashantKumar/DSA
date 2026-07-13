package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.ArrayList;
import java.util.List;

public class DetectACycleInAnDirectedGraph {

    public static boolean isCycleDFS(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycleDFSUtil(V, adj, i,visited,pathVisited)) return true;
            }
        }
        return false;

    }

    public static boolean isCycleDFSUtil(int V, List<Integer>[] adj, int vertex, boolean[] visited, boolean[] pathVisited) {
        visited[vertex]=true;
        pathVisited[vertex]=true;

        for(int i=0;i<adj[vertex].size();i++){
            int neighbor = adj[vertex].get(i);
            if(!visited[neighbor]) {
                if(isCycleDFSUtil(V, adj, neighbor, visited, pathVisited)) return true;
            }
            else if(pathVisited[neighbor]) return true;
        }
        pathVisited[vertex]=false;
        return false;
    }


    public static boolean isCycleDFS2(int V, List<Integer>[] adj) {
        int[] visited = new int[V];

        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(isCycleDFSUtil2(V, adj, i,visited)) return true;
            }
        }
        return false;

    }

    public static boolean isCycleDFSUtil2(int V, List<Integer>[] adj, int vertex, int[] visited) {
        visited[vertex]=2;

        for(int i=0;i<adj[vertex].size();i++){
            int neighbor = adj[vertex].get(i);
            if(visited[neighbor]==0) {
                if(isCycleDFSUtil2(V, adj, neighbor, visited)) return true;
            }
            else if(visited[neighbor]==2) return true;
        }
        visited[vertex]=1;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V1 = 2;
        List<Integer>[] adj1 = new List[2];
        adj1[0] = new ArrayList<>();
        adj1[1] = new ArrayList<>(List.of(0));

        System.out.println(isCycleDFS(V1, adj1));
        System.out.println(isCycleDFS2(V1, adj1));

        System.out.println("----------------------------------------------------");

         int V2 = 2;
         List<Integer>[] adj2 = new List[2];
         adj2[0] = new ArrayList<>(List.of(1));
         adj2[1] = new ArrayList<>(List.of(0));

        System.out.println(isCycleDFS(V2, adj2));
        System.out.println(isCycleDFS2(V2, adj2));

        System.out.println("----------------------------------------------------");

    }
}
