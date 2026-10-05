package AZStriverPlaylist.SlidingWindowAndTwoPointers;

public class MinimumWindowSubstring {
    /*
    * Time Complexity : O(n^2)
    * Space Complexity : O(m)
    */
    public static String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        int sIndex=-1;
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<(s.length()-t.length()+1);i++){
            int count=0;
            int[] charMap = new int[26];
            for(int j=0;j<t.length();j++) charMap[t.charAt(j)-'A']++;
            for(int j=i;j<s.length();j++){
                if(charMap[s.charAt(j)-'A']>0) count++;
                charMap[s.charAt(j)-'A']--;
                if(count==t.length()){
                    if(minLength>j-i+1){
                        sIndex=i;
                        minLength=(j-i+1);
                    }
                    break;
                }
            }
        }
        return s.substring(sIndex, sIndex+minLength);
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(m)
    */
    public static String minWindow2(String s, String t) {
        if(t.isEmpty()) return "";
        int sIndex=-1;
        int minLength=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int count=0;
        int[] charMap = new int[26];
        for(int k=0;k<t.length();k++) charMap[t.charAt(k)-'A']++;
        while(j<s.length()){
            if(charMap[s.charAt(j)-'A']>0) count++;
            charMap[s.charAt(j)-'A']--;
            while(count==t.length()){
                if(minLength>j-i+1){
                    sIndex=i;
                    minLength=(j-i+1);
                }
                if(charMap[s.charAt(i)-'A']==0) count--;
                charMap[s.charAt(i)-'A']++;
                i++;
            }
            j++;
        }
        return s.substring(sIndex, sIndex+minLength);
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String s2 = "A";
        String t2 = "A";

        System.out.println("Input String : " + s1 + " Output : "+ minWindow(s1, t1));
        System.out.println("Input String : " + s1 + " Output : "+ minWindow2(s1, t1));

        System.out.println("---------------------------------------------------------");
        System.out.println("Input String : " + s2 + " Output : "+ minWindow(s2, t2));
        System.out.println("Input String : " + s2 + " Output : "+ minWindow2(s2, t2));
    }
}
