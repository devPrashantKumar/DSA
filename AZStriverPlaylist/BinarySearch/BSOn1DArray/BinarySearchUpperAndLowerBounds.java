package AZStriverPlaylist.BinarySearch.BSOn1DArray;

public class BinarySearchUpperAndLowerBounds {
    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public static int upperBound(int[] arr, int num) {
        int ans = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // lowerBound and ceil both are same.
    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public static int lowerBound(int[] arr, int num) {
        int ans = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public static int ceil(int[] arr, int num) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static int ceilUsingOpppositePolarity(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left==arr.length?-1:left;
    }

    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public static int floor(int[] arr, int num) {
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int floorUsingOpppositePolarity(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 9, 10, 14, 18 };
        System.out.println("UpperBound 1 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 1));
        System.out.println("UpperBound 7 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 7));
        System.out.println("UpperBound 9 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 9));
        System.out.println("UpperBound 14 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 14));
        System.out.println("UpperBound 18 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 18));
        System.out.println("UpperBound 0 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 0));
        System.out.println("UpperBound 11 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 11));
        System.out.println("UpperBound 25 - " + BinarySearchUpperAndLowerBounds.upperBound(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("LowerBound 1 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 1));
        System.out.println("LowerBound 7 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 7));
        System.out.println("LowerBound 9 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 9));
        System.out.println("LowerBound 14 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 14));
        System.out.println("LowerBound 18 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 18));
        System.out.println("LowerBound 0 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 0));
        System.out.println("LowerBound 11 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 11));
        System.out.println("LowerBound 25 - " + BinarySearchUpperAndLowerBounds.lowerBound(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Ceil 1 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 1));
        System.out.println("Ceil 7 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 7));
        System.out.println("Ceil 9 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 9));
        System.out.println("Ceil 14 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 14));
        System.out.println("Ceil 18 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 18));
        System.out.println("Ceil 0 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 0));
        System.out.println("Ceil 11 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 11));
        System.out.println("Ceil 25 - " + BinarySearchUpperAndLowerBounds.ceil(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Ceil 1 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 1));
        System.out.println("Ceil 7 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 7));
        System.out.println("Ceil 9 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 9));
        System.out.println("Ceil 14 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 14));
        System.out.println("Ceil 18 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 18));
        System.out.println("Ceil 0 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 0));
        System.out.println("Ceil 11 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 11));
        System.out.println("Ceil 25 - " + BinarySearchUpperAndLowerBounds.ceilUsingOpppositePolarity(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Floor 1 - " + BinarySearchUpperAndLowerBounds.floor(arr, 1));
        System.out.println("Floor 7 - " + BinarySearchUpperAndLowerBounds.floor(arr, 7));
        System.out.println("Floor 9 - " + BinarySearchUpperAndLowerBounds.floor(arr, 9));
        System.out.println("Floor 14 - " + BinarySearchUpperAndLowerBounds.floor(arr, 14));
        System.out.println("Floor 18 - " + BinarySearchUpperAndLowerBounds.floor(arr, 18));
        System.out.println("Floor 0 - " + BinarySearchUpperAndLowerBounds.floor(arr, 0));
        System.out.println("Floor 11 - " + BinarySearchUpperAndLowerBounds.floor(arr, 11));
        System.out.println("Floor 25 - " + BinarySearchUpperAndLowerBounds.floor(arr, 25));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Floor 1 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 1));
        System.out.println("Floor 7 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 7));
        System.out.println("Floor 9 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 9));
        System.out.println("Floor 14 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 14));
        System.out.println("Floor 18 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 18));
        System.out.println("Floor 0 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 0));
        System.out.println("Floor 11 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 11));
        System.out.println("Floor 25 - " + BinarySearchUpperAndLowerBounds.floorUsingOpppositePolarity(arr, 25));
    }
}
