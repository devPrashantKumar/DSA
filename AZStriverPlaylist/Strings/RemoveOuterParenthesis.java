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

    /*
     * TIme Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static String removeOuterParenthesesOptimised(String s) {
        StringBuilder str = new StringBuilder();
        int counter=0;
        for(int k=0;k<s.length();k++){
            if(counter==0){
                counter++;
                continue;
            } 
            if(s.charAt(k)=='(') counter++;
            else counter--;

            if(counter!=0){
                str.append(s.charAt(k));
            }
        }
        return str.toString();
    }

    /*
     * TIme Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static String removeOuterParenthesesOptimised2(String s) {
        StringBuilder str = new StringBuilder();
        int counter=0;
        for(char k : s.toCharArray()){
            if(k=='('){
                if(counter>0) str.append(k);
                counter++;
            }else{
                counter--;
                if(counter>0) str.append(k);
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String input1 = "(()())(())";
        System.out.println("Input : "+input1+" Output : "+RemoveOuterParenthesis.removeOuterParentheses(input1) );
        System.out.println("Input : "+input1+" Output : "+RemoveOuterParenthesis.removeOuterParenthesesOptimised(input1) );
        System.out.println("Input : "+input1+" Output : "+RemoveOuterParenthesis.removeOuterParenthesesOptimised2(input1) );

        System.out.println("--------------------------------------------");
        String input2 = "(()())(())(()(()))";
        System.out.println("Input : "+input2+" Output : "+RemoveOuterParenthesis.removeOuterParentheses(input2) );
        System.out.println("Input : "+input2+" Output : "+RemoveOuterParenthesis.removeOuterParenthesesOptimised(input2) );
        System.out.println("Input : "+input2+" Output : "+RemoveOuterParenthesis.removeOuterParenthesesOptimised2(input2) );

        System.out.println("--------------------------------------------");

        String input3 = "()()";
        System.out.println("Input : "+input3+" Output : "+RemoveOuterParenthesis.removeOuterParentheses(input3) );
        System.out.println("Input : "+input3+" Output : "+RemoveOuterParenthesis.removeOuterParenthesesOptimised(input3) );
        System.out.println("Input : "+input3+" Output : "+RemoveOuterParenthesis.removeOuterParenthesesOptimised2(input3) );

        System.out.println("--------------------------------------------");

    }
}
