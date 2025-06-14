package AZStriverPlaylist.Recursion;

public class GenerateAllBinaryStrings {
    public static void allBinaryStrings(int n){
        generateBinaryString("","0", n-1);
        generateBinaryString("","1", n-1);
    }

    public static void generateBinaryString(String str, String character, int len) {
        if(len==0){
            System.out.println(str+character);
            return;
        }
        if(character.equals("0")){
            generateBinaryString(str+character,"1", len-1);
        }
        generateBinaryString(str+character,"0", len-1);
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Input 1 " + n1);
        GenerateAllBinaryStrings.allBinaryStrings(n1);
    }
}
