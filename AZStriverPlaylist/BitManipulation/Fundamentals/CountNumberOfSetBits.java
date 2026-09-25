package AZStriverPlaylist.BitManipulation.Fundamentals;

public class CountNumberOfSetBits {
    
    /*
        Note: O(number of set bits) < O(logN) < O(32)
    */ 
    
    // time complexity : O(32) 
    // works for both negative and non-negative numbers
    public static int countSetBits(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    // time complexity : O(logN) 
    // For negative int, >> keeps the sign bit, so it never reaches 0, will not work for negative numbers
    public static int countSetBitsNaive(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1); // Check last bit
            num >>= 1; // Right shift
        }
        return count;
    }

    // time complexity : O(logN) 
    // >>> is unsigned right shift, so zeros are inserted from the left. Therefore, this method does work for negative integers.
    public static int countSetBitsNaive_2(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1); // Check last bit
            num >>>= 1; // Right shift
        }
        return count;
    }

    // time complexity : O(logN) 
    // correct for non-negative numbers
    public static int countSetBitsNaive2(int num) {
        int count = 0;
        while (num > 0) {
            count += (num % 2);
            num /= 2; 
        }
        return count;
    }

    // time complexity : O(number of set bits) 
    // works for both negative and non-negative numbers
    public static int countSetBitsOptimized(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1); // Removes the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(10));
        System.out.println(countSetBits(15));
        System.out.println(countSetBits(0));
        System.out.println(countSetBits(-10));

        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsNaive(10));
        System.out.println(countSetBitsNaive(15));
        System.out.println(countSetBitsNaive(0));
        // System.out.println(countSetBitsNaive(-10)); fail for this

        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsNaive_2(10));
        System.out.println(countSetBitsNaive_2(15));
        System.out.println(countSetBitsNaive_2(0));
        System.out.println(countSetBitsNaive_2(-10));

        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsNaive2(10));
        System.out.println(countSetBitsNaive2(15));
        System.out.println(countSetBitsNaive2(0));

        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsOptimized(10));
        System.out.println(countSetBitsOptimized(15));
        System.out.println(countSetBitsOptimized(0));
        System.out.println(countSetBitsOptimized(-10));
        System.out.println("-----------------------------------------");
    }
}
