package AZStriverPlaylist.Array.Easy;

import java.util.*;

public class SingleNumber {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int singleNumberBruteforce(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the number appearing only once
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int singleNumberBetter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        // Only the single number remains
        for (int num : map.keySet()) {
            return num;
        }
        return -1;
    }

    /*
     * Time compleity : O(n)
     * Space Complexity : O(1)
     * this solution will work fine for large numbers also, because xor of two
     * numbers can not exceed there size
     */
    public static int singleNumberOptimalUsingXORApproch(int[] arr) {
        return Arrays.stream(arr).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        int[] input1 = { 4,1,2,1,2 };
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + singleNumberBruteforce(input1));
        System.out.println(
                "Input : " + Arrays.toString(input1) + " Output : " + singleNumberBetter(input1));
        System.out.println("Input : " + Arrays.toString(input1) + " Output : "
                + singleNumberOptimalUsingXORApproch(input1));
        System.out.println("------------------------------------------------------");

    }
}
