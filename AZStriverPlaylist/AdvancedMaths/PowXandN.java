package AZStriverPlaylist.AdvancedMaths;

public class PowXandN {
    /*
     * Time Complexity : O(n)
     */
    public static double powXN(double x, int n) {
        double result = 1;
        long nn = n;
        if (nn < 0)
            nn = -1 * nn;
        if (x == 0 || x == 1)
            return x;
        if (n == 0)
            return 1.0;
        while (nn-- > 0) {
            result *= x;
        }
        return (n > 0) ? result : 1 / result;
    }

    /*
     * Time complexity : O(lon2n)
     */
    public static double myPow(double x, int n) {
        if (n < 0)
            return 1 / myPow(x, Math.abs((long) n));
        return myPow(x, (long) n);
    }

    public static double myPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n == 1 || x == 1)
            return x;
        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        return x * myPow(x, n - 1);
    }

    /*
     * Time complexity : O(lon2n)
     */
    public static double myPowUsingIterative(double x, int n) {
        double result = 1.0;
        long nn = n;
        if (nn < 0)
            nn = -1 * nn;
        if (x == 0 || x == 1)
            return x;
        while (nn > 0) {
            if (nn % 2 != 0) {
                result *= x;
                nn = nn - 1;
            } else {
                nn /= 2;
                x = x * x;
            }
        }
        return (n > 0) ? result : 1 / result;
    }

    public static void main(String[] args) {
        double x1 = 2.0;
        int n1 = 10;
        System.out.println("Input 1 " + x1 + ", " + n1 + " Output : " + PowXandN.powXN(x1, n1));
        System.out.println("Input 1 " + x1 + ", " + n1 + " Output : " + PowXandN.myPow(x1, n1));
        System.out.println("Input 1 " + x1 + ", " + n1 + " Output : " + PowXandN.myPowUsingIterative(x1, n1));

        double x2 = 2.10;
        int n2 = 3;
        System.out.println("Input 1 " + x2 + ", " + n2 + " Output : " + PowXandN.powXN(x2, n2));
        System.out.println("Input 1 " + x2 + ", " + n2 + " Output : " + PowXandN.myPow(x2, n2));
        System.out.println("Input 1 " + x2 + ", " + n2 + " Output : " + PowXandN.myPowUsingIterative(x2, n2));

        double x3 = 2.0;
        int n3 = -2;
        System.out.println("Input 1 " + x3 + ", " + n3 + " Output : " + PowXandN.powXN(x3, n3));
        System.out.println("Input 1 " + x3 + ", " + n3 + " Output : " + PowXandN.myPow(x3, n3));
        System.out.println("Input 1 " + x3 + ", " + n3 + " Output : " + PowXandN.myPowUsingIterative(x3, n3));

    }
}
