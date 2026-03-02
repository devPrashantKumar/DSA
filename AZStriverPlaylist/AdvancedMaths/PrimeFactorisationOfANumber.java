package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorisationOfANumber {

    /*
     * Time Complexity : O(n*sqrt(n))
     */
    public static int[] primeFactorisationBruteForce(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)){
                while(n%i==0){
                    primeFactors.add(i);
                    n = n/i;
                }
                i--;
            }
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
    public static int[] primeFactorisationBetter(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        boolean flag = false;
        int i=2;
        while (i <= n / i) {
            if (n % i == 0) {
                flag=true;
                int mn = n;
                if (isPrime(i)){
                    primeFactors.add(i);
                    mn /= i;
                }
                    
                if (isPrime(n / i)){
                    primeFactors.add(n / i);
                    mn /= (n/i);
                }
                n = mn;
            }else{
                i++;
            }
        }
        if(!flag) primeFactors.add(n);
        return primeFactors.stream().mapToInt(Integer::intValue).toArray();
    }

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
        System.out.println("Prime Factorisations of " + 4 + " are " + Arrays.toString(primeFactorisationBruteForce(4)));
        System.out.println("Prime Factorisations of " + 4 + " are " + Arrays.toString(primeFactorisationBetter(8)));
        System.out.println("Prime Factorisations of " + 12 + " are " + Arrays.toString(primeFactors(12)));

    }
}
