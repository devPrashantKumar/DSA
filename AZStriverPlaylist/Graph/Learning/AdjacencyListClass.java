package AZStriverPlaylist.Graph.Learning;

import java.util.*;

public class AdjacencyListClass {
    int vertices;
    ArrayList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public AdjacencyListClass(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
    }

    public void addUndirectedEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
    }

    public void addDirectedEdge(int from, int to) {
        adjacencyList[from].add(to);
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
                        if (visited[adjacencyList[vertex].get(i)] == 0) {
                            queue.add(adjacencyList[vertex].get(i));
                            visited[adjacencyList[vertex].get(i)] = 1;
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
                        if (visited[adjacencyList[vertex].get(i)] == 0) {
                            stk.add(adjacencyList[vertex].get(i));
                            visited[adjacencyList[vertex].get(i)] = 1;
                        }
                    }
                }
            }
        }
        return traversalResult;
    }

    public int[] DFSInAdjacencyListRecursion() {
        List<Integer> traversalResult = new ArrayList<>();
        int[] visited = new int[vertices];
        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == 0) {
                DFSInAdjacencyListRecursionUtil(visited,v,traversalResult);
            }
        }
        return traversalResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public void DFSInAdjacencyListRecursionUtil(int[] visited, int vertex, List<Integer> traversalResult) {
        traversalResult.add(vertex);
        visited[vertex]=1;
        for (int v = 0; v < adjacencyList[vertex].size(); v++) {
            if (visited[adjacencyList[vertex].get(v)] == 0) {
                DFSInAdjacencyListRecursionUtil(visited,adjacencyList[vertex].get(v),traversalResult);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyListClass adjacencyListClass = new AdjacencyListClass(5);
        adjacencyListClass.addUndirectedEdge(0, 1);
        adjacencyListClass.addUndirectedEdge(1, 2);
        adjacencyListClass.addUndirectedEdge(2, 4);
        adjacencyListClass.addDirectedEdge(0, 3);
        adjacencyListClass.printAdjacencyList();
        System.out.println(Arrays.toString(adjacencyListClass.BFSInAdjacencyList()));
        System.out.println(Arrays.toString(adjacencyListClass.DFSInAdjacencyList()));
        System.out.println(Arrays.toString(adjacencyListClass.DFSInAdjacencyListRecursion()));
    }
}
