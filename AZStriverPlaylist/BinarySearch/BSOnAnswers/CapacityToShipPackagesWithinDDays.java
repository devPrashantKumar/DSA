package AZStriverPlaylist.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    
    public static int shipWithinDays(int[] weights, int days) {
        int minCapacity = Arrays.stream(weights).max().orElse(0);
        int maxCapacity = Arrays.stream(weights).sum();
        int left = minCapacity;
        int right = maxCapacity;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(checkDays(weights,days,mid)) right = mid-1;
            else left = mid+1;
        }
        return left;
    }

    public static boolean checkDays(int[] weights, int days, int capacity){
        int currentWeight=0;
        for(int weight : weights){
            if(currentWeight+weight>capacity){
                days--;
                currentWeight=0;
            }
            currentWeight += weight;
            if (days<0) return false;
        }
        days--;
        return (days>=0);
    }
}
