package AZStriverPlaylist.Tries;

public class NumberOfDistinctSubstringsInAString {
    class TrieNode {
        TrieNode[] childrenCharacter;
        boolean endNode;

        TrieNode() {
            childrenCharacter = new TrieNode[26];
            endNode = false;
        }

        public boolean containsKey(char c) {
            return childrenCharacter[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return childrenCharacter[c - 'a'];
        }

        public void put(char c) {
            childrenCharacter[c - 'a'] = new TrieNode();
        }

        public boolean isEndNode() {
            return endNode;
        }
    }

    TrieNode root;

    NumberOfDistinctSubstringsInAString() {
        root = new TrieNode();
    }

    public int insert(String str, int count) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.containsKey(str.charAt(i))) {
                node.put(str.charAt(i));
                count++;
            }
            node = node.get(str.charAt(i));
        }
        node.endNode = true;
        return count;
    }

    // Time: O(n²) — n suffixes, average suffix length n/2, so total work ≈ n²/2
    // Space: O(n²) worst case — e.g. string with all distinct characters
    // creates a completely separate path for every suffix
    public int countDistinctSubstring(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(i);
            count = insert(subString, count);
        }
        return count + 1; // +1 for the empty substring (root node)
    }

    public static void main(String[] args) {
        String nums = "aba";
        NumberOfDistinctSubstringsInAString longestWordWithAllPrefixes = new NumberOfDistinctSubstringsInAString();
        System.out.println(longestWordWithAllPrefixes.countDistinctSubstring(nums));

        System.out.println("----------------------------------------------------------------------");

        String nums2 = "abc";
        NumberOfDistinctSubstringsInAString longestWordWithAllPrefixes2 = new NumberOfDistinctSubstringsInAString();
        System.out.println(longestWordWithAllPrefixes2.countDistinctSubstring(nums2));

        System.out.println("----------------------------------------------------------------------");
    }
}
