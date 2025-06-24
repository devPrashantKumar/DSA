package AZStriverPlaylist.StackAndQueues.ExpressionConversion;

import java.util.Stack;
/*
 * Reference : https://www.geeksforgeeks.org/dsa/postfix-prefix-conversion/
 */
public class PostfixToPrefixConversion {
    /*
     * Time complexity : O(n)
     */
    public static String postfixToPrefix(String exp) {
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stk.push(String.valueOf(character));
            } else {
                String t1 = stk.pop();
                String t2 = stk.pop();
                stk.push(character+t2+t1);
            }
        }

        return stk.pop();
    }

    public static void main(String[] args) {
        String exp1 = "AB+CD-*";
        System.out.println("Input : " + exp1 + " Output : " + PostfixToPrefixConversion.postfixToPrefix(exp1));

        String exp2 = "ABC/-AK/L-*";
        System.out.println("Input : " + exp2 + " Output : " + PostfixToPrefixConversion.postfixToPrefix(exp2));
    }
}
