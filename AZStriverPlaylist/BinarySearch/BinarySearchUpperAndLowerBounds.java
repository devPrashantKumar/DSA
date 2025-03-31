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

    // lowerBound and ceil both are same.
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

    public static int ceil(Integer[] arr, int num){
        int ans = -1;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>=num){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }

    public static int floor(Integer[] arr, int num){
        int ans = -1;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]<=num){
                ans = mid;
                left = mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }    

    public static void main(String[] args) {
        Integer[] arr = {1,5,7,9,10,14,18};
        System.out.println("UpperBound 1 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 1));
        System.out.println("UpperBound 7 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 7));
        System.out.println("UpperBound 9 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 9));
        System.out.println("UpperBound 14 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 14));
        System.out.println("UpperBound 18 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 18));
        System.out.println("UpperBound 0 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 0));
        System.out.println("UpperBound 11 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 11));
        System.out.println("UpperBound 25 - "+BinarySearchUpperAndLowerBounds.upperBound(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("LowerBound 1 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 1));
        System.out.println("LowerBound 7 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 7));
        System.out.println("LowerBound 9 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 9));
        System.out.println("LowerBound 14 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 14));
        System.out.println("LowerBound 18 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 18));
        System.out.println("LowerBound 0 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 0));
        System.out.println("LowerBound 11 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 11));
        System.out.println("LowerBound 25 - "+BinarySearchUpperAndLowerBounds.lowerBound(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Ceil 1 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 1));
        System.out.println("Ceil 7 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 7));
        System.out.println("Ceil 9 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 9));
        System.out.println("Ceil 14 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 14));
        System.out.println("Ceil 18 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 18));
        System.out.println("Ceil 0 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 0));
        System.out.println("Ceil 11 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 11));
        System.out.println("Ceil 25 - "+BinarySearchUpperAndLowerBounds.ceil(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Floor 1 - "+BinarySearchUpperAndLowerBounds.floor(arr, 1));
        System.out.println("Floor 7 - "+BinarySearchUpperAndLowerBounds.floor(arr, 7));
        System.out.println("Floor 9 - "+BinarySearchUpperAndLowerBounds.floor(arr, 9));
        System.out.println("Floor 14 - "+BinarySearchUpperAndLowerBounds.floor(arr, 14));
        System.out.println("Floor 18 - "+BinarySearchUpperAndLowerBounds.floor(arr, 18));
        System.out.println("Floor 0 - "+BinarySearchUpperAndLowerBounds.floor(arr, 0));
        System.out.println("Floor 11 - "+BinarySearchUpperAndLowerBounds.floor(arr, 11));
        System.out.println("Floor 25 - "+BinarySearchUpperAndLowerBounds.floor(arr, 25));
    }
}
