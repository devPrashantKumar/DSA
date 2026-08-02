package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class LongestPalindromicSubsequence {


    public static int longestPalindromicSubsequence(String str1) {
        return LongestCommonSubsequence.longestCommonSubsequence(str1, new StringBuilder(str1).reverse().toString());
    }

    public static int longestPalindromicSubsequenceMemoization(String str1) {
        return LongestCommonSubsequence.longestCommonSubsequenceMemoization(str1, new StringBuilder(str1).reverse().toString());
    }

    public static int longestPalindromicSubsequenceTabulation(String str1) {
        return LongestCommonSubsequence.longestCommonSubsequenceTabulation(str1, new StringBuilder(str1).reverse().toString());
    }

    public static int longestPalindromicSubsequenceTabulationSpaceOptimised(String str1) {
        return LongestCommonSubsequence.longestCommonSubsequenceTabulationSpaceOptimised(str1, new StringBuilder(str1).reverse().toString());
    }

    public static String printLongestPalindromicSubsequenceUsingTabulation(String str1) {
        return PrintLongestCommonSubsequence.longestCommonSubsequenceUsingTabulation(str1, new StringBuilder(str1).reverse().toString());
    }


    public static void main(String[] args) {
        String str1 = "bdefgedb";

        System.out.println(longestPalindromicSubsequence(str1));
        System.out.println(longestPalindromicSubsequenceMemoization(str1));
        System.out.println(longestPalindromicSubsequenceTabulation(str1));
        System.out.println(longestPalindromicSubsequenceTabulationSpaceOptimised(str1));
        System.out.println(printLongestPalindromicSubsequenceUsingTabulation(str1));

        System.out.println("--------------------------------------------------");
        String str11 = "mnop";

        System.out.println(longestPalindromicSubsequence(str11));
        System.out.println(longestPalindromicSubsequenceMemoization(str11));
        System.out.println(longestPalindromicSubsequenceTabulation(str11));
        System.out.println(longestPalindromicSubsequenceTabulationSpaceOptimised(str11));
        System.out.println(printLongestPalindromicSubsequenceUsingTabulation(str11));

        System.out.println("--------------------------------------------------");
    }
}
