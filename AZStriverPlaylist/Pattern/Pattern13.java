package AZStriverPlaylist.Pattern;

public class Pattern13 {

    public static void pattern13(int n) {
        int count=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern13(5);
    }
}
