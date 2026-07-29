package AZStriverPlaylist.Pattern;

public class Pattern22 {

    public static void pattern22(int n) {
        for(int i=1;i<=n;i++){
            int num=n;
            for(int j=1;j<2*n;j++){
                if(j<i) System.out.print(num-- +" ");
                else if(j>=(2*n-i)) System.out.print(num++ +" ");
                else System.out.print(num+" ");

            }
            System.out.println();
        }

        for(int i=n-1;i>0;i--){
            int num=n;
            for(int j=1;j<2*n;j++){
                if(j<i) System.out.print(num-- +" ");
                else if(j>=(2*n-i)) System.out.print(num++ +" ");
                else System.out.print(num+" ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        pattern22(5);
    }
}
