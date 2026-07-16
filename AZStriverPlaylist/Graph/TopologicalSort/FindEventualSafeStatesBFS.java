package AZStriverPlaylist.Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStatesBFS {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int V = graph.length;
        List<Integer>[] reverseGraph = new List[graph.length];
        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            reverseGraph[i]= new ArrayList<>();
            indegree[i] = graph[i].length;
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                reverseGraph[graph[i][j]].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            result.add(vertex);
            for(int i=0;i<reverseGraph[vertex].size();i++){
                int neighbor = reverseGraph[vertex].get(i);
                if(indegree[neighbor]>0){
                    indegree[neighbor]--;
                    if(indegree[neighbor]==0) queue.add(neighbor);
                }
                
            }
        }

        return result.stream().sorted().toList();
    }

    public static void main(String[] args) {        
        int[][] prerequisites1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(prerequisites1));
        System.out.println("----------------------------------------------------");

        int[][] prerequisites2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(eventualSafeNodes(prerequisites2));
        System.out.println("----------------------------------------------------");
    }
}
