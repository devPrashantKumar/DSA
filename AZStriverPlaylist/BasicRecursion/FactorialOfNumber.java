package AZStriverPlaylist.BasicRecursion;

public class FactorialOfNumber {
    // Tail-recursive style.
    public static int factorialUsingParameterisedApproach(int num, int prod){
        if(num==0) return prod;
        return factorialUsingParameterisedApproach(num-1, prod*num);
    }

    // Classic recursive pattern.
    public static int factorialUsingFunctionalApproach(int num){
        if(num==0) return 1;
        return num * factorialUsingFunctionalApproach(num-1);
    }

    public static void main(String[] args) {
        int input1=5;
        System.out.println("Parameterized: Factorial of " + input1 + " -> "+FactorialOfNumber.factorialUsingParameterisedApproach(input1, 1));
        System.out.println("Functional: Factorial of " + input1 + " -> "+FactorialOfNumber.factorialUsingFunctionalApproach(input1));
    }
}
