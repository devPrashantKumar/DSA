package AZStriverPlaylist.Heap;

import java.util.Arrays;

public class CheckIfAnArrayRepresentsAMinHeapOrNot {
    public static boolean check(int[] arr) {
        return checkUtil(arr, 0, Integer.MIN_VALUE);
    }

    public static boolean checkUtil(int[] arr, int index, int min) {
        if (index >= arr.length)
            return true;
        if (arr[index] <= min)
            return false;
        return checkUtil(arr, 2 * index + 1, arr[index]) && checkUtil(arr, 2 * index + 2, arr[index]);
    }

    // https://www.geeksforgeeks.org/dsa/how-to-check-if-a-given-array-represents-a-binary-heap/
    // if x<y and y<z then x<z
    public static boolean checkIterative(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (2 * i + 1 < n && arr[2 * i + 1] <= arr[i])
                return false;
            if (2 * i + 2 < n && arr[2 * i + 2] <= arr[i])
                return false;
        }
        return true;
    }


    public static boolean checkRecursive(int[] arr) {
        return checkReursiveUtil(arr, 0);
    }

    public static boolean checkReursiveUtil(int[] arr, int index) {
        if (index >= arr.length)
            return true;
        if (2*index+1<arr.length && arr[index] >= arr[2*index+1])
            return false;
        if (2*index+2<arr.length && arr[index] >= arr[2*index+2])
            return false;
        return checkReursiveUtil(arr, 2 * index + 1) && checkReursiveUtil(arr, 2 * index + 2);
    }

    public static void main(String[] args) {
        int[] input1 = { 10, 20, 30, 21, 23 };
        System.out.println("Input1 : " + Arrays.toString(input1));
        System.out.println("Output1 : " + CheckIfAnArrayRepresentsAMinHeapOrNot.check(input1));
        System.out.println("Output1 : " + CheckIfAnArrayRepresentsAMinHeapOrNot.checkIterative(input1));
        System.out.println("Output1 : " + CheckIfAnArrayRepresentsAMinHeapOrNot.checkRecursive(input1));

        int[] input2 = { 10, 20, 30, 25, 15 };
        System.out.println("Input1 : " + Arrays.toString(input2));
        System.out.println("Output1 : " + CheckIfAnArrayRepresentsAMinHeapOrNot.check(input2));
        System.out.println("Output1 : " + CheckIfAnArrayRepresentsAMinHeapOrNot.checkIterative(input2));
        System.out.println("Output1 : " + CheckIfAnArrayRepresentsAMinHeapOrNot.checkRecursive(input2));
    }
}
