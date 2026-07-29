package AZStriverPlaylist.Pattern;

public class Pattern06 {

    public static void pattern6(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i+1);j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern6_2(int n) {
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern6(5);
        System.out.println("------------------------");
        pattern6_2(5);
    }
}
