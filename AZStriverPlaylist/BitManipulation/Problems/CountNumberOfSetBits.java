package AZStriverPlaylist.BitManipulation.Problems;

public class CountNumberOfSetBits {
    public static int countSetBits(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static int countSetBitsNaive(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1); // Check last bit
            num >>= 1; // Right shift
        }
        return count;
    }

    public static int countSetBitsNaive2(int num) {
        int count = 0;
        while (num > 1) {
            count += (num % 2);
            num /= 2; 
        }
        if(num==1) count++;
        return count;
    }

    // time complexity : O(log n)
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
        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsNaive(10));
        System.out.println(countSetBitsNaive(15));
        System.out.println(countSetBitsNaive(0));
        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsNaive2(10));
        System.out.println(countSetBitsNaive2(15));
        System.out.println(countSetBitsNaive2(0));
        System.out.println("-----------------------------------------");

        System.out.println(countSetBitsOptimized(10));
        System.out.println(countSetBitsOptimized(15));
        System.out.println(countSetBitsOptimized(0));
        System.out.println("-----------------------------------------");
    }
}
