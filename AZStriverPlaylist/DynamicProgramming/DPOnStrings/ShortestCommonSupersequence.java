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

    public static String shortestCommonSupersequence2(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        StringBuilder strb = new StringBuilder();
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                strb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]){
                    strb.append(str1.charAt(i-1));
                    i--;
                }
                else{
                    strb.append(str2.charAt(j-1));
                    j--;
                }
            }

        }
        while (i > 0) {
            strb.append(str1.charAt(i-1));
            i--;    
        }
        while (j > 0) {            
            strb.append(str2.charAt(j-1));
            j--;
        }
        return strb.reverse().toString();
    }


    public static void main(String[] args) {
        String str1 = "mno";
        String str2 = "nop";

        System.out.println(shortestCommonSupersequence(str1,str2));
        System.out.println(shortestCommonSupersequence2(str1,str2));

        System.out.println("--------------------------------------------------");
        String str11 = "dynamic";
        String str12 = "program";

        System.out.println(shortestCommonSupersequence(str11,str12));
        System.out.println(shortestCommonSupersequence2(str11,str12));

        System.out.println("--------------------------------------------------");
    }
}
