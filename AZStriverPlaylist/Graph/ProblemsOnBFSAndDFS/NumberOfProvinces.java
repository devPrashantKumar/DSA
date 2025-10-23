package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

public class NumberOfProvinces {
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

    public static void main(String[] args) {
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("provinces : "+findCircleNum(isConnected1));
        System.out.println("-------------------------------------------------------------");

        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println("provinces : "+findCircleNum(isConnected2));
        System.out.println("-------------------------------------------------------------");
    }
    
}
