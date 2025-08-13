package AZStriverPlaylist.BitManipulation.Problems;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a=12;
        int b=13;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a : "+a+", b : "+b);
        System.out.println("-----------------------------");

        int a2=12;
        int b2=0;
        a2 = a2^b2;
        b2 = a2^b2;
        a2 = a2^b2;
        System.out.println("a2 : "+a2+", b2 : "+b2);
        System.out.println("-----------------------------");

        int a3=0;
        int b3=0;
        a3 = a3^b3;
        b3 = a3^b3;
        a3 = a3^b3;
        System.out.println("a3 : "+a3+", b3 : "+b3);
        System.out.println("-----------------------------");
    }
}
