public class BinaryNotationUtility {
    public static String decimalToBinaryString(int val){
        StringBuilder binary = new StringBuilder();
        do{
            binary.append(val%2);
            val /= 2;
        }while(val!=0);
        return binary.reverse().toString();
    }

    public static int binaryStringToDecimal(String binary){
        int factor=1;
        int decimal=0;
        for(int i=binary.length()-1;i>=0;i--){
            int value = binary.charAt(i)-'0';
            if(value>1 || value<0){
                throw new IllegalArgumentException("Provide valid Binary string");
            }
            decimal += (value*factor);
            factor *= 2;
        }
        return decimal;
    }

    public static String onesComplimentOfBinaryString(String binary){
        StringBuilder onesCompliment = new StringBuilder();
        boolean flag=true;
        for(char c : binary.toCharArray()){
            int val = Math.abs(c-'1');
            if(flag && val==1){
                flag=false;
            }
            if(!flag){
                onesCompliment.append(Integer.toString(val));
            }   
        }
        String onesComplimentString  = onesCompliment.toString();
        if(onesComplimentString.equals("")){
            return Integer.toString(0);
        }
        return onesComplimentString;
    }

    public static String twosComplimentOfBinaryString(String binary){
        String onesCompliment = BinaryNotationUtility.onesComplimentOfBinaryString(binary);
        StringBuilder twosCompliment = new StringBuilder();
        int carry=1;
        for(int i=onesCompliment.length()-1;i>=0;i--){
            int sum = (onesCompliment.charAt(i)-'0')+carry;
            carry = sum/2;
            twosCompliment.append(Integer.toString(sum%2));
        }
        if(carry==1){
            twosCompliment.append(Integer.toString(carry));
        }
        
        return twosCompliment.reverse().toString();
    }
}
