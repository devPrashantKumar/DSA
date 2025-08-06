package PracticeFolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class practice {


    public static long minCost(int[] basket1, int[] basket2) {
        long minCost=0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num:basket1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:basket2){
            map.put(num,map.getOrDefault(num,0)-1);
        }

        List<Integer> accessA = new ArrayList<>();
        List<Integer> accessB = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int fruit = entry.getKey();
            int diff = entry.getValue();
            minValue = Math.min(minValue,fruit);
            if(diff%2!=0) return -1;
            int count = Math.abs(diff/2);
            for(int i=0;i<count;i++){
                if(diff>0) {
                    accessA.add(fruit);
                }
                if(diff<0){
                    accessB.add(fruit);
                }
            }

        }
        Collections.sort(accessA);
        Collections.sort(accessB,Collections.reverseOrder());

        for(int i=0;i<accessA.size();i++){
            minCost += Math.min(Math.min(accessA.get(i),accessB.get(i)), 2*minValue);
        }

        return minCost;
    }

    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxfruits=0;
        int[] rightFruits = new int[k+1];
        int[] leftFruits = new int[k+1];
        int cumulativeFruitsRight=0;
        int cumulativeFruitsLeft=0;

        int itrRight = 0;
        int itrLeft = 0;

        for(;itrRight<fruits.length;){
            if(fruits[itrRight][0]<startPos){
                itrRight++;
                itrLeft++;
            }else{
                if(fruits[itrRight][0]>startPos) itrLeft--;
                break;
            } 
        }
        if(itrRight==fruits.length){
            itrLeft--;
        }
        for(int i=0;i<=k;i++){
            if(itrRight<fruits.length && fruits[itrRight][0]==i+startPos){
                cumulativeFruitsRight += fruits[itrRight][1];
                itrRight++; 
            }
            rightFruits[i] = cumulativeFruitsRight;
        }

        for(int i=0;i<=k;i++){
            if(itrLeft>=0 && fruits[itrLeft][0]==startPos-i){
                cumulativeFruitsLeft += fruits[itrLeft][1];
                itrLeft--; 
            }
            leftFruits[i] = cumulativeFruitsLeft;
        }
        System.out.println(Arrays.toString(leftFruits));
        System.out.println(Arrays.toString(rightFruits));

        for(int i=0;i<=k/2;i++){
            maxfruits = Math.max(maxfruits, leftFruits[i]+rightFruits[k-2*i]-rightFruits[0]);
        }
        for(int i=0;i<=k/2;i++){
            maxfruits = Math.max(maxfruits, rightFruits[i]+leftFruits[k-2*i]-leftFruits[0]);
        }
        return maxfruits;
    }

    public static int totalFruit(int[] fruits) {
        int maxFruits=0;
        Map<Integer, Integer> map = new HashMap<>();
        int left=0,right=0;
        for(;right<fruits.length;){
            if(map.size()<2 || map.containsKey(fruits[right])){
                map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
                maxFruits = Math.max(right-left+1, maxFruits);
                right++;
            }
            else{
                map.put(fruits[left], map.getOrDefault(fruits[left],0)-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }

        }
        return maxFruits;
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count=0;
        for(int i=0;i<fruits.length;i++){
            int j=0;
            for(;j<baskets.length;j++){
                if(baskets[j]>=fruits[i]){
                    baskets[j]=0;
                    break;
                }
            }
            if(j==baskets.length) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(practice.maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}},5,4));
        System.out.println(practice.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}},5,4));
        System.out.println(practice.maxTotalFruits(new int[][]{{0,3},{6,4},{8,5}},3,2));

    }
}