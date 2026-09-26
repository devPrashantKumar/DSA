package AZStriverPlaylist.BitManipulation.Problems;

public class DivideTwoIntegers {
    /*
    * Time Complexity : O((log n)^2)
    * Space Complexity : O(n)
    */
   // exponential subtraction / bit shifting approach
    public static int divide(int d, int dv) {
        if(d==0) return 0;
        if (dv == 0) throw new ArithmeticException("Division by zero");
        if (d == Integer.MIN_VALUE && dv == -1) return Integer.MAX_VALUE;
        int sign=1;
        if((d<=0 && dv>0) || (d>=0 && dv<0)) sign = -1;
        long dividend = Math.abs((long) d);
        long divisor = Math.abs((long) dv);
        long ans = 0;
        while (dividend>=divisor) {
            int count=0;
            while(dividend>=(divisor<<(count+1))) count++;
            ans += (1L<<count);
            dividend -= (divisor<<count);
        }
        return (int)((sign==-1) ? (-ans) : ans);
    }

    public static int divide2(int d, int dv) {
        if(d==0) return 0;
        if (dv == 0) throw new ArithmeticException("Division by zero");
        int sign=1;
        if((d<=0 && dv>0) || (d>=0 && dv<0)) sign = -1;
        long dividend = Math.abs((long) d);
        long divisor = Math.abs((long) dv);
        long ans = 0;
        while (dividend>=divisor) {
            int count=0;
            while(dividend>=(divisor<<(count+1))) count++;
            ans += (1L<<count);
            dividend -= (divisor<<count);
        }
        if(ans>Integer.MAX_VALUE && sign==1) return Integer.MAX_VALUE;
        else if(ans>Integer.MAX_VALUE && sign==-1) return Integer.MIN_VALUE;
        return (int)((sign==-1) ? (-ans) : ans);
    }

    public static void main(String[] args) {
        int n1 = 22;
        int d1 = 3;
        System.out.println("n1 -> "+n1+", d1 -> "+d1);
        System.out.println(divide(n1, d1));
        System.out.println(divide2(n1, d1));
        System.out.println("------------------------------");

        int n2 = 7;
        int d2 = -3;
        System.out.println("n -> "+n2+", d -> "+d2);
        System.out.println(divide(n2, d2));
        System.out.println(divide2(n2, d2));

    }
}
