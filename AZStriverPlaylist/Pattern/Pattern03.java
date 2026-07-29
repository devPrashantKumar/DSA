package AZStriverPlaylist.Pattern;

public class Pattern03 {

    public static void pattern3(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern3(5);
    }
}
