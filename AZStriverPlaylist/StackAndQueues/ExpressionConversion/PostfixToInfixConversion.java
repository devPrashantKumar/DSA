package AZStriverPlaylist.StackAndQueues.ExpressionConversion;

import java.util.Stack;

public class PostfixToInfixConversion {
    /*
     * Time complexity : O(n)
     */
    public static String postfixToInfix(String exp) {
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stk.push(String.valueOf(character));
            } else {
                String t2 = stk.pop();
                String t1 = stk.pop();
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
        String exp1 = "ab*c+";
        System.out.println("Input : " + exp1 + " Output : " + PostfixToInfixConversion.postfixToInfix(exp1));

        String exp2 = "abc+*d/";
        System.out.println("Input : " + exp2 + " Output : " + PostfixToInfixConversion.postfixToInfix(exp2));

        String exp3 = "abc++";
        System.out.println("Input : " + exp3 + " Output : " + PostfixToInfixConversion.postfixToInfix(exp3));
    }
}
