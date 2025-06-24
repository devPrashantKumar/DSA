package AZStriverPlaylist.StackAndQueues.ExpressionConversion;

import java.util.Stack;
/*
 * Reference : https://www.geeksforgeeks.org/dsa/prefix-infix-conversion/
 */
public class PrefixToInfixConversion {
    /*
     * Time complexity : O(n)
     */
    public static String prefixToInfix(String exp) {
        Stack<String> stk = new Stack<>();
        for (int i = exp.length()-1; i >=0 ; i--) {
            char character = exp.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stk.push(String.valueOf(character));
            } else {
                String t1 = stk.pop();
                String t2 = stk.pop();
                stk.push("(" + t1 + character + t2 + ")");

                // StringBuilder sb = new StringBuilder();
                // sb.append("(")
                //         .append(t1)
                //         .append(character)
                //         .append(t2)
                //         .append(")");

                // stk.push(sb.toString());
            }
        }

        return stk.pop();
    }

    public static void main(String[] args) {
        String exp1 = "*-A/BC-/AKL";
        System.out.println("Input : " + exp1 + " Output : " + PrefixToInfixConversion.prefixToInfix(exp1));

        String exp2 = "*+AB-CD";
        System.out.println("Input : " + exp2 + " Output : " + PrefixToInfixConversion.prefixToInfix(exp2));
    }
}
