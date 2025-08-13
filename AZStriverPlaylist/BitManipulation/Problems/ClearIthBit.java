package AZStriverPlaylist.BitManipulation.Problems;

public class ClearIthBit {
    public static int clearIthBit(int num, int i) {
        return (num & (~(1<<i)));
    }

    public static void main(String[] args) {
        System.out.println(clearIthBit(10,1));
        System.out.println(clearIthBit(15,3));
        System.out.println(clearIthBit(1,0));
        System.out.println(clearIthBit(0,3));
        System.out.println("-----------------------------------------");
    }
}
