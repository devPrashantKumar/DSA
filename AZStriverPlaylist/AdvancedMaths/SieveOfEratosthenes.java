package AZStriverPlaylist.AdvancedMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
    public static int[] printAllPrimes(int n) {
        List<Integer> prime = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime(i)) prime.add(i);
        }
        return prime.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] printAllPrimesSieve(int n) {
        List<Integer> prime = new ArrayList<>();
        int[] primeArray = new int[n+1];
        Arrays.fill(primeArray, 1);

        for(int i=2;i<=n;i++){
            if(primeArray[i]==1){
                prime.add(i);
                int count=2;
                while(count*i<=n){
                    primeArray[count*i]=0;
                    count++;
                }
            }
        }
        return prime.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] printAllPrimesSieveBetter(int n) {
        List<Integer> prime = new ArrayList<>();
        int[] primeArray = new int[n+1];
        Arrays.fill(primeArray, 1);

        for(int i=2;i<=n/i;i++){
            if(primeArray[i]==1){
                for(int j=i*i;j<=n;j=j+i){
                    primeArray[j]=0;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(primeArray[i]==1) prime.add(i);
        }
        return prime.stream().mapToInt(Integer::intValue).toArray();
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

    public static void main(String[] args) {
        System.out.println("Prime till Number : " + 10 + " is : " + Arrays.toString(printAllPrimes(10)));
        System.out.println("Prime till Number : " + 8 + " is : " + Arrays.toString(printAllPrimes(8)));
        System.out.println("Prime till Number : " + 7+ " is : " + Arrays.toString(printAllPrimes(7)));
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Prime till Number : " + 10 + " is : " + Arrays.toString(printAllPrimesSieve(10)));
        System.out.println("Prime till Number : " + 8 + " is : " + Arrays.toString(printAllPrimesSieve(8)));
        System.out.println("Prime till Number : " + 7+ " is : " + Arrays.toString(printAllPrimesSieve(7)));
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Prime till Number : " + 10 + " is : " + Arrays.toString(printAllPrimesSieveBetter(10)));
        System.out.println("Prime till Number : " + 8 + " is : " + Arrays.toString(printAllPrimesSieveBetter(8)));
        System.out.println("Prime till Number : " + 7+ " is : " + Arrays.toString(printAllPrimesSieveBetter(7)));

    }
}
