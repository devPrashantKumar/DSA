package Algorithms.StringPatternMatching;

public class NaiveAlgorithm {
   /*
    * Time complexity :
    * Best Case: O(n) – if the pattern is found early.
    * Worst Case: O(n * m) – where n = source.length(), m = pattern.length().
    */
    public static int findSubstringIndex(String source, String pattern) {
        if(source.length()<pattern.length()) return -1;
        for(int i=0;i<=source.length()-pattern.length();i++){
            int j=0;
            for(;j<pattern.length();j++){
                if(source.charAt(i+j)!=pattern.charAt(j)) break;
            }
            if(j==pattern.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String pattern1 = "cde";
        System.out.println("Input : s - "+s1+" , pattern - "+pattern1);
        System.out.println("Output : " + NaiveAlgorithm.findSubstringIndex(s1,pattern1));
        System.out.println("---------------------------------------------------");
        
        String s2 = "abcde";
        String pattern2 = "afcde";
        System.out.println("Input : s - "+s2+" , pattern - "+pattern2);
        System.out.println("Output : " + NaiveAlgorithm.findSubstringIndex(s2,pattern2));
        System.out.println("---------------------------------------------------");
        
    }
}
