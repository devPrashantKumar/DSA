package AZStriverPlaylist.Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

    /*
    * Time Complexity : O(V+E)
    * Space Complexity : O(V)
    */
    public static int[] topologicalSort(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stk = new Stack<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                topologicalSortUtil(V, adj, i,visited,stk);
            }
        }
        int[] result = new int[V];
        for(int i=0;i<V;i++) result[i]=stk.pop();

        return result;

    }

    public static void topologicalSortUtil(int V, List<Integer>[] adj, int vertex, boolean[] visited, Stack<Integer> stk) {
        visited[vertex]=true;
        for(int i=0;i<adj[vertex].size();i++){
            int neighbor = adj[vertex].get(i);
            if(!visited[neighbor]) {
                topologicalSortUtil(V, adj, neighbor, visited,stk);
            }
        }
        stk.add(vertex);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V1 = 2;
        List<Integer>[] adj1 = new List[2];
        adj1[0] = new ArrayList<>();
        adj1[1] = new ArrayList<>(List.of(0));

        System.out.println(Arrays.toString(topologicalSort(V1, adj1)));

        System.out.println("----------------------------------------------------");

        int V2 = 4;
        List<Integer>[] adj2 = new List[4];
        adj2[0] = new ArrayList<>(List.of(1));
        adj2[1] = new ArrayList<>(List.of(2,3));
        adj2[2] = new ArrayList<>();
        adj2[3] = new ArrayList<>();


        System.out.println(Arrays.toString(topologicalSort(V2, adj2)));

        System.out.println("----------------------------------------------------");

    }
}

