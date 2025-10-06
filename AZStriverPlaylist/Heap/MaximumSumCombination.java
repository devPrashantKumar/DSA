package AZStriverPlaylist.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSumCombination {
    /*
     * Time Complexity : O(n^2 * log(n^2))
     * Space Complexity : O(n^2)
     */
    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        List<Integer> sumPairs = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                sumPairs.add(a[i]+b[j]);
            }
        }
        sumPairs.sort((a1,b1)->b1-a1);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, sumPairs.size()); i++) {
            result.add(sumPairs.get(i));
        }

        return result;
    }

    /*
     * Time Complexity : O(n^2 * log(k))
     * Space Complexity : O(k)
     */
    public static ArrayList<Integer> topKSumPairs2(int[] a, int[] b, int k) {
        Queue<Integer> sumPairs = new PriorityQueue<>(k);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                int sum = a[i]+b[j];
                if(sumPairs.size()<k) sumPairs.offer(sum);
                else if(sum>sumPairs.peek()){
                    sumPairs.poll();
                    sumPairs.offer(sum);
                }
            }
        }
        int[] result = new int[k];
        while(!sumPairs.isEmpty()) {
            result[sumPairs.size()-1]=sumPairs.poll();
        }
        return new ArrayList<>(Arrays.stream(result).boxed().toList());
    }

    public static ArrayList<Integer> topKSumPairs3(int[] a, int[] b, int k) {
        return null;
    }

    public static void main(String[] args) {
        int[] input11 = {3,2};
        int[] input12 = {1,4};
        int k1 = 2;
        System.out.println("Input : "+Arrays.toString(input11)+", "+Arrays.toString(input12)+", "+k1);
        System.out.println(topKSumPairs(input11, input12, k1));
        System.out.println(topKSumPairs2(input11, input12, k1));

        System.out.println("----------------------------------------------------------------------------------");
    }



}
