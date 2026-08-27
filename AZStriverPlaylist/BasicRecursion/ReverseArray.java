package AZStriverPlaylist.BasicRecursion;

import java.util.Arrays;

public class ReverseArray {

    public static void reverseArrayUsingRecursion2(int[] arr, int left, int right){
        if(left>=right) return;
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
        reverseArrayUsingRecursion2(arr, ++left, --right);
    }

    // important
    public static void reverseArrayUsingRecursion(int[] arr, int len){
        if(len==0) return;
        int element = arr[len-1];
        reverseArrayUsingRecursion(arr, len-1);
        arr[arr.length-1-(len-1)] = element;
    }

    public static void reverseArrayUsingRecursion3(int[] arr, int len){
        reverseArrayUsingRecursion3Util(arr, len, 0);
    }

    public static void reverseArrayUsingRecursion3Util(int[] arr, int len, int index){
        if(len==index) return;
        int element = arr[index];
        reverseArrayUsingRecursion3Util(arr, len, index+1);
        arr[len-1-(index)] = element;
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

        System.out.println("----------------------------------------");

        int[] input3={1,2,3,4,5,6};
        System.out.println("Input 2 " + Arrays.toString(input3));
        reverseArrayUsingRecursion3(input3,input3.length);
        System.out.println("Output 2 "+Arrays.toString(input3));
    }
}
