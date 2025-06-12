package AZStriverPlaylist.Recursion;


public class PowXandN {
    /*
     * Time Complexity : O(n)
     */
    public static double powXN(double x, int n){
        double result=1;
        long nn = n;
        if(nn<0) nn = -1*nn;
        if(x==0 || x==1) return x;
        if (n==0) return 1.0;
        while(nn-->0){
            result *=x;
        }
        return (n>0)?  result:1/result;
    }

    /* 
     * Time complexity : O(lon2n)
     */
    public static double powXNOptimized(double x, int n){
        double result=1;
        long nn = n;
        if(nn<0) nn = -1*nn;
        if(x==0 || x==1) return x;
        if (n==0) return 1.0;
        result = powerOfXN(x,nn);
        return (n>0)?  result:1/result;
    }

    public static double powerOfXN(double x, long n){
        if(n==0) return 1;
        if(n%2==0) return powerOfXN(x*x, n/2);
        else return x*powerOfXN(x, n-1);
    }

    public static void main(String[] args) {
        double x1=2.0;
        int n1 = 10;
        System.out.println("Input 1 " + x1+", " + n1 + " Output : "+PowXandN.powXN(x1,n1));
        System.out.println("Input 1 " + x1+", " + n1 + " Output : "+PowXandN.powXNOptimized(x1,n1));

        double x2=2.10;
        int n2 = 3;
        System.out.println("Input 1 " + x2+", " + n2 + " Output : "+PowXandN.powXN(x2,n2));
        System.out.println("Input 1 " + x2+", " + n2 + " Output : "+PowXandN.powXNOptimized(x2,n2));

        double x3=2.0;
        int n3 = -2;
        System.out.println("Input 1 " + x3+", " + n3 + " Output : "+PowXandN.powXN(x3,n3));
        System.out.println("Input 1 " + x3+", " + n3 + " Output : "+PowXandN.powXNOptimized(x3,n3));
    }
}
