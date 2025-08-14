package AZStriverPlaylist.BasicMaths;

public class PrimeNumber {

    /*
     * Time Complexity : O(n)
     */
    public static boolean checkPrimeBruteforce(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }
        if (count == 2)
            return true;
        return false;
    }

    /*
     * Time Complexity O(sqrt(n))
     */
    public static boolean checkPrimeOptimised(int num) {
        int count = 0;
        for (int i = 1; i <= num/i; i++) {
            if (num % i == 0){
                count++;
                if(i!=num/i) count++;
            }
        }
        if (count == 2)
            return true;
        return false;
    }

    /*
     * Overflow Safety:
     * Using i <= num/i instead of i*i <= num ensures correctness even for large num
     * (e.g., num = Integer.MAX_VALUE).
     * Example: If num = Integer.MAX_VALUE (2³¹ - 1), i*i would overflow when i >
     * 46340 (since 46340² = 2,147,395,600 and 46341² = 2,147,441,881 >
     * Integer.MAX_VALUE).
     * i <= num/i avoids this issue entirely.
     * 
     * Time Complexity O(sqrt(n))
     */
    public static boolean checkPrimeOptimised2(int num) {
        if (num <= 1)
            return false;
        // i*i<=num can overflow for large i so i<=num/i is efficient
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int input1 = 11;
        System.out.println("Input : " + input1 + " Output : " + PrimeNumber.checkPrimeBruteforce(input1));
        System.out.println("Input : " + input1 + " Output : " + PrimeNumber.checkPrimeOptimised(input1));
        System.out.println("Input : " + input1 + " Output : " + PrimeNumber.checkPrimeOptimised2(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : " + input2 + " Output : " + PrimeNumber.checkPrimeBruteforce(input2));
        System.out.println("Input : " + input2 + " Output : " + PrimeNumber.checkPrimeOptimised(input2));
        System.out.println("Input : " + input2 + " Output : " + PrimeNumber.checkPrimeOptimised2(input2));

    }
}
