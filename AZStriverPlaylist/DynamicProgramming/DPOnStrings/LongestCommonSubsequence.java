package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class LongestCommonSubsequence {

    // Time: O(2^(m+n)) - each call branches into 2 unless chars match
    // Space: O(m+n) - recursion stack depth
    public static int longestCommonSubsequence(String str1, String str2) {
        return longestCommonSubsequenceUtil(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    private static int longestCommonSubsequenceUtil(String str1, String str2, int index1, int index2) {
        if (index1 < 0 || index2 < 0)
            return 0;
        if (str1.charAt(index1) == str2.charAt(index2)) {
            return 1 + longestCommonSubsequenceUtil(str1, str2, index1 - 1, index2 - 1);
        }
        return Math.max(longestCommonSubsequenceUtil(str1, str2, index1 - 1, index2),
                longestCommonSubsequenceUtil(str1, str2, index1, index2 - 1));
    }

    // Time: O(m*n) - each (index1, index2) state computed once
    // Space: O(m*n) dp array + O(m+n) recursion stack
    public static int longestCommonSubsequenceMemoization(String str1, String str2) {
        Integer[][] dp = new Integer[str1.length()][str2.length()];
        longestCommonSubsequenceMemoizationUtil(str1, str2, str1.length() - 1, str2.length() - 1, dp);
        return dp[str1.length() - 1][str2.length() - 1];
    }

    private static int longestCommonSubsequenceMemoizationUtil(String str1, String str2, int index1, int index2,
            Integer[][] dp) {
        if (index1 < 0 || index2 < 0)
            return 0;
        if (dp[index1][index2] != null)
            return dp[index1][index2];
        if (str1.charAt(index1) == str2.charAt(index2)) {
            dp[index1][index2] = 1 + longestCommonSubsequenceMemoizationUtil(str1, str2, index1 - 1, index2 - 1, dp);
        } else {
            dp[index1][index2] = Math.max(longestCommonSubsequenceMemoizationUtil(str1, str2, index1 - 1, index2, dp),
                    longestCommonSubsequenceMemoizationUtil(str1, str2, index1, index2 - 1, dp));
        }
        return dp[index1][index2];
    }

    // Time: O(m*n) - each (index1, index2) state computed once
    // Space: O(m*n) dp array
    public static int longestCommonSubsequenceTabulation(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty())
            return 0;
        Integer[][] dp = new Integer[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0))
                dp[i][0] = 1;
            else
                dp[i][0] = (i > 0) ? dp[i - 1][0] : 0;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(0))
                dp[0][i] = 1;
            else
                dp[0][i] = (i > 0) ? dp[0][i - 1] : 0;
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }

    // Time: O(m*n) - each (index1, index2) state computed once
    // Space: O(m*n) dp array
    public static int longestCommonSubsequenceTabulation2(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) return 0;
        Integer[][] dp = new Integer[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) dp[i][0] = 0;
        for (int i = 0; i <= str2.length(); i++) dp[0][i] = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }


    // Time: O(m*n) - each (index1, index2) state computed once
    // Space: O(m) dp array
    public static int longestCommonSubsequenceTabulationSpaceOptimised(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) return 0;
        Integer[] dp = new Integer[str1.length() + 1];
        for (int i = 0; i <= str1.length(); i++) dp[i] = 0;

        for (int j = 1; j <= str2.length(); j++) {
            int prevDiagonal=0;
            for (int i = 1; i <= str1.length(); i++) {
                int temp = dp[i];
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i] = 1 + prevDiagonal;
                else
                    dp[i]= Math.max(dp[i], dp[i-1]);
                prevDiagonal = temp;
                
            }
        }
        return dp[str1.length()];
    }

    public static void main(String[] args) {
        String str1 = "bdefg";
        String str2 = "bfg";

        System.out.println(longestCommonSubsequence(str1, str2));
        System.out.println(longestCommonSubsequenceMemoization(str1, str2));
        System.out.println(longestCommonSubsequenceTabulation(str1, str2));
        System.out.println(longestCommonSubsequenceTabulation2(str1, str2));
        System.out.println(longestCommonSubsequenceTabulationSpaceOptimised(str1, str2));

        System.out.println("--------------------------------------------------");
        String str11 = "mnop";
        String str12 = "mnq";

        System.out.println(longestCommonSubsequence(str11, str12));
        System.out.println(longestCommonSubsequenceMemoization(str11, str12));
        System.out.println(longestCommonSubsequenceTabulation(str11, str12));
        System.out.println(longestCommonSubsequenceTabulation2(str11, str12));
        System.out.println(longestCommonSubsequenceTabulationSpaceOptimised(str11, str12));

        System.out.println("--------------------------------------------------");
    }
}
