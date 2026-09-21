package AZStriverPlaylist.BeginnerProblems.BasicMaths;

public class PerfectNumber {

    /*
    * Time Complexity: O(sqrt(N))
    * Space Complexity: O(1)
    */
    public static boolean isPerfect(int n) {
        if(n==0 || n==1) return false;
        int sum=0;
        for(int i=2;i<=n/i;i++){
            if(n%i==0){
                sum += i;
                if(i!=n/i) sum += (n/i);
            }
        }
        return (sum+1)==n;
    }

    public static void main(String[] args) {
        int input1 = 6;
        System.out.println("Input : "+ input1+" Output : "+isPerfect(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+isPerfect(input2));

        System.out.println("-------------------------------------------------------------------------------");
        int input3 = 4;
        System.out.println("Input : "+ input3+" Output : "+isPerfect(input3));
    }
}
