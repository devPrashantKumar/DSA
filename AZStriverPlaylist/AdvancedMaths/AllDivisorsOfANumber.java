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
     * Time Complexity : O(sqrt(n))
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