package AZStriverPlaylist.Array;

import java.util.Arrays;

public class SecondLargestNumberInArray {
    /*
     * Bruteforce Approch
     * Time Complexity O(n logn)
     */
    public static int secondLargestNumber(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    /*
     * This same approch will work in case of kth Largest also
     * Time complexity : O(n*k)
     */
    public static int secondLargestNumberBetterApproach(int[] arr, int k) {
        int previosLargest = Integer.MAX_VALUE;
        while (k-- > 0) {
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < previosLargest && arr[i] > largest) {
                    largest = arr[i];
                }
            }
            previosLargest = largest;
        }
        return previosLargest;
    }

    /*
     * Time complexity: O(n)
     */
    public static int secondLargestNumberOptimalApproach(int[] arr) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] input1 = { 2, 4, 1, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + SecondLargestNumberInArray.secondLargestNumber(input1));

        System.out.println("------------------------------------------------------");
        int[] input2 = { 2, 4, 3, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + SecondLargestNumberInArray.secondLargestNumberOptimalApproach(input2));

        System.out.println("------------------------------------------------------");
        int[] input3 = { 2, 4, 3, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input3) + " Output : "
                + SecondLargestNumberInArray.secondLargestNumberBetterApproach(input3, 2));

        System.out.println("------------------------------------------------------");
        int[] input4 = { 2, 4, 3, 7, 8, 3 };
        System.out.println("Input : " + Arrays.toString(input4) + " Output : "
                + SecondLargestNumberInArray.secondLargestNumberBetterApproach(input4, 7));

    }

}
