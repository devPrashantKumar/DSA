package AZStriverPlaylist.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram1(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if(charArray1.length!=charArray2.length) return false;
        for(int i=0;i<charArray1.length;i++){
            if(charArray1[i]!=charArray2[i]) return false;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> hmap1 = new HashMap<>();
        HashMap<Character,Integer> hmap2 = new HashMap<>();
        for(char c : s.toCharArray()){
            hmap1.put(c,hmap1.getOrDefault(c, 0)+1);
        }
        for(char c : t.toCharArray()){
            hmap2.put(c,hmap2.getOrDefault(c, 0)+1);
        }
        return hmap1.equals(hmap2);

    }

    public static boolean isAnagram3(String s, String t) {
        HashMap<Character,Integer> hmap1 = new HashMap<>();

        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            hmap1.put(s.charAt(i),hmap1.getOrDefault(s.charAt(i), 0)+1);
            hmap1.put(t.charAt(i),hmap1.getOrDefault(t.charAt(i), 0)-1);
        }

        for(int frequency : hmap1.values()){
            if(frequency!=0) return false;
        }
        //hmap1.values().stream().allMatch(frequency -> frequency==0);
        return true;

    }

    public static boolean isAnagram4(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        int[] characterArray1 = new int[26];
        int[] characterArray2 = new int[26];

        for(char ch : charArray1){
            characterArray1[ch-'a']++;
        }
        for(char ch : charArray2){
            characterArray2[ch-'a']++;
        }

        return Arrays.equals(characterArray1, characterArray2);
    }

    public static boolean isAnagram(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        int[] characterArray1 = new int[26];

        for(char ch : charArray1){
            characterArray1[ch-'a']++;
        }
        for(char ch : charArray2){
            characterArray1[ch-'a']--;
        }
        
        return Arrays.stream(characterArray1).allMatch(num -> num == 0);
    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String t1 = "carrace";
        String s2 = "jar";
        String t2 = "jam";
        System.out.println("---------------------------------------------------");
        System.out.println("Input : s - "+s1+" , t - "+t1);
        System.out.println("Output : " + ValidAnagram.isAnagram1(s1,t1));
        System.out.println("---------------------------------------------------");
        System.out.println("Input : s - "+s2+" , t - "+t2);
        System.out.println("Output : " + ValidAnagram.isAnagram2(s2, t2));
        System.out.println("---------------------------------------------------");
        
    }
}
