package AZStriverPlaylist.BeginnerProblems.BasicStrings;

public class PalindromeCheck {

    /*
    * Recursive Approach
    *
    * Time Complexity: O(N)
    * Space Complexity: O(N) - Character Array + Recursion Stack
    */
    public static boolean palindromeCheck(String s) {
        return palindromeCheckUtil(s.toCharArray(), 0, s.length()-1);
    }

    public static boolean palindromeCheckUtil(char[] s, int left, int right) {
        if(left>=right) return true;
        if(s[left]!=s[right]) return false;
        return palindromeCheckUtil(s, left+1, right-1);
    }

    /*
    * Iterative Approach
    *
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    */
    public static boolean palindromeCheckIterative(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String input1 = "tree";
        System.out.println("Input : "+input1+" Output : "+palindromeCheck(input1));
        System.out.println("Input : "+input1+" Output : "+palindromeCheckIterative(input1));

        String input2 = "hannah";
        System.out.println("Input : "+input2+" Output : "+palindromeCheck(input2));
        System.out.println("Input : "+input2+" Output : "+palindromeCheckIterative(input2));

        String input3 = "aabbaaa";
        System.out.println("Input : "+input3+" Output : "+palindromeCheck(input3));
        System.out.println("Input : "+input3+" Output : "+palindromeCheckIterative(input3));

    }
}
