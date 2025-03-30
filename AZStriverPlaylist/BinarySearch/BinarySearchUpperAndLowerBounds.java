package AZStriverPlaylist.BinarySearch;

public class BinarySearchUpperAndLowerBounds {
    public static int upperBound(Integer[] arr, int num){
        int ans = arr.length;
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>num){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return ans;
    }

    public static int lowerBound(Integer[] arr, int num){
        int ans = arr.length;
        int left=0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>=num){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}
