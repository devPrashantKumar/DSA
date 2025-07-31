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


    public static int clearLastSetBit(int num) {
        return num & (num - 1);
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

        System.out.println("Clear the last set bit:");
        System.out.println(clearLastSetBit(12)); // 8 (1100 → 1000)
        System.out.println(clearLastSetBit(7)); // 6 (0111 → 0110)
        System.out.println(clearLastSetBit(1)); // 0 (0001 → 0000)
        System.out.println(clearLastSetBit(0)); // 0 (edge case)
    }
}
