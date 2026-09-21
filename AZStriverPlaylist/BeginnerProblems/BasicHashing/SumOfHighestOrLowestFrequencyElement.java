package AZStriverPlaylist.BeginnerProblems.BasicHashing;

import java.util.Arrays;

public class SumOfHighestOrLowestFrequencyElement {
    public static void frequencySum(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int[] map = new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            map[arr[i]-min]++;
        }

        int minFrequency = Integer.MAX_VALUE;
        int maxFrequency = Integer.MIN_VALUE;
        int minFrequencyElement=0;
        int maxFrequencyElement=0;
        for(int i=0;i<map.length;i++){
            if(map[i]!=0){
                if(map[i]!=0 && map[i]<minFrequency){
                    minFrequencyElement = i;
                    minFrequency=map[i];
                }

                if(map[i]!=0 && map[i]>maxFrequency){
                    maxFrequencyElement = i;
                    maxFrequency=map[i];
                }
            }
        }
        
        System.out.println("Output : ");
        System.out.println(minFrequencyElement+min+" : "+map[minFrequencyElement]);
        System.out.println(maxFrequencyElement+min+" : "+map[maxFrequencyElement]);
        System.out.println("Sum : "+(map[minFrequencyElement]+map[maxFrequencyElement]));

    }
    
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 10, 5, 20};
        System.out.println("Input : "+Arrays.toString(arr1));
        frequencySum(arr1);
        System.out.println("-------------------------------------");
        int[] arr2 = {10};
        System.out.println("Input : "+Arrays.toString(arr2));
        frequencySum(arr2);
        
    }
}
