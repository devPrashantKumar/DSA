package AZStriverPlaylist.Greedy;

import java.util.Stack;

public class ValidParanthesisChecker {

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }
            else if (c==')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(max<0) return false;
            if(min<0) min=0;
        }
        return (min==0);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static boolean checkValidStringUsingStack(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                open.push(i);
            else if (c == '*')
                star.push(i);
            else {
                if (!open.isEmpty())
                    open.pop();
                else if (!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }

        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.peek() > star.peek())
                return false;
            open.pop();
            star.pop();
        }
        return open.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "()";
        System.out.println("Input : " + input1);
        System.out.println("Output : " + checkValidString(input1));
        System.out.println("Output : " + checkValidStringUsingStack(input1));

        System.out.println("----------------------------------------------------------------");
        String input2 = "(*)";
        System.out.println("Input : " + input2);
        System.out.println("Output : " + checkValidString(input2));
        System.out.println("Output : " + checkValidStringUsingStack(input2));

        System.out.println("----------------------------------------------------------------");
        String input3 = "(*))";
        System.out.println("Input : " + input3);
        System.out.println("Output : " + checkValidString(input3));
        System.out.println("Output : " + checkValidStringUsingStack(input3));

        System.out.println("----------------------------------------------------------------");
    }
}
