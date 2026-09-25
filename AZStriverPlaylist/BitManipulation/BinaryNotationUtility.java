package AZStriverPlaylist.BitManipulation;
public class BinaryNotationUtility {

    /* 
    * Time Complexity : O(logN)
    * Space Complexity : O(logN)
    */
    public static String decimalToBinaryString(int val){
        StringBuilder binary = new StringBuilder();
        do{
            binary.append(val%2);
            val /= 2;
        }while(val!=0);
        return binary.reverse().toString();
    }

    /* 
    * Time Complexity : O(N)
    * Space Complexity : O(1)
    */
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

    /*
    * ones compliment - reverse all bits
    * Time Complexity : O(N)
    * Space Complexity : O(1)
    */
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

    /*
    * twos compliment - find ones compliment and add 1
    * Time Complexity : O(N)
    * Space Complexity : O(1)
    */
    public static String twosComplimentOfBinaryString(String binary){
        String onesCompliment = onesComplimentOfBinaryString(binary);
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

    public static void main(String[] args) {
        System.out.println(decimalToBinaryString(0));
        System.out.println(decimalToBinaryString(10));
        System.out.println(decimalToBinaryString(8));
        System.out.println(decimalToBinaryString(7));

        System.out.println("---------------------------------------------------------");

        System.out.println(binaryStringToDecimal("0"));
        System.out.println(binaryStringToDecimal("1010"));
        System.out.println(binaryStringToDecimal("1000"));
        System.out.println(binaryStringToDecimal("111"));
        try {
            System.out.println(binaryStringToDecimal("11221"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------------");

        System.out.println(onesComplimentOfBinaryString("0"));
        System.out.println(onesComplimentOfBinaryString("1010"));
        System.out.println(onesComplimentOfBinaryString("1000"));
        System.out.println(onesComplimentOfBinaryString("111"));

        System.out.println("---------------------------------------------------------");

        System.out.println(twosComplimentOfBinaryString("0"));
        System.out.println(twosComplimentOfBinaryString("1010"));
        System.out.println(twosComplimentOfBinaryString("1000"));
        System.out.println(twosComplimentOfBinaryString("111"));

    }
}
