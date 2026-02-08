package AZStriverPlaylist.Strings.Medium;

public class MaximumNestingDepthOfTheParentheses {

    public static int maxDepth(String s) {
        int maxCounter = 0;
        int counter = 0;
        for (char c : s.toCharArray()) {
            char ch = (char) c;
            if (ch == '(')
                counter++;
            else if (ch == ')')
                counter--;
            maxCounter = Math.max(maxCounter,counter);
        }
        return maxCounter;
    }

    public static void main(String[] args) {
        String input1 = "(1+(2*3)+((8)/4))+1";
        System.out.println("Input : " + input1 + " Output : " + MaximumNestingDepthOfTheParentheses.maxDepth(input1));
        String input2 = "(1)+((2))+(((3)))";
        System.out.println("Input : " + input2 + " Output : " + MaximumNestingDepthOfTheParentheses.maxDepth(input2));
        String input3 = "()(())((()()))";
        System.out.println("Input : " + input3 + " Output : " + MaximumNestingDepthOfTheParentheses.maxDepth(input3));
    }

}
