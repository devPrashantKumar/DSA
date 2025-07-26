package AZStriverPlaylist.BasicHashing;

import java.util.Arrays;

public class FindTheHighestOrLowestFrequencyElement {
    public static void frequency(int[] arr){
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
        int minFrequencyElement=0, maxFrequencyElement=0;
        for(int i=0;i<map.length;i++){
            if(map[i]!=0 && map[i]<minFrequency){
                minFrequencyElement = i;
                minFrequency=map[i];
            }

            if(map[i]!=0 && map[i]>maxFrequency){
                maxFrequencyElement = i;
                maxFrequency=map[i];
            }

        }
        System.out.println("Output : ");
        System.out.println(minFrequencyElement+min+" : "+map[minFrequencyElement]);
        System.out.println(maxFrequencyElement+min+" : "+map[maxFrequencyElement]);

    }
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 10, 5, 20};
        System.out.println("Input : "+Arrays.toString(arr1));
        FindTheHighestOrLowestFrequencyElement.frequency(arr1);
    }
}
