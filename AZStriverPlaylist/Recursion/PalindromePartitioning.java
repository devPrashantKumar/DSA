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

    public static List<List<String>> partition2(String str){
        List<List<String>> result = new ArrayList<>();
        partitionUtil2(str, 0,true, new ArrayList<>(), result);
        return result;
    }

    /*
     * using StringBuilder instead of String
     */
    public static void partitionUtil2(String str, int index, boolean prevPalindrom, List<StringBuilder> partitionList, List<List<String>> result){
        if(index==str.length()){
            if(prevPalindrom) result.add(new ArrayList<>(partitionList.stream().map(StringBuilder::toString).toList()));
            return;
        }

        if(prevPalindrom){
            StringBuilder strTemp = new StringBuilder();
            strTemp.append(str.charAt(index));
            partitionList.add(strTemp);
            partitionUtil2(str, index+1, true, partitionList, result);
            partitionList.remove(partitionList.size()-1);
        }

        if(!partitionList.isEmpty()){
            StringBuilder strTemp2 = partitionList.get(partitionList.size()-1);
            strTemp2.append(str.charAt(index));
            prevPalindrom = checkPalindrom(strTemp2, 0, strTemp2.length()-1);
            partitionUtil2(str, index+1, prevPalindrom, partitionList, result);
            strTemp2.deleteCharAt(strTemp2.length()-1);
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
        System.out.println("------------------------------------------------------------------------------");
        String str3="aab";
        System.out.println("Input 1 " + str3+" Output : "+PalindromePartitioning.partition2(str3));

        String str4="a";
        System.out.println("Input 1 " + str4+" Output : "+PalindromePartitioning.partition2(str4));

        String str5="aabaa";
        System.out.println("Input 1 " + str5+" Output : "+PalindromePartitioning.partition2(str5));
    }
}
