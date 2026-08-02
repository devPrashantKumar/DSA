package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class MinimumInsertionsToMakeStringPalindrome {


    public static int minimumInsertionsToMakeStringPalindrome(String str1) {
        return str1.length() - LongestPalindromicSubsequence.longestPalindromicSubsequence(str1);
    }

    public static int minimumInsertionsToMakeStringPalindromeMemoization(String str1) {
        return str1.length() - LongestPalindromicSubsequence.longestPalindromicSubsequenceMemoization(str1);
    }

    public static int minimumInsertionsToMakeStringPalindromeTabulation(String str1) {
        return str1.length() - LongestPalindromicSubsequence.longestPalindromicSubsequenceTabulation(str1);
    }

    public static int minimumInsertionsToMakeStringPalindromeTabulationSpaceOptimised(String str1) {
        return str1.length() - LongestPalindromicSubsequence.longestPalindromicSubsequenceTabulationSpaceOptimised(str1);
    }


    public static void main(String[] args) {
        String str1 = "bdefgedb";

        System.out.println(minimumInsertionsToMakeStringPalindrome(str1));
        System.out.println(minimumInsertionsToMakeStringPalindromeMemoization(str1));
        System.out.println(minimumInsertionsToMakeStringPalindromeTabulation(str1));
        System.out.println(minimumInsertionsToMakeStringPalindromeTabulationSpaceOptimised(str1));

        System.out.println("--------------------------------------------------");
        String str11 = "mnop";

        System.out.println(minimumInsertionsToMakeStringPalindrome(str11));
        System.out.println(minimumInsertionsToMakeStringPalindromeMemoization(str11));
        System.out.println(minimumInsertionsToMakeStringPalindromeTabulation(str11));
        System.out.println(minimumInsertionsToMakeStringPalindromeTabulationSpaceOptimised(str11));

        System.out.println("--------------------------------------------------");
    }
}
