package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphBFSAndDFS {
    /*
     * Time Complexity : O(V+2E)
     * Space Complexity :O(V)+O(V)=O(V),
     *      - O(V), space occupied by visited
     *      - O(V), max recursive depth dfs will go if all vertex are in linear chain
     */
    public static boolean isBipartiteGraphDFS(int V, List<List<Integer>> edges) {
        int[] visited = new int[V];
        for(int i=0;i<visited.length;i++) visited[i]=-1;
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                visited[i]=0;
                if(!isBipartiteGraphDFSUtil(edges,visited,i)) return false;
            }
        }
        return true;
    }

    public static boolean isBipartiteGraphDFSUtil(List<List<Integer>> edges, int[] visited, int vertex) {
        int color = visited[vertex];
        for(int j=0;j<edges.get(vertex).size();j++){
            if(visited[edges.get(vertex).get(j)]==-1){
                visited[edges.get(vertex).get(j)]= ((color+1)%2); // we can use [1 - color] also
                if(!isBipartiteGraphDFSUtil(edges,visited,edges.get(vertex).get(j)))return false;
            }
            else if(visited[edges.get(vertex).get(j)]!=((color+1)%2)) return false;
        } 
        return true;
    }

    public static boolean isBipartiteGraphDFS2(int V, List<List<Integer>> edges) {
        int[] visited = new int[V];
        for(int i=0;i<visited.length;i++) visited[i]=-1;
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                if(!isBipartiteGraphDFSUtil2(edges,visited,i,0)) return false;
            }
        }
        return true;
    }

    public static boolean isBipartiteGraphDFSUtil2(List<List<Integer>> edges, int[] visited, int vertex, int color) {
        visited[vertex]=color;
        for(int j=0;j<edges.get(vertex).size();j++){
            if(visited[edges.get(vertex).get(j)]==-1){
                if(!isBipartiteGraphDFSUtil2(edges,visited,edges.get(vertex).get(j),1-color))return false;
            }
            else if(visited[edges.get(vertex).get(j)]==color) return false;
        } 
        return true;
    }


    public static boolean isBipartiteGraphBFS(int V, List<List<Integer>> edges) {
        int[] visited = new int[V];
        for(int i=0;i<visited.length;i++) visited[i]=-1;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                queue.offer(i);
                visited[i] = 0;
                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    int color = visited[vertex];
                    for(int j=0;j<edges.get(vertex).size();j++){
                        if(visited[edges.get(vertex).get(j)]==-1){
                            queue.offer(edges.get(vertex).get(j));
                            visited[edges.get(vertex).get(j)] = (color+1)%2; 
                        }else if(visited[edges.get(vertex).get(j)]!=(color+1)%2){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // public boolean isBipartite(int[][] graph) {
    //     int n = graph.length;
    //     int[] color= new int[n];
    //     Queue<Integer> queue = new LinkedList<>();
    //     for(int i=0;i<n;i++) color[i]=-1;
    //     for(int i=0;i<n;i++){
    //         if(color[i]==-1){
    //             queue.add(i);
    //             color[i]=0;
    //             while(!queue.isEmpty()){
    //                 Integer vertex = queue.poll();
    //                 int currentColor = color[vertex];
    //                 for(int k=0;k<graph[vertex].length;k++){
    //                     int newColor = 1-currentColor;
    //                     int neighbour = graph[vertex][k];
    //                     if(color[neighbour]==-1){
    //                         queue.add(neighbour);
    //                         color[neighbour]=newColor;
    //                     }else if(color[neighbour]!=newColor) return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        int V1 = 4;
        List<List<Integer>> edges1 = List.of(List.of(1),List.of(2,0,3), List.of(1,3),List.of(1,2));
        System.out.println(isBipartiteGraphDFS(V1,edges1));
        System.out.println(isBipartiteGraphDFS2(V1,edges1));
        System.out.println(isBipartiteGraphBFS(V1,edges1));

        System.out.println("----------------------------------------------------------------------");

        int V2 = 7;
        List<List<Integer>> edges2 = List.of(List.of(1),List.of(0,2), List.of(1,3),List.of(2),List.of(5),List.of(4),List.of());
        System.out.println(isBipartiteGraphDFS(V2,edges2));
        System.out.println(isBipartiteGraphDFS2(V2,edges2));
        System.out.println(isBipartiteGraphBFS(V2,edges2));

        System.out.println("----------------------------------------------------------------------");
    }
}
