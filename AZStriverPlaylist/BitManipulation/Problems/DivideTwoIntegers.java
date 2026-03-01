package AZStriverPlaylist.BitManipulation.Problems;

public class DivideTwoIntegers {
    /*
    * Time Complexity : O((log n)^2)
    * Space Complexity : O(n)
    */
    public static int divide(int d, int dv) {
        if(d==dv) return 1;
        if(d==0) return 0;
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
        return (int)(sign*ans);
    }

    public static void main(String[] args) {
        int n1 = 22;
        int d1 = 3;
        System.out.println("n1 -> "+n1+", d1 -> "+d1);
        System.out.println(divide(n1, d1));
    }
}
