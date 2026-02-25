package AZStriverPlaylist.BitManipulation.Problems;

public class ClearIthBit {
    public static int clearIthBit(int num, int i) {
        return (num & (~(1<<i)));
    }

    // approach 2, not ideal
    public static int clearIthBit2(int num, int i) {
        if ((num & (1 << i)) != 0) {
            return num ^ (1 << i);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(clearIthBit(10,1));
        System.out.println(clearIthBit(15,3));
        System.out.println(clearIthBit(1,0));
        System.out.println(clearIthBit(0,3));
        System.out.println("-----------------------------------------");
        System.out.println(clearIthBit2(10,1));
        System.out.println(clearIthBit2(15,3));
        System.out.println(clearIthBit2(1,0));
        System.out.println(clearIthBit2(0,3));
        System.out.println("-----------------------------------------");
    }
}
