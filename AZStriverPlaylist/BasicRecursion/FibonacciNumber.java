package AZStriverPlaylist.BasicRecursion;

public class FibonacciNumber {
    
    public static int nthFibonacciNumber(int n){
        if(n<=1) return n;
        return nthFibonacciNumber(n-1)+nthFibonacciNumber(n-2);
    }
    public static void main(String[] args) {
        int input0 = 0;
        System.out.println("Input : "+input0+" Output : "+FibonacciNumber.nthFibonacciNumber(input0));

        int input1 = 1;
        System.out.println("Input : "+input1+" Output : "+FibonacciNumber.nthFibonacciNumber(input1));

        int input2 = 2;
        System.out.println("Input : "+input2+" Output : "+FibonacciNumber.nthFibonacciNumber(input2));

        int input3 = 3;
        System.out.println("Input : "+input3+" Output : "+FibonacciNumber.nthFibonacciNumber(input3));

        int input4 = 4;
        System.out.println("Input : "+input4+" Output : "+FibonacciNumber.nthFibonacciNumber(input4));

        int input5 = 5;
        System.out.println("Input : "+input5+" Output : "+FibonacciNumber.nthFibonacciNumber(input5));

        int input6 = 6;
        System.out.println("Input : "+input6+" Output : "+FibonacciNumber.nthFibonacciNumber(input6));
    }
}
