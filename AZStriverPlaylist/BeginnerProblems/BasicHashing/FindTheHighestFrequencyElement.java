package AZStriverPlaylist.BeginnerProblems.BasicHashing;

import java.util.Arrays;

public class FindTheHighestFrequencyElement {
    public static void highestFrequency(int[] arr){
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
        int maxFrequencyElement=0;
        for(int i=0;i<map.length;i++){
            if(map[i]!=0 && map[i]>maxFrequency){
                maxFrequencyElement = i;
                maxFrequency=map[i];
            }

        }
        System.out.println("Output : ");
        System.out.println(maxFrequencyElement+min+" : "+map[maxFrequencyElement]);

    }
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 10, 5, 20};
        System.out.println("Input : "+Arrays.toString(arr1));
        highestFrequency(arr1);
    }
}
