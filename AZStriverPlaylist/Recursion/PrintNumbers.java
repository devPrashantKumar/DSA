package AZStriverPlaylist.Recursion;

public class PrintNumbers {
    public static void printLinearly1toN(int i, int n){
        if(i>n) return;
        System.out.print(i+" ");
        printLinearly1toN(i+1,n);
    }

    public static void printLinearlyNto1(int i, int n){
        if(i>n) return;
        printLinearlyNto1(i+1,n);
        System.out.print(i+" ");
    }
    
    public static void main(String[] args) {
        printLinearly1toN(1,5);
        System.out.println();
        printLinearly1toN(1,3);
        System.out.println();

        System.out.println("------------------------------------");
        printLinearlyNto1(1,5);
        System.out.println();
        printLinearlyNto1(1,3);
        System.out.println();

    }
}

