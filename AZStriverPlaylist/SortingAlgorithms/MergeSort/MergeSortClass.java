package AZStriverPlaylist.SortingAlgorithms.MergeSort;

public class MergeSortClass {
    public static int[] mergeSort(int[] arr){
        mergeSortUtil(arr,0,arr.length-1);
        return arr;
    }

    private static void mergeSortUtil(int[] arr, int startIndex, int endIndex){
        if(endIndex-startIndex<=0) return;
        int midIndex = startIndex+((endIndex-startIndex)/2);
        mergeSortUtil(arr, startIndex, midIndex);
        mergeSortUtil(arr,midIndex+1,endIndex);
        merge(arr, startIndex, midIndex, midIndex+1, endIndex);
    }

    private static int[] merge(int[] arr, int startIndex1, int endIndex1,int startIndex2,int endIndex2){
        int[] temp1 = new int[endIndex1-startIndex1+1];
        int[] temp2 = new int[endIndex2-startIndex2+1];

        for(int i=startIndex1,j=0;i<=endIndex1;i++,j++){
            temp1[j]=arr[i];
        }
        for(int i=startIndex2,j=0;i<=endIndex2;i++,j++){
            temp2[j]=arr[i];
        }

        int temp1Pointer=0;
        int temp2Pointer=0;
        for(int i=startIndex1;i<=endIndex2;i++){
            if(temp1Pointer+1<=temp1.length && temp2Pointer+1<=temp2.length){
                if(temp1[temp1Pointer]<=temp2[temp2Pointer]){
                    arr[i]=temp1[temp1Pointer++];
                }
                else{
                    arr[i]=temp2[temp2Pointer++];
                }
            }
            else if(temp1Pointer+1<=temp1.length){
                arr[i]=temp1[temp1Pointer++];
            }
            else{
                arr[i]=temp2[temp2Pointer++];
            }
        }
        return arr;
    }
}
