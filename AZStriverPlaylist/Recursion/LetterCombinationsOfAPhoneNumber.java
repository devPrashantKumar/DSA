package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static List<String> combination(String digits) {
        char[][] keypad = { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g' ,'h', 'i'}, {'j','k', 'l' },
                {'m' , 'n', 'o'}, { 'p','q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
        List<String> result = new ArrayList<>();
        StringBuilder sequence = new StringBuilder();
        generateCombination(digits, keypad, sequence, 0, result);
        return result;
    }

    public static void generateCombination(String digits, char[][] keypad, StringBuilder sequence, int index,
            List<String> result) {
        if (sequence.length() == digits.length()) {
            if(sequence.length()!=0){
                result.add(sequence.toString());
            }
            return;
        }
        int keyIndex = (digits.charAt(index)-'0')-1;
        for (int j = 0; j < keypad[keyIndex].length; j++) {
            sequence.append(keypad[keyIndex][j]);
            generateCombination(digits, keypad, sequence, index + 1, result);
            sequence.deleteCharAt(sequence.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println("Input: " + digits1);
        System.out.println(" Output : " + LetterCombinationsOfAPhoneNumber.combination(digits1));

        String digits2 = "2";
        System.out.println("Input: " + digits2);
        System.out.println(" Output : " + LetterCombinationsOfAPhoneNumber.combination(digits2));

        String digits3 = "";
        System.out.println("Input: " + digits3);
        System.out.println(" Output : " + LetterCombinationsOfAPhoneNumber.combination(digits3));
    }
}
