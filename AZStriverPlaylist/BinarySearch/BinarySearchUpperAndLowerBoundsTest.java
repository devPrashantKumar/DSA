package AZStriverPlaylist.BinarySearch;

public class  BinarySearchUpperAndLowerBoundsTest{
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

    }
}