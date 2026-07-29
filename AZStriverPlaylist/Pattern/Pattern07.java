package AZStriverPlaylist.Pattern;

public class Pattern07 {

    public static void pattern7(int n) {
        for(int i=0;i<n;i++){
            for(int j=1;j<(n-i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<(2*i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern7(5);
        
    }
}
