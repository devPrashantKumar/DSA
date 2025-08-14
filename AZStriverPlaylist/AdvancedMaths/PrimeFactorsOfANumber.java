package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorsOfANumber {
    public static int[] primeFactorsBruteForce(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i))
                primeFactors.add(i);
        }

        return primeFactors.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static int[] primeFactorsBetter(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                if (isPrime(i))
                    primeFactors.add(i);
                if (i != n / i) {
                    if (isPrime(n / i))
                        primeFactors.add(n / i);
                }
            }
        }

        return primeFactors.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println("Prime Factors of " + 12 + " are " + Arrays.toString(primeFactorsBruteForce(12)));
        System.out.println("Prime Factors of " + 12 + " are " + Arrays.toString(primeFactorsBetter(12)));

    }
}
