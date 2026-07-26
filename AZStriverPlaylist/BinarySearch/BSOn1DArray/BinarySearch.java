package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class BinarySearch {
    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(logn) for tail-recursive stack
     */
    public static Integer binarySearchUsingRecursion(Integer[] arr, Integer data){
        return binarySearchUtilForRecursion(arr,data,0,arr.length-1);
    }

    public static Integer binarySearchUtilForRecursion(Integer[] arr, Integer data, int start, int end){
        if(start>end) return null;
        int mid = start+((end-start)/2);
        //int mid = (start-1)+((end-start+1)/2); wrong formula
        if(arr[mid].equals(data)) return arr[mid];
        else if(arr[mid]>data) return binarySearchUtilForRecursion(arr, data, start, mid-1);
        else return binarySearchUtilForRecursion(arr, data, mid+1, end);
    }    

    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public static Integer binarySearchUsingIteration(Integer[] arr, Integer data){
        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+((end-start)/2);
            // The second formula used in your code, (start - 1) + ((end - start + 1) / 2), 
            // has an issue because it calculates an incorrect mid index. 
            // Specifically, it results in an out-of-bounds index
            // int mid = (start-1)+((end-start+1)/2); wrong formula
            if(arr[mid].equals(data)) return arr[mid];
            else if(arr[mid]>data) end = mid-1;
            else start = mid+1;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,7,9,10,14,18};
        System.out.println("Element found 1 - "+BinarySearch.binarySearchUsingRecursion(arr, 1));
        System.out.println("Element found 7 - "+BinarySearch.binarySearchUsingRecursion(arr, 7));
        System.out.println("Element found 9 - "+BinarySearch.binarySearchUsingRecursion(arr, 9));
        System.out.println("Element found 14 - "+BinarySearch.binarySearchUsingRecursion(arr, 14));
        System.out.println("Element found 18 - "+BinarySearch.binarySearchUsingRecursion(arr, 18));
        System.out.println("Element found 0 - "+BinarySearch.binarySearchUsingRecursion(arr, 0));
        System.out.println("Element found 11 - "+BinarySearch.binarySearchUsingRecursion(arr, 11));
        System.out.println("Element found 25 - "+BinarySearch.binarySearchUsingRecursion(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Element found 1 - "+BinarySearch.binarySearchUsingIteration(arr, 1));
        System.out.println("Element found 7 - "+BinarySearch.binarySearchUsingIteration(arr, 7));
        System.out.println("Element found 9 - "+BinarySearch.binarySearchUsingIteration(arr, 9));
        System.out.println("Element found 14 - "+BinarySearch.binarySearchUsingIteration(arr, 14));
        System.out.println("Element found 18 - "+BinarySearch.binarySearchUsingIteration(arr, 18));
        System.out.println("Element found 0 - "+BinarySearch.binarySearchUsingIteration(arr, 0));
        System.out.println("Element found 11 - "+BinarySearch.binarySearchUsingIteration(arr, 11));
        System.out.println("Element found 25 - "+BinarySearch.binarySearchUsingIteration(arr, 25));
    }
}
