package AZStriverPlaylist.BasicMaths;

public class PrimeNumber {
    /* 
    Overflow Safety:
        Using i <= num/i instead of i*i <= num ensures correctness even for large num (e.g., num = Integer.MAX_VALUE).
        Example: If num = Integer.MAX_VALUE (2³¹ - 1), i*i would overflow when i > 46340 (since 46340² = 2,147,395,600 and 46341² = 2,147,441,881 > Integer.MAX_VALUE).
        i <= num/i avoids this issue entirely.

     * Time Complexity O(sqrt(n))
     */
    public static boolean checkPrime(int num){
        if(num<=1) return false;
        // i*i<=num can overflow for large i so i<=num/i is efficient
        for(int i=2;i<=num/i;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int input1 = 11;
        System.out.println("Input : "+ input1+" Output : "+PrimeNumber.checkPrime(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+PrimeNumber.checkPrime(input2));
    }
}
