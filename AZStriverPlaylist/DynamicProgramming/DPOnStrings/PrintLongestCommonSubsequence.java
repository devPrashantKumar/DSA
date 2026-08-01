package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class PrintLongestCommonSubsequence {
    public static String longestCommonSubsequence(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        longestCommonSubsequenceUtil(str1, str2, str1.length() - 1, str2.length() - 1, new StringBuilder(), result);
        return result.reverse().toString();
    }

    public static void longestCommonSubsequenceUtil(String str1, String str2, int index1, int index2, StringBuilder strb, StringBuilder result) {
        if (index1 < 0 || index2 < 0){
            if(strb.length()>result.length()){
                result.setLength(0);
                result.append(strb);
            }
            return;
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            strb.append(str1.charAt(index1));
            longestCommonSubsequenceUtil(str1, str2, index1 - 1, index2 - 1, strb, result);
            strb.deleteCharAt(strb.length()-1);
            return;
        }
        longestCommonSubsequenceUtil(str1, str2, index1 - 1, index2, strb, result);
        longestCommonSubsequenceUtil(str1, str2, index1, index2 - 1, strb, result);
    }

    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";

        System.out.println(longestCommonSubsequence(str1, str2));

        System.out.println("--------------------------------------------------");
        String str11 = "mnop";
        String str12 = "mnq";

        System.out.println(longestCommonSubsequence(str11, str12));
       
        System.out.println("--------------------------------------------------");
    
    }
}
