package AZStriverPlaylist.Strings;

import java.util.Arrays;

public class LongestCommonPrefix {


    /*
     * Time complexity : O(m*n)
     */
    public static String commanPrefix(String[] strings) {
        int i=0;
        l1 : for(;i<strings[0].length();i++){
            char c = strings[0].charAt(i);
            for(int j=1;j<strings.length;j++){
                if(i==strings[j].length() || strings[j].charAt(i)!=c ) break l1;
            }
        }
        return strings[0].substring(0,i);
    }

    public static void main(String[] args) {
        String[] input1 = {"flower","flow","flight"};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestCommonPrefix.commanPrefix(input1) );
        String[] input2 = {"dog","racecar","car"};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestCommonPrefix.commanPrefix(input2) );
    }
}
