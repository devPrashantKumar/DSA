package AZStriverPlaylist.Graph.ProblemsOnBFSAndDFS;

public class RottenOranges {

    /* Bruteforce Approach
     * Time Complexity : O((m * n)^2)
     * Space Complexity : O(1)
     */
    public static int orangesRotting(int[][] grid) {
        int time=-1;
        boolean flag = false;
        boolean freshExists = false;
        int m = grid.length;
        int n = m>0 ? grid[0].length : 0;

        do{
            time++;
            freshExists=false;
            flag = false;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        freshExists = true;
                        if((i-1>=0 && grid[i-1][j]==2) 
                            || (i+1<=m-1 && grid[i+1][j]==2)
                            || (j-1>=0 && grid[i][j-1]==2)
                            || (j+1<=n-1 && grid[i][j+1]==2)){
                                grid[i][j]=3;
                                flag=true;
                            }
                    }
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==3) grid[i][j]=2;
                }
            }
        }while(flag);
        return (freshExists) ? -1 : time;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid1));
        System.out.println("---------------------------------------------");
    
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid2));
        System.out.println("---------------------------------------------");
    
        int[][] grid3 = {{0,2}};
        System.out.println(orangesRotting(grid3));
        System.out.println("---------------------------------------------");
    }
}