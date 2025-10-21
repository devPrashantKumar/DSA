package AZStriverPlaylist.BasicRecursion;

public class FactorialOfNumber {
    // Tail-recursive style.
    public static int factorialUsingParameterisedApproach(int num, int prod){
        if(num==0) return prod;
        return factorialUsingParameterisedApproach(num-1, prod*num);
    }

    // Functional (Non-tail Recursion) / Classic recursive pattern.
    public static int factorialUsingFunctionalApproach(int num){
        if(num==0) return 1;
        return num * factorialUsingFunctionalApproach(num-1);
    }

     // Tail Recursion using a Mutable Reference
    public static int factorialUsingApproach2(int num){
        int[] ans  ={1};
        factorialUsingApproach2Util(num, ans);
        return ans[0];
    }

    public static void factorialUsingApproach2Util(int num, int[] ans){
        if(num==0) return;
        ans[0]*=num;
        factorialUsingApproach2Util(num-1, ans);
    }

    public static void main(String[] args) {
        int input1=5;
        System.out.println("Parameterized: Factorial of " + input1 + " -> "+FactorialOfNumber.factorialUsingParameterisedApproach(input1, 1));
        System.out.println("Functional: Factorial of " + input1 + " -> "+FactorialOfNumber.factorialUsingFunctionalApproach(input1));
        System.out.println("Tail Recursion using a Mutable Reference: Factorial of " + input1 + " -> "+FactorialOfNumber.factorialUsingApproach2(input1));
    }
}
