package AZStriverPlaylist.StackAndQueues.ExpressionConversion;

import java.util.Stack;

/*
 * Reference : https://www.geeksforgeeks.org/dsa/convert-infix-expression-to-postfix-expression/
 */
public class InfixToPostfixConversion {
    /*
     * Time complexity : O(n)+O(n) => O(n)
     * O(n) - for outer for loop executions
     * O(n) - total execution of while loops
     */
    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                result.append(character);
            } else {
                if (isArithmaticOperator(character)) {
                    while (!stk.isEmpty() && precedence(stk.peek()) >= precedence(character)) {
                        result.append(stk.pop());
                    }
                    stk.push(character);
                } else {
                    if (character == '(') {
                        stk.push(character);
                    } else {
                        while (!stk.isEmpty() && stk.peek() != '(') {
                            result.append(stk.pop());
                        }
                        stk.pop();
                    }
                }
            }
        }
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        return result.toString();
    }

    public static int precedence(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    // public static int precedence2(char c) {
    // switch (c) {
    // case '^' : return 3;
    // case '*', '/' : return 2;
    // case '+', '-' : return 1;
    // default : return -1;
    // }
    // }

    public static boolean isArithmaticOperator(char c) {
        if (c == '+' || c == '-' || c == '^' || c == '*' || c == '/')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String exp1 = "A*(B+C)/D";
        System.out.println("Input : " + exp1 + " Output : " + InfixToPostfixConversion.infixToPostfix(exp1));

        String exp2 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Input : " + exp2 + " Output : " + InfixToPostfixConversion.infixToPostfix(exp2));
    }
}
