package AZStriverPlaylist.BitManipulation.Problems;

public class CountNumberOfBitsToBeFlippedToConvertAToB {
    /*
     * Time Complexity : O(log(numA^numB))
     */
    public static int minBitFlips(int numA, int numB) {
        int bitsDifference = numA ^ numB;
        return bitsCount(bitsDifference);
    }

    public static int bitsCount(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num & (num - 1));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("numA : " + 10 + " numB  : " + 7 + " -> minBitFlips : " + minBitFlips(10, 7));
        System.out.println("numA : " + 3 + " numB  : " + 4 + " -> minBitFlips : " + minBitFlips(3, 4));
    }
}
