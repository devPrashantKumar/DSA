package AZStriverPlaylist.BasicRecursion;

public class PrintNameNTimes {

    // tail-recursion
    public static void print(int n){
        if(n==0) return;
        System.out.println("Prashant Kumar");
        print(n-1);
    }

    // classic-recursion
    public static void print2(int n){
        if(n==0) return;
        print2(n-1);
        System.out.println("Prashant Kumar");

    }
    public static void main(String[] args) {
        System.out.println("---------------TAIL RECURSION----------------------");

        print(5);
        System.out.println("-------------------------------------");
        print(0);
        System.out.println("-------------------------------------");
        print(3);
        System.out.println("-------------------------------------");
        System.out.println("--------------CLASSIC RECURSION-----------------------");
        print2(5);
        System.out.println("-------------------------------------");
        print2(0);
        System.out.println("-------------------------------------");
        print2(3);
    }
}

