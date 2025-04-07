package AZStriverPlaylist.BasicMaths;

public class PalindromNumber{
    /*
     * Time Complexity: O(log10N + 1) 
     */
    public static boolean checkPalindromNumber(int x){
        int num=x;
        if(x==Integer.MIN_VALUE) return false;
        if(x==0) return true;

        x = Math.abs(x);
        int reverseNum=0;
        while(x>0){
            int digit = x%10;
            x /=10;
            if((Integer.MAX_VALUE-digit)/10 < reverseNum) return false;
            else reverseNum = (reverseNum*10)+digit;
            
        }
        return reverseNum==num;
    }

    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+PalindromNumber.checkPalindromNumber(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+PalindromNumber.checkPalindromNumber(input2));

        System.out.println("-------------------------------------------------------------------------------");
        int input3 = Integer.MIN_VALUE;
        System.out.println("Input : "+ input3+" Output : "+PalindromNumber.checkPalindromNumber(input3));
        
        System.out.println("-------------------------------------------------------------------------------");
        int input4 = 121;
        System.out.println("Input : "+ input4+" Output : "+PalindromNumber.checkPalindromNumber(input4));

        System.out.println("-------------------------------------------------------------------------------");
        int input5 = 10;
        System.out.println("Input : "+ input5+" Output : "+PalindromNumber.checkPalindromNumber(input5));

    }
}