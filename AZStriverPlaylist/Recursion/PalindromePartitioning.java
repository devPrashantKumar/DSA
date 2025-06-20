package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String str){
        List<List<String>> result = new ArrayList<>();
        partitionUtil(str, 0,new ArrayList<>(), result);
        return result;
    }

    /*
     * using StringBuilder instead of String
     */
    public static void partitionUtil(String str, int index, List<StringBuilder> partitionList, List<List<String>> result){
        if(index==str.length()){
            result.add(new ArrayList<>(partitionList.stream().map(StringBuilder::toString).toList()));
            return;
        }
        StringBuilder strTemp = new StringBuilder();
        for(int i=index;i<str.length();i++){
            strTemp.append(str.charAt(i));
            if(checkPalindrom(strTemp, 0, strTemp.length()-1)){
                partitionList.add(strTemp);
                partitionUtil(str, i+1, partitionList, result);
                partitionList.remove(partitionList.size()-1);
            }
        }
    }

    public static boolean checkPalindrom(StringBuilder str, int left, int right){
        if(left>=right) return true;
        if(str.charAt(left)!=str.charAt(right)) return false;
        return checkPalindrom(str, ++left, --right);
    }

    public static void main(String[] args) {
        String str1="aab";
        System.out.println("Input 1 " + str1+" Output : "+PalindromePartitioning.partition(str1));

        String str2="a";
        System.out.println("Input 1 " + str2+" Output : "+PalindromePartitioning.partition(str2));
    }
}
