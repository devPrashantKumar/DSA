package AZStriverPlaylist.Recursion;

public class TowerOfHanoi {
    public static void towerOfHanoiSol(int n, char source, char helper, char destination){
        if(n==0) return;
        towerOfHanoiSol(n-1, source, destination, helper);
        System.out.println("Transfer disk "+n + " from "+source+" to "+destination);
        towerOfHanoiSol(n-1, helper, source, destination);
    }

    public static void main(String[] args) {
        towerOfHanoiSol(3, 'A', 'B', 'C');
    }
}
