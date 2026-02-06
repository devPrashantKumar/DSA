package AZStriverPlaylist.Strings;

public class RotateString {
    /*
    * Time:  O(n²)
    * Space: O(n)
    */
    public static boolean rotateStringSimpleApproach(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String sTemp = s+s;
        for(int i=0;i<=sTemp.length()-goal.length();i++){
            int j=0;
            for(;j<goal.length();j++){
                if(sTemp.charAt(i+j)!=goal.charAt(j)) break;
            }
            if(j==goal.length()){
                return true;
            }
        }
        return false;
    }

    /*
    * Time:  O(n) - optimized substring search internally
    * Space: O(n)
    */
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Input : s - "+s1+" , goal - "+goal1);
        System.out.println("Output : " + RotateString.rotateString(s1,goal1));
        System.out.println("Output : " + RotateString.rotateStringSimpleApproach(s1,goal1));
        System.out.println("---------------------------------------------------");
        
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Input : s - "+s2+" , goal - "+goal2);
        System.out.println("Output : " + RotateString.rotateString(s2,goal2));
        System.out.println("Output : " + RotateString.rotateStringSimpleApproach(s2,goal2));
        System.out.println("---------------------------------------------------");
        
    }
}
