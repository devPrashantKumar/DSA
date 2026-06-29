package AZStriverPlaylist.Graph.Learning;

import java.util.*;

public class AdjacencyMatrixClass {
    /*
    * Space complexity : O(V^2)
    */
    int[][] adjacencyMatrix;
    int vertices;

    public AdjacencyMatrixClass(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addUndirectedEdge(int vertex1, int vertex2) {
        adjacencyMatrix[vertex1][vertex2] = 1;
        adjacencyMatrix[vertex2][vertex1] = 1;
    }

    public void addDirectedEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1;
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * Time Complexity : O(V)+O(V^2)=O(V^2)
     * Space Complexity : O(V)+O(V)=O(V),
     *      - O(V), space occupied by visited
     *      - O(V), space occupied by queue
     */
    public int[] BFSInAdjacencyMatrix() {
        int[] traversalResult = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertices];
        int k = 0;
        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == 0) {
                queue.add(v);
                visited[v] = 1;
                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    traversalResult[k++] = vertex;
                    for (int i = 0; i < adjacencyMatrix[vertex].length; i++) {
                        if (adjacencyMatrix[vertex][i] != 0 && visited[i] == 0) {
                            queue.add(i);
                            visited[i] = 1;
                        }
                    }
                }
            }
        }
        return traversalResult;
    }

    /*⚠️ Issue: When to mark visited[vertex]
        although time complexity is same, but still it will takw more time.
        You’re marking visited[vertex] = 1 after dequeuing (inside the loop).
        That’s logically correct, but less efficient, because it allows the same vertex to be added to the queue multiple times before it’s visited — especially in dense graphs.
        🧠 Better approach:
        Mark it as visited when you enqueue it — so you never enqueue the same node twice. (BFSInAdjacencyMatrix is efficient implementation)
    */
    public int[] BFSInAdjacencyMatrix2() {
        int[] traversalResult = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertices];
        int k = 0;
        for(int v=0;v<visited.length;v++){
            if(visited[v]==0){
                queue.add(v);
                while(!queue.isEmpty()){
                    int vertex = queue.poll();
                    if(visited[vertex]==0){
                        traversalResult[k++]=vertex;
                        visited[vertex]=1;
                        for(int i=0;i<adjacencyMatrix[vertex].length;i++){
                            if(adjacencyMatrix[vertex][i]!=0 && visited[i]==0){
                                queue.add(i);
                            }
                        }
                    }
                }
            }
        }
        return traversalResult;
    }


    public int[] DFSInAdjacencyMatrix(){
        int[] traversalResult = new int[vertices];
        Stack<Integer> stk = new Stack<>();
        int[] visited = new int[vertices];
        int k = 0;
        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == 0) {
                stk.add(v);
                visited[v] = 1;
                while (!stk.isEmpty()) {
                    Integer vertex = stk.pop();
                    traversalResult[k++] = vertex;
                    for (int i = 0; i < adjacencyMatrix[vertex].length; i++) {
                        if (adjacencyMatrix[vertex][i] != 0 && visited[i] == 0) {
                            stk.add(i);
                            visited[i] = 1;
                        }
                    }
                }
            }
        }
        return traversalResult;
    }

    /*
     * Time Complexity : O(V)+O(V^2)=O(V^2)
     * Space Complexity : O(V)+O(V)=O(V),
     *      - O(V), space occupied by visited
     *      - O(V), max recursive depth dfs will go if all vertex are in linear chain
     */
    public int[] DFSInAdjacencyMatrix2(){
        List<Integer> traversalResult = new ArrayList<>();
        int[] visited = new int[vertices];
        for (int v = 0; v < visited.length; v++) {
            if(visited[v]==0){
                DFSInAdjacencyMatrixUtil(visited, v, traversalResult);
            }
        }
        return traversalResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public void DFSInAdjacencyMatrixUtil(int[] visited, int vertex, List<Integer> traversalResult){
        traversalResult.add(vertex);
        visited[vertex]=1;
        for(int i=0;i<adjacencyMatrix[vertex].length;i++){
            if(adjacencyMatrix[vertex][i]!=0 && visited[i]==0){
                DFSInAdjacencyMatrixUtil(visited, i, traversalResult);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixClass adjacencyMatrixClass = new AdjacencyMatrixClass(5);
        adjacencyMatrixClass.addUndirectedEdge(0, 1);
        adjacencyMatrixClass.addUndirectedEdge(1, 2);
        adjacencyMatrixClass.addUndirectedEdge(2, 4);
        adjacencyMatrixClass.addDirectedEdge(0, 3);
        adjacencyMatrixClass.printAdjacencyMatrix();
        System.out.println(Arrays.toString(adjacencyMatrixClass.BFSInAdjacencyMatrix()));
        System.out.println(Arrays.toString(adjacencyMatrixClass.BFSInAdjacencyMatrix2()));
        System.out.println(Arrays.toString(adjacencyMatrixClass.DFSInAdjacencyMatrix()));
        System.out.println(Arrays.toString(adjacencyMatrixClass.DFSInAdjacencyMatrix2()));
    }

}
