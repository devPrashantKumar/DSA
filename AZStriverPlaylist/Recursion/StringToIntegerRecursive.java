package AZStriverPlaylist.Recursion;

public class StringToIntegerRecursive {

    public static int myAtoiRecursionApproach(String s) {
        int n = s.length();
        int sign = 1;
        int i = 0;
        while (i < n && s.charAt(i) == ' ')
            i++;

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        return parseString(s, i, 0, sign);
    }

    public static int parseString(String s, int index, int currentValue, int sign) {
        if(index>=s.length() || !Character.isDigit(s.charAt(index))) return currentValue*sign;
        
        int digit = Character.getNumericValue(s.charAt(index));

        if (currentValue > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        currentValue = (currentValue * 10) + digit;
        
        return parseString(s, index+1, currentValue, sign);
    }

    public static void main(String[] args) {
        String input1 = "42";
        System.out.println("Input : " + input1 + " Output : " + StringToIntegerRecursive.myAtoiRecursionApproach(input1));
        System.out.println("Input : " + input1 + " Output : " + StringToIntegerRecursive.myAtoiRecursionApproach(input1));

        String input2 = "-042";
        System.out.println("Input : " + input2 + " Output : " + StringToIntegerRecursive.myAtoiRecursionApproach(input2));
        System.out.println("Input : " + input2 + " Output : " + StringToIntegerRecursive.myAtoiRecursionApproach(input2));

        String input3 = "0-1";
        System.out.println("Input : " + input3 + " Output : " + StringToIntegerRecursive.myAtoiRecursionApproach(input3));
        System.out.println("Input : " + input3 + " Output : " + StringToIntegerRecursive.myAtoiRecursionApproach(input3));

    }
}
