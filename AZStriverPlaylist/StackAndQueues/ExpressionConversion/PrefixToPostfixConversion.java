package AZStriverPlaylist.StackAndQueues.ExpressionConversion;

import java.util.Stack;
/*
 * Reference : https://www.geeksforgeeks.org/dsa/prefix-postfix-conversion/
 */
public class PrefixToPostfixConversion {
    /*
     * Time complexity : O(n)
     */
    public static String prefixToPostfix(String exp) {
        Stack<String> stk = new Stack<>();
        for (int i = exp.length()-1; i >=0 ; i--) {
            char character = exp.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stk.push(String.valueOf(character));
            } else {
                String t1 = stk.pop();
                String t2 = stk.pop();
                stk.push(t1+t2+character);
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        String exp1 = "*+AB-CD";
        System.out.println("Input : " + exp1 + " Output : " + PrefixToPostfixConversion.prefixToPostfix(exp1));

        String exp2 = "*-A/BC-/AKL";
        System.out.println("Input : " + exp2 + " Output : " + PrefixToPostfixConversion.prefixToPostfix(exp2));
    }
}
