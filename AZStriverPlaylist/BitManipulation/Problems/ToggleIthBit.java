package AZStriverPlaylist.BitManipulation.Problems;

public class ToggleIthBit {
    public static int toggleIthBit(int num, int i) {
        return (num ^ (1<<i));
    }

    public static void main(String[] args) {
        System.out.println(toggleIthBit(10,1));
        System.out.println(toggleIthBit(15,2));
        System.out.println(toggleIthBit(1,0));
        System.out.println(toggleIthBit(0,1));
        System.out.println("-----------------------------------------");
    }
}
