package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class WildcardMatching {

    // Time: O(3^(n+m)) worst case, Space: O(n+m) recursion stack
    public static boolean isMatch(String s, String p) {
        return isMatchUtil(s, p, s.length() - 1, p.length() - 1);
    }

    public static boolean isMatchUtil(String s, String p, int sIndex, int pIndex) {
        if (pIndex < 0 && sIndex < 0)
            return true;
        if (pIndex < 0 && sIndex >= 0)
            return false;
        if (sIndex < 0) {
            for (int i = 0; i <= pIndex; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if (p.charAt(pIndex) == '*') {
            return isMatchUtil(s, p, sIndex, pIndex - 1) || isMatchUtil(s, p, sIndex - 1, pIndex);
        }
        if (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex)) {
            return isMatchUtil(s, p, sIndex - 1, pIndex - 1);
        } else {
            return false;
        }
    }

    public static boolean isMatchMemoization(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        isMatchMemoizationUtil(s, p, s.length() - 1, p.length() - 1,dp);
        return dp[s.length()-1][p.length()-1];
    }

    public static boolean isMatchMemoizationUtil(String s, String p, int sIndex, int pIndex, Boolean[][] dp ) {
        if (pIndex < 0 && sIndex < 0)
            return true;
        if (pIndex < 0 && sIndex >= 0)
            return false;
        if (sIndex < 0) {
            for (int i = 0; i <= pIndex; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if(dp[sIndex][pIndex]!=null) return dp[sIndex][pIndex];

        if (p.charAt(pIndex) == '*') {
            dp[sIndex][pIndex]  = isMatchMemoizationUtil(s, p, sIndex, pIndex - 1,dp) || isMatchMemoizationUtil(s, p, sIndex - 1, pIndex,dp);
        }
        else if (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex)) {
            dp[sIndex][pIndex]  =  isMatchMemoizationUtil(s, p, sIndex - 1, pIndex - 1,dp);
        } else{
            dp[sIndex][pIndex] = false;
        }
            
        return dp[sIndex][pIndex];
    }

    public static boolean isMatchTabulation(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int i = 1;
        while (i <= p.length() && p.charAt(i - 1) == '*') {
            dp[0][i++] = true;
        }
        for (; i <= p.length(); i++)
            dp[0][i] = false;
        for (int j = 1; j <= s.length(); j++)
            dp[j][0] = false;

        for (int j = 1; j <= s.length(); j++) {
            for (int k = 1; k <= p.length(); k++) {
                if (p.charAt(k-1) == '*') {
                    dp[j][k] = dp[j][k - 1] || dp[j - 1][k];
                } else if (p.charAt(k-1) == '?' || s.charAt(j-1) == p.charAt(k-1)) {
                    dp[j][k] = dp[j - 1][k - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static boolean isMatchTabulationSpaceOptimised(String s, String p) {
        boolean[] dp = new boolean[p.length() + 1];
        dp[0] = true;
        int i = 1;
        while (i <= p.length() && p.charAt(i - 1) == '*') {
            dp[i++] = true;
        }
        for (; i <= p.length(); i++)
            dp[i] = false;

        for (int j = 1; j <= s.length(); j++) {
            boolean diagonal = dp[0];
            dp[0]=false;
            for (int k = 1; k <= p.length(); k++) {
                boolean temp = dp[k];
                if (p.charAt(k-1) == '*') {
                    dp[k] = dp[k - 1] || dp[k];
                } else if (p.charAt(k-1) == '?' || s.charAt(j-1) == p.charAt(k-1)) {
                    dp[k] = diagonal;
                } else {
                    dp[k] = false;
                }
                diagonal = temp;
            }
        }
        return dp[p.length()];
    }

    public static void main(String[] args) {
        String str1 = "aa";
        String target1 = "a";

        System.out.println(isMatch(str1, target1));
        System.out.println(isMatchMemoization(str1, target1));
        System.out.println(isMatchTabulation(str1, target1));
        System.out.println(isMatchTabulationSpaceOptimised(str1, target1));

        System.out.println("--------------------------------------------------");
        String str11 = "aa";
        String target12 = "*";

        System.out.println(isMatch(str11, target12));
        System.out.println(isMatchMemoization(str11, target12));
        System.out.println(isMatchTabulation(str11, target12));
        System.out.println(isMatchTabulationSpaceOptimised(str11, target12));

        System.out.println("--------------------------------------------------");

        String str21 = "cb";
        String target22 = "?a";

        System.out.println(isMatch(str21, target22));
        System.out.println(isMatchMemoization(str21, target22));
        System.out.println(isMatchTabulation(str21, target22));
        System.out.println(isMatchTabulationSpaceOptimised(str21, target22));

        System.out.println("--------------------------------------------------");
    }
}
