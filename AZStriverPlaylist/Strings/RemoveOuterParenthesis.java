package AZStriverPlaylist.Strings;

public class RemoveOuterParenthesis {
    /*
     * TIme Complexity : O(2*n)
     * Space Complexity : O(1)
     */
    public static String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int start=0;
        int counter=0;
        for(int k=0;k<s.length();k++){
            if(counter==0) start=k;
            if(s.charAt(k)=='(') counter++;
            else counter--;

            if(counter==0){
                for(int i=start+1;i<k;i++){
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String input1 = "(()())(())";
        System.out.println("Input : "+input1+" Output : "+RemoveOuterParenthesis.removeOuterParentheses(input1) );
        String input2 = "(()())(())(()(()))";
        System.out.println("Input : "+input2+" Output : "+RemoveOuterParenthesis.removeOuterParentheses(input2) );
        String input3 = "()()";
        System.out.println("Input : "+input3+" Output : "+RemoveOuterParenthesis.removeOuterParentheses(input3) );
    }
}
