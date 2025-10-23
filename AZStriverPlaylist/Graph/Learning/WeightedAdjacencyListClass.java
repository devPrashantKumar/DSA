package AZStriverPlaylist.Graph.Learning;

import java.util.*;

public class WeightedAdjacencyListClass {
    class Pair {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public String toString(){
            return "("+vertex+", "+weight+")";
        }
    }

    int vertices;
    ArrayList<Pair>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public WeightedAdjacencyListClass(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<Pair>();
        }
    }

    public void addUndirectedEdge(int vertex1, int vertex2, int weight) {
        adjacencyList[vertex1].add(new Pair(vertex2, weight));
        adjacencyList[vertex2].add(new Pair(vertex1, weight));
    }

    public void addDirectedEdge(int from, int to, int weight) {
        adjacencyList[from].add(new Pair(to, weight));
    }

    public void printAdjacencyList() {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                System.out.print(adjacencyList[i].get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] BFSInAdjacencyList() {
        int[] traversalResult = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertices];
        int k = 0;
        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == 0) {
                queue.add(v);
                visited[v] = 1;
                while (!queue.isEmpty()) {
                    int vertex = queue.poll();
                    traversalResult[k++] = vertex;
                    for (int i = 0; i < adjacencyList[vertex].size(); i++) {
                        if (visited[adjacencyList[vertex].get(i).vertex] == 0) {
                            queue.add(adjacencyList[vertex].get(i).vertex);
                            visited[adjacencyList[vertex].get(i).vertex] = 1;
                        }
                    }
                }
            }
        }
        return traversalResult;
    }

    public int[] DFSInAdjacencyList() {
        int[] traversalResult = new int[vertices];
        int[] visited = new int[vertices];
        int k = 0;
        Stack<Integer> stk = new Stack<>();
        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == 0) {
                stk.add(v);
                visited[v] = 1;
                while (!stk.isEmpty()) {
                    int vertex = stk.pop();
                    traversalResult[k++] = vertex;
                    for (int i = 0; i < adjacencyList[vertex].size(); i++) {
                        if (visited[adjacencyList[vertex].get(i).vertex] == 0) {
                            stk.add(adjacencyList[vertex].get(i).vertex);
                            visited[adjacencyList[vertex].get(i).vertex] = 1;
                        }
                    }
                }
            }
        }
        return traversalResult;
    }

    public static void main(String[] args) {
        WeightedAdjacencyListClass weighteddjacencyListClass = new WeightedAdjacencyListClass(5);
        weighteddjacencyListClass.addUndirectedEdge(0, 1,10);
        weighteddjacencyListClass.addUndirectedEdge(1, 2,15);
        weighteddjacencyListClass.addUndirectedEdge(2, 4,5);
        weighteddjacencyListClass.addDirectedEdge(0, 3,20);
        weighteddjacencyListClass.printAdjacencyList();
        System.out.println(Arrays.toString(weighteddjacencyListClass.BFSInAdjacencyList()));
        System.out.println(Arrays.toString(weighteddjacencyListClass.DFSInAdjacencyList()));
    }
}
