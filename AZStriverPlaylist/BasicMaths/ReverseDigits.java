package AZStriverPlaylist.BasicMaths;

public class ReverseDigits{
    /*
     * Time Complexity: O(log10N + 1) 
     */
    public static int reverseDigitsOfNumber(int x){
        if(x==Integer.MIN_VALUE) return 0;
        int sign = (x<0)? -1:1;
        x = Math.abs(x);
        int reverseNum=0;
        if(x==0) return x;
        while(x>0){
            int digit = x%10;
            x /=10;
            if((Integer.MAX_VALUE-digit)/10 >= reverseNum)
                reverseNum = (reverseNum*10)+digit;
            else return 0;
            // this wil also work
            // if((Integer.MAX_VALUE-digit)/10 < reverseNum) return 0;
            // else reverseNum = (reverseNum*10)+digit;
            
        }
        return reverseNum*sign;
    }

    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+ReverseDigits.reverseDigitsOfNumber(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+ReverseDigits.reverseDigitsOfNumber(input2));

        System.out.println("-------------------------------------------------------------------------------");
        int input3 = Integer.MIN_VALUE;
        System.out.println("Input : "+ input3+" Output : "+ReverseDigits.reverseDigitsOfNumber(input3));
    }
}