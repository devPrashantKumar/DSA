package AZStriverPlaylist.BasicRecursion;

public class SumOfFirstNNumbers {
    public static int sum1toN(int i, int n){
        if(i>n) return 0;
        return i+sum1toN(i+1,n);
    }

    public static int sumNto1(int n){
        if(n==0) return 0;
        return n+sumNto1(n-1);
    }

    public static void main(String[] args) {
        System.out.println(sum1toN(1,5));
        System.out.println(sum1toN(1,3));
        System.out.println("------------------------------------");
        
        System.out.println(sumNto1(5));
        System.out.println(sumNto1(3));
        System.out.println("------------------------------------");

    }
}
