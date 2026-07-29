package AZStriverPlaylist.Pattern;

public class Pattern05 {

    public static void pattern5(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i+1);j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void pattern5_2(int n) {
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern5(5);
        System.out.println("------------------------");
        pattern5_2(5);
    }
}
