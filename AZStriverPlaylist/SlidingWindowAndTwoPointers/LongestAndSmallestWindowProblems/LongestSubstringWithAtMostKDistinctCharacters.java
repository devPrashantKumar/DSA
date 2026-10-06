package AZStriverPlaylist.SlidingWindowAndTwoPointers.LongestAndSmallestWindowProblems;

import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int kDistinctChar(String s, int k) {
        int maxLength=0;
        Map<Character,Integer> hmap = new HashMap<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),0)+1);
            if(hmap.size()>k){
                hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
                if(hmap.get(s.charAt(i))==0)
                    hmap.remove(s.charAt(i));
                i++;
            }
            if(hmap.size()<=k){
                maxLength = Math.max(maxLength,j-i+1);
            }
            j++;
        }
        return maxLength;
    }

    public static int kDistinctChar3(String s, int k) {
        if(k==0) return 0;
        int maxLength=0;
        Map<Character,Integer> hmap = new HashMap<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j), 0) + 1);
            while (hmap.size() > k) {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) - 1);
                if (hmap.get(s.charAt(i)) == 0)
                    hmap.remove(s.charAt(i));
                i++;
            }
            maxLength = Math.max(maxLength, j - i+1);
            j++;
        }
        return maxLength;
    }

    public static int kDistinctChar2(String s, int k) {
        int maxLength=0;
        Map<Character,Integer> hmap = new HashMap<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),0)+1);
            if(hmap.size()>k){
                maxLength = Math.max(maxLength,j-i);
                while (hmap.size()>k) {
                    hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
                    if(hmap.get(s.charAt(i))==0)
                        hmap.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        maxLength = Math.max(maxLength,j-i);
        return maxLength;
    }

    

    public static void main(String[] args) {
        String stringInput2 = "aababbcaacc";
        int k2 = 2;
        System.out.println("Input String : " + stringInput2 + " Output : "+ kDistinctChar(stringInput2, k2));
        System.out.println("Input String : " + stringInput2 + " Output : "+ kDistinctChar2(stringInput2, k2));
        System.out.println("Input String : " + stringInput2 + " Output : "+ kDistinctChar3(stringInput2, k2));

        System.out.println("----------------------------------------------");

        String stringInput3 = "abcddefg";
        int k3 = 3;
        System.out.println("Input String : " + stringInput3 + " Output : "+ kDistinctChar(stringInput3, k3));
        System.out.println("Input String : " + stringInput3 + " Output : "+ kDistinctChar2(stringInput3, k3));
        System.out.println("Input String : " + stringInput3 + " Output : "+ kDistinctChar3(stringInput3, k3));

    }
}
