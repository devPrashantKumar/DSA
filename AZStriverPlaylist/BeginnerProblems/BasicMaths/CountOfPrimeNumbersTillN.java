package AZStriverPlaylist.BeginnerProblems.BasicMaths;

import java.util.Arrays;

public class CountOfPrimeNumbersTillN {
    /*
     * Time Complexity: O(N√N)
     * Space Complexity: O(1)
     */
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /*
     * Time Complexity: O(√N)
     * Space Complexity: O(1)
     */
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

     /*
     * Time Complexity: O(N log(log N))
     * Space Complexity: O(N)
     */
    public static int countPrimesUsingSieve(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int input1 = 6;
        System.out.println("Input : "+ input1+" Output : "+countPrimes(input1));
        System.out.println("Input : "+ input1+" Output : "+countPrimesUsingSieve(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 10;
        System.out.println("Input : "+ input2+" Output : "+countPrimes(input2));
        System.out.println("Input : "+ input2+" Output : "+countPrimesUsingSieve(input2));

        System.out.println("-------------------------------------------------------------------------------");
        int input3 = 0;
        System.out.println("Input : "+ input3+" Output : "+countPrimes(input3));
        System.out.println("Input : "+ input3+" Output : "+countPrimesUsingSieve(input3));

    }
}
