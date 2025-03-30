package AZStriverPlaylist.BinarySearch;

public class  BinarySearchTest{
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