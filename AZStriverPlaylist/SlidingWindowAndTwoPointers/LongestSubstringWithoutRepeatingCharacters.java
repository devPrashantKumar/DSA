package AZStriverPlaylist.SlidingWindowAndTwoPointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                maxLen = Math.max(maxLen, j - i);
                do {
                    set.remove(s.charAt(i));
                } while (s.charAt(i++) != s.charAt(j));
            }
            set.add(s.charAt(j));
            j++;
        }
        maxLen = Math.max(maxLen, j - i);
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxWindow = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxWindow = Math.max(set.size(), maxWindow);
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        String s1 = "zxyzxyz";
        String s2 = "xxxx";
        String s3 = "abcabcbb";
        String s4 = "bbbbb";
        String s5 = "pwwkew";

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + s1);
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s1));
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(s1));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + s2);
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s2));
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(s2));

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + s3);
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s3));
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(s3));

        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + s4);
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s4));
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(s4));

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("Input : " + s5);
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s5));
        System.out.println("Output : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(s5));
    }
}
