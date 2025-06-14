package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateAllParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("",n,n,result);
        return result;
    }

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

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Input 1 " + n1+" Output : "+GenerateParenthesis.generateAllParenthesis(n1));
    
        int n2 = 1;
        System.out.println("Input 1 " + n2+" Output : "+GenerateParenthesis.generateAllParenthesis(n2));
    }
}
