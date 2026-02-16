package AZStriverPlaylist.Recursion;

import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakUtil(s, wordDict, -1);
    }

    public static boolean wordBreakUtil(String s, List<String> wordDict, int index) {
        int n = s.length();
        if(index==n-1){
            return true;
        }
        for(int i=index+1;i<n;i++){
            String s2 = s.substring(index+1,i+1);
            if(wordDict.contains(s2)){
                boolean partition = wordBreakUtil(s, wordDict, i);
                if(partition) return partition;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 ="takeuforward";
        List<String> wordDict1 = List.of("take" , "forward" , "you", "u");
        System.out.println("input : s -> "+s1+" wordDict -> "+wordDict1);
        System.out.println("output : "+wordBreak(s1,wordDict1));
        System.out.println("-------------------------------------------------------");
        String s2 ="applepineapple";
        List<String> wordDict2 = List.of("apple");
        System.out.println("input : s -> "+s2+" wordDict -> "+wordDict2);
        System.out.println("output : "+wordBreak(s2,wordDict2));
        System.out.println("-------------------------------------------------------");
    }
}
