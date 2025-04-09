package AZStriverPlaylist.Recursion;

public class PrintNumbers {
    public static void printLinearly1toN(int i, int n){
        if(i>n) return;
        System.out.print(i+" ");
        printLinearly1toN(i+1,n);
    }

    public static void printLinearly1toNUsingBackTracking(int n){
        if(n==0) return;
        printLinearly1toNUsingBackTracking(n-1);
        System.out.print(n+" ");

    }

    public static void printLinearlyNto1UsingBackTracking(int i, int n){
        if(i>n) return;
        printLinearlyNto1UsingBackTracking(i+1,n);
        System.out.print(i+" ");
    }

    public static void printLinearlyNto1(int n){
        if(n==0) return;
        System.out.print(n+" ");
        printLinearlyNto1(n-1);
    }

    public static void main(String[] args) {
        printLinearly1toN(1,5);
        System.out.println();
        printLinearly1toN(1,3);
        System.out.println();

        System.out.println("------------------------------------");
        printLinearly1toNUsingBackTracking(5);
        System.out.println();
        printLinearly1toNUsingBackTracking(3);
        System.out.println();

        System.out.println("------------------------------------");
        printLinearlyNto1(5);
        System.out.println();
        printLinearlyNto1(3);
        System.out.println();

        System.out.println("------------------------------------");
        printLinearlyNto1UsingBackTracking(1,5);
        System.out.println();
        printLinearlyNto1UsingBackTracking(1,3);
        System.out.println();

    }
}

