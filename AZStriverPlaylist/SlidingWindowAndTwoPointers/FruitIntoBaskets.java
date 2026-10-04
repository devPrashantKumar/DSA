package AZStriverPlaylist.SlidingWindowAndTwoPointers;

import java.util.*;

public class FruitIntoBaskets {
    //wrong approch 
    // public static int totalFruit(int[] fruits) {
    //     int maxFruilts = 0;
    //     int fruitCount = 0;
    //     int i = -1, j = -1;
    //     for (int k = 0; k < fruits.length; k++) {
    //         if (i == -1 && j == -1) {
    //             i = k;
    //         } else if (j == -1 && fruits[k] != fruits[i]) {
    //             j = k;
    //         } else if (j == -1 && fruits[i] == fruits[k]) {
    //             i = k;
    //         } else {
    //             if (fruits[k] == fruits[i]) {
    //                 i = k;
    //             } else if (fruits[k] == fruits[j]) {
    //                 j = k;
    //             } else {
    //                 if (i > j) {
    //                     j = k;
    //                     fruitCount = (k - i);
    //                 } else {
    //                     i = k;
    //                     fruitCount = (k - j);
    //                 }
    //             }
    //         }
    //         fruitCount++;
    //         maxFruilts = Math.max(maxFruilts, fruitCount);
    //     }
    //     return maxFruilts;
    // }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1) 
    */
    public static int totalFruit2(int[] fruits) {
        Map<Integer,Integer> fruitMap = new HashMap<>();
        int i=0;
        int j=0;
        int maxFruits=0;
        while(j<fruits.length){
            fruitMap.put(fruits[j], fruitMap.getOrDefault(fruits[j],0)+1);
            if(fruitMap.size()>2){
                maxFruits = Math.max(maxFruits,j-i);
                while(fruitMap.size()>2){
                    fruitMap.put(fruits[i], fruitMap.getOrDefault(fruits[i],0)-1);
                    if(fruitMap.get(fruits[i])==0) fruitMap.remove(fruits[i]);
                    i++;
                }
            }
            j++;
        }
        maxFruits = Math.max(maxFruits, j-i);
        return maxFruits;
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1) 
    */
    public static int totalFruit3(int[] fruits) {
        Map<Integer,Integer> fruitMap = new HashMap<>();
        int i=0;
        int j=0;
        int maxFruits=0;
        while(j<fruits.length){
            fruitMap.put(fruits[j], fruitMap.getOrDefault(fruits[j],0)+1);
            while(fruitMap.size()>2){
                fruitMap.put(fruits[i], fruitMap.getOrDefault(fruits[i],0)-1);
                if(fruitMap.get(fruits[i])==0) fruitMap.remove(fruits[i]);
                i++;
            }
            maxFruits = Math.max(maxFruits,j-i+1);
            j++;
        }
        return maxFruits;
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1) 
    */
    public static int totalFruit4(int[] fruits) {
        Map<Integer,Integer> fruitMap = new HashMap<>();
        int i=0;
        int j=0;
        int maxFruits=0;
        while(j<fruits.length){
            fruitMap.put(fruits[j], fruitMap.getOrDefault(fruits[j],0)+1);
            // we need to maximise length so we don't care about valid sequence of lesser curr max length.
            if(fruitMap.size()>2){
                fruitMap.put(fruits[i], fruitMap.getOrDefault(fruits[i],0)-1);
                if(fruitMap.get(fruits[i])==0) fruitMap.remove(fruits[i]);
                i++;
            }
            if(fruitMap.size()<=2){
                maxFruits = Math.max(maxFruits,j-i+1);
            }
            j++;
        }
        return maxFruits;
    }



    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 1 };
        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("output : " + FruitIntoBaskets.totalFruit2(nums1));
        System.out.println("output : " + FruitIntoBaskets.totalFruit3(nums1));
        System.out.println("output : " + FruitIntoBaskets.totalFruit4(nums1));

        System.out.println("-----------------------------------------------");
        
        int[] nums12 = { 0, 1, 2, 2 };
        System.out.println("Input : " + Arrays.toString(nums12));
        System.out.println("output : " + FruitIntoBaskets.totalFruit2(nums12));
        System.out.println("output : " + FruitIntoBaskets.totalFruit3(nums12));
        System.out.println("output : " + FruitIntoBaskets.totalFruit4(nums12));

        System.out.println("-----------------------------------------------");

        int[] nums3 = { 1, 2, 3, 2, 2 };
        System.out.println("Input : " + Arrays.toString(nums3));
        System.out.println("output : " + FruitIntoBaskets.totalFruit2(nums3));
        System.out.println("output : " + FruitIntoBaskets.totalFruit3(nums3));
        System.out.println("output : " + FruitIntoBaskets.totalFruit4(nums3));

        System.out.println("-----------------------------------------------");

        int[] nums4 = { 1,1,6,5,6,6,1,1,1,1 ,2};
        System.out.println("Input : " + Arrays.toString(nums4));
        System.out.println("output : " + FruitIntoBaskets.totalFruit2(nums4));
        System.out.println("output : " + FruitIntoBaskets.totalFruit3(nums4));
        System.out.println("output : " + FruitIntoBaskets.totalFruit4(nums4));

        System.out.println("-----------------------------------------------");

    }
}
