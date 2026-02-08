package AZStriverPlaylist.Strings.Medium;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int start=0,end=0,maxLength=0;
        for(int i=0;i<s.length();i++){
            int includeCenterPalindromLength = 1+palindromeLenthIterative(s,i-1,i+1);
            int simplePalindromLength = palindromeLenthIterative(s,i,i+1);
            int length = Math.max(includeCenterPalindromLength,simplePalindromLength);
            if(maxLength<length){
                start = i-((length-1)/2);
                end = i + length / 2;
                maxLength = length;
            }
        }
        return s.substring(start,end+1);
    }

    // recursive approach
    public static int palindromeLenth(String s, int left, int right){
        if(left<0 || right >= s.length() || s.charAt(left)!=s.charAt(right)) return 0;
        else return 2+palindromeLenth(s, left-1, right+1);
    }

    public static int palindromeLenthIterative(String s, int left, int right){
        int length=0;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                length = length+2;
                left--;
                right++;
            } 
            else break;
            
        }
        return length;
    }


    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println("input : "+s1+" output : "+longestPalindrome(s1));
        System.out.println("-----------------------------------------------------");
        String s2 = "cbbd";
        System.out.println("input : "+s2+" output : "+longestPalindrome(s2));
        System.out.println("-----------------------------------------------------");
    }
}