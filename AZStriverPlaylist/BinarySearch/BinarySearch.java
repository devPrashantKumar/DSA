package AZStriverPlaylist.BinarySearch;

public class BinarySearch {
    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(logn) for recursive stack
     */
    public static Integer binarySearchUsingRecursion(Integer[] arr, Integer data){
        return binarySearchUtilForRecursion(arr,data,0,arr.length-1);
    }

    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public static Integer binarySearchUsingIteration(Integer[] arr, Integer data){
        return binarySearchUtilForIteration(arr,data,0,arr.length-1);
    }

    public static Integer binarySearchUtilForRecursion(Integer[] arr, Integer data, int start, int end){
        if(start>end) return null;
        int mid = start+((end-start)/2);
        //int mid = (start-1)+((end-start+1)/2); wrong formula
        if(arr[mid].equals(data)) return arr[mid];
        else if(arr[mid]>data) return binarySearchUtilForRecursion(arr, data, start, mid-1);
        else return binarySearchUtilForRecursion(arr, data, mid+1, end);
    }

    public static Integer binarySearchUtilForIteration(Integer[] arr, Integer data, int start, int end){
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
}
