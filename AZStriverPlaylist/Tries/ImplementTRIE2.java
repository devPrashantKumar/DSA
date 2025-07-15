package AZStriverPlaylist.Tries;

public class ImplementTRIE2 {
    class TrieNode{
        TrieNode [] character;
        int cntPrefix;
        int cntEnd;

        TrieNode(){
            character = new TrieNode[26];
            cntEnd=0;
            cntPrefix=0;
        }

        public boolean containsKey(char c){
            return character[c-'a']!=null;
        }

        public TrieNode get(char c){
            return character[c-'a'];
        }

        public int getCountEnd(){
            return this.cntEnd;
        }

        public int getCountPrefix(){
            return this.cntPrefix;
        }

        public void put(char c){
            character[c-'a']=new TrieNode();
        }

        public void increaseCountEnd(){
            this.cntEnd++;
        }

        public void increaseCountPrefix(){
            this.cntPrefix++;
        }

        public void decreaseCountPrefix(){
            this.cntPrefix--;
        }

        public void decreaseCountEnd(){
            this.cntEnd--;
        }

    }

    TrieNode root;

    ImplementTRIE2(){
        root = new TrieNode();
    }

    public void insert(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                node.put(str.charAt(i));
            }
            node = node.get(str.charAt(i));
            node.increaseCountPrefix();
        }
        node.increaseCountEnd();
    }


    public int countWords(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                return 0;
            }
            node = node.get(str.charAt(i));
        }
        return node.getCountEnd();
    }

    public int countStartsWith(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                return 0;
            }
            node = node.get(str.charAt(i));
        }
        return node.getCountPrefix();
    }

    public void erase(String str){
        TrieNode node = root;
        for(int i=0;i<str.length();i++){
            if(!node.containsKey(str.charAt(i))){
                return;
            }
            node = node.get(str.charAt(i));
            node.decreaseCountPrefix();;
        }
        node.decreaseCountEnd();
    }
}
