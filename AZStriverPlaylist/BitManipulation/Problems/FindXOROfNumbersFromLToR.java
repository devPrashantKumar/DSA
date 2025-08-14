package AZStriverPlaylist.BitManipulation.Problems;

/*
 * Problem : https://www.geeksforgeeks.org/competitive-programming/find-xor-of-numbers-from-the-range-l-r/
 * Solution Discussion : https://www.geeksforgeeks.org/dsa/calculate-xor-1-n/
 */
public class FindXOROfNumbersFromLToR {

    /*
     * Time Complexity : O(1)
     */
    public static int findRangeXOR(int l, int r) {
        return findXOR(r) ^ findXOR(l - 1);
    }

    /*
     * Time Complexity : O(1)
     */
    public static int findXOR(int n) {
        int mod = n % 4;
        if (mod == 0)
            return n;
        else if (mod == 1)
            return 1;
        else if (mod == 2)
            return n + 1;
        else if (mod == 3)
            return 0;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("l : " + 4 + " r  : " + 8 + " -> findRangeXOR : " + findRangeXOR(4, 8));
        System.out.println("l : " + 3 + " r  : " + 7 + " -> findRangeXOR : " + findRangeXOR(3, 7));
    }
}
