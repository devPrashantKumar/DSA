package AZStriverPlaylist.Pattern;

public class Pattern18 {

    public static void pattern18(int n) {
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print((char) ('A'+(n-i+j))+" ");
            }
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern18(5);
    }
}
