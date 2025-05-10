package AZStriverPlaylist.Strings;

public class StringToInteger {
    public static int myAtoiMyApproach(String s) {
        long result = 0;
        int n = s.length();
        boolean isPositive = true;
        int i = 0;
        for (; i < n; i++) {
            if (s.charAt(i) == '-') {
                isPositive = false;
                i++;
                break;
            } else if (s.charAt(i) == '+') {
                isPositive = true;
                i++;
                break;
            } else if (s.charAt(i) == ' ')
                continue;
            else if (Character.isDigit(s.charAt(i)))
                break;
            else
                return (int) result;
        }

        for (; i < n; i++) {
            if (!Character.isDigit(s.charAt(i)))
                return (int) ((isPositive) ? result : result * -1);
            result = (result * 10) + Character.getNumericValue(s.charAt(i));
            long tempResult = (isPositive) ? result : result * -1;
            if (tempResult > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (tempResult < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) ((isPositive) ? result : result * -1);
    }

    public static int myAtoiStandardApproach(String s) {
        int result = 0;
        int n = s.length();
        int sign = 1;
        int i = 0;
        while (i < n && s.charAt(i) == ' ')
            i++;

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        for (; i < n; i++) {
            if (!Character.isDigit(s.charAt(i)))
                break;
            int digit = Character.getNumericValue(s.charAt(i));
            // for  Integer.MAX_VALUE it will follow normal flow.
            // for  Integer.MIN_VALUE it will automaticaly return Integer.MIN_VALUE due to overflow.
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = (result * 10) + digit;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        String input1 = "42";
        System.out.println("Input : " + input1 + " Output : " + StringToInteger.myAtoiMyApproach(input1));
        System.out.println("Input : " + input1 + " Output : " + StringToInteger.myAtoiStandardApproach(input1));

        String input2 = "-042";
        System.out.println("Input : " + input2 + " Output : " + StringToInteger.myAtoiMyApproach(input2));
        System.out.println("Input : " + input2 + " Output : " + StringToInteger.myAtoiStandardApproach(input2));

        String input3 = "0-1";
        System.out.println("Input : " + input3 + " Output : " + StringToInteger.myAtoiMyApproach(input3));
        System.out.println("Input : " + input3 + " Output : " + StringToInteger.myAtoiStandardApproach(input3));

    }
}
