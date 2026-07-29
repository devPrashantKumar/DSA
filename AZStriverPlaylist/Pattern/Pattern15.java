package AZStriverPlaylist.Pattern;

public class Pattern15 {

    public static void pattern15(int n) {
        for(int i=n;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print((char) ('A'+j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern15(5);
    }
}
