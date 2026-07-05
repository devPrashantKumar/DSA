package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInAnDirectedGraph {
    public static boolean isCycle(int V, List<Integer>[] adj) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
                boolean[] visited = new boolean[V];
                queue.offer(i);
                visited[i]=true;
                while(!queue.isEmpty()){
                    Integer vertex = queue.poll();
                    for(Integer dependentOn : adj[vertex]){
                        if(visited[dependentOn]) return true;
                        queue.offer(dependentOn);
                        visited[dependentOn]=true;
                    }
                }
            //}
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V1 = 2;
        List<Integer>[] adj1 = new List[2];
        adj1[0] = new ArrayList<>();
        adj1[1] = new ArrayList<>(List.of(0));

        System.out.println(isCycle(V1, adj1));
        System.out.println("----------------------------------------------------");

         int V2 = 2;
         List<Integer>[] adj2 = new List[2];
         adj2[0] = new ArrayList<>(List.of(1));
         adj2[1] = new ArrayList<>(List.of(0));

        System.out.println(isCycle(V2, adj2));
        System.out.println("----------------------------------------------------");

    }
}
