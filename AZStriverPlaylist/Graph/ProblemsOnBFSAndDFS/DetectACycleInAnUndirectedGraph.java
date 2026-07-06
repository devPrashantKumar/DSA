package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInAnUndirectedGraph {
    public static boolean isCycle(int V, List<Integer>[] adj) {
        int[] visited = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    for (int j = 0; j < adj[vertex].size(); j++) {
                        if (adj[vertex].get(j) <= vertex)
                            continue;
                        if (visited[adj[vertex].get(j)] == 1)
                            return true;
                        queue.offer(adj[vertex].get(j));
                        visited[adj[vertex].get(j)] = 1;
                    }
                }
            }
        }
        return false;
    }


    public static boolean isCycleDFS(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycleDFSUtil(V, adj, -1,i,visited)) return true;
            }
        }
        return false;
    }

    public static boolean isCycleDFSUtil(int V, List<Integer>[] adj, int parent, int node, boolean[] visited) {
        visited[node]=true;
        for(int i=0;i<adj[node].size();i++){
            if(adj[node].get(i)==parent) continue;
            if(visited[adj[node].get(i)]) return true;
            if(isCycleDFSUtil(V, adj, node, adj[node].get(i), visited)) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V1 = 6;
        List<Integer>[] adj1 = new List[6];
        adj1[0] = new ArrayList<>(List.of(1, 3));
        adj1[1] = new ArrayList<>(List.of(0, 2, 4));
        adj1[2] = new ArrayList<>(List.of(1, 5));
        adj1[3] = new ArrayList<>(List.of(0, 4));
        adj1[4] = new ArrayList<>(List.of(1, 3, 5));
        adj1[5] = new ArrayList<>(List.of(2, 4));

        System.out.println(isCycle(V1, adj1));
        System.out.println(isCycleDFS(V1, adj1));
        System.out.println("----------------------------------------------------");

        int V2 = 4;
        List<Integer>[] adj2 = new List[4];
        adj2[0] = new ArrayList<>(List.of(1, 2));
        adj2[1] = new ArrayList<>(List.of(0));
        adj2[2] = new ArrayList<>(List.of(0, 3));
        adj2[3] = new ArrayList<>(List.of(2));

        System.out.println(isCycle(V2, adj2));
        System.out.println(isCycleDFS(V2, adj2));
        System.out.println("----------------------------------------------------");

    }
}
