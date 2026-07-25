package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    /* 
    * Time Complexity : O(V^2) 
    * Space Complexity : O(V) space occupied by recursive stack
    */
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                provinces++;
                findCircleNumUtil(isConnected, visited, i);
            }
        }
        return provinces;
    }

    public static void findCircleNumUtil(int[][] isConnected, boolean[] visited, int v) {
        visited[v]=true;
        for(int i=0;i<isConnected[v].length;i++){
            if(isConnected[v][i]==1 && !visited[i]){
                findCircleNumUtil(isConnected, visited, i);
            }
        }
    }

    /* 
    * Time Complexity : O(V^2) 
    * Space Complexity : O(V) space occupied by queue
    */
    public static int findCircleNumUsingBFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new LinkedList<>();
        int provinces=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                queue.offer(i);
                visited[i]=true;
                provinces++;
                while(!queue.isEmpty()){
                    Integer vertex = queue.poll();
                    for(int j=0;j<isConnected[vertex].length;j++){
                        if(isConnected[vertex][j]==1 && !visited[j]){
                            queue.offer(j);
                            visited[j]=true;
                        }
                    }
                }
            }
        }
        return provinces;
    }

    public static void main(String[] args) {
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("provinces : "+findCircleNum(isConnected1));
        System.out.println("provinces : "+findCircleNumUsingBFS(isConnected1));

        System.out.println("-------------------------------------------------------------");

        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println("provinces : "+findCircleNum(isConnected2));
        System.out.println("provinces : "+findCircleNumUsingBFS(isConnected2));

        System.out.println("-------------------------------------------------------------");
    }
    
}
