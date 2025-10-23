package AZStriverPlaylist.Graph.Learning;

import java.util.List;

public class NumberOfConnectedComponentsInGraph {
    /*
     * Time Complexity : O(V+2E)
     * Space Complexity :O(V)+O(V)=O(V),
     *      - O(V), space occupied by visited
     *      - O(V), max recursive depth dfs will go if all vertex are in linear chain
     */
    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int count = 0;
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                count++;
                visited[i]=1;
                findNumberOfComponentUtil(edges,visited,i);
            }
        }
        return count;
    }

    public static void findNumberOfComponentUtil(List<List<Integer>> edges, int[] visited, int vertex) {
        for(int j=0;j<edges.get(vertex).size();j++){
            if(visited[edges.get(vertex).get(j)]==0){
                visited[edges.get(vertex).get(j)]=1;
                findNumberOfComponentUtil(edges,visited,edges.get(vertex).get(j));
            }
        } 
    }

    public static void main(String[] args) {
        int V1 = 4;
        List<List<Integer>> edges1 = List.of(List.of(1),List.of(2,0), List.of(1),List.of());
        System.out.println(findNumberOfComponent(V1,edges1));
        System.out.println("----------------------------------------------------------------------");

        int V2 = 7;
        List<List<Integer>> edges2 = List.of(List.of(1),List.of(0,2), List.of(1,3),List.of(2),List.of(5),List.of(4),List.of());
        System.out.println(findNumberOfComponent(V2,edges2));
        System.out.println("----------------------------------------------------------------------");
    }
}
