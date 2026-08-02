package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class LongestCommonSubstring {

    // Time: O(3^(m+n)) - each call branches into 3 unless chars match
    // Space: O(m+n) - recursion stack depth
    public static int longestCommonSubstring(String str1, String str2) {
        return longestCommonSubstringUtil(str1, str2, str1.length() - 1, str2.length() - 1, false);
    }

    public static int longestCommonSubstringUtil(String str1, String str2, int index1, int index2, boolean matched) {
        if (index1 < 0 || index2 < 0)
            return 0;
        int lastMatched = 0;
        if (matched && str1.charAt(index1) != str2.charAt(index2))
            return 0;
        if (str1.charAt(index1) == str2.charAt(index2)) {
            lastMatched = 1 + longestCommonSubstringUtil(str1, str2, index1 - 1, index2 - 1, true);
        }
        int index1Excluded = 0;
        int index2Excluded = 0;
        if (!matched) {
            index1Excluded = longestCommonSubstringUtil(str1, str2, index1 - 1, index2, false);
            index2Excluded = longestCommonSubstringUtil(str1, str2, index1, index2 - 1, false);
        }

        return Math.max(lastMatched, Math.max(index1Excluded, index2Excluded));
    }

    // Time: O(m*n*min(m,n)) - m*n starting cells, each recursing along a diagonal
    // of length up to min(m,n); no branching, just a straight-line chain
    // Space: O(min(m,n)) - recursion depth along a single diagonal
    public static int longestCommonSubstring2(String str1, String str2) {
        int maxLen = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                maxLen = Math.max(maxLen, longestCommonSubstringUtil2(str1, str2, i, j));
            }
        }
        return maxLen;
    }

    public static int longestCommonSubstringUtil2(String str1, String str2, int index1, int index2) {
        if (index1 < 0 || index2 < 0)
            return 0;
        if (str1.charAt(index1) != str2.charAt(index2))
            return 0;
        return 1 + longestCommonSubstringUtil2(str1, str2, index1 - 1, index2 - 1);
    }

    public static String printLongestCommonSubstring2(String str1, String str2) {
        String maxLenString = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                    String result = printLongestCommonSubstringUtil2(str1, str2, i, j);
                    if(result.length()>maxLenString.length()){
                        maxLenString = result;
                    }
            }
        }
        return maxLenString;
    }

    public static String printLongestCommonSubstringUtil2(String str1, String str2, int index1, int index2) {
        if (index1 < 0 || index2 < 0)
            return "";
        if (str1.charAt(index1) != str2.charAt(index2))
            return "";
        return printLongestCommonSubstringUtil2(str1, str2, index1 - 1, index2 - 1)+str1.charAt(index1);
    }

    // Time: O(m*n*2) - each (index1, index2, matched) state computed once
    // Space: O(2*(m*n)) dp array + O(m+n) recursion stack
    public static int longestCommonSubstringMemoization(String str1, String str2) {
        Integer[][][] dp = new Integer[str1.length()][str2.length()][2];
        longestCommonSubstringMemoizationUtil(str1, str2, str1.length() - 1, str2.length() - 1, 0, dp);
        return dp[str1.length() - 1][str2.length() - 1][0];
    }

    public static int longestCommonSubstringMemoizationUtil(String str1, String str2, int index1, int index2,
            int matched,
            Integer[][][] dp) {
        if (index1 < 0 || index2 < 0)
            return 0;
        if (dp[index1][index2][matched] != null)
            return dp[index1][index2][matched];

        int lastMatched = 0;
        if (matched == 1 && str1.charAt(index1) != str2.charAt(index2)) {
            dp[index1][index2][matched] = 0;
            return dp[index1][index2][matched];
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            lastMatched = 1 + longestCommonSubstringMemoizationUtil(str1, str2, index1 - 1, index2 - 1, 1, dp);
        }
        int index1Excluded = 0;
        int index2Excluded = 0;
        if (matched == 0) {
            index1Excluded = longestCommonSubstringMemoizationUtil(str1, str2, index1 - 1, index2, 0, dp);
            index2Excluded = longestCommonSubstringMemoizationUtil(str1, str2, index1, index2 - 1, 0, dp);
        }

        dp[index1][index2][matched] = Math.max(lastMatched, Math.max(index1Excluded, index2Excluded));
        return dp[index1][index2][matched];
    }

    // Time: O(m*n) - each (index1, index2) state computed once
    // Space: O(m*n) dp array + O(m+n) recursion stack
    public static int longestCommonSubstringMemoization2(String str1, String str2) {
        Integer[][] dp = new Integer[str1.length()][str2.length()];
        int maxLen = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                maxLen = Math.max(maxLen, longestCommonSubstringMemoizationUtil2(str1, str2, i, j, dp));
            }
        }
        return maxLen;
    }

    public static int longestCommonSubstringMemoizationUtil2(String str1, String str2, int index1, int index2,
            Integer[][] dp) {
        if (index1 < 0 || index2 < 0)
            return 0;
        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = 1 + longestCommonSubstringMemoizationUtil2(str1, str2, index1 - 1, index2 - 1, dp);
        } else {
            dp[index1][index2] = 0;
        }
        return dp[index1][index2];
    }


    public static String printLongestCommonSubstringMemoization2(String str1, String str2) {
        String[][] dp = new String[str1.length()][str2.length()];
        String maxLenString = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                String result = printLongestCommonSubstringMemoizationUtil2(str1, str2, i, j,dp);
                    if(result.length()>maxLenString.length()){
                        maxLenString = result;
                    }
            }
        }
        return maxLenString;
    }

    public static String  printLongestCommonSubstringMemoizationUtil2(String str1, String str2, int index1, int index2,
            String[][] dp) {
        if (index1 < 0 || index2 < 0)
            return "";
        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = printLongestCommonSubstringMemoizationUtil2(str1, str2, index1 - 1, index2 - 1, dp)+str1.charAt(index1);
        } else {
            dp[index1][index2] = "";
        }
        return dp[index1][index2];
    }

    // Time: O(2*m*n) - each (index1, index, matched) state computed once
    // Space: O(2*m*n) dp array
    public static int longestCommonSubstringTabulation(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty())
            return 0;
        int[][][] dp = new int[str1.length() + 1][str2.length() + 1][2];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                for (int matched = 0; matched < 2; matched++) {
                    int lastMatched = 0;
                    if (matched == 1 && str1.charAt(i - 1) != str2.charAt(j - 1)) {
                        dp[i][j][matched] = 0;
                        continue;
                    }
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        lastMatched = 1 + dp[i - 1][j - 1][1];
                    }
                    int index1Excluded = 0;
                    int index2Excluded = 0;
                    if (matched == 0) {
                        index1Excluded = dp[i - 1][j][0];
                        index2Excluded = dp[i][j - 1][0];
                    }

                    dp[i][j][matched] = Math.max(lastMatched, Math.max(index1Excluded, index2Excluded));
                }
            }
        }
        return dp[str1.length()][str2.length()][0];
    }

    // Time: O(m*n) - single pass over the 2D table, no branching/recursion
    // Space: O(m*n) dp array
    public static int longestCommonSubstringTabulation2(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
                // else dp[i][j] stays 0 - no common substring can end here
            }
        }
        return maxLen;
    }

    // Time: O(m*n) - single pass, two rolling rows
    // Space: O(n) - only current and previous row kept
    public static int longestCommonSubstringSpaceOptimised(String str1, String str2) {
        int[] prev = new int[str2.length() + 1];
        int[] curr = new int[str2.length() + 1];
        int maxLen = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    maxLen = Math.max(maxLen, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            // this swapping is correct think about it why we are doing it here
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return maxLen;
    }

    public static String printLongestCommonSubstringTabulation2(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0;
        String maxString="";

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(dp[i][j]>maxLen){
                        maxLen = dp[i][j];
                        StringBuilder strb = new StringBuilder();
                        int m=i;
                        int n=j;
                        while(m>0 && n>0 && dp[m][n]>0){
                            strb.append(str1.charAt(--m));
                            n--;
                        }
                        maxString = strb.reverse().toString();
                    }
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";

        System.out.println(longestCommonSubstring(str1, str2));
        System.out.println(longestCommonSubstring2(str1, str2));
        System.out.println(printLongestCommonSubstring2(str1, str2));

        System.out.println(longestCommonSubstringMemoization(str1, str2));
        System.out.println(longestCommonSubstringMemoization2(str1, str2));
        System.out.println(printLongestCommonSubstringMemoization2(str1, str2));

        System.out.println(longestCommonSubstringTabulation(str1, str2));
        System.out.println(longestCommonSubstringTabulation2(str1, str2));
        System.out.println(longestCommonSubstringSpaceOptimised(str1, str2));
        
        System.out.println(printLongestCommonSubstringTabulation2(str1, str2));

        System.out.println("--------------------------------------------------");
        String str11 = "abcdxyz";
        String str12 = "xyzabcd";

        System.out.println(longestCommonSubstring(str11, str12));
        System.out.println(longestCommonSubstring2(str11, str12));
        System.out.println(printLongestCommonSubstring2(str11, str12));

        System.out.println(longestCommonSubstringMemoization(str11, str12));
        System.out.println(longestCommonSubstringMemoization2(str11, str12));
        System.out.println(printLongestCommonSubstringMemoization2(str11, str12));

        System.out.println(longestCommonSubstringTabulation(str11, str12));
        System.out.println(longestCommonSubstringTabulation2(str11, str12));
        System.out.println(longestCommonSubstringSpaceOptimised(str11, str12));
        
        System.out.println(printLongestCommonSubstringTabulation2(str11, str12));

        System.out.println("--------------------------------------------------");
    }
}
