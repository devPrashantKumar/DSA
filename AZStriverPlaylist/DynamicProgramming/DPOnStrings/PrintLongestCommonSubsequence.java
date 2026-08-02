package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {

    // Time: O(2^(m+n)) - each call branches into 2 unless chars match
    // Space: O(m+n) - recursion stack depth
    public static String longestCommonSubsequence(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        longestCommonSubsequenceUtil(str1, str2, str1.length() - 1, str2.length() - 1, new StringBuilder(), result);
        return result.reverse().toString();
    }

    public static void longestCommonSubsequenceUtil(String str1, String str2, int index1, int index2,
            StringBuilder strb, StringBuilder result) {
        if (index1 < 0 || index2 < 0) {
            if (strb.length() > result.length()) {
                result.setLength(0);
                result.append(strb);
            }
            return;
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            strb.append(str1.charAt(index1));
            longestCommonSubsequenceUtil(str1, str2, index1 - 1, index2 - 1, strb, result);
            strb.deleteCharAt(strb.length() - 1);
            return;
        }
        longestCommonSubsequenceUtil(str1, str2, index1 - 1, index2, strb, result);
        longestCommonSubsequenceUtil(str1, str2, index1, index2 - 1, strb, result);
    }

    // Time: O(2^(m+n)) - each call branches into 2 unless chars match
    // Space: O(m+n) - recursion stack depth
    public static String longestCommonSubsequence2(String str1, String str2) {
        return longestCommonSubsequenceUtil2(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    public static String longestCommonSubsequenceUtil2(String str1, String str2, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return "";
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            return longestCommonSubsequenceUtil2(str1, str2, index1 - 1, index2 - 1)+str1.charAt(index1);
        }
        String skipFromStr1 = longestCommonSubsequenceUtil2(str1, str2, index1 - 1, index2);
        String skipFromStr2 = longestCommonSubsequenceUtil2(str1, str2, index1, index2 - 1);
        return (skipFromStr1.length() >= skipFromStr2.length()) ? skipFromStr1 : skipFromStr2;
    }

    // Time: O(m*n*min(m,n)) - m*n states, each doing O(min(m,n)) string concat/comparison
    // Space: O(m*n*min(m,n)) - dp cache stores a string (up to length min(m,n)) per state
    public static String longestCommonSubsequenceMemoization(String str1, String str2) {
        String[][] dp = new String[str1.length()][str2.length()];
        return longestCommonSubsequenceMemoizationUtil(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }

    public static String longestCommonSubsequenceMemoizationUtil(String str1, String str2, int index1, int index2, String[][] dp) {
        if (index1 < 0 || index2 < 0) return "";
        if (dp[index1][index2] != null) return dp[index1][index2];

        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = longestCommonSubsequenceMemoizationUtil(str1, str2, index1 - 1, index2 - 1, dp) + str1.charAt(index1);
        } else {
            String skipFromStr1 = longestCommonSubsequenceMemoizationUtil(str1, str2, index1 - 1, index2, dp);
            String skipFromStr2 = longestCommonSubsequenceMemoizationUtil(str1, str2, index1, index2 - 1, dp);
            dp[index1][index2] = (skipFromStr1.length() >= skipFromStr2.length()) ? skipFromStr1 : skipFromStr2;
        }
        return dp[index1][index2];
    }

    // Time: O(m*n) - table build O(m*n) + backtrack O(m+n)
    // Space: O(m*n) dp array
    public static String longestCommonSubsequenceUsingTabulation(String str1, String str2) {
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
        // System.out.println(Arrays.deepToString(dp));
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                strb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1])
                    i--;
                else
                    j--;
            }

        }
        return strb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";

        System.out.println(longestCommonSubsequence(str1, str2));
        System.out.println(longestCommonSubsequence2(str1, str2));

        System.out.println(longestCommonSubsequenceMemoization(str1, str2));
        System.out.println(longestCommonSubsequenceUsingTabulation(str1, str2));

        System.out.println("--------------------------------------------------");
        String str11 = "mnop";
        String str12 = "mnq";

        System.out.println(longestCommonSubsequence(str11, str12));
        System.out.println(longestCommonSubsequence2(str11, str12));

        System.out.println(longestCommonSubsequenceMemoization(str11, str12));
        System.out.println(longestCommonSubsequenceUsingTabulation(str11, str12));

        System.out.println("--------------------------------------------------");

    }
}
