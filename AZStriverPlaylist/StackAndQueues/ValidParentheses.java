package AZStriverPlaylist.StackAndQueues;

import java.util.Stack;

public class ValidParentheses {
    /*
     * Time Complexity O(n)
     * Space Complexity O(n)
     */
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : charArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (!((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String stringInput1 = "()";
        String stringInput2 = "()[]{}";
        String stringInput3 = "(]";
        String stringInput4 = "([])";

        System.out.println("Input String : " + stringInput1 + " Output : " + ValidParentheses.isValid(stringInput1));
        System.out.println("Input String : " + stringInput2 + " Output : " + ValidParentheses.isValid(stringInput2));
        System.out.println("Input String : " + stringInput3 + " Output : " + ValidParentheses.isValid(stringInput3));
        System.out.println("Input String : " + stringInput4 + " Output : " + ValidParentheses.isValid(stringInput4));
    }
}
