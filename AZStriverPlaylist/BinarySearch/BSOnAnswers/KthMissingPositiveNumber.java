package AZStriverPlaylist.BinarySearch.BSOnAnswers;

public class KthMissingPositiveNumber {
    /*
    * Time Complexity : O(n)
    */
    public static int findKthPositive(int[] arr, int k) {
        int kthMissing = k;
        for(int num:arr){
            if(num<=kthMissing) kthMissing++;
            else return kthMissing;
        }
        return kthMissing;
    }

    /*
    * Time Complexity : O(log n)
    */
    public static int findKthPositiveUsingBS(int[] arr, int k) {
        int left=0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid] - (mid + 1) >= k) right = mid-1;
            //if(arr[mid]>k+mid) right = mid-1;
            else left = mid+1;
        }
        return right>=0 ? arr[right]+(k-(arr[right]-(right+1))) : k;
        //return left+k; simplified version of above formula
    }

    public static int findKthPositiveUsingBS2(int[] arr, int k) {
        int left=0;
        int right = arr.length-1;
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid] - (mid + 1) >= k) right = mid-1;
            else {
                ans = mid;
                left = mid+1;
            }
        }
        return ans>=0 ? arr[ans]+(k-(arr[ans]-(ans+1))) : k;
        //return left+k; simplified version of above formula
    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[] { 2,3,4,7,11 }, 5));
        System.out.println(findKthPositiveUsingBS(new int[] { 2,3,4,7,11 }, 5));
        System.out.println(findKthPositiveUsingBS2(new int[] { 2,3,4,7,11 }, 5));

        System.out.println("===================================");
        System.out.println(findKthPositive(new int[] { 1,2,3,4 }, 2));
        System.out.println(findKthPositiveUsingBS(new int[] { 1,2,3,4 }, 2));
        System.out.println(findKthPositiveUsingBS2(new int[] { 1,2,3,4 }, 2));
    }
}
