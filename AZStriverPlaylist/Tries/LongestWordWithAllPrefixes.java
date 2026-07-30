package AZStriverPlaylist.Tries;

import java.util.Arrays;

public class LongestWordWithAllPrefixes {
    class TrieNode {
        TrieNode[] childrenCharacter;
        boolean endNode;

        // Time: O(1) (fixed 26-letter alphabet) | Space: O(1) — 26-slot array per node
        TrieNode() {
            childrenCharacter = new TrieNode[26];
            endNode = false;
        }

        // Time: O(1) | Space: O(1)
        public boolean containsKey(char c) {
            return childrenCharacter[c - 'a'] != null;
        }

        // Time: O(1) | Space: O(1)
        public TrieNode get(char c) {
            return childrenCharacter[c - 'a'];
        }

        // Time: O(1) | Space: O(1) extra (one new TrieNode allocated)
        public void put(char c) {
            childrenCharacter[c - 'a'] = new TrieNode();
        }

        // Time: O(1) | Space: O(1)
        public boolean isEndNode() {
            return endNode;
        }
    }

    TrieNode root;

    LongestWordWithAllPrefixes() {
        root = new TrieNode();
    }

    // Time: O(L) — L = str.length() | Space: O(L) worst case (a new node per character)
    public void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.containsKey(str.charAt(i))) {
                node.put(str.charAt(i));
            }
            node = node.get(str.charAt(i));
        }
        node.endNode = true;
    }

    // Time: O(S) — delegates to the recursive DFS below, S = total characters across inserted words
    // Space: O(H) — H = length of the longest word (recursion depth)
    public int longestWordWithAllPrefixes() {
        return longestWordWithAllPrefixes(root, 0);
    }

    // Time: O(S) — visits every trie node once, S = total characters across inserted words
    // Space: O(H) — H = recursion depth, bounded by the longest word length
    public int longestWordWithAllPrefixes(TrieNode node, int length) {
        int maxLength = length;
        for (int i = 0; i < 26; i++) {
            if (node.childrenCharacter[i] != null) {
                if (node.childrenCharacter[i].isEndNode()) {
                    int suffixMaxLength = longestWordWithAllPrefixes(node.childrenCharacter[i], length + 1);
                    maxLength = Math.max(maxLength, suffixMaxLength);
                }
            }
        }
        return maxLength;
    }

    // Time: O(sum of strs[i].length()) — each string is walked once via the util call
    // Space: O(1) extra (trie already built; no recursion)
    public String longestWordWithAllPrefixes2(String[] strs){
        int longestStringIndex = -1;
        int longestStringSize  = 0;
        for(int i=0;i<strs.length;i++){
            boolean isPrefixStringExists = longestWordWithAllPrefixes2Util(strs[i]);
            if(isPrefixStringExists && strs[i].length()>longestStringSize){
                longestStringSize = strs[i].length();
                longestStringIndex = i;
            }
        }
        return (longestStringIndex!=-1) ? strs[longestStringIndex] : "";
    }

    // Time: O(L) — L = str.length(), early-exits on the first missing prefix
    // Space: O(1)
    public boolean longestWordWithAllPrefixes2Util(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.childrenCharacter[c - 'a'] == null || !node.childrenCharacter[c - 'a'].isEndNode())
                return false;
            node = node.childrenCharacter[c - 'a'];
        }
        return true;
    }

    // Time: O(S) — delegates to the recursive DFS below, S = total characters across inserted words
    // Space: O(H) — H = length of the longest word (recursion depth + strb buffer)
    public String longestWordWithAllPrefixesWord() {
        StringBuilder result = new StringBuilder();
        longestWordWithAllPrefixesWord(root, new StringBuilder(), result);
        return result.toString();
    }

    // Time: O(S) — visits every trie node once, S = total characters across inserted words;
    //             each new-best update copies up to H chars, but that happens at most H times
    // Space: O(H) — H = recursion depth / strb buffer length, bounded by the longest word
    public void longestWordWithAllPrefixesWord(TrieNode node, StringBuilder strb, StringBuilder result) {
        for (int i = 0; i < 26; i++) {
            if (node.childrenCharacter[i] != null) {
                if (node.childrenCharacter[i].isEndNode()) {
                    strb.append((char) ('a' + i));
                    longestWordWithAllPrefixesWord(node.childrenCharacter[i], strb, result);
                    if (strb.length() > result.length()) {
                        result.setLength(0);
                        result.append(strb);
                    }
                    strb.deleteCharAt(strb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] nums = { "n", "ni", "nin", "ninj", "ninja", "nil" };
        LongestWordWithAllPrefixes longestWordWithAllPrefixes = new LongestWordWithAllPrefixes();
        Arrays.stream(nums).forEachOrdered(longestWordWithAllPrefixes::insert);
        System.out.println(longestWordWithAllPrefixes.longestWordWithAllPrefixes());
        System.out.println(longestWordWithAllPrefixes.longestWordWithAllPrefixesWord());
        System.out.println(longestWordWithAllPrefixes.longestWordWithAllPrefixes2(nums));

        System.out.println("----------------------------------------------------------------------");

        String[] nums2 = { "ninja", "night", "nil" };
        LongestWordWithAllPrefixes longestWordWithAllPrefixes2 = new LongestWordWithAllPrefixes();
        Arrays.stream(nums2).forEachOrdered(longestWordWithAllPrefixes2::insert);
        System.out.println(longestWordWithAllPrefixes2.longestWordWithAllPrefixes());
        System.out.println(longestWordWithAllPrefixes2.longestWordWithAllPrefixesWord());
        System.out.println(longestWordWithAllPrefixes2.longestWordWithAllPrefixes2(nums2));

        System.out.println("----------------------------------------------------------------------");
    }
}
