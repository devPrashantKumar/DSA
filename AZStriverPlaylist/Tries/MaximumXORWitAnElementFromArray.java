package AZStriverPlaylist.Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumXORWitAnElementFromArray {
    static class Triplet {
        int x;
        int m;
        int i;
        Triplet(int x, int m, int i){
            this.x = x;
            this.m=m;
            this.i=i;
        }
    }

    static class TrieNode {
        TrieNode[] bits;

        TrieNode() {
            bits = new TrieNode[2];
        }

        public boolean containsBit(int bit) {
            return (bits[bit] != null);
        }

        public TrieNode get(int bit) {
            return bits[bit];
        }

        public void put(int bit) {
            bits[bit] = new TrieNode();
        }
    }

    TrieNode root;

    MaximumXORWitAnElementFromArray() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bitMask = 1 << i;
            int positionBit = (num & bitMask) > 0 ? 1 : 0;
            if (node.bits[positionBit] == null)
                node.bits[positionBit] = new TrieNode();
            node = node.bits[positionBit];
        }
    }

    // this solution is wrong
    // public int maximizeXor(int x, int limit) {
    //     TrieNode node = root;
    //     int secondNum = 0;
    //     for (int i = 31; i >= 0; i--) {
    //         boolean deviatedFromLimitPositionBit = false;
    //         int limitPositionBit = (limit & (1 << i)) > 0 ? 1 : 0;
    //         int positionBit = (x & (1 << i)) > 0 ? 1 : 0;
    //         int desiredBit = (positionBit + 1) % 2;
           
    //         if (!deviatedFromLimitPositionBit) {
    //             if(limitPositionBit==0){
    //                 if(node.bits[0] == null) return -1;
    //                 secondNum = (secondNum << 1) + 0;
    //                 node = node.bits[0];
    //             }else{
    //                 if (node.bits[desiredBit] != null) {
    //                     if (desiredBit == 0) deviatedFromLimitPositionBit = true;
    //                     secondNum = (secondNum << 1) + desiredBit;
    //                     node = node.bits[desiredBit];
    //                 } 
    //                 else {
    //                     if (positionBit == 0) deviatedFromLimitPositionBit = true;
    //                     secondNum = (secondNum << 1) + positionBit;
    //                     node = node.bits[positionBit];
    //                 }
    //             }
    //         } else {
    //             if (node.bits[desiredBit] != null) {
    //                 secondNum = (secondNum << 1) + desiredBit;
    //                 node = node.bits[desiredBit];
    //             } else {
    //                 secondNum = (secondNum << 1) + positionBit;
    //                 node = node.bits[positionBit];
    //             }
    //         }

    //     }
    //     return secondNum;
    // }

    // public int[] maximizeXor(int[] nums, int[][] queries) {
    //     for (int i = 0; i < nums.length; i++) {
    //         insert(nums[i]);
    //     }

    //     int[] result = new int[queries.length];
    //     for (int i = 0; i < queries.length; i++) {
    //         int secondNum = maximizeXor(queries[i][0], queries[i][1]);
    //         if(secondNum==-1)
    //             result[i]=-1;
    //         else 
    //             result[i] = (secondNum^queries[i][0]);
    //     }
    //     return result;
    // }

    public int[] maximizeXor2(int[] nums, int[][] queries) {
        List<Triplet> queriesList = new ArrayList<>();
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queriesList.add(new Triplet(queries[i][0], queries[i][1], i));
        }
        Collections.sort(queriesList,(a,b)->a.m-b.m);

        int numIndex=0;
        for (int i = 0; i < queriesList.size(); i++) {
            Triplet t = queriesList.get(i);
            while(numIndex<nums.length && nums[numIndex]<=t.m){
                insert(nums[numIndex++]);
            }
            if(numIndex==0){
                result[t.i]=-1;
                continue;
            }

            TrieNode node = root;
            int secondNum=0;
            for(int j=31;j>=0;j--){
                int bitMask = 1<<j;
                int positionBit = (t.x&bitMask)>0 ? 1 : 0;
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
            result[t.i]=(t.x^secondNum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[][] queries = { { 3, 1 }, { 1, 3 }, { 5, 6 } };
        System.out.println(Arrays.toString(new MaximumXORWitAnElementFromArray().maximizeXor2(nums, queries)));
        System.out.println("--------------------------------------------------------------");

        int[] nums1 = { 5, 2, 4, 6, 6, 3 };
        int[][] queries1 = { { 12, 4 }, { 8, 1 }, { 6, 3 } };
        System.out.println(Arrays.toString(new MaximumXORWitAnElementFromArray().maximizeXor2(nums1, queries1)));

    }
}
