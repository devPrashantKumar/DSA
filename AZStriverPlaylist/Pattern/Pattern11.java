package AZStriverPlaylist.Pattern;

public class Pattern11 {

    public static void pattern11(int n) {
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print((i+j)%2);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern11(5);
    }
}
