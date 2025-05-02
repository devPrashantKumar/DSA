package AZStriverPlaylist.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInAnArray {

    /*
     * Time Complexity : O(n^2)
     */
    public static int[] leadersInArrayBruteForce(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader)
                result.add(arr[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     * Time Complexity : O(n)
     */
    public static int[] leadersInArrayOptimal(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxi) {
                result.add(arr[i]);
                maxi = arr[i];
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] input1 = { 4, 7, 1, 0 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(LeadersInAnArray.leadersInArrayBruteForce(input1)));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + Arrays.toString(LeadersInAnArray.leadersInArrayOptimal(input1)));
        System.out.println("------------------------------------------------------");

        int[] input2 = { 10, 22, 12, 3, 0, 6 };
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(LeadersInAnArray.leadersInArrayBruteForce(input2)));
        System.out.println("Input : " + Arrays.toString(input2) + " Output : "
                + Arrays.toString(LeadersInAnArray.leadersInArrayOptimal(input2)));
        System.out.println("------------------------------------------------------");
    }

}
