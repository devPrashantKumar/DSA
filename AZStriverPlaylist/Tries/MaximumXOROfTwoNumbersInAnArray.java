package AZStriverPlaylist.Tries;

import java.util.Arrays;

public class MaximumXOROfTwoNumbersInAnArray {
    static class TrieNode {
        TrieNode[] bits;

        TrieNode(){
            bits = new TrieNode[2];
        }

        public boolean containsBit(int bit){
            return (bits[bit]!=null);
        }

        public TrieNode get(int bit){
            return bits[bit];
        }

        public void put(int bit){
            bits[bit] = new TrieNode();
        }
    }

    TrieNode root;

    MaximumXOROfTwoNumbersInAnArray(){
        root = new TrieNode();
    }

    // Time: O(32) — always walks 32 bit levels, one per int bit
    // Space: O(32) worst case — new node created at every level for a fully distinct bit path
    public void insert(int num){
        TrieNode node = root;
        for(int i=31;i>=0;i--){
            int bitMask = 1<<i;
            int positionBit = (num&bitMask)>0 ? 1 : 0;
            if(node.bits[positionBit]==null)
                node.bits[positionBit] = new TrieNode();
            node = node.bits[positionBit];
        }
    }

    // Time: O(32*N) -> O(N) — building the trie is 32 ops per number (N numbers),
    // then querying each number greedily walks 32 levels again
    // Space: O(32*N) -> O(N) — trie stores up to 32 nodes per number in the worst case
    // (no shared prefixes among the N numbers); O(1) extra space for the query itself
    public int[] findMaximumXOR(int[] nums) {
        for(int i=0;i<nums.length;i++){
            insert(nums[i]);
        }
        int maxXor=Integer.MIN_VALUE;
        int resultFirstNum = Integer.MIN_VALUE;
        int resultSecondNum = Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++){
            TrieNode node = root;
            int num = nums[j];
            int secondNum=0;
            for(int i=31;i>=0;i--){
                int bitMask = 1<<i;
                int positionBit = (num&bitMask)>0 ? 1 : 0;
                int oppositeBit = (positionBit+1)%2;
                if(node.bits[oppositeBit]!=null) {
                    secondNum =  (secondNum<<1)+oppositeBit;
                    node = node.bits[oppositeBit];
                }
                else{
                    secondNum =  (secondNum<<1)+positionBit;
                    node = node.bits[positionBit];
                }
            }
            if((num^secondNum)>maxXor){
                resultFirstNum = num;
                resultSecondNum = secondNum;
                maxXor = num^secondNum;
            }
        }
        return new int[]{resultFirstNum,resultSecondNum,maxXor};

    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(Arrays.toString(new MaximumXOROfTwoNumbersInAnArray().findMaximumXOR(nums)));

        System.out.println("--------------------------------------------------------------");

        int[] nums1 = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(Arrays.toString(new MaximumXOROfTwoNumbersInAnArray().findMaximumXOR(nums1)));


    }
}
