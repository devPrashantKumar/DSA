package AZStriverPlaylist.BasicMaths;

public class DivisorsOfN {
    public static void printDivisorsOfN(int n){
        if(n<=0) return;
        //for (int i = 1; i <= n / i; i++) { ... } can also use this syntax for sqrt
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                System.out.print(i+" ");
                if(n/i!=i){
                    System.out.print(n/i+" ");
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int input1 = 36;
        System.out.println("Input : "+ input1);
        DivisorsOfN.printDivisorsOfN(input1);

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2);
        DivisorsOfN.printDivisorsOfN(input2);

    }
}
