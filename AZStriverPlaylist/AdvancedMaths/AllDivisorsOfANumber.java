package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllDivisorsOfANumber {
    /*
     * Time Complexity : O(n)
     */
    public static int[] allDivisorsBruteForce(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors.stream().mapToInt(Integer::intValue).toArray();
    }

    /* 
    Overflow Safety:
        Using i <= num/i instead of i*i <= num ensures correctness even for large num (e.g., num = Integer.MAX_VALUE).
        Example: If num = Integer.MAX_VALUE (2³¹ - 1), i*i would overflow when i > 46340 (since 46340² = 2,147,395,600 and 46341² = 2,147,441,881 > Integer.MAX_VALUE).
        i <= num/i avoids this issue entirely.

     * Time Complexity O(sqrt(n))
     */
    public static int[] allDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println("Divisors of Number : " + 10 + " is : " + Arrays.toString(allDivisorsBruteForce(10)));
        System.out.println("Divisors of Number : " + 10 + " is : " + Arrays.toString(allDivisors(10)));
        System.out.println("Divisors of Number : " + 10 + " is : " + Arrays.toString(allDivisorsBruteForce(8)));
        System.out.println("Divisors of Number : " + 10 + " is : " + Arrays.toString(allDivisors(8)));
        System.out.println("Divisors of Number : " + 10 + " is : " + Arrays.toString(allDivisorsBruteForce(7)));
        System.out.println("Divisors of Number : " + 10 + " is : " + Arrays.toString(allDivisors(7)));

    }

}