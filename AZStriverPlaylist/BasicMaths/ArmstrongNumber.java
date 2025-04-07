package AZStriverPlaylist.BasicMaths;

public class ArmstrongNumber {
    public static boolean isArmstrongNumber(int num){
        int numberOfDigits=1;
        int originalNum=num;
        int sumOfPowers=0;
        if(num!=0){
            numberOfDigits = (int)(Math.log10(num)+1);
        }
        while(num!=0){
            int numberPower=1;
            int lastDigit = num%10;
            num /= 10;
            for(int i=0;i<numberOfDigits;i++){
                if(Integer.MAX_VALUE/lastDigit<numberPower){
                    return false;
                }
                numberPower*=lastDigit;
            }

            if(Integer.MAX_VALUE-sumOfPowers<numberPower){
                return false;
            }
            sumOfPowers+=numberPower;
        }
        return sumOfPowers==originalNum;
    }
    
    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+ArmstrongNumber.isArmstrongNumber(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+ArmstrongNumber.isArmstrongNumber(input2));

        System.out.println("-------------------------------------------------------------------------------");
        int input3 = 371;
        System.out.println("Input : "+ input3+" Output : "+ArmstrongNumber.isArmstrongNumber(input3));

    }
}
