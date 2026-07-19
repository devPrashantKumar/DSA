package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateAllParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("",n,n,result);
        return result;
    }

    // Time: O(4^n / sqrt(n)) - bounded by the nth Catalan number of valid combinations, each built via string concatenation
    // Space: O(4^n / sqrt(n)) for the output, plus O(n) recursion stack depth (excluding output storage)
    public static void generateParenthesis(String str, int open, int closed, List<String> result) {
        if(open==0 && closed==0){
            result.add(str);
            return;
        }
        if(open!=0){
            generateParenthesis(str+'(',open-1,closed,result);
        }
        if(closed>open){
            generateParenthesis(str+')',open,closed-1,result);
        }
    }


    public static List<String> generateAllParenthesisUsingStringBuilder(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesisUsingStringBuilder(new StringBuilder(),n,n,result);
        return result;
    }

    // Time: O(4^n / sqrt(n)) - same Catalan-bounded branching as the String version
    // Space: O(4^n / sqrt(n)) for the output, plus O(n) recursion stack; StringBuilder avoids the extra O(n) copy per call that String concatenation incurs
    public static void generateParenthesisUsingStringBuilder(StringBuilder str, int open, int closed, List<String> result) {
        if(open==0 && closed==0){
            result.add(str.toString());
            return;
        }
        if(open!=0){
            str.append('(');
            generateParenthesisUsingStringBuilder(str,open-1,closed,result);
            str.deleteCharAt(str.length()-1);
        }
        if(closed>open){
            str.append(')');
            generateParenthesisUsingStringBuilder(str,open,closed-1,result);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Input 1 " + n1+" Output : "+GenerateParenthesis.generateAllParenthesis(n1));
    
        int n2 = 1;
        System.out.println("Input 2 " + n2+" Output : "+GenerateParenthesis.generateAllParenthesis(n2));

        System.out.println("----------------------------------------------------------------------------------");

        int n3 = 3;
        System.out.println("Input 3 " + n3+" Output : "+GenerateParenthesis.generateAllParenthesisUsingStringBuilder(n3));
    
        int n4 = 1;
        System.out.println("Input 4 " + n4+" Output : "+GenerateParenthesis.generateAllParenthesisUsingStringBuilder(n4));
        System.out.println("----------------------------------------------------------------------------------");
    }
}
