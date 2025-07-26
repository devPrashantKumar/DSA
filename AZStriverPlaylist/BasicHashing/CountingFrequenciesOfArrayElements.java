package AZStriverPlaylist.BasicHashing;

import java.util.Arrays;

public class CountingFrequenciesOfArrayElements {
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

        System.out.println("Output : ");
        for(int i=0;i<map.length;i++){
            if(map[i]!=0){
                System.out.println(i+min+" : "+map[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {0, 20, 10, 5, 20};
        System.out.println("Input : "+Arrays.toString(arr1));
        CountingFrequenciesOfArrayElements.frequency(arr1);
    }
}
