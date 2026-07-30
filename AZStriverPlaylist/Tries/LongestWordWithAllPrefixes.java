package AZStriverPlaylist.Tries;

import java.util.Arrays;

public class LongestWordWithAllPrefixes {
    class TrieNode{
        TrieNode [] childrenCharacter;
        boolean endNode;

        TrieNode(){
            childrenCharacter = new TrieNode[26];
            endNode=false;
        }

        public boolean containsKey(char c){
            return childrenCharacter[c-'a']!=null;
        }

        public TrieNode get(char c){
            return childrenCharacter[c-'a'];
        }

        public void put(char c){
            childrenCharacter[c-'a'] = new TrieNode();
        }

        public boolean isEndNode(){
            return endNode;
        }
    }

    TrieNode root;

    LongestWordWithAllPrefixes(){
        root = new TrieNode();
    }

    public void insert(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                node.put(str.charAt(i));
            }
            node = node.get(str.charAt(i));
        }
        node.endNode=true;
    }
    
    public int longestWordWithAllPrefixes(){
        return longestWordWithAllPrefixes(root, 0);
    }

    public int longestWordWithAllPrefixes(TrieNode node, int length){
        int maxLength=length;
        for(int i=0;i<26;i++){
            if(node.childrenCharacter[i]!=null){
                if(node.childrenCharacter[i].isEndNode()){
                    int suffixMaxLength = longestWordWithAllPrefixes(node.childrenCharacter[i],length+1);
                    maxLength = Math.max(maxLength, suffixMaxLength);
                }
            }
        }
        return maxLength;
    }

    public String longestWordWithAllPrefixesWord(){
        StringBuilder result = new StringBuilder();
        longestWordWithAllPrefixesWord(root, new StringBuilder(),result);
        return result.toString();
    }

    public void longestWordWithAllPrefixesWord(TrieNode node, StringBuilder strb, StringBuilder result){
        for(int i=0;i<26;i++){
            if(node.childrenCharacter[i]!=null){
                if(node.childrenCharacter[i].isEndNode()){
                    strb.append((char)('a'+i));
                    longestWordWithAllPrefixesWord(node.childrenCharacter[i],strb, result);
                    if(strb.length()>result.length()){
                        result.setLength(0);
                        result.append(strb);
                    }
                    strb.deleteCharAt(strb.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] nums = { "n", "ni", "nin", "ninj" , "ninja" , "nil" };
        LongestWordWithAllPrefixes longestWordWithAllPrefixes = new LongestWordWithAllPrefixes();
        Arrays.stream(nums).forEachOrdered(longestWordWithAllPrefixes::insert);
        System.out.println(longestWordWithAllPrefixes.longestWordWithAllPrefixes());
        System.out.println(longestWordWithAllPrefixes.longestWordWithAllPrefixesWord());
        System.out.println("----------------------------------------------------------------------");

        String[] nums2 = { "ninja" , "night" , "nil" };
        LongestWordWithAllPrefixes longestWordWithAllPrefixes2 = new LongestWordWithAllPrefixes();
        Arrays.stream(nums2).forEachOrdered(longestWordWithAllPrefixes2::insert);
        System.out.println(longestWordWithAllPrefixes2.longestWordWithAllPrefixes());
        System.out.println(longestWordWithAllPrefixes2.longestWordWithAllPrefixesWord());
        System.out.println("----------------------------------------------------------------------");

    }
}
