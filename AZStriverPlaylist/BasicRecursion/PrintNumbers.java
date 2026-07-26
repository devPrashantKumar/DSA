package AZStriverPlaylist.BasicRecursion;

public class PrintNumbers {
    // tail-recursion
    // the recursive call is the last operation
    public static void printLinearly1toN(int i, int n){
        if(i>n) return;
        System.out.print(i+" ");
        printLinearly1toN(i+1,n);
    }

    // classic-recursion
    // the recursive call is not the last operation — there's still work to do with its result after it returns.
    public static void printLinearly1toNUsingClassicRecursion(int n){
        if(n==0) return;
        printLinearly1toNUsingClassicRecursion(n-1);
        System.out.print(n+" ");

    }

    public static void printLinearlyNto1UsingClassicRecursion(int i, int n){
        if(i>n) return;
        printLinearlyNto1UsingClassicRecursion(i+1,n);
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
        printLinearly1toNUsingClassicRecursion(5);
        System.out.println();
        printLinearly1toNUsingClassicRecursion(3);
        System.out.println();

        System.out.println("------------------------------------");
        printLinearlyNto1(5);
        System.out.println();
        printLinearlyNto1(3);
        System.out.println();

        System.out.println("------------------------------------");
        printLinearlyNto1UsingClassicRecursion(1,5);
        System.out.println();
        printLinearlyNto1UsingClassicRecursion(1,3);
        System.out.println();

    }
}

