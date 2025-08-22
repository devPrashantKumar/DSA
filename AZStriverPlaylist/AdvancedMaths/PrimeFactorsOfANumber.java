package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorsOfANumber {

    /*
     * Time Complexity : O(n*sqrt(n))
     */
    public static int[] primeFactorsBruteForce(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i))
                primeFactors.add(i);
        }

        return primeFactors.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     * Time complexity : sqrt(n)
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    /*
     * Time Complexity : O(sqrt(n)*sqrt(n)) -> O(n)
     */
    public static int[] primeFactorsBetter(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        boolean flag = false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                flag=true;
                if (isPrime(i))
                    primeFactors.add(i);
                if (i != n / i) {
                    if (isPrime(n / i))
                        primeFactors.add(n / i);
                }
            }
        }
        if(!flag) primeFactors.add(n);

        return primeFactors.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     * TIme COmplexity :O(sqrt(n)*logn)
     */
    public static int[] primeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        if(num<=1) return new int[]{};
        while(num%2==0){
            factors.add(2);
            num /=2;
        }
        
        for(int i=3;i<=num/i;i+=2){
            while(num%i==0){
                factors.add(i);
                num  /= i;
            }
        }

        if(num!=1) factors.add(num);
        return factors.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println("Prime Factors of " + -1 + " are " + Arrays.toString(primeFactorsBruteForce(-1)));
        System.out.println("Prime Factors of " + -1 + " are " + Arrays.toString(primeFactorsBetter(-1)));
        System.out.println("Prime Factors of " + -1 + " are " + Arrays.toString(primeFactorsBruteForce(-1)));

        System.out.println("Prime Factors of " + 0 + " are " + Arrays.toString(primeFactorsBruteForce(0)));
        System.out.println("Prime Factors of " + 0 + " are " + Arrays.toString(primeFactorsBetter(0)));
        System.out.println("Prime Factors of " + 0 + " are " + Arrays.toString(primeFactorsBruteForce(0)));

        System.out.println("Prime Factors of " + 1 + " are " + Arrays.toString(primeFactorsBruteForce(1)));
        System.out.println("Prime Factors of " + 1 + " are " + Arrays.toString(primeFactorsBetter(1)));
        System.out.println("Prime Factors of " + 1 + " are " + Arrays.toString(primeFactorsBruteForce(1)));

        System.out.println("Prime Factors of " + 39 + " are " + Arrays.toString(primeFactorsBruteForce(39)));
        System.out.println("Prime Factors of " + 39 + " are " + Arrays.toString(primeFactorsBetter(39)));
        System.out.println("Prime Factors of " + 39 + " are " + Arrays.toString(primeFactorsBruteForce(39)));

        System.out.println("Prime Factors of " + 17 + " are " + Arrays.toString(primeFactorsBruteForce(17)));
        System.out.println("Prime Factors of " + 17 + " are " + Arrays.toString(primeFactorsBetter(17)));
        System.out.println("Prime Factors of " + 17 + " are " + Arrays.toString(primeFactorsBruteForce(17)));


        
        
    }
}
