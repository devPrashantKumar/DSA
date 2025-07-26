package AZStriverPlaylist.BasicRecursion;

public class PrintNameNTimes {
    public static void print(int n){
        if(n==0) return;
        System.out.println("Prashant Kumar");
        print(n-1);
    }
    public static void main(String[] args) {
        print(5);
        System.out.println("-------------------------------------");
        print(0);
        System.out.println("-------------------------------------");
        print(3);
    }
}

