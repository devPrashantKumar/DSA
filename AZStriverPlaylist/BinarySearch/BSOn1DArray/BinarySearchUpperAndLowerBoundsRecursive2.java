package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class BinarySearchUpperAndLowerBoundsRecursive2 {

    // ---------- Upper Bound ----------
    /** Returns the index of the first element greater than num, or arr.length if not found. */
    public static int upperBoundRecursion(int[] arr, int num) {
        int result = upperBoundRecursionUtil(arr, num, 0, arr.length - 1,-1);
        return (result == -1) ? arr.length : result;
    }

    private static int upperBoundRecursionUtil(int[] arr, int num, int left,int right, int ans){
        if(left>right) return ans;
        int mid = left+(right-left)/2;
        if(arr[mid]>num){
            return upperBoundRecursionUtil(arr,num,left,mid-1, mid);
        }
        return upperBoundRecursionUtil(arr,num,mid+1,right,ans);
    }

    public static int upperBoundRecursion2(int[] arr, int num) {
        return upperBoundRecursionUtil(arr, num, 0, arr.length - 1,arr.length);
    }

    // ---------- Lower Bound ----------
    /** Returns the index of the first element >= num, or arr.length if not found. */
    public static int lowerBoundRecursion(int[] arr, int num) {
        int result = lowerBoundRecursionUtil(arr, num, 0, arr.length - 1,-1);
        return (result == -1) ? arr.length : result;
    }

    private static int lowerBoundRecursionUtil(int[] arr, int num, int left,int right, int ans){
        if(left>right) return ans;
        int mid = left+(right-left)/2;
        if(arr[mid]>=num){
            return lowerBoundRecursionUtil(arr,num,left,mid-1,mid);
        }
        return lowerBoundRecursionUtil(arr,num,mid+1,right,ans);
    }

    public static int lowerBoundRecursion2(int[] arr, int num) {
        return lowerBoundRecursionUtil(arr, num, 0, arr.length - 1,arr.length);
    }

    // ---------- Ceil ----------
    /** Returns the index of the smallest element >= num, or -1 if none exists. */
    public static int ceilRecursion(int[] arr, int num) {
        return ceilRecursionUtil(arr, num, 0, arr.length - 1,-1);
    }

    private static int ceilRecursionUtil(int[] arr, int num, int left,int right,int ans){
        if(left>right) return ans;
        int mid = left+(right-left)/2;
        if(arr[mid]>=num){
            return ceilRecursionUtil(arr,num,left,mid-1,mid);
        }
        return ceilRecursionUtil(arr,num,mid+1,right,ans);
    }

    // ---------- Floor ----------
    /** Returns the index of the largest element <= num, or -1 if none exists. */
    public static int floorRecursion(int[] arr, int num) {
        return floorRecursionUtil(arr, num, 0, arr.length - 1,-1);
    }

    private static int floorRecursionUtil(int[] arr, int num, int left,int right, int ans){
        if(left>right) return ans;
        int mid = left+(right-left)/2;
        if(arr[mid]<=num){
            return floorRecursionUtil(arr,num,mid+1,right,mid);
        }
        return floorRecursionUtil(arr,num,left,mid-1,ans);
    }   

    public static void main(String[] args) {
        int[] arr = {1,5,7,9,10,14,18};
        System.out.println("UpperBound 1 - "+upperBoundRecursion(arr, 1));
        System.out.println("UpperBound 7 - "+upperBoundRecursion(arr, 7));
        System.out.println("UpperBound 9 - "+upperBoundRecursion(arr, 9));
        System.out.println("UpperBound 14 - "+upperBoundRecursion(arr, 14));
        System.out.println("UpperBound 18 - "+upperBoundRecursion(arr, 18));
        System.out.println("UpperBound 0 - "+upperBoundRecursion(arr, 0));
        System.out.println("UpperBound 11 - "+upperBoundRecursion(arr, 11));
        System.out.println("UpperBound 25 - "+upperBoundRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("UpperBound 1 - "+upperBoundRecursion2(arr, 1));
        System.out.println("UpperBound 7 - "+upperBoundRecursion2(arr, 7));
        System.out.println("UpperBound 9 - "+upperBoundRecursion2(arr, 9));
        System.out.println("UpperBound 14 - "+upperBoundRecursion2(arr, 14));
        System.out.println("UpperBound 18 - "+upperBoundRecursion2(arr, 18));
        System.out.println("UpperBound 0 - "+upperBoundRecursion2(arr, 0));
        System.out.println("UpperBound 11 - "+upperBoundRecursion2(arr, 11));
        System.out.println("UpperBound 25 - "+upperBoundRecursion2(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("LowerBound 1 - "+lowerBoundRecursion(arr, 1));
        System.out.println("LowerBound 7 - "+lowerBoundRecursion(arr, 7));
        System.out.println("LowerBound 9 - "+lowerBoundRecursion(arr, 9));
        System.out.println("LowerBound 14 - "+lowerBoundRecursion(arr, 14));
        System.out.println("LowerBound 18 - "+lowerBoundRecursion(arr, 18));
        System.out.println("LowerBound 0 - "+lowerBoundRecursion(arr, 0));
        System.out.println("LowerBound 11 - "+lowerBoundRecursion(arr, 11));
        System.out.println("LowerBound 25 - "+lowerBoundRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("LowerBound 1 - "+lowerBoundRecursion2(arr, 1));
        System.out.println("LowerBound 7 - "+lowerBoundRecursion2(arr, 7));
        System.out.println("LowerBound 9 - "+lowerBoundRecursion2(arr, 9));
        System.out.println("LowerBound 14 - "+lowerBoundRecursion2(arr, 14));
        System.out.println("LowerBound 18 - "+lowerBoundRecursion2(arr, 18));
        System.out.println("LowerBound 0 - "+lowerBoundRecursion2(arr, 0));
        System.out.println("LowerBound 11 - "+lowerBoundRecursion2(arr, 11));
        System.out.println("LowerBound 25 - "+lowerBoundRecursion2(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Ceil 1 - "+ceilRecursion(arr, 1));
        System.out.println("Ceil 7 - "+ceilRecursion(arr, 7));
        System.out.println("Ceil 9 - "+ceilRecursion(arr, 9));
        System.out.println("Ceil 14 - "+ceilRecursion(arr, 14));
        System.out.println("Ceil 18 - "+ceilRecursion(arr, 18));
        System.out.println("Ceil 0 - "+ceilRecursion(arr, 0));
        System.out.println("Ceil 11 - "+ceilRecursion(arr, 11));
        System.out.println("Ceil 25 - "+ceilRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Floor 1 - "+floorRecursion(arr, 1));
        System.out.println("Floor 7 - "+floorRecursion(arr, 7));
        System.out.println("Floor 9 - "+floorRecursion(arr, 9));
        System.out.println("Floor 14 - "+floorRecursion(arr, 14));
        System.out.println("Floor 18 - "+floorRecursion(arr, 18));
        System.out.println("Floor 0 - "+floorRecursion(arr, 0));
        System.out.println("Floor 11 - "+floorRecursion(arr, 11));
        System.out.println("Floor 25 - "+floorRecursion(arr, 25));
    }
}
