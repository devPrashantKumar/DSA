package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class MinimumInsertionsOrDeletionsToConvertStringAToB {


    public static int minimumInsertionsOrDeletionsToConvertStringAToB(String str1, String str2) {
        return str1.length()+str2.length() - (2*LongestCommonSubsequence.longestCommonSubsequence(str1, str2));
    }

    public static int minimumInsertionsOrDeletionsToConvertStringAToBMemoization(String str1, String str2) {
        return str1.length()+str2.length() - (2*LongestCommonSubsequence.longestCommonSubsequenceMemoization(str1, str2));
    }

    public static int minimumInsertionsOrDeletionsToConvertStringAToBTabulation(String str1, String str2) {
        return str1.length()+str2.length() - (2*LongestCommonSubsequence.longestCommonSubsequenceTabulation(str1, str2));
    }

    public static int minimumInsertionsOrDeletionsToConvertStringAToBTabulationSpaceOptimised(String str1, String str2) {
        return str1.length()+str2.length() - (2*LongestCommonSubsequence.longestCommonSubsequenceTabulationSpaceOptimised(str1, str2));
    }

    public static void main(String[] args) {
        String str1 = "sea";
        String str2 = "eat";

        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToB(str1,str2));
        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToBMemoization(str1,str2));
        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToBTabulation(str1,str2));
        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToBTabulationSpaceOptimised(str1,str2));

        System.out.println("--------------------------------------------------");
        String str11 = "leetcode";
        String str12 = "etco";

        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToB(str11,str12));
        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToBMemoization(str11,str12));
        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToBTabulation(str11,str12));
        System.out.println(minimumInsertionsOrDeletionsToConvertStringAToBTabulationSpaceOptimised(str11,str12));

        System.out.println("--------------------------------------------------");
    }
}
