package AZStriverPlaylist.StackAndQueues.ExpressionConversion;

import java.util.Stack;

/*
 * Reference : https://www.geeksforgeeks.org/dsa/convert-infix-prefix-notation/ - this article is wrong
 * refer this video for corrct solution : https://www.youtube.com/watch?v=4pIc9UBHJtk
 */
public class InfixToPrefixConversion {
    /*
     * Time complexity : O(n)+O(n) => O(n)
     * O(n) - for outer for loop executions
     * O(n) - total execution of while loops
     */
    public static String infixToPrefix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        String reversedExp = new StringBuilder(exp).reverse().toString();
        String swapped = reversedExp.replace('(', '#').replace(')', '(').replace('#', ')');
        for (int i = 0; i < swapped.length(); i++) {
            char character = swapped.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                result.append(character);
            } else if (character == '(') {
                stk.push(character);
            } else if (character == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    result.append(stk.pop());
                }
                stk.pop();
            } else {
                if (character == '^') {
                    while (!stk.isEmpty() && precedence(stk.peek()) >= precedence(character)) {
                        result.append(stk.pop());
                    }
                } else {
                    while (!stk.isEmpty() && precedence(stk.peek()) > precedence(character)) {
                        result.append(stk.pop());
                    }
                }

                stk.push(character);
            }
        }

        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        return result.reverse().toString();
    }

    public static int precedence(char c) {
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        String exp1 = "a*b+c/d";
        System.out.println("Input : " + exp1 + " Output : " + InfixToPrefixConversion.infixToPrefix(exp1));

        String exp2 = "(a-b/c)*(a/k-l)";
        System.out.println("Input : " + exp2 + " Output : " + InfixToPrefixConversion.infixToPrefix(exp2));
    }
}
