package AZStriverPlaylist.Recursion.HardProblems;

import java.util.*;

public class MColoringProblem {

    public static boolean graphColoring(int[][] edges, int m, int n) {
        List<Integer>[] adjacencyList = createAdjacencyList(edges, n);
        int[] vertexColor = new int[n];
        return graphColoringUtil(adjacencyList, m, n, 0, vertexColor);
    }

    public static boolean graphColoringUtil(List<Integer>[] adjacencyList, int m, int n, int vertex, int[] vertexColor){
        if(vertex==n) return true;
        for(int color=1;color<=m;color++){
            if(isSafeVertexColor(adjacencyList, vertex, vertexColor, color)){
                vertexColor[vertex]=color;
                if(graphColoringUtil(adjacencyList, m, n, vertex+1, vertexColor)) return true;
                vertexColor[vertex]=0;
            }
        }
        return false;
    }

    public static boolean isSafeVertexColor(List<Integer>[] adjacencyList, int vertex, int[] vertexColor, int color){
        for(Integer neighbour : adjacencyList[vertex]){
            if(vertexColor[neighbour]==color) return false;
        }
        return true;
    }

    public static List<Integer>[] createAdjacencyList(int[][] edges, int n) {
        @SuppressWarnings("unchecked")
        List<Integer>[] vertices = new List[n];

        for(int i=0;i<n;i++){
            vertices[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            vertices[edge[0]].add(edge[1]);
            vertices[edge[1]].add(edge[0]);
        }
        return vertices;
    }

    public static void main(String[] args) {
        int[][] edges = { {0, 1} , {1, 2} , {2, 3} , {3, 0} , {0, 2} };
        int m = 3;
        int n = 4;
        System.out.println("Output : "+ graphColoring(edges, m, n));
        System.out.println("------------------------------------------------");

        int[][] edges1 = { {0, 1} , {1, 2} , {0,2} };
        int m1 = 2;
        int n1 = 3;
        System.out.println("Output : "+ graphColoring(edges1, m1, n1));
        System.out.println("------------------------------------------------");
    }
}
