package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.*;

public class MinimizeMaxDistanceToGasStation {

    static class Pair implements Comparable<Pair>{
        double distance;
        int index;

        Pair(double distance, int index){
            this.distance = distance;
            this.index = index;
        }

        @Override
        public int compareTo(Pair arg0) {
            if(this.distance<arg0.distance) return -1;
            else if(this.distance>arg0.distance) return 1;
            else if(this.index>arg0.index) return 1;
            else if(this.index<arg0.index)return -1;
            else return 0;
        }
    }

    /* -------------------- 1. Bruteforce -------------------- */
    // Time: O(k * n)
    // Space: O(n)
    public static double minimiseMaxDistanceBruteforce(int[] arr, int k) {
        int[] placed = new int[arr.length-1];
        for(int i=1;i<=k;i++){
            int index=-1;
            double maxLength = Integer.MIN_VALUE;
            for(int j=0;j<arr.length-1;j++){
                double distance = arr[j+1]-arr[j];
                double sectionLength = distance/(placed[j]+1);
                if(sectionLength>maxLength){
                    maxLength = sectionLength;
                    index = j;
                }
            }
            placed[index]++;
        }

        double maxLength = Integer.MIN_VALUE;
        for(int j=0;j<arr.length-1;j++){
            double distance = arr[j+1]-arr[j];
            double sectionLength = distance/(placed[j]+1);
            if(sectionLength>maxLength){
                maxLength = sectionLength;
            }
        }
        return maxLength;
    }

    /* -------------------- 2. Priority Queue (Better) -------------------- */
    // Time: O((n + k) log n)
    // Space: O(n)
    public static double minimiseMaxDistanceBetter(int[] arr, int k) {
        int[] placed = new int[arr.length-1];
        PriorityQueue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int j=0;j<arr.length-1;j++){
            double distance = arr[j+1]-arr[j];
            queue.add(new Pair(distance, j));
        }
        for(int i=1;i<=k;i++){
            Pair pair = queue.poll();
            int currentGaps = placed[pair.index]+1;
            double distance = pair.distance*(currentGaps);
            //double distance = (double)arr[pair.index+1]-arr[pair.index]; // this also we can use
            double sectionLength = distance/(currentGaps+1);
            placed[pair.index]++;
            queue.add(new Pair(sectionLength, pair.index));
        }

        return queue.poll().distance;
    }

    /* -------------------- 3. Binary Search (Optimal) -------------------- */
    // Time: O(n * log(maxDistance))
    // Space: O(1)
    public static double minimiseMaxDistanceBinarySearch(int[] arr, int k) {
        double left = 0;
        double right = Arrays.stream(arr).max().orElse(0);
        while(right-left>1e-6){
            double mid = left+(right-left)/2;
            int placed = placeAtDistance(arr,mid);
            if(placed>k){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        // here concept of oppsite polarity will not work,
        // in pevious iterations we stored correct answer in rigth so answer will still be stored in right only in this case
        return right;
    }

    public static int placeAtDistance(int[] arr, double dist){
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            double distance = arr[i+1]-arr[i];
            int partitions = (int)(distance/dist);
            if(partitions*dist==distance) partitions--;
            count += partitions;
        }
        return count;
    }

    public static double minimiseMaxDistanceBinarySearch2(int[] arr, int k) {
        double ans = -1;
        double left = 0;
        double right = Arrays.stream(arr).max().orElse(0);
        while(right-left>1e-6){
            double mid = left+(right-left)/2;
            int placed = placeAtDistance(arr,mid);
            if(placed>k){
                left = mid;
            }
            else{
                ans = mid;
                right = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
         System.out.println(minimiseMaxDistanceBruteforce(new int[] { 1, 2, 3, 4, 5, 6 ,7, 8, 9, 10 },10));
        System.out.println(minimiseMaxDistanceBetter(new int[] { 1, 2, 3, 4, 5, 6 ,7, 8, 9, 10 }, 10));
        System.out.println(minimiseMaxDistanceBinarySearch(new int[] { 1, 2, 3, 4, 5, 6 ,7, 8, 9, 10 }, 10));
        System.out.println(minimiseMaxDistanceBinarySearch2(new int[] { 1, 2, 3, 4, 5, 6 ,7, 8, 9, 10 }, 10));

        System.out.println("---------------------------------------------");
        
        System.out.println(minimiseMaxDistanceBruteforce(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1));
        System.out.println(minimiseMaxDistanceBetter(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1));
        System.out.println(minimiseMaxDistanceBinarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1));
        System.out.println(minimiseMaxDistanceBinarySearch2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1));

        System.out.println("---------------------------------------------");

        System.out.println(minimiseMaxDistanceBruteforce(new int[] { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 }, 2));
        System.out.println(minimiseMaxDistanceBetter(new int[] { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 }, 2));
        System.out.println(minimiseMaxDistanceBinarySearch(new int[] { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 }, 2));
        System.out.println(minimiseMaxDistanceBinarySearch2(new int[] { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 }, 2));

        System.out.println("---------------------------------------------");
    }
}
