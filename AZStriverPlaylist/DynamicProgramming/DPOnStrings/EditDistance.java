package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class EditDistance {

    // Time: O(3^(n+m)) worst case, Space: O(n+m) recursion stack
    public static int minDistance(String s, String t) {
        return minDistanceUtil(s, t, s.length() - 1, t.length() - 1);
    }

    public static int minDistanceUtil(String s, String t, int sIndex, int tIndex) {
        if (tIndex < 0)
            return 1 + sIndex;
        if (sIndex < 0)
            return 1 + tIndex;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            return minDistanceUtil(s, t, sIndex - 1, tIndex - 1);
        }
        int insert = 1 + minDistanceUtil(s, t, sIndex, tIndex - 1);
        int swap = 1 + minDistanceUtil(s, t, sIndex - 1, tIndex - 1);
        int delete = 1 + minDistanceUtil(s, t, sIndex - 1, tIndex);
        return Math.min(insert, Math.min(swap, delete));
    }

    // Time: O(n*m), Space: O(n*m) dp + O(n+m) recursion stack
    public static int numDistinctMemoization(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return numDistinctUtilMemoization(s, t, s.length() - 1, t.length() - 1, dp);
    }

    public static Integer numDistinctUtilMemoization(String s, String t, int sIndex, int tIndex, Integer[][] dp) {
        if (tIndex < 0) return 1 + sIndex;
        if (sIndex < 0) return 1 + tIndex;
        if (dp[sIndex][tIndex] != null) return dp[sIndex][tIndex];

        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            dp[sIndex][tIndex] = numDistinctUtilMemoization(s, t, sIndex - 1, tIndex - 1,dp);
        } else {
            int insert = 1 + numDistinctUtilMemoization(s, t, sIndex, tIndex - 1,dp);
            int swap = 1 + numDistinctUtilMemoization(s, t, sIndex - 1, tIndex - 1,dp);
            int delete = 1 + numDistinctUtilMemoization(s, t, sIndex - 1, tIndex,dp);
            dp[sIndex][tIndex] = Math.min(insert, Math.min(swap, delete));
        }
        return dp[sIndex][tIndex];

    }

    // Time: O(n*m), Space: O(n*m) dp table
    public static int numDistinctTabulation(String s, String t) {
        Integer[][] dp = new Integer[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= t.length(); i++)
            dp[0][i] = i;
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i - 1][j]));
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    // Time: O(n*m), Space: O(m) single 1D array
    public static int numDistinctSpaceOptimized(String s, String t) {
        int[] dp = new int[t.length() + 1];
        for (int i = 0; i <= t.length(); i++) dp[i] = i;
        for (int i = 1; i <= s.length(); i++) {
            int diagonal = dp[0];
            dp[0] = i;
            for (int j = 1; j <= t.length(); j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = diagonal;
                }else{
                    dp[j] = 1+Math.min(dp[j-1],Math.min(diagonal,dp[j]));
                }
                diagonal = temp;
            }
        }
        return dp[t.length()];
    }

    public static void main(String[] args) {
        String str1 = "horse";
        String target1 = "ros";

        System.out.println(minDistance(str1, target1));
        System.out.println(numDistinctMemoization(str1, target1));
        System.out.println(numDistinctTabulation(str1, target1));
        System.out.println(numDistinctSpaceOptimized(str1, target1));

        System.out.println("--------------------------------------------------");
        String str11 = "intention";
        String target12 = "execution";

        System.out.println(minDistance(str11, target12));
        System.out.println(numDistinctMemoization(str11, target12));
        System.out.println(numDistinctTabulation(str11, target12));
        System.out.println(numDistinctSpaceOptimized(str11, target12));

        System.out.println("--------------------------------------------------");
    }
}
