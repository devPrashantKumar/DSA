package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class ShortestCommonSupersequence {

    public static String shortestCommonSupersequence(String str1, String str2) {
        String commonSubsequence = PrintLongestCommonSubsequence.longestCommonSubsequenceUsingTabulation(str1, str2);
        StringBuilder strb = new StringBuilder();
        int m=0;
        int n=0;
        for(int i=0;i<commonSubsequence.length();i++){
            while(m<str1.length() && str1.charAt(m)!=commonSubsequence.charAt(i)) strb.append(str1.charAt(m++));
            while(n<str2.length() && str2.charAt(n)!=commonSubsequence.charAt(i)) strb.append(str2.charAt(n++));
            strb.append(commonSubsequence.charAt(i));
            m++;
            n++;
        }
        while(m<str1.length()) strb.append(str1.charAt(m++));
        while(n<str2.length()) strb.append(str2.charAt(n++));
        return strb.toString();
    }


    public static void main(String[] args) {
        String str1 = "mno";
        String str2 = "nop";

        System.out.println(shortestCommonSupersequence(str1,str2));

        System.out.println("--------------------------------------------------");
        String str11 = "dynamic";
        String str12 = "program";

        System.out.println(shortestCommonSupersequence(str11,str12));

        System.out.println("--------------------------------------------------");
    }
}
