package AZStriverPlaylist.Tries;

public class ImplementTRIE {
    class TrieNode{
        TrieNode [] character;
        boolean isEnd;

        TrieNode(){
            character = new TrieNode[26];
            isEnd=false;
        }

        public boolean containsKey(char c){
            return character[c-'a']!=null;
        }

        public TrieNode get(char c){
            return character[c-'a'];
        }

        public void put(char c){
            character[c-'a']=new TrieNode();
        }

        public void makeEndNode(boolean isEnd){
            this.isEnd=isEnd;
        }

        public boolean isEndNode(){
            return this.isEnd;
        }
    }

    TrieNode root;

    ImplementTRIE(){
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
        node.makeEndNode(true);
    }


    public boolean search(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                return false;
            }
            node = node.get(str.charAt(i));
        }
        return node.isEndNode();
    }

    public boolean startsWith(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                return false;
            }
            node = node.get(str.charAt(i));
        }
        return true;
    }
}
