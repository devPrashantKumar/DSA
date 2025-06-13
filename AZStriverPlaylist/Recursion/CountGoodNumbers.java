package AZStriverPlaylist.Recursion;

public class CountGoodNumbers {
    private static final int MOD = 1_000_000_007;

    /*
     * Time Complexity : O(log2n)
     */
    public static int countGoodNumbers(long n){
        long result = ((pow(5,(n+1)/2)*pow(4,n/2))%CountGoodNumbers.MOD);
        return (int) result;
    }

    public static long pow(long num, long power){
        if(power==0) return 1;
        if(power%2==0) return pow((num*num)%CountGoodNumbers.MOD,power/2);
        else return (num*pow(num,power-1))%CountGoodNumbers.MOD;
    }

    public static void main(String[] args) {
        long n1 = 1;
        System.out.println("Input 1 " + n1 + " Output : "+CountGoodNumbers.countGoodNumbers(n1));

        long n2 = 4;
        System.out.println("Input 1 "  + n2 + " Output : "+CountGoodNumbers.countGoodNumbers(n2));

        long n3 = 50;
        System.out.println("Input 1 " + n3 + " Output : "+CountGoodNumbers.countGoodNumbers(n3));
    }
}
