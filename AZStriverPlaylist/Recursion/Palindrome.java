package AZStriverPlaylist.Recursion;

public class Palindrome {
    public static boolean checkPalindrom(String str, int left, int right){
        if(left>=right) return true;
        if(str.charAt(left)!=str.charAt(right)) return false;
        return checkPalindrom(str, ++left, --right);
    }

    public static void main(String[] args) {
        String str1="HELLO";
        System.out.println("Input 1 " + str1+" Output : "+Palindrome.checkPalindrom(str1, 0, str1.length()-1));

        String str2="abccba";
        System.out.println("Input 1 " + str2+" Output : "+Palindrome.checkPalindrom(str2, 0, str2.length()-1));
    }
}
