package AZStriverPlaylist.BitManipulation.Problems;

public class SetIthBit {
    public static int setIthBit(int num, int i) {
        return (num | (1<<i));
    }

    public static void main(String[] args) {
        System.out.println(setIthBit(10,0));
        System.out.println(setIthBit(15,4));
        System.out.println(setIthBit(0,1));
        System.out.println(setIthBit(0,3));
        System.out.println("-----------------------------------------");
    }
}
