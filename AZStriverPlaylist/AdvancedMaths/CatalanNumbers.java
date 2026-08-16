package AZStriverPlaylist.AdvancedMaths;

public class CatalanNumbers {

    public static long catalan(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalan(n)); // 42
    }
}