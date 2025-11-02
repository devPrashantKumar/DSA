package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class BinarySearchUpperAndLowerBoundsRecursive {

    // ---------- Upper Bound ----------
    /** Returns the index of the first element greater than num, or arr.length if not found. */
    public static int upperBoundRecursion(int[] arr, int num) {
        int result = upperBoundRecursionUtil(arr, num, 0, arr.length - 1);
        return (result == -1) ? arr.length : result;
    }

    private static int upperBoundRecursionUtil(int[] arr, int num, int left,int right){
        if(left>right) return -1;
        int mid = left+(right-left)/2;
        if(arr[mid]>num){
            int nextUpperBound = upperBoundRecursionUtil(arr,num,left,mid-1);
            return (nextUpperBound!=-1) ? nextUpperBound : mid;
        }
        return upperBoundRecursionUtil(arr,num,mid+1,right);
    }

    // ---------- Lower Bound ----------
    /** Returns the index of the first element >= num, or arr.length if not found. */
    public static int lowerBoundRecursion(int[] arr, int num) {
        int result = lowerBoundRecursionUtil(arr, num, 0, arr.length - 1);
        return (result == -1) ? arr.length : result;
    }

    private static int lowerBoundRecursionUtil(int[] arr, int num, int left,int right){
        if(left>right) return -1;
        int mid = left+(right-left)/2;
        if(arr[mid]>=num){
            int nextLowerBound = lowerBoundRecursionUtil(arr,num,left,mid-1);
            return (nextLowerBound!=-1) ? nextLowerBound : mid;
        }
        return lowerBoundRecursionUtil(arr,num,mid+1,right);
    }

    // ---------- Ceil ----------
    /** Returns the index of the smallest element >= num, or -1 if none exists. */
    public static int ceilRecursion(int[] arr, int num) {
        return ceilRecursionUtil(arr, num, 0, arr.length - 1);
    }

    private static int ceilRecursionUtil(int[] arr, int num, int left,int right){
        if(left>right) return -1;
        int mid = left+(right-left)/2;
        if(arr[mid]>=num){
            int nextCeil = ceilRecursionUtil(arr,num,left,mid-1);
            return (nextCeil!=-1) ? nextCeil : mid;
        }
        return ceilRecursionUtil(arr,num,mid+1,right);
    }

    // ---------- Floor ----------
    /** Returns the index of the largest element <= num, or -1 if none exists. */
    public static int floorRecursion(int[] arr, int num) {
        return floorRecursionUtil(arr, num, 0, arr.length - 1);
    }

    private static int floorRecursionUtil(int[] arr, int num, int left,int right){
        if(left>right) return -1;
        int mid = left+(right-left)/2;
        if(arr[mid]<=num){
            int nextFloor = floorRecursionUtil(arr,num,mid+1,right);
            return (nextFloor!=-1) ? nextFloor : mid;
        }
        return floorRecursionUtil(arr,num,left,mid-1);
    }   

    public static void main(String[] args) {
        int[] arr = {1,5,7,9,10,14,18};
        System.out.println("UpperBound 1 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 1));
        System.out.println("UpperBound 7 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 7));
        System.out.println("UpperBound 9 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 9));
        System.out.println("UpperBound 14 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 14));
        System.out.println("UpperBound 18 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 18));
        System.out.println("UpperBound 0 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 0));
        System.out.println("UpperBound 11 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 11));
        System.out.println("UpperBound 25 - "+BinarySearchUpperAndLowerBoundsRecursive.upperBoundRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("LowerBound 1 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 1));
        System.out.println("LowerBound 7 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 7));
        System.out.println("LowerBound 9 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 9));
        System.out.println("LowerBound 14 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 14));
        System.out.println("LowerBound 18 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 18));
        System.out.println("LowerBound 0 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 0));
        System.out.println("LowerBound 11 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 11));
        System.out.println("LowerBound 25 - "+BinarySearchUpperAndLowerBoundsRecursive.lowerBoundRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Ceil 1 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 1));
        System.out.println("Ceil 7 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 7));
        System.out.println("Ceil 9 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 9));
        System.out.println("Ceil 14 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 14));
        System.out.println("Ceil 18 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 18));
        System.out.println("Ceil 0 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 0));
        System.out.println("Ceil 11 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 11));
        System.out.println("Ceil 25 - "+BinarySearchUpperAndLowerBoundsRecursive.ceilRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Floor 1 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 1));
        System.out.println("Floor 7 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 7));
        System.out.println("Floor 9 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 9));
        System.out.println("Floor 14 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 14));
        System.out.println("Floor 18 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 18));
        System.out.println("Floor 0 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 0));
        System.out.println("Floor 11 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 11));
        System.out.println("Floor 25 - "+BinarySearchUpperAndLowerBoundsRecursive.floorRecursion(arr, 25));
    }
}
