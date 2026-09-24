package AZStriverPlaylist.Recursion.SubsequencePatternProblems;

import java.util.*;
public class GenerateAllBinaryStrings {
    public static List<String> allBinaryStrings(int n){
        List<String> result = new ArrayList<>();
        generateBinaryString("","0", n-1,result);
        generateBinaryString("","1", n-1,result);
        return result;
    }

    public static void generateBinaryString(String str, String character, int len, List<String> result) {
        if(len==0){
            result.add(str+character);
            return;
        }
        generateBinaryString(str+character,"0", len-1,result);
        if(character.equals("0")){
            generateBinaryString(str+character,"1", len-1,result);
        }
    }

    public static List<String> allBinaryStrings2(int n){
        List<String> result = new ArrayList<>();
        generateBinaryString2(new StringBuilder(),"0", n, result);
        return result;
    }

    public static void generateBinaryString2(StringBuilder str, String lastUsedCharacter, int len, List<String> result) {
        if(len==0){
            result.add(str.toString());
            return;
        }

        str.append("0");
        generateBinaryString2(str,"0", len-1,result);
        str.deleteCharAt(str.length()-1);
        if(lastUsedCharacter.equals("0")){
            str.append("1");
            generateBinaryString2(str,"1", len-1,result);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Input1 - " + n1);
        System.out.println(allBinaryStrings(n1));
        System.out.println("----------------------------------");
        System.out.println(allBinaryStrings2(n1));
    }
}
