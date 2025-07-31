package AZStriverPlaylist.BitManipulation.Problems;

public class CheckIfNumberIsOddOrNot {
    public static boolean checkIfNumberIsOddOrNot(int num) {
        return (num & 1) == 1;
    }
    public static void main(String[] args) {
        System.out.println(checkIfNumberIsOddOrNot(10)); // false
        System.out.println(checkIfNumberIsOddOrNot(15)); // true
        System.out.println(checkIfNumberIsOddOrNot(0)); // false
    }
}
