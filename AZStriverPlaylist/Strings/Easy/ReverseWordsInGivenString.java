package AZStriverPlaylist.Strings.Easy;

public class ReverseWordsInGivenString {

    /*
     * Time Complexity : O(n)
     */
    public static String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder result =  new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                if (word.length() >0 ) {
                    if (result.length() > 0)
                        result.insert(0,' ');
                    result.insert(0,word);
                    word.setLength(0);
                }
            }
        }

        if (word.length() >0 ) {
            if (result.length() > 0)
                result.insert(0,' ');
            result.insert(0,word);
        }

        return result.toString();
    }

    public static String reverseWordsApproach2(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder result =  new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                if (word.length() >0 ) {
                    result.append(word.reverse().toString());
                    result.append(" ");
                    word.setLength(0);
                }
            }
        }

        if (word.length() >0 ) {
            result.append(word.reverse().toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "the sky is blue";
        System.out.println("Input : "+input1+" Output : "+ReverseWordsInGivenString.reverseWords(input1) );
        System.out.println("Input : "+input1+" Output : "+ReverseWordsInGivenString.reverseWordsApproach2(input1) );
        System.out.println("----------------------------------------");
        String input2 = "  hello world  ";
        System.out.println("Input : "+input2+" Output : "+ReverseWordsInGivenString.reverseWords(input2) );
        System.out.println("Input : "+input2+" Output : "+ReverseWordsInGivenString.reverseWordsApproach2(input2) );
        System.out.println("----------------------------------------");
        String input3 = "a good   example";
        System.out.println("Input : "+input3+" Output : "+ReverseWordsInGivenString.reverseWords(input3) );
        System.out.println("Input : "+input3+" Output : "+ReverseWordsInGivenString.reverseWordsApproach2(input3) );

    }
}
