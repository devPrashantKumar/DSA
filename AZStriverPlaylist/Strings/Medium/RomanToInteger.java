package AZStriverPlaylist.Strings.Medium;

public class RomanToInteger {
    public static int romanToIntSimple(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            if (c1 == 'M') {
                result += 1000;
            } else if (c1 == 'D') {
                result += 500;
            } else if (c1 == 'C') {
                if (i + 1 != n && s.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                } else if (i + 1 != n && s.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if (c1 == 'L') {
                result += 50;
            } else if (c1 == 'X') {
                if (i + 1 != n && s.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                } else if (i + 1 != n && s.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if (c1 == 'V') {
                result += 5;
            } else if (c1 == 'I') {
                if (i + 1 != n && s.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                } else if (i + 1 != n && s.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            }

        }
        return result;
    }

    /*
     * Better implementation (time complexity same)
     */
    public static int romanToIntOptimal(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = (i + 1 <= n - 1) ? s.charAt(i + 1) : ' ';
            int num1 = RomanToInteger.mapCharToNum(c1);
            int num2 = RomanToInteger.mapCharToNum(c2);
            if (num1 >= num2)
                result += num1;
            else {
                result -= num1;
                result += num2;
                i++;
            }
        }
        return result;
    }

    public static int romanToIntOptimal2(String s) {
        int n = s.length();
        if(n==0) return 0;
        int result = mapCharToNum(s.charAt(0));
        for (int i = 1; i < n; i++) {
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);
            int num1 = RomanToInteger.mapCharToNum(prev);
            int num2 = RomanToInteger.mapCharToNum(curr);
            result+=num2;
            if (num1 < num2) result -= (2*num1);
        }
        return result;
    }

    public static int mapCharToNum(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String input1 = "III";
        System.out.println("Input : " + input1 + " Output : " + RomanToInteger.romanToIntSimple(input1));
        System.out.println("Input : " + input1 + " Output : " + RomanToInteger.romanToIntOptimal(input1));
        System.out.println("Input : " + input1 + " Output : " + RomanToInteger.romanToIntOptimal2(input1));

        String input2 = "LVIII";
        System.out.println("Input : " + input2 + " Output : " + RomanToInteger.romanToIntSimple(input2));
        System.out.println("Input : " + input2 + " Output : " + RomanToInteger.romanToIntOptimal(input2));
        System.out.println("Input : " + input2 + " Output : " + RomanToInteger.romanToIntOptimal2(input2));

        String input3 = "MCMXCIV";
        System.out.println("Input : " + input3 + " Output : " + RomanToInteger.romanToIntSimple(input3));
        System.out.println("Input : " + input3 + " Output : " + RomanToInteger.romanToIntOptimal(input3));
        System.out.println("Input : " + input3 + " Output : " + RomanToInteger.romanToIntOptimal2(input3));

    }
}
