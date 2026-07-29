package AZStriverPlaylist.Pattern;

public class Pattern09 {

    public static void pattern9(int n) {
        for(int i=0;i<n;i++){
            for(int j=1;j<(n-i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<(2*i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=(n-1);i>=0;i--){
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
        pattern9(5);
        
    }
}
