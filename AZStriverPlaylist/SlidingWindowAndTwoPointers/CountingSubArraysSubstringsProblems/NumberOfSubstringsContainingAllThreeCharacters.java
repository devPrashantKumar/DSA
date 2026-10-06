package AZStriverPlaylist.SlidingWindowAndTwoPointers.CountingSubArraysSubstringsProblems;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int stringsCount=0;
        int i=0;
        while(i<s.length()){
            int count=0;
            int[] charMap = new int[3];
            for(int j=0;j<3;j++) charMap[j]++;
            for(int j=i;j<s.length();j++){
                if(charMap[s.charAt(j)-'a']>0) count++;
                charMap[s.charAt(j)-'a']--;
                if(count==3){
                    stringsCount += (s.length()-j);
                    break;
                }
            }
            i++;
        }
        return stringsCount;
    }

    public static int numberOfSubstrings2(String s) {
        int stringsCount=0;
        int i=0;
        int j=0;
        int count=0;
        int[] charMap = new int[3];
        for(int k=0;k<3;k++) charMap[k]++;
        while(j<s.length()){
            if(charMap[s.charAt(j)-'a']>0) count++;
            charMap[s.charAt(j)-'a']--;
            while(count==3){
                stringsCount += (s.length()-j);
                if(charMap[s.charAt(i)-'a']==0) count--;
                charMap[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return stringsCount;
    }

    public static void main(String[] args) {
        String s1 = "abcba";
        String s2 = "ccabcc";

        System.out.println("Input String : " + s1 + " Output : "+ numberOfSubstrings(s1));
        System.out.println("Input String : " + s1 + " Output : "+ numberOfSubstrings2(s1));

        System.out.println("---------------------------------------------------------");
        System.out.println("Input String : " + s2 + " Output : "+ numberOfSubstrings(s2));
        System.out.println("Input String : " + s2 + " Output : "+ numberOfSubstrings2(s2));
    }
}
