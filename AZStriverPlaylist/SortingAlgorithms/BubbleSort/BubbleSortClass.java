package AZStriverPlaylist.SortingAlgorithms.BubbleSort;

public class BubbleSortClass {
    /*
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     * In-Place Algorithm
     * Stable Algorithm
     */
    public static int[] bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
