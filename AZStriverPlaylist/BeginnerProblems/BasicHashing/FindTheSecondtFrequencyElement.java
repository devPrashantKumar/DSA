package AZStriverPlaylist.BeginnerProblems.BasicHashing;

import java.util.Arrays;

public class FindTheSecondtFrequencyElement {
    public static void secondHighestFrequency(int[] arr){
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

        int maxFrequency = Integer.MIN_VALUE;
        int secondMaxFrequency = Integer.MIN_VALUE;
        int maxFrequencyElement=-1;
        int secondMaxFrequencyElement=-1;
        for(int i=0;i<map.length;i++){
            if(map[i]!=0){
                if(map[i]>maxFrequency){
                    secondMaxFrequency = maxFrequency;
                    secondMaxFrequencyElement = maxFrequencyElement;
                    maxFrequency=map[i];
                    maxFrequencyElement = i;
                }
                else if(map[i]<maxFrequency && map[i]>secondMaxFrequency){
                    secondMaxFrequency = map[i];
                    secondMaxFrequencyElement = i;
                }
            }
            

        }
        System.out.println("Output : ");
        System.out.println(maxFrequencyElement+min+" : "+map[maxFrequencyElement]);
        if(secondMaxFrequencyElement!=-1)
            System.out.println(secondMaxFrequencyElement+min+" : "+map[secondMaxFrequencyElement]);
        else System.out.println("No Second Max Frequency Element");

    }
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 10, 5, 20};
        System.out.println("Input : "+Arrays.toString(arr1));
        secondHighestFrequency(arr1);
        System.out.println("-----------------------------------------------");
        int[] arr2 = {10, 15};
        System.out.println("Input : "+Arrays.toString(arr2));
        secondHighestFrequency(arr2);
    }
}
