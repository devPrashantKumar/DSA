package AZStriverPlaylist.Recursion;

import java.util.Arrays;

public class ReverseArray {

    public static void reverseArrayUsingRecursion2(int[] arr, int left, int right){
        if(left>=right) return;
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
        reverseArrayUsingRecursion2(arr, ++left, --right);
    }

    public static void reverseArrayUsingRecursion(int[] arr, int len){
        if(len==0) return;
        int element = arr[len-1];
        reverseArrayUsingRecursion(arr, len-1);
        arr[arr.length-1-(len-1)] = element;
    }

    public static void main(String[] args) {
        int[] input1={1,2,3,4,5,6};
        System.out.println("Input 1 " + Arrays.toString(input1));
        reverseArrayUsingRecursion(input1,input1.length);
        System.out.println("Output 1 "+Arrays.toString(input1));

        System.out.println("----------------------------------------");

        int[] input2={1,2,3,4,5,6};
        System.out.println("Input 2 " + Arrays.toString(input2));
        reverseArrayUsingRecursion2(input2,0,input2.length-1);
        System.out.println("Output 2 "+Arrays.toString(input2));
    }
}
