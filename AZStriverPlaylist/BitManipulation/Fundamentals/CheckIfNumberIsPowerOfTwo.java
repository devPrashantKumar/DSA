package AZStriverPlaylist.BitManipulation.Fundamentals;

public class CheckIfNumberIsPowerOfTwo {

    public static boolean isPowerOfTwo(int num) {
        if(num<=0) return false;
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(10)); // false
        System.out.println(isPowerOfTwo(16)); // true
        System.out.println(isPowerOfTwo(0)); // false
        System.out.println(isPowerOfTwo(-10)); // false
    }
}
