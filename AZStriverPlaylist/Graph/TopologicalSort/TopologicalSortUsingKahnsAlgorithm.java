package AZStriverPlaylist.Graph.TopologicalSort;

import java.util.*;

public class TopologicalSortUsingKahnsAlgorithm {
    
    /*
 * Time Complexity : O(V+E)
 *      - O(V+E), building in-degree array over adjacency list
 *      - O(V+E), BFS processing over vertices and edges
 * Space Complexity : O(V)+O(V)=O(V)
 *      - O(V), in-degree array
 *      - O(V), queue
 */
    public static int[] kahnsTopoSort(int V, List<Integer>[] adj) {
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
            return new int[]{-1};
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V1 = 2;
        List<Integer>[] adj1 = new List[2];
        adj1[0] = new ArrayList<>();
        adj1[1] = new ArrayList<>(List.of(0));

        System.out.println(Arrays.toString(kahnsTopoSort(V1, adj1)));

        System.out.println("----------------------------------------------------");

        int V2 = 4;
        List<Integer>[] adj2 = new List[4];
        adj2[0] = new ArrayList<>(List.of(1));
        adj2[1] = new ArrayList<>(List.of(2,3));
        adj2[2] = new ArrayList<>();
        adj2[3] = new ArrayList<>();

        System.out.println(Arrays.toString(kahnsTopoSort(V2, adj2)));

        System.out.println("----------------------------------------------------");

    }
}
