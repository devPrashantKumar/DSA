package AZStriverPlaylist.Strings.Medium;

public class IntegerToRoman {
    public static String intToRomanSimple(int num) {
        StringBuilder str = new StringBuilder();
        String[] romanCharacters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(String character : romanCharacters){
            int numericValue = mapCharToNum(character);
            str.append(character.repeat(num/numericValue));
            num %= numericValue;
        }
        return str.toString();
    }

    public static int mapCharToNum(String c) {
        return switch (c) {
            case "M" -> 1000;
            case "CM" -> 900;
            case "D"-> 500;
            case "CD"-> 400;
            case "C"-> 100;
            case "XC"-> 90;
            case "L"-> 50;
            case "XL"-> 40;
            case "X"-> 10;
            case "IX"-> 9;
            case "V"-> 5;
            case "IV"-> 4;
            case "I"-> 1;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        int input1 = 3;
        System.out.println("Input : " + input1 + " Output : " + intToRomanSimple(input1));

        int input2 = 58;
        System.out.println("Input : " + input2 + " Output : " + intToRomanSimple(input2));

        int input3 = 1994;
        System.out.println("Input : " + input3 + " Output : " + intToRomanSimple(input3));

    }
}
