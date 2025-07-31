package AZStriverPlaylist.BitManipulation.Problems;

public class CheckIfIthBitIsSetOrNot {

    public static boolean checkIthBitIsSetUsingLeftShift(int num, int index) {
        return (num & (1 << index)) > 0;
        // return (num & (1<<index))!=0; both will work
    }

    public static boolean checkIthBitIsSetUsingRightShift(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
    public static void main(String[] args) {
        System.out.println(checkIthBitIsSetUsingLeftShift(10, 0)); // false
        System.out.println(checkIthBitIsSetUsingLeftShift(10, 3)); // true

        System.out.println("Check bit using right shift:");
        System.out.println(checkIthBitIsSetUsingRightShift(10, 0)); // false
        System.out.println(checkIthBitIsSetUsingRightShift(10, 3)); // true
    }
}
