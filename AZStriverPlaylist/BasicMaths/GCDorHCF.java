package AZStriverPlaylist.BasicMaths;

public class GCDorHCF {
    public static int gcdUsingRecursion(int num1, int num2){
        if(num1==0 && num2==0) return 1;
        if(num1==0 && num2!=0) return num2;
        if(num1!=0 && num2==0) return num1;
        if(num1>num2) return gcdUsingRecursion(num1%num2, num2);
        return gcdUsingRecursion(num1,num2%num1);
    }

    // Time Complexity: O(log(min(a, b)))
    public static int gcd(int num1, int num2){
        if(num1==0 && num2==0) return 1;
        while(num1>0 && num2>0){
            if(num1>num2) num1 = num1%num2;
            else num2 = num2%num1;
        }
        if(num1==0 && num2!=0) return num2;
        return num1;
    }

    // public static int lcm(int num1, int num2){
    //     return (num1*num2)/gcd(num1,num2);
    // }

    public static void main(String[] args) {
        int input11 = 11;
        int input12 = 3;
        System.out.println("Input : "+ input11+" "+input12);
        System.out.println("Output : "+GCDorHCF.gcdUsingRecursion(input11,input12));
        System.out.println("Output : "+GCDorHCF.gcd(input11,input12));

        System.out.println("-------------------------------------------------------------------------------");
        int input21 = 12;
        int input22 = 36;
        System.out.println("Input : "+ input21+" "+input22);
        System.out.println("Output : "+GCDorHCF.gcdUsingRecursion(input21,input22));
        System.out.println("Output : "+GCDorHCF.gcd(input21,input22));

        System.out.println("-------------------------------------------------------------------------------");
        int input31 = 12;
        int input32 = 18;
        System.out.println("Input : "+ input31+" "+input32);
        System.out.println("Output : "+GCDorHCF.gcdUsingRecursion(input31,input32));
        System.out.println("Output : "+GCDorHCF.gcd(input31,input32));

    }
}
