package AZStriverPlaylist.BitManipulation.Problems;

public class SetUnsetTheRightmostSetUnsetBit {
    public static int setRightmostUnsetBit(int num) {
        return (num | (num+1));
    }

    public static int unsetRightmostSetBit(int num) {
        return (num & (num-1));
    }

    public static void main(String[] args) {
        System.out.println(setRightmostUnsetBit(10));
        System.out.println(setRightmostUnsetBit(15));
        System.out.println(setRightmostUnsetBit(1));
        System.out.println(setRightmostUnsetBit(0));
        System.out.println("-----------------------------------------");

        System.out.println(unsetRightmostSetBit(10));
        System.out.println(unsetRightmostSetBit(15));
        System.out.println(unsetRightmostSetBit(1));
        System.out.println(unsetRightmostSetBit(0));
        System.out.println("-----------------------------------------");
    }
}
