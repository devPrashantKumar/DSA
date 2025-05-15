public class BitManipulationProblems {
    public static int setTheIthBit(int num, int index) {
        return num | (1 << index);
    }

    public static int clearTheIthBit(int num, int index) {
        return num & ~(1 << index);
    }

    public static int toggleTheIthBit(int num, int index) {
        return num ^ (1 << index);
    }

    public static boolean checkIthBitIsSetUsingLeftShift(int num, int index) {
        return (num & (1 << index)) > 0;
        // return (num & (1<<index))!=0; both will work
    }

    public static boolean checkIthBitIsSetUsingRightShift(int num, int index) {
        return ((num >> index) & 1) == 1;
    }

    public static int clearLastSetBit(int num) {
        return num & (num - 1);
    }

    public static boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    public static int countSetBits(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Set bit:");
        System.out.println(setTheIthBit(10, 0)); // 11
        System.out.println(setTheIthBit(10, 2)); // 10 (unchanged)

        System.out.println("Clear bit:");
        System.out.println(clearTheIthBit(10, 1)); // 8 (1010 → 1000)
        System.out.println(clearTheIthBit(10, 3)); // 2 (1010 → 0010)

        System.out.println("Toggle bit:");
        System.out.println(toggleTheIthBit(10, 0)); // 11 (1010 → 1011)
        System.out.println(toggleTheIthBit(10, 2)); // 14 (1010 → 1110)

        System.out.println("Check bit using left shift:");
        System.out.println(checkIthBitIsSetUsingLeftShift(10, 0)); // false
        System.out.println(checkIthBitIsSetUsingLeftShift(10, 3)); // true

        System.out.println("Check bit using right shift:");
        System.out.println(checkIthBitIsSetUsingRightShift(10, 0)); // false
        System.out.println(checkIthBitIsSetUsingRightShift(10, 3)); // true

        System.out.println("Check if i'th bit is power of 2:");
        System.out.println(isPowerOfTwo(1)); // true (2^0)
        System.out.println(isPowerOfTwo(2)); // true (2^1)
        System.out.println(isPowerOfTwo(4)); // true (2^2)
        System.out.println(isPowerOfTwo(8)); // true (2^3)
        System.out.println(isPowerOfTwo(0)); // false
        System.out.println(isPowerOfTwo(3)); // false
        System.out.println(isPowerOfTwo(5)); // false

        System.out.println("Clear the last set bit:");
        System.out.println(clearLastSetBit(12)); // 8 (1100 → 1000)
        System.out.println(clearLastSetBit(7)); // 6 (0111 → 0110)
        System.out.println(clearLastSetBit(1)); // 0 (0001 → 0000)
        System.out.println(clearLastSetBit(0)); // 0 (edge case)

        System.out.println("Count the set bits:");
        System.out.println(countSetBits(5)); // 2 (0101)
        System.out.println(countSetBits(7)); // 3 (0111)
        System.out.println(countSetBits(0)); // 0 (0000)
        System.out.println(countSetBits(255)); // 8 (11111111)
    }
}
